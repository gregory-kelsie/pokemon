package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;

/**
 * Created by Gregory on 6/23/2017.
 */
public class StatusState extends GameState{
    private GameStateManager gsm;
    private Texture background;
    private int pokemonPosition;
    private Texture pokemonTexture;
    private BitmapFont regularFont;
    public StatusState(GameStateManager gsm, int pokemonPosition) {
        this.gsm = gsm;
        background = new Texture("pokemonMenu/statusScreen.png");
        this.pokemonPosition = pokemonPosition;
        pokemonTexture = new Texture(gsm.getParty().get(pokemonPosition).getMapIconPath());
        regularFont = new BitmapFont(Gdx.files.internal("battle/font/regularFont.fnt"));
        regularFont.setColor(Color.BLACK);
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
        regularFont.draw(batch, gsm.getParty().get(pokemonPosition).getHealthEV() + "", 431, 342);
        regularFont.draw(batch, gsm.getParty().get(pokemonPosition).getAttackEV() + "", 431, 294);
        regularFont.draw(batch, gsm.getParty().get(pokemonPosition).getDefenseEV() + "", 431, 246);
        regularFont.draw(batch, gsm.getParty().get(pokemonPosition).getSpAttackEV() + "", 431, 198);
        regularFont.draw(batch, gsm.getParty().get(pokemonPosition).getSpDefenseEV() + "", 431, 156);
        regularFont.draw(batch, gsm.getParty().get(pokemonPosition).getSpeedEV() + "", 431, 105);
    }

    private void renderIvBox(SpriteBatch batch) {
        regularFont.draw(batch, gsm.getParty().get(pokemonPosition).getHealthIV() + "", 935, 342);
        regularFont.draw(batch, gsm.getParty().get(pokemonPosition).getAttackIV() + "", 935, 294);
        regularFont.draw(batch, gsm.getParty().get(pokemonPosition).getDefenseIV() + "", 935, 246);
        regularFont.draw(batch, gsm.getParty().get(pokemonPosition).getSpAttackIV() + "", 935, 198);
        regularFont.draw(batch, gsm.getParty().get(pokemonPosition).getSpDefenseIV() + "", 935, 156);
        regularFont.draw(batch, gsm.getParty().get(pokemonPosition).getSpeedIV() + "", 935, 105);
    }

    private void renderNameAndItemBox(SpriteBatch batch) {
        regularFont.draw(batch, gsm.getParty().get(pokemonPosition).getName() +
                "\nLv." + gsm.getParty().get(pokemonPosition).getLevel(), 42, 1812);
        regularFont.draw(batch, gsm.getParty().get(pokemonPosition).getCurrentHealth() + "/" +
                gsm.getParty().get(pokemonPosition).getHealthStat(), 918, 1701);
        regularFont.draw(batch, "None", 15, 1227);
    }

    private void renderInfoBox(SpriteBatch batch) {
        regularFont.draw(batch, gsm.getParty().get(pokemonPosition).getId() +"", 828, 1062);
        regularFont.draw(batch, gsm.getParty().get(pokemonPosition).getName(), 828, 993);
        regularFont.draw(batch, gsm.getParty().get(pokemonPosition).getNatureString(), 828, 849);
        regularFont.draw(batch, "" + Math.round(gsm.getParty().get(pokemonPosition).getDisplayedExp()), 828, 774);
        regularFont.draw(batch, "" +  (gsm.getParty().get(pokemonPosition).getNextLevelExp()
                - Math.round(gsm.getParty().get(pokemonPosition).getDisplayedExp())), 828, 700);
        regularFont.draw(batch, gsm.getParty().get(pokemonPosition).getAbilityString(), 828, 633);
    }
    private void renderStatBox(SpriteBatch batch) {
        regularFont.draw(batch, gsm.getParty().get(pokemonPosition).getAttackStat() +"", 957, 1605);
        regularFont.draw(batch, gsm.getParty().get(pokemonPosition).getDefenseStat() +"", 957, 1548);
        regularFont.draw(batch, gsm.getParty().get(pokemonPosition).getSpecialAttackStat() +"", 957, 1491);
        regularFont.draw(batch, gsm.getParty().get(pokemonPosition).getSpecialDefenseStat() +"", 957, 1422);
        regularFont.draw(batch, gsm.getParty().get(pokemonPosition).getSpeedStat() +"", 957, 1365);
    }
    @Override
    public void update(double dt) {
        if (MyInput.clicked()) {
            int x = MyInput.getX();
            int y = MyInput.getY();
            if (x >= 852 && x <= 1080 && y >= 0 && y <= 160) {
                gsm.setState(new LoadingState(gsm, LoadingState.POKEMON_MENU));
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
