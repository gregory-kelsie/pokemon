package com.pokemon.toronto.game.com.pokemon.toronto.animation.skill;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SkillAnimation;
import com.pokemon.toronto.game.com.pokemon.toronto.animation.SpriteDynamicAnimation;

/**
 * Created by Gregory on 6/19/2017.
 */
public class TackleAnimation extends SkillAnimation {
    private int state;
    private final int MOVE_SPRITE_PHASE = 0;
    private final int SHOW_ATTACK_TEXTURE = 1;
    private final int FLASH_ENEMY = 2;
    private final int FINISHED = 3;
    private SpriteDynamicAnimation sda;

    private double flashCounter;
    private double flashTotalTimeCounter;
    private boolean showEnemyThroughFlash;
    private boolean showPlayerThroughFlash;

    private double counter;

    private Texture hitTexture;
    private Sound hitSound;
    public TackleAnimation(boolean playerUser) {
        super(playerUser);
        hitSound = Gdx.audio.newSound(Gdx.files.internal("sounds/hit.wav"));
        state = MOVE_SPRITE_PHASE;
        if (playerUser) {
            this.sda = new SpriteDynamicAnimation(playerX, true);
        } else {
            this.sda = new SpriteDynamicAnimation(enemyX, false);
        }
        flashCounter = 0;
        flashTotalTimeCounter = 0;
        showEnemyThroughFlash = true;
        showPlayerThroughFlash = true;
        hitTexture = new Texture("battle/skillAnimations/hit.png");
        counter = 0;
    }

    @Override
    public void update(double dt) {
        if (this.playerUser) {
            updatePlayerTackleAnimation(dt);
        } else {
            updateEnemyTackleAnimation(dt);
        }
    }


    private void updatePlayerTackleAnimation(double dt) {
        if (state == MOVE_SPRITE_PHASE) {
            sda.update(dt);
            playerX = sda.getX();
            if (sda.isFinished()) {
                state = SHOW_ATTACK_TEXTURE;
                hitSound.play();
                sda.restart();
            }
        } else if (state == SHOW_ATTACK_TEXTURE) {
            counter += dt;

            if (counter >= 0.08) {
                counter = 0;
                state = FLASH_ENEMY;
            }

        }else if (state == FLASH_ENEMY) {
            flashCounter += dt;
            flashTotalTimeCounter += dt;
            if (flashCounter >= 0.1) {
                flashCounter = 0;
                showEnemyThroughFlash = !showEnemyThroughFlash;
            }
            if (flashTotalTimeCounter >= 1) {
                state = FINISHED;
                showEnemyThroughFlash = true;
                flashCounter = 0;
                flashTotalTimeCounter = 0;
                finished = true;
            }
        }
    }

    public boolean displayEnemyPokemon() {
        if (state == FLASH_ENEMY) {
            if (!showEnemyThroughFlash) {
                return false;
            }
            return true;
        }
        return true;
    }

    public boolean displayUserPokemon() {
        if (state == FLASH_ENEMY) {
            if (!showPlayerThroughFlash) {
                return false;
            }
            return true;
        }
        return true;
    }

    private void updateEnemyTackleAnimation(double dt) {
        if (state == MOVE_SPRITE_PHASE) {
            sda.update(dt);
            enemyX = sda.getX();
            if (sda.isFinished()) {
                state = SHOW_ATTACK_TEXTURE;
                hitSound.play();
                sda.restart();
            }
        } else if (state == SHOW_ATTACK_TEXTURE) {
            counter += dt;

            if (counter >= 0.08) {
                counter = 0;
                state = FLASH_ENEMY;
            }

        }else if (state == FLASH_ENEMY) {
            flashCounter += dt;
            flashTotalTimeCounter += dt;
            if (flashCounter >= 0.1) {
                flashCounter = 0;
                showPlayerThroughFlash = !showPlayerThroughFlash;
            }
            if (flashTotalTimeCounter >= 1) {
                state = FINISHED;
                showPlayerThroughFlash = true;
                flashCounter = 0;
                flashTotalTimeCounter = 0;
                finished = true;
            }
        }
    }

    @Override
    public void drawAnimation(SpriteBatch batch) {
        if (state == SHOW_ATTACK_TEXTURE) {
            if (playerUser) {
                batch.draw(hitTexture, 730, 1680);
            } else {
                batch.draw(hitTexture, 210, 1470);
            }
        }
    }

    @Override
    public void drawAnimationBackground(SpriteBatch batch) {

    }

    @Override
    public void render(SpriteBatch batch) {

    }

    public void dispose() {
        hitTexture.dispose();
        hitSound.dispose();
    }
}
