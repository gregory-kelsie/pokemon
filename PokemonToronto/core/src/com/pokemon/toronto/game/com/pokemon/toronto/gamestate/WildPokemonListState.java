package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;

/**
 * Created by Gregory on 6/12/2017.
 */
public class WildPokemonListState extends GameState{
    private GameStateManager gsm;
    private Texture background;
    private Texture backArrow;
    private Texture forwardArrow;
    private Texture panel;
    private int currentPage;
    private final int FIRST_PAGE = 0;
    private BitmapFont name;
    private BitmapFont info;

    private final int TOP_POSITION = 0;
    private final int MID_POSITION = 1;
    private final int BOT_POSITION = 2;

    private Texture topTexture;
    private Texture middleTexture;
    private Texture bottomTexture;

    private boolean initiateBattle;
    private ShapeRenderer transitionRenderer;
    private int transitionHeight;
    private boolean finishedTransition;
    private int clickedPokemonPosition;
    private Music wildBgm;
    public WildPokemonListState(GameStateManager gsm) {
        this.gsm = gsm;
        background = gsm.getLoader().get("wildPokemonList/wildPokemonListBackground.png", Texture.class);
        backArrow = gsm.getLoader().get("wildPokemonList/backwardsArrow.png", Texture.class);
        forwardArrow = gsm.getLoader().get("wildPokemonList/forwardArrow.png", Texture.class);
        panel = gsm.getLoader().get("wildPokemonList/pokemonListPanel.png", Texture.class);
        currentPage = FIRST_PAGE;
        name = new BitmapFont(Gdx.files.internal("font/textHeaderFont.fnt"));
        name.setColor(Color.BLACK);
        info = new BitmapFont(Gdx.files.internal("font/textBoxNarrowFont.fnt"));
        info.setColor(Color.BLACK);
        initNewSpriteTextures();
        wildBgm = Gdx.audio.newMusic(Gdx.files.internal("sounds/wildBgm.mp3"));
        initiateBattle = false;
        finishedTransition = false;
        transitionRenderer = new ShapeRenderer();
        transitionHeight = 0;
        clickedPokemonPosition = -1;
    }

    private void initNewSpriteTextures() {
        topTexture = new Texture(gsm.getNearbyPokemon().get(currentPage * 3).getPokemon().getMapIconPath());
        if (currentPage * 3 + 1 < gsm.getNearbyPokemon().size()) {
            middleTexture = new Texture(gsm.getNearbyPokemon().get(currentPage * 3 + 1).getPokemon().getMapIconPath());
        }
        if (currentPage * 3 + 2 < gsm.getNearbyPokemon().size()) {
            bottomTexture = new Texture(gsm.getNearbyPokemon().get(currentPage * 3 + 2).getPokemon().getMapIconPath());
        }
    }
    /**
     * Calculate distance between two points in latitude and longitude taking
     * into account height difference. If you are not interested in height
     * difference pass 0.0. Uses Haversine method as its base.
     *
     * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
     * el2 End altitude in meters
     * @returns Distance in Meters
     */
    public double distance(double lat1, double lat2, double lon1,
                                  double lon2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        //double height = el1 - el2;

        distance = Math.pow(distance, 2);// + Math.pow(height, 2);

        return Math.sqrt(distance);
    }

    private void setNameColor(int pokemonPosition) {
        double dist = distance(gsm.getLatitude(), gsm.getNearbyPokemon().get(currentPage * 3 + pokemonPosition).getLatitude(),
                gsm.getLongitude(), gsm.getNearbyPokemon().get(currentPage * 3 + pokemonPosition).getLongitude());
        if (dist <= 30) {
            name.setColor(Color.GREEN);
        } else if (dist <= 500) {
            name.setColor(Color.YELLOW);
        } else if (dist <= 1000) {
            name.setColor(Color.ORANGE);
        } else {
            name.setColor(Color.RED);
        }
    }

    private boolean inBattlingRange(int pokemonPosition) {
        double dist = distance(gsm.getLatitude(), gsm.getNearbyPokemon().get(currentPage * 3 + pokemonPosition).getLatitude(),
                gsm.getLongitude(), gsm.getNearbyPokemon().get(currentPage * 3 + pokemonPosition).getLongitude());
        if (dist <= 1000) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public void render(SpriteBatch batch) {
        batch.draw(background, 0, 0);
        setNameColor(TOP_POSITION);
        name.draw(batch, gsm.getNearbyPokemon().get(currentPage * 3).getPokemon().getName() + " Lv " +
                Integer.toString(gsm.getNearbyPokemon().get(currentPage * 3).getPokemon().getLevel()), 30, 1700);

        batch.draw(topTexture,700,1300, 394, 394);
        //batch.draw(holder, 500, 200, 384, 384);
        info.draw(batch, "Distance: " + Math.round(distance(gsm.getLatitude(), gsm.getNearbyPokemon().get(currentPage * 3 + TOP_POSITION).getLatitude(),
                gsm.getLongitude(), gsm.getNearbyPokemon().get(currentPage * 3 + TOP_POSITION).getLongitude())) + "m\nNature: " +
                gsm.getNearbyPokemon().get(currentPage * 3).getPokemon().getNatureString() +
                "\nAbility: " +  gsm.getNearbyPokemon().get(currentPage * 3).getPokemon().getAbilityString() +
                "\nExpiration:" + gsm.getNearbyPokemon().get(currentPage * 3).getExpirationString(), 30, 1620);

        if (currentPage * 3 + 1 < gsm.getNearbyPokemon().size()) {
            batch.draw(panel, 0, 710);
            setNameColor(MID_POSITION);
            name.draw(batch, gsm.getNearbyPokemon().get(currentPage * 3 + 1).getPokemon().getName() + " Lv " +
                    Integer.toString(gsm.getNearbyPokemon().get(currentPage * 3 + 1).getPokemon().getLevel()), 30, 1150);
            info.draw(batch, "Distance: " + Math.round(distance(gsm.getLatitude(), gsm.getNearbyPokemon().get(currentPage * 3 + MID_POSITION).getLatitude(),
                    gsm.getLongitude(), gsm.getNearbyPokemon().get(currentPage * 3 + MID_POSITION).getLongitude())) + "m\nNature: " +
                    gsm.getNearbyPokemon().get(currentPage * 3 + 1).getPokemon().getNatureString() +
                    "\nAbility: " +  gsm.getNearbyPokemon().get(currentPage * 3 + 1).getPokemon().getAbilityString() +
                    "\nExpiration:" + gsm.getNearbyPokemon().get(currentPage * 3 + 1).getExpirationString(), 30, 1070);
            batch.draw(middleTexture,700,780, 394, 394);

            if (currentPage * 3 + 2 < gsm.getNearbyPokemon().size()) {
                batch.draw(panel, 0, 170);
                setNameColor(BOT_POSITION);
                name.draw(batch, gsm.getNearbyPokemon().get(currentPage * 3 + 2).getPokemon().getName() + " Lv " +
                        Integer.toString(gsm.getNearbyPokemon().get(currentPage * 3 + 2).getPokemon().getLevel()), 30, 600);
                info.draw(batch, "Distance: " + Math.round(distance(gsm.getLatitude(), gsm.getNearbyPokemon().get(currentPage * 3 + BOT_POSITION).getLatitude(),
                        gsm.getLongitude(), gsm.getNearbyPokemon().get(currentPage * 3 + BOT_POSITION).getLongitude())) + "m\nNature: " +
                        gsm.getNearbyPokemon().get(currentPage * 3 + 2).getPokemon().getNatureString() +
                        "\nAbility: " +  gsm.getNearbyPokemon().get(currentPage * 3 + 2).getPokemon().getAbilityString() +
                        "\nExpiration:" + gsm.getNearbyPokemon().get(currentPage * 3 + 2).getExpirationString(), 30, 520);
                batch.draw(bottomTexture,700,260, 394, 394);
                if (currentPage * 3 + 3 < gsm.getNearbyPokemon().size()) {
                    batch.draw(forwardArrow, 880, 10);
                }
            }
        }
        if (currentPage > FIRST_PAGE) {
            batch.draw(backArrow, 60, 10);
        }
        name.setColor(Color.BLACK);
        name.draw(batch, Integer.toString(currentPage + 1) + "/" + Integer.toString((int)Math.ceil(gsm.getNearbyPokemon().size() / 3.0)), 420, 70);

        if (initiateBattle || finishedTransition) {
            batch.end();
            Gdx.gl.glEnable(GL20.GL_BLEND);
            Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
            transitionRenderer.begin(ShapeRenderer.ShapeType.Filled);
            transitionRenderer.setColor(0,0,0, 1);
            transitionRenderer.rect(0,0,1080, transitionHeight);
            transitionRenderer.end();
            Gdx.gl.glDisable(GL20.GL_BLEND);
            batch.begin();
        }
    }

    @Override
    public void update(double dt) {
        if (finishedTransition) {
            if (clickedPokemonPosition == TOP_POSITION) {
                gsm.setState(new BattleState(gsm, gsm.getNearbyPokemon().get(currentPage * 3 + TOP_POSITION).getPokemon(), wildBgm));
                gsm.getNearbyPokemon().remove(currentPage * 3 + TOP_POSITION);
            } else if (clickedPokemonPosition == MID_POSITION) {
                gsm.setState(new BattleState(gsm, gsm.getNearbyPokemon().get(currentPage * 3 + MID_POSITION).getPokemon(), wildBgm));
                gsm.getNearbyPokemon().remove(currentPage * 3 + MID_POSITION);
            } else if (clickedPokemonPosition == BOT_POSITION) {
                gsm.setState(new BattleState(gsm, gsm.getNearbyPokemon().get(currentPage * 3 + BOT_POSITION).getPokemon(), wildBgm));
                gsm.getNearbyPokemon().remove(currentPage * 3 + BOT_POSITION);
            }
        }
        if (initiateBattle) {
            transitionHeight += (dt * 760);
            if (transitionHeight >= 1920) {
                initiateBattle = false;
                finishedTransition = true;
            }
        }

        if (MyInput.clicked() && !initiateBattle) {
            if (MyInput.getX() >= 931 && MyInput.getX() <= 1080 && MyInput.getY() >= 0 && MyInput.getY() <= 152) {
                gsm.setState(new LoadingState(gsm, LoadingState.MAP_STATE));
                dispose();
            } else if (MyInput.getX() >= 841 && MyInput.getX() <= 1021 && MyInput.getY() >= 1754 && MyInput.getY() <= 1920) {
                if (currentPage * 3 + 3 < gsm.getNearbyPokemon().size()) {
                    currentPage++;
                    topTexture.dispose();
                    bottomTexture.dispose();
                    middleTexture.dispose();
                    initNewSpriteTextures();
                }
            } else if (MyInput.getX() >= 33 && MyInput.getX() <= 160 && MyInput.getY() >= 1819 && MyInput.getY() <= 1920) {
                if (currentPage != 0) {
                    currentPage--;
                    topTexture.dispose();
                    topTexture = new Texture(gsm.getNearbyPokemon().get(currentPage * 3).getPokemon().getMapIconPath());
                    middleTexture.dispose();
                    middleTexture = new Texture(gsm.getNearbyPokemon().get(currentPage * 3 + 1).getPokemon().getMapIconPath());
                    bottomTexture.dispose();
                    bottomTexture = new Texture(gsm.getNearbyPokemon().get(currentPage * 3 + 2).getPokemon().getMapIconPath());
                }
            } else if (MyInput.getX() >= 0 && MyInput.getX() <= 1080 && MyInput.getY() >= 246 && MyInput.getY() <= 671) {
                //Clicked top panel
                if (inBattlingRange(TOP_POSITION)) {
                    initiateBattle = true;
                    clickedPokemonPosition = TOP_POSITION;
                    wildBgm.play();
                } else {
                    gsm.getGameCallBack().startPokemonMapActivity(gsm.getNearbyPokemon().get(currentPage * 3 + TOP_POSITION).getLatitude(),
                            gsm.getNearbyPokemon().get(currentPage * 3 + TOP_POSITION).getLongitude(),
                            gsm.getNearbyPokemon().get(currentPage * 3 + TOP_POSITION).getPokemon().getMapIconPath(),
                            (int) Math.round(distance(gsm.getLatitude(), gsm.getNearbyPokemon().get(currentPage * 3 + TOP_POSITION).getLatitude(),
                                    gsm.getLongitude(), gsm.getNearbyPokemon().get(currentPage * 3 + TOP_POSITION).getLongitude())));
                }

            } else if (MyInput.getX() >= 0 && MyInput.getX() <= 1080 && MyInput.getY() >= 777 && MyInput.getY() <= 1197) {
                //Clicked mid panel

                if (currentPage * 3 + 1 < gsm.getNearbyPokemon().size()) {
                    if (inBattlingRange(MID_POSITION)) {
                        initiateBattle = true;
                        clickedPokemonPosition = MID_POSITION;
                        wildBgm.play();
                    } else {
                        gsm.getGameCallBack().startPokemonMapActivity(gsm.getNearbyPokemon().get(currentPage * 3 + MID_POSITION).getLatitude(),
                                gsm.getNearbyPokemon().get(currentPage * 3 + MID_POSITION).getLongitude(),
                                gsm.getNearbyPokemon().get(currentPage * 3 + MID_POSITION).getPokemon().getMapIconPath(),
                                (int) Math.round(distance(gsm.getLatitude(), gsm.getNearbyPokemon().get(currentPage * 3 + MID_POSITION).getLatitude(),
                                        gsm.getLongitude(), gsm.getNearbyPokemon().get(currentPage * 3 + MID_POSITION).getLongitude())));
                    }

                }
            } else if (MyInput.getX() >= 0 && MyInput.getX() <= 1080 && MyInput.getY() >= 1332 && MyInput.getY() <= 1690) {
                //Clicked bottom panel
                if (currentPage * 3 + 2 < gsm.getNearbyPokemon().size()) {
                    if (inBattlingRange(BOT_POSITION)) {
                        initiateBattle = true;
                        clickedPokemonPosition = BOT_POSITION;
                        wildBgm.play();
                    } else {
                        gsm.getGameCallBack().startPokemonMapActivity(gsm.getNearbyPokemon().get(currentPage * 3 + BOT_POSITION).getLatitude(),
                                gsm.getNearbyPokemon().get(currentPage * 3 + BOT_POSITION).getLongitude(),
                                gsm.getNearbyPokemon().get(currentPage * 3 + BOT_POSITION).getPokemon().getMapIconPath(),
                                (int) Math.round(distance(gsm.getLatitude(), gsm.getNearbyPokemon().get(currentPage * 3 + BOT_POSITION).getLatitude(),
                                        gsm.getLongitude(), gsm.getNearbyPokemon().get(currentPage * 3 + BOT_POSITION).getLongitude())));
                    }
                }
            }
            Gdx.app.log("GDX LOGGERs - ", "X: " + MyInput.getX() + ", Y: " + MyInput.getY());
        }
    }

    @Override
    protected void dispose() {
        name.dispose();
        info.dispose();
        topTexture.dispose();
        if (!finishedTransition) {
            wildBgm.dispose();
        }
        try {
            middleTexture.dispose();
        } catch (Exception e) { }
        try {
            bottomTexture.dispose();
        } catch (Exception e) { }
        transitionRenderer.dispose();
        gsm.getLoader().unload("wildPokemonList/backwardsArrow.png");
        gsm.getLoader().unload("wildPokemonList/forwardArrow.png");
        gsm.getLoader().unload("wildPokemonList/pokemonListPanel.png");
        gsm.getLoader().unload("wildPokemonList/wildPokemonListBackground.png");
    }
}
