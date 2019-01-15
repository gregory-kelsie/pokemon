package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.pokemon.toronto.game.com.pokemon.toronto.input.GestureHandler;
import com.pokemon.toronto.game.com.pokemon.toronto.input.InputHandler;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;
import com.pokemon.toronto.game.com.pokemon.toronto.pokedex.Pokedex;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gregorykelsie on 2018-07-12.
 */

public class PokedexState extends GameState {

    private GameStateManager gsm;

    private Texture background;
    private Texture blackDivider;
    private Texture grayArea;

    private Texture obtainedEntry;
    private Texture seenEntry;
    private Texture noEntry;

    private Texture selectedEntry;
    private Texture selectedNoEntry;

    private Texture upButton;
    private Texture downButton;

    private BitmapFont regularFont; //Textbox and Skill

    private int scrollAmt;
    private float scrollPower; //For actual scrolling

    private int selectOffset;
    private Pokedex pokedex;
    private List<Texture> displayIcons;
    private Texture selectedPokemon;

    public PokedexState(GameStateManager gsm) {

        this.gsm = gsm;
        Gdx.input.setInputProcessor(new GestureDetector(new GestureHandler()));
        this.pokedex = new Pokedex();
        this.scrollAmt = 0;
        this.selectOffset = 0;
        this.scrollPower = 0;
        loadAssets();


    }

    private void loadAssets() {
        background = new Texture("pokedex/bg.png");
        blackDivider = new Texture("pokedex/blackbar.png");
        grayArea = new Texture("pokedex/graybar.png");

        obtainedEntry = new Texture("pokedex/obtained.png");
        seenEntry = new Texture("pokedex/seen.png");
        noEntry = new Texture("pokedex/hiddenbar.png");

        selectedEntry = new Texture("pokedex/highlight.png");
        selectedNoEntry = new Texture("pokedex/smallhighlight.png");

        upButton = new Texture("pokedex/up.png");
        downButton = new Texture("pokedex/down.png");

        regularFont = new BitmapFont(Gdx.files.internal("battle/font/regularFont.fnt"));
        regularFont.setColor(Color.WHITE);

        displayIcons = new ArrayList<Texture>();
        for (int i = 0; i < 14; i++) {
            displayIcons.add(new Texture(pokedex.getKantoDex().get(i).getMiniIcon()));
        }

        selectedPokemon = new Texture(pokedex.getKantoDex().get(0).getSprite());

    }
    @Override
    public void render(SpriteBatch batch) {
        batch.draw(background, 0, 0, 1080, 1920);
        batch.draw(grayArea, 0, 1391, 1080, 289);
        batch.draw(blackDivider, 0, 1257, 1080, 134);

        //batch.draw(upButton, 142, 959, 159, 176);
        //batch.draw(downButton, 142, 251, 159, 176);

        //batch.draw(selectedPokemon, 21, 1340, 396, 396);
        batch.draw(selectedPokemon, 21, 1340, 396, 396, 0, 0,
                selectedPokemon.getWidth(), selectedPokemon.getHeight(), true, false);

        for (int i = 0; i < 14; i++) {
            batch.draw(obtainedEntry, 410, 1623 - (i * (29 + 88)), 632, 88);
            batch.draw(displayIcons.get(i), 415, 1606 - (i * (29 + 88)), 128, 128);
            String name = pokedex.getKantoDex().get(scrollAmt + i).getName();
            if (scrollAmt + i + 1 < 10) {
                regularFont.draw(batch, "00" + (scrollAmt + i + 1) + "   " + name,649, 1686 - (i * (29 + 88)));
            } else if (scrollAmt + i + 1 < 100) {
                regularFont.draw(batch, "0" + (scrollAmt + i + 1) + "   " + name,649, 1686 - (i * (29 + 88)));
            } else {
                regularFont.draw(batch, Integer.toString(scrollAmt + i + 1) + "   " + name,649, 1686 - (i * (29 + 88)));
            }
        }
        batch.draw(selectedEntry, 410, 1623 - (selectOffset * (29 + 88)), 632, 88);
    }

    @Override
    public void update(double dt) {
        int x = MyInput.getX();
        int y = MyInput.getY();

        if (MyInput.isPanning()) {
            float dx = MyInput.getDeltaX();
            float dy = MyInput.getDeltaY();
            if (x >= 320 && dy != 0) {
                if (dy > 1) { //scrolling up but finger goes down
                    if (scrollAmt != 0) {
                        scrollPower += dy;
                        if (scrollPower >= 20) {
                            scrollUp();
                            scrollPower = 0;
                        }
                    }
                } else if (dy < -1) {
                    if (scrollAmt  != 784 - 14) {
                        scrollPower += dy;
                        if (scrollPower <= -20) {
                            scrollDown();
                            scrollPower = 0;
                        }
                    }
                }
            } else {
                scrollPower = 0;

            }
        }
        if (MyInput.tapped()) {
            Gdx.app.log("hub - " + scrollAmt, x + "," + y);
            if (x >= 117 && x <= 282 && y >= 809 && y <= 952) {
                //Clicked up
                if (scrollAmt != 0) {
                    scrollUp();
                    gsm.getGameCallBack().pulsate();
                }
            } else if (x >= 117 && x <= 282 && y >= 1477 && y <= 1684) {
                //Clicked down
                if (scrollAmt != 784 - 14) { //# of Pokemon in dex - 14 entries displayed
                    scrollDown();
                    gsm.getGameCallBack().pulsate();
                }
            } else if (x >= 680 && x <= 770 && y >= 1852 && y <= 1920) {
                //Clicked Right arrow
                if (scrollAmt >= 0 && scrollAmt < 151) {
                    scrollAmt = 151;
                } else if (scrollAmt >= 151 && scrollAmt < 251) {
                    scrollAmt = 251;
                } else if (scrollAmt >= 251 && scrollAmt < 386) {
                    scrollAmt = 386;
                } else if (scrollAmt >= 386 && scrollAmt < 493) {
                    scrollAmt = 493;
                } else if (scrollAmt >= 493 && scrollAmt < 649) {
                    scrollAmt = 649;
                } else if (scrollAmt >= 649 && scrollAmt < 721) {
                    scrollAmt = 721;
                }
                refreshSprites();
            } else if (x >= 564 && x <= 643 && y >= 1852 && y <= 1920) {
                //Clicked left arrow
                if (scrollAmt >= 151 && scrollAmt < 251) {
                    //Johto goes to Kanto
                    scrollAmt = 0;
                } else if (scrollAmt >= 251 && scrollAmt < 386) {
                    //Hoenn goes to Johto
                    scrollAmt = 151;
                } else if (scrollAmt >= 386 && scrollAmt < 493) {
                    //Sinnoh goes to Hoenn
                    scrollAmt = 251;
                } else if (scrollAmt >= 493 && scrollAmt < 649) {
                    scrollAmt = 386;
                } else if (scrollAmt >= 649 && scrollAmt < 721) {
                    scrollAmt = 493;
                }
                refreshSprites();
            }

            else if (x >= 382 && x <= 1020 && y >= 210 && y <= 298) {
                //First Entry 29 DIFFERENCE AND 88 SIZE
                selectOffset = 0;
                changeSelectedPokemon();
            } else if (x >= 382 && x <= 1020 && y >= 327 && y <= 415) {
                selectOffset = 1;
                changeSelectedPokemon();
            } else if (x >= 382 && x <= 1020 && y >= 444 && y <= 532) {
                selectOffset = 2;
                changeSelectedPokemon();
            } else if (x >= 382 && x <= 1020 && y >= 561 && y <= 649) {
                selectOffset = 3;
                changeSelectedPokemon();
            } else if (x >= 382 && x <= 1020 && y >= 678 && y <= 766) {
                selectOffset = 4;
                changeSelectedPokemon();
            } else if (x >= 382 && x <= 1020 && y >= 795 && y <= 883) {
                selectOffset = 5;
                changeSelectedPokemon();
            } else if (x >= 382 && x <= 1020 && y >= 912 && y <= 1000) {
                selectOffset = 6;
                changeSelectedPokemon();
            } else if (x >= 382 && x <= 1020 && y >= 1029 && y <= 1117) {
                selectOffset = 7;
                changeSelectedPokemon();
            } else if (x >= 382 && x <= 1020 && y >= 1146 && y <= 1234) {
                selectOffset = 8;
                changeSelectedPokemon();
            } else if (x >= 382 && x <= 1020 && y >= 1263 && y <= 1351) {
                selectOffset = 9;
                changeSelectedPokemon();
            } else if (x >= 382 && x <= 1020 && y >= 1380 && y <= 1468) {
                selectOffset = 10;
                changeSelectedPokemon();
            } else if (x >= 382 && x <= 1020 && y >= 1497 && y <= 1585) {
                selectOffset = 11;
                changeSelectedPokemon();
            } else if (x >= 382 && x <= 1020 && y >= 1614 && y <= 1702) {
                selectOffset = 12;
                changeSelectedPokemon();
            } else if (x >= 382 && x <= 1020 && y >= 1731 && y <= 1819) {
                selectOffset = 13;
                changeSelectedPokemon();
            }


            else if (x >= 892 && x <= 1080 && y >= 1853 && y <= 1910) {
                Gdx.input.setInputProcessor(new InputHandler());
                gsm.setState(new HubState(gsm));
                dispose();
            }
        }

    }

    private void changeSelectedPokemon() {
        selectedPokemon.dispose();
        selectedPokemon = new Texture(pokedex.getKantoDex().get(scrollAmt + selectOffset).getSprite());
    }

    private void scrollUp() {
        scrollAmt--;
        displayIcons.get(13).dispose();
        for (int i = 13; i > 0; i--) {
            displayIcons.set(i, displayIcons.get(i - 1));
        }
        displayIcons.set(0, new Texture(pokedex.getKantoDex().get(scrollAmt).getMiniIcon()));
        changeSelectedPokemon();
    }
    private void scrollDown() {
        scrollAmt++;
        displayIcons.get(0).dispose();
        for (int i = 0; i < 13; i++) {
            displayIcons.set(i, displayIcons.get(i + 1));
        }
        displayIcons.set(13, new Texture(pokedex.getKantoDex().get(scrollAmt + 13).getMiniIcon()));
        changeSelectedPokemon();
    }

    private void refreshSprites() {
        for (int i = 0; i < 14; i++) {
            displayIcons.get(i).dispose();
            displayIcons.set(i,
                    new Texture(pokedex.getKantoDex().get(scrollAmt + i).getMiniIcon()));
        }
        selectOffset = 0;
        changeSelectedPokemon();
    }

    @Override
    public void dispose() {
        background.dispose();
        blackDivider.dispose();
        grayArea.dispose();
        obtainedEntry.dispose();
        seenEntry.dispose();
        noEntry.dispose();
        selectedEntry.dispose();
        selectedNoEntry.dispose();
        upButton.dispose();
        downButton.dispose();
        regularFont.dispose();
        for (Texture t: displayIcons) {
            t.dispose();
        }
        selectedPokemon.dispose();
    }
}
