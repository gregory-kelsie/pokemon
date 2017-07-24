package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/14/2017.
 */
public class PokemonPartyState extends GameState {
    private GameStateManager gsm;
    private Texture background;
    private Texture panel;
    private Texture blankHealthBar;
    private Texture greenBar;
    private Texture healthCap;
    private Texture grayButton;
    private Texture greenButton;
    private BitmapFont nameFont;
    private BitmapFont levelFont;
    private List<Texture> pokemonIcons;
    private boolean onSwitchButton;
    private BitmapFont buttonFont;
    private int selectedPokemon;
    public PokemonPartyState(GameStateManager gsm) {
        this.gsm = gsm;
        background = gsm.getLoader().get("pokemonMenu/background.png", Texture.class);
        panel = gsm.getLoader().get("pokemonMenu/panel.png", Texture.class);
        blankHealthBar = gsm.getLoader().get("pokemonMenu/emptyHealthBar.png", Texture.class);
        greenBar = gsm.getLoader().get("pokemonMenu/greenLife.png", Texture.class);
        healthCap = gsm.getLoader().get("pokemonMenu/healthCap.png", Texture.class);
        grayButton = gsm.getLoader().get("pokemonMenu/grayButton.png", Texture.class);
        greenButton = gsm.getLoader().get("pokemonMenu/greenButton.png", Texture.class);
        nameFont = new BitmapFont(Gdx.files.internal("pokemonMenu/name.fnt"));
        levelFont = new BitmapFont(Gdx.files.internal("pokemonMenu/level.fnt"));
        buttonFont = new BitmapFont(Gdx.files.internal("battle/font/regularFont.fnt"));
        buttonFont.setColor(Color.WHITE);
        pokemonIcons = new ArrayList<Texture>();
        pokemonIcons.add(new Texture(gsm.getParty().get(0).getMapIconPath()));
        for (int i = 1; i < gsm.getParty().size(); i++) {
                pokemonIcons.add(new Texture(gsm.getParty().get(i).getMapIconPath()));
        }
        nameFont.setColor(Color.BLACK);
        levelFont.setColor(Color.BLACK);
        onSwitchButton = false;
        selectedPokemon = -1;
    }
    @Override
    public void render(SpriteBatch batch) {
        batch.draw(background, 0,0);

        //Draw First Panel
        batch.draw(panel, 54, 1503);
        drawButtons(batch);
        batch.draw(blankHealthBar, 90,1551);
        batch.draw(greenBar, 93, 1555, (int)(672 *
                (1.0 * gsm.getParty().get(0).getCurrentHealth() / gsm.getParty().get(0).getHealthStat())), 33);
        nameFont.draw(batch, gsm.getParty().get(0).getName().toUpperCase(), 91,1700);
        nameFont.draw(batch, "Level: " + Integer.toString(gsm.getParty().get(0).getLevel()), 91,1661);
        batch.draw(pokemonIcons.get(0), 758, 1465, 310, 310);

        if (hasSecondPokemon()) {
            drawSecondPokemon(batch);
            if (hasThirdPokemon()) {
                drawThirdPokemon(batch);
                if (hasFourthPokemon()) {
                    drawFourthPokemon(batch);
                    if (hasFifthPokemon()) {
                        drawFifthPokemon(batch);
                        if (hasSixthPokemon()) {
                            drawSixthPokemon(batch);
                        }
                    }
                }
            }
        }
    }

    private void drawButtons(SpriteBatch batch) {
        if (onSwitchButton) {
            batch.draw(greenButton, 432, 10);
            batch.draw(grayButton, 39, 10);
        } else {
            batch.draw(greenButton, 39, 10);
            batch.draw(grayButton, 432, 10);
        }
        buttonFont.draw(batch, "Status", 108, 75);
        buttonFont.draw(batch, "Switch", 507, 75);
    }
    private void drawSecondPokemon(SpriteBatch batch) {
        batch.draw(panel, 54, 1239);
        batch.draw(blankHealthBar, 90,1287);
        batch.draw(greenBar, 93, 1291, (int)(672 *
                (1.0 * gsm.getParty().get(1).getCurrentHealth() / gsm.getParty().get(1).getHealthStat())), 33);
        nameFont.draw(batch, gsm.getParty().get(1).getName().toUpperCase(), 91,1436);
        nameFont.draw(batch, "Level: " + Integer.toString(gsm.getParty().get(1).getLevel()), 91,1397);
        batch.draw(pokemonIcons.get(1), 758, 1201, 310, 310);
    }

    private void drawThirdPokemon(SpriteBatch batch) {
        batch.draw(panel, 54, 975);
        batch.draw(blankHealthBar, 90,1023);
        batch.draw(greenBar, 93, 1027, (int)(672 *
                (1.0 * gsm.getParty().get(2).getCurrentHealth() / gsm.getParty().get(2).getHealthStat())), 33);
        nameFont.draw(batch, gsm.getParty().get(2).getName().toUpperCase(), 91,1172);
        nameFont.draw(batch, "Level: " + Integer.toString(gsm.getParty().get(2).getLevel()), 91,1133);
        batch.draw(pokemonIcons.get(2), 758, 937, 310, 310);
    }

    private void drawFourthPokemon(SpriteBatch batch) {
        batch.draw(panel, 54, 711);
        batch.draw(blankHealthBar, 90,759);
        batch.draw(greenBar, 93, 763, (int)(672 *
                (1.0 * gsm.getParty().get(3).getCurrentHealth() / gsm.getParty().get(3).getHealthStat())), 33);
        nameFont.draw(batch, gsm.getParty().get(3).getName().toUpperCase(), 91,908);
        nameFont.draw(batch, "Level: " + Integer.toString(gsm.getParty().get(3).getLevel()), 91,869);
        batch.draw(pokemonIcons.get(3), 758, 673, 310, 310);
    }

    private void drawFifthPokemon(SpriteBatch batch) {
        batch.draw(panel, 54, 447);
        batch.draw(blankHealthBar, 90,495);
        batch.draw(greenBar, 93, 499, (int)(672 *
                (1.0 * gsm.getParty().get(4).getCurrentHealth() / gsm.getParty().get(4).getHealthStat())), 33);
        nameFont.draw(batch, gsm.getParty().get(4).getName().toUpperCase(), 91,644);
        nameFont.draw(batch, "Level: " + Integer.toString(gsm.getParty().get(4).getLevel()), 91,605);
        batch.draw(pokemonIcons.get(4), 758, 409, 310, 310);
    }

    private void drawSixthPokemon(SpriteBatch batch) {
        batch.draw(panel, 54, 183);
        batch.draw(blankHealthBar, 90,231);
        batch.draw(greenBar, 93, 235, (int)(672 *
                (1.0 * gsm.getParty().get(5).getCurrentHealth() / gsm.getParty().get(5).getHealthStat())), 33);
        nameFont.draw(batch, gsm.getParty().get(5).getName().toUpperCase(), 91,380);
        nameFont.draw(batch, "Level: " + Integer.toString(gsm.getParty().get(5).getLevel()), 91,341);
        batch.draw(pokemonIcons.get(5), 758, 145, 310, 310);
    }

    /**
     * Swap the pokemon in position's position and selectedPokemon
     * @param position
     */
    private void swapPokemon(int position) {
        Pokemon temp = gsm.getParty().get(selectedPokemon);
        gsm.getParty().set(selectedPokemon, gsm.getParty().get(position));
        gsm.getParty().set(position, temp);
        Texture textureTemp = pokemonIcons.get(selectedPokemon);
        pokemonIcons.set(selectedPokemon, pokemonIcons.get(position));
        pokemonIcons.set(position, textureTemp);
        selectedPokemon = -1;
    }
    @Override
    public void update(double dt) {
        if (MyInput.clicked()) {
            int x = MyInput.getX();
            int y = MyInput.getY();
            if (x >= 814 && x <= 1068 && y >= 1673 && y <= 1890) {

                    gsm.setState(new MainMenuState(gsm));
                    dispose();
            }  else if (x >= 8 && x <= 950 && y >= 218 && y <= 424) {
                //First Pokemon
                if (onSwitchButton && selectedPokemon == -1) {
                    selectedPokemon = 0;
                } else if (onSwitchButton && selectedPokemon != 0) {
                    swapPokemon(0);

                } else {
                    gsm.setState(new StatusState(gsm, gsm.getParty().get(0), false));
                    dispose();
                }
            }   else if (x >= 8 && x <= 950 && y >= 462 && y <= 651 && hasSecondPokemon()) {
                //Second Pokemon
                if (onSwitchButton && selectedPokemon == -1) {
                    selectedPokemon = 1;
                } else if (onSwitchButton && selectedPokemon != 1) {
                    swapPokemon(1);

                } else {
                    gsm.setState(new StatusState(gsm, gsm.getParty().get(1), false));
                    dispose();
                }
            }  else if (x >= 8 && x <= 950 && y >= 750 && y <= 909 && hasThirdPokemon()) {
                //Third Pokemon
                if (onSwitchButton && selectedPokemon == -1) {
                    selectedPokemon = 2;
                } else if (onSwitchButton && selectedPokemon != 2) {
                    swapPokemon(2);

                } else {
                    gsm.setState(new StatusState(gsm, gsm.getParty().get(2), false));
                    dispose();
                }
            }  else if (x >= 8 && x <= 950 && y >= 1032 && y <= 1170 && hasFourthPokemon()) {
                //Fourth Pokemon
                if (onSwitchButton && selectedPokemon == -1) {
                    selectedPokemon = 3;
                } else if (onSwitchButton && selectedPokemon != 3) {
                    swapPokemon(3);

                } else {
                    gsm.setState(new StatusState(gsm, gsm.getParty().get(3), false));
                    dispose();
                }
            }  else if (x >= 8 && x <= 950 && y >= 1309 && y <= 1433 && hasFifthPokemon()) {
                //Fifth Pokemon
                if (onSwitchButton && selectedPokemon == -1) {
                    selectedPokemon = 4;
                } else if (onSwitchButton && selectedPokemon != 4) {
                    swapPokemon(4);

                } else {
                    gsm.setState(new StatusState(gsm, gsm.getParty().get(4), false));
                    dispose();
                }
            }  else if (x >= 8 && x <= 950 && y >= 1553 && y <= 1672 && hasSixthPokemon()) {
                //Sixth Pokemon
                if (onSwitchButton && selectedPokemon == -1) {
                    selectedPokemon = 5;
                } else if (onSwitchButton && selectedPokemon != 5) {
                    swapPokemon(5);

                } else {
                    gsm.setState(new StatusState(gsm, gsm.getParty().get(5), false));
                    dispose();
                }
            } else if (x >= 44 && x <= 340 && y >= 1836 && y <= 1905) {
                if (onSwitchButton) {
                    onSwitchButton = false;
                    selectedPokemon = -1;
                }
            } else if (x >= 451 && x <= 775 && y >= 1832 && y <= 1902) {
                if (!onSwitchButton) {
                    onSwitchButton = true;
                }
            }

            else {
                Gdx.app.log("Screen Click", x + ", " + y);
            }
        }
    }

    private boolean hasSecondPokemon() {
        if (gsm.getParty().size() > 1) {
            return true;
        }
        return false;
    }

    private boolean hasThirdPokemon() {
        if (gsm.getParty().size() > 2) {
            return true;
        }
        return false;
    }

    private boolean hasFourthPokemon() {
        if (gsm.getParty().size() > 3) {
            return true;
        }
        return false;
    }

    private boolean hasFifthPokemon() {
        if (gsm.getParty().size() > 4) {
            return true;
        }
        return false;
    }

    private boolean hasSixthPokemon() {
        if (gsm.getParty().size() > 5) {
            return true;
        }
        return false;
    }

    @Override
    protected void dispose() {
        nameFont.dispose();
        levelFont.dispose();
        for (int i = 0; i < pokemonIcons.size(); i++) {
            pokemonIcons.get(i).dispose();
        }
        gsm.getLoader().unload("pokemonMenu/background.png");
        gsm.getLoader().unload("pokemonMenu/panel.png");
        gsm.getLoader().unload("pokemonMenu/emptyHealthBar.png");
        gsm.getLoader().unload("pokemonMenu/greenLife.png");
        gsm.getLoader().unload("pokemonMenu/healthCap.png");
        gsm.getLoader().unload("pokemonMenu/grayButton.png");
        gsm.getLoader().unload("pokemonMenu/greenButton.png");
    }
}
