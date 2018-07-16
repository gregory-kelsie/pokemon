package com.pokemon.toronto.game.com.pokemon.toronto.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
/**
 * Created by Gregory on 6/5/2017.
 */
public class InputHandler extends InputAdapter {
    /**
     * Return true and set the input to handle a touch.
     * @param screenX The x coordinate of the touch,
     *                origin is in the upper left corner
     * @param screenY The y coordinate of the touch,
     *                origin is in the upper left corner
     * @param pointer The pointer for the touch.
     * @param button The button.
     * @return Whether the input was processed.
     */
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        MyInput.setMouseDown(screenX, screenY);
        return true;
    }

    /**
     * Return true and set the input to handle a touch release.
     * @param screenX The x coordinate of the release,
     *                origin is in the upper left corner
     * @param screenY The y coordinate of the release,
     *                origin is in the upper left corner
     * @param pointer The pointer for the touch.
     * @param button The button.
     * @return Whether the input was processed.
     */
    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        MyInput.setMouseReleased(screenX, screenY);
        return true;
    }

    /**
     * Return true and set the input to handle a drag.
     * @param screenX The x coordinate of the drag,
     *                origin is in the upper left corner
     * @param screenY The y coordinate of the drag,
     *                origin is in the upper left corner
     * @param pointer The pointer for the touch.
     * @return Whether the input was processed.
     */
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        MyInput.setDrag();
        Gdx.app.log("drag", "screenX: " + screenX + ", screenY: " + screenY + ", pointer: " + pointer);
        return super.touchDragged(screenX, screenY, pointer);
    }

}