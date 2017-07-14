package com.pokemon.toronto.game.com.pokemon.toronto.animation;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;

/**
 * Created by Gregory on 6/19/2017.
 */
public abstract class SkillAnimation {
    protected Pokemon user;
    protected Pokemon enemy;
    protected boolean finished;
    protected boolean playerUser;
    protected int playerX;
    protected int playerY;

    protected int enemyX;
    protected int enemyY;

    protected boolean drawAnimationBackground;

    public SkillAnimation(boolean playerUser) {

        finished = false;
        this.playerUser = playerUser;

        playerX = 122;
        playerY = 1231;

        enemyX = 591;
        enemyY = 1460;
        drawAnimationBackground = false;

    }

    public boolean drawAnimationBackground() {
        return drawAnimationBackground;
    }

    protected void setUser(Pokemon p) {
        this.user = p;
    }

    protected void setEnemy(Pokemon p) {
        this.enemy = p;
    }

    public abstract void update(double dt);
    public abstract void render(SpriteBatch batch);

    public int getPlayerX() {
        return playerX;
    }

    public int getEnemyY() {
        return enemyY;
    }

    public int getEnemyX() {
        return enemyX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public boolean isFinished() {
        return finished;
    }

    public abstract void drawAnimationBackground(SpriteBatch batch);
    public abstract void drawAnimation(SpriteBatch batch);
    public boolean displayUserPokemon() {
        return true;
    }

    public boolean displayEnemyPokemon() {
        return true;
    }

    public void dispose() {

    }
}
