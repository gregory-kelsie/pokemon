package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;

/**
 * Created by Gregory on 6/23/2017.
 */
public class StatusState extends GameState{
    private GameStateManager gsm;
    private Texture background;
    private Pokemon pokemon;
    private Texture pokemonTexture;
    private BitmapFont regularFont;
    private boolean cameFromBox;
    public StatusState(GameStateManager gsm, Pokemon pokemon, boolean cameFromBox) {
        this.gsm = gsm;
        background = new Texture("pokemonMenu/statusScreen.png");
        this.pokemon = pokemon;
        pokemonTexture = new Texture(pokemon.getMapIconPath());
        regularFont = new BitmapFont(Gdx.files.internal("battle/font/regularFont.fnt"));
        regularFont.setColor(Color.BLACK);
        this.cameFromBox = cameFromBox;
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(background, 0, 0);
        batch.draw(pokemonTexture, 75, 1338, 340, 340);
        renderNameAndItemBox(batch);
        renderStatBox(batch);
        renderInfoBox(batch);
        renderEvBox(batch);
        renderIvBox(batch);

    }

    private void renderEvBox(SpriteBatch batch) {
        regularFont.draw(batch, pokemon.getHealthEV() + "", 431, 342);
        regularFont.draw(batch, pokemon.getAttackEV() + "", 431, 294);
        regularFont.draw(batch, pokemon.getDefenseEV() + "", 431, 246);
        regularFont.draw(batch, pokemon.getSpAttackEV() + "", 431, 198);
        regularFont.draw(batch, pokemon.getSpDefenseEV() + "", 431, 156);
        regularFont.draw(batch, pokemon.getSpeedEV() + "", 431, 105);
    }

    private void renderIvBox(SpriteBatch batch) {
        regularFont.draw(batch, pokemon.getHealthIV() + "", 935, 342);
        regularFont.draw(batch, pokemon.getAttackIV() + "", 935, 294);
        regularFont.draw(batch, pokemon.getDefenseIV() + "", 935, 246);
        regularFont.draw(batch, pokemon.getSpAttackIV() + "", 935, 198);
        regularFont.draw(batch, pokemon.getSpDefenseIV() + "", 935, 156);
        regularFont.draw(batch, pokemon.getSpeedIV() + "", 935, 105);
    }

    private void renderNameAndItemBox(SpriteBatch batch) {
        regularFont.draw(batch, pokemon.getName() +
                "\nLv." + pokemon.getLevel(), 42, 1812);
        regularFont.draw(batch, pokemon.getCurrentHealth() + "/" +
                pokemon.getHealthStat(), 918, 1701);
        regularFont.draw(batch, "None", 15, 1227);
    }

    private void renderInfoBox(SpriteBatch batch) {
        regularFont.draw(batch, pokemon.getId() +"", 828, 1062);
        regularFont.draw(batch, pokemon.getName(), 828, 993);
        regularFont.draw(batch, pokemon.getNatureString(), 828, 849);
        regularFont.draw(batch, "" + Math.round(pokemon.getDisplayedExp()), 828, 774);
        regularFont.draw(batch, "" +  (pokemon.getNextLevelExp()
                - Math.round(pokemon.getDisplayedExp())), 828, 700);
        regularFont.draw(batch, pokemon.getAbilityString(), 828, 633);
    }
    private void renderStatBox(SpriteBatch batch) {
        regularFont.draw(batch, pokemon.getAttackStat() +"", 957, 1605);
        regularFont.draw(batch, pokemon.getDefenseStat() +"", 957, 1548);
        regularFont.draw(batch, pokemon.getSpecialAttackStat() +"", 957, 1491);
        regularFont.draw(batch, pokemon.getSpecialDefenseStat() +"", 957, 1422);
        regularFont.draw(batch, pokemon.getSpeedStat() +"", 957, 1365);
    }
    @Override
    public void update(double dt) {
        if (MyInput.clicked()) {
            int x = MyInput.getX();
            int y = MyInput.getY();
            if (x >= 852 && x <= 1080 && y >= 0 && y <= 160) {
                if (cameFromBox) {
                    gsm.setState(new BoxState(gsm, false));
                } else {
                    gsm.setState(new LoadingState(gsm, LoadingState.POKEMON_MENU));
                }
                dispose();
            }
            Gdx.app.log("Screen Click", x + ", " + y);
        }
    }

    @Override
    protected void dispose() {
        background.dispose();
        pokemonTexture.dispose();
        regularFont.dispose();
    }
}
