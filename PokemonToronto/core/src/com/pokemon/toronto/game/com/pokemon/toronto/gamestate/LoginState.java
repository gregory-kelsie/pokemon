package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Nature;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.factory.PokemonFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.input.InputHandler;
import com.pokemon.toronto.game.com.pokemon.toronto.net.JSONParser;
import com.pokemon.toronto.game.com.pokemon.toronto.player.Player;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer;
import com.pokemon.toronto.game.com.pokemon.toronto.trainer.trivial.TrainerFactory;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Gregory on 8/28/2017.
 */

public class LoginState extends GameState {
    private GameStateManager gsm;
    private Texture background;
    private Stage stage;
    private TextButton textButton;
    private TextField usernameField;
    private TextField passwordField;
    private BitmapFont errorText;

    private String errorMessage;
    private boolean displayError;
    public LoginState(GameStateManager gsm) {
        this.gsm = gsm;
        background = new Texture("login/background.png");
        errorText = new BitmapFont(Gdx.files.internal("battle/font/regularFont.fnt"));
        errorText.setColor(Color.RED);
        displayError = false;
        errorMessage = "";
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
        skin.getFont("default-font").getData().setScale(4f,4f);
        textButton = new TextButton("Login", skin);
        textButton.setPosition(100, 300);
        textButton.setSize(880, 90);
        textButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent e, float x, float y, int point, int button) {
                if (usernameField.getText().length() < 5) {
                    displayError = true;
                    errorMessage = "Invalid username.";
                } else if (passwordField.getText().length() < 6) {
                    displayError = true;
                    errorMessage = "Invalid password.";
                } else {
                    Pattern p = Pattern.compile("[^a-zA-Z0-9]");
                    boolean hasSpecialChar = p.matcher(usernameField.getText()).find();
                    if (hasSpecialChar) {
                        displayError = true;
                        errorMessage = "Username must be alphanumeric.";
                    } else {
                        hasSpecialChar = p.matcher(passwordField.getText()).find();
                        if (hasSpecialChar) {
                            displayError = true;
                            errorMessage = "Password must be alphanumeric.";
                        } else {
                            try {
                                connectToDatabase();
                            } catch (Exception e2) {
                                displayError = true;
                                errorMessage = "Could not connect online.\n" + e2.getMessage();
                                return false;
                            }
                        }
                    }
                }
                return false;
            }
        });

        usernameField = new TextField("", skin);
        usernameField.setPosition(100, 600);
        usernameField.setSize(880, 90);
        passwordField = new TextField("", skin);
        passwordField.setPosition(100, 450);
        passwordField.setSize(880, 90);
        passwordField.setPasswordCharacter('*');
        passwordField.setPasswordMode(true);

        stage.addActor(textButton);
        stage.addActor(usernameField);
        stage.addActor(passwordField);

        usernameField.setText("spacejam");
        passwordField.setText("jordans");
    }

    private void connectToDatabase() {
        displayError = false;
        errorMessage = "";
        JSONParser jp = new JSONParser();
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        String username = usernameField.getText();
        params.add(new BasicNameValuePair("username", username));
        params.add(new BasicNameValuePair("password", passwordField.getText()));
        JSONObject obj = jp.makeHttpRequest("http://kelsiegr.com/pokemononline/login.php", "POST", params);

        try {
            int success = Integer.parseInt(obj.get("success").toString());
            if (success == 1) {
                displayError = true;
                Gdx.app.log("startedgamez", obj.get("startedGame").toString());
                int startedGame = Integer.parseInt(obj.get("startedGame").toString());
                errorMessage = obj.get("message").toString();
                gsm.setPlayer(new Player(Integer.parseInt(obj.get("uid").toString()), username));
                if (startedGame == 0) {
                    gsm.setState(new LoadingState(gsm, LoadingState.INTRODUCTION));
                    dispose();
                } else {
                    //Load pokes and everything.
                    gsm.setPlayer(new Player(Integer.parseInt(obj.get("uid").toString()), username, Integer.parseInt(obj.get("money").toString()),
                            obj.get("gender").toString().charAt(0)));
                    Gdx.input.setInputProcessor(new InputHandler());
                    loadParty();
                    gsm.logIn();
                    gsm.playBgm();
                    gsm.setState(new LoadingState(gsm, LoadingState.POKENAV_MENU));
                    dispose();
                }

            } else {
                displayError = true;
                errorMessage = obj.get("message").toString();
            }
        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            Gdx.app.log("LoginError", e1.getMessage());
            e1.printStackTrace();
        }
    }

    private void loadParty() {
        JSONParser jp = new JSONParser();
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("uid", String.valueOf(gsm.getPlayer().getId())));
        JSONObject obj = jp.makeHttpRequest("http://kelsiegr.com/pokemononline/getParty.php", "POST", params);
        try {
            JSONArray jsonParty = obj.getJSONArray("party");
            PokemonFactory pf = new PokemonFactory();
            SkillFactory sf = new SkillFactory();
            for (int i = 0; i < jsonParty.length(); i++) {
                JSONObject pokemonObject = jsonParty.getJSONObject(i);
                int ivs[] = {pokemonObject.getInt("iv_hp"),
                        pokemonObject.getInt("iv_atk"),
                        pokemonObject.getInt("iv_def"),
                        pokemonObject.getInt("iv_spatk"),
                        pokemonObject.getInt("iv_spdef"),
                        pokemonObject.getInt("iv_spd")};
                int evs[] = {pokemonObject.getInt("ev_hp"),
                        pokemonObject.getInt("ev_atk"),
                        pokemonObject.getInt("ev_def"),
                        pokemonObject.getInt("ev_spatk"),
                        pokemonObject.getInt("ev_spdef"),
                        pokemonObject.getInt("ev_spd")};

                Skill firstSkill = sf.createSkill(pokemonObject.getInt("skill_one_id"));
                Skill secondSkill = null;
                Skill thirdSkill = null;
                Skill fourthSkill = null;
                firstSkill.setCurrentPP(pokemonObject.getInt("skill_one_pp"));
                if (pokemonObject.getInt("skill_two_id") != -1) {
                    secondSkill = sf.createSkill(pokemonObject.getInt("skill_two_id"));
                    secondSkill.setCurrentPP(pokemonObject.getInt("skill_two_pp"));
                    if (pokemonObject.getInt("skill_three_id") != -1) {
                        thirdSkill = sf.createSkill(pokemonObject.getInt("skill_three_id"));
                        thirdSkill.setCurrentPP(pokemonObject.getInt("skill_three_pp"));
                        if (pokemonObject.getInt("skill_four_id") != -1) {
                            fourthSkill = sf.createSkill(pokemonObject.getInt("skill_four_id"));
                            fourthSkill.setCurrentPP(pokemonObject.getInt("skill_four_pp"));
                        }
                    }
                }
                Pokemon p = pf.createPokemon(
                        pokemonObject.getInt("pid"),
                        pokemonObject.getInt("level"),
                        pokemonObject.getString("gender").charAt(0),
                        Nature.fromInt(pokemonObject.getInt("nature_id")),
                        Pokemon.Ability.fromInt(pokemonObject.getInt("ability_id")),
                        pokemonObject.getInt("current_health"),
                        pokemonObject.getInt("current_exp"),
                        Pokemon.Status.fromInt(pokemonObject.getInt("status")),
                        ivs,
                        evs,
                        firstSkill,
                        secondSkill,
                        thirdSkill,
                        fourthSkill
                        );
                gsm.addToParty(p);
            }
            gsm.getGameCallBack().spawnNewGamePokemon();
        } catch (JSONException e) {
            Gdx.app.log("JSONException", e.getMessage());
        }
    }

    public void drawStage() {
        stage.act();
        stage.draw();
    }
    @Override
    public void render(SpriteBatch batch) {
        batch.draw(background,0,0);
        if (displayError) {
            errorText.draw(batch, errorMessage, 100, 200);
        }
    }

    @Override
    public void update(double dt) {

    }

    @Override
    protected void dispose() {
        background.dispose();
        errorText.dispose();
        stage.dispose();
    }
}
