package com.pokemon.toronto.game.com.pokemon.toronto.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by gregorykelsie on 2018-07-13.
 */

public class GestureHandler extends GestureDetector.GestureAdapter {

    @Override
    public boolean tap(float x, float y, int count, int button) {
        Gdx.app.log("tap", "x: " + x + ", y: " + y + ", count: " + count + " button: " + button);
        MyInput.tap(Math.round(x), Math.round(y));
        return super.tap(x, y, count, button);
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        Gdx.app.log("fling", "velocityX: " + velocityX + ", velocityY, : " + velocityY + ", button: " + button);
        return super.fling(velocityX, velocityY, button);
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        Gdx.app.log("pan", "x: " + x + ", y: " + y + ", deltaX: " + deltaX + ", deltaY: " + deltaY);
        MyInput.pan(Math.round(x), Math.round(y), deltaX, deltaY);
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        Gdx.app.log("panstop", "x: " + x + ", y: " + y);
        MyInput.stopPan();
        return false;
    }
}
