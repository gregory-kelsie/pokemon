package com.pokemon.toronto.game.com.pokemon.toronto.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
/**
 * Created by Gregory on 6/5/2017.
 */
public class InputHandler extends InputAdapter {
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        // TODO Auto-generated method stub
        MyInput.setMouseDown(true, screenX, screenY);

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        // TODO Auto-generated method stub
        MyInput.setMouseReleased(true, screenX, screenY);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        // TODO Auto-generated method stub

        return super.touchDragged(screenX, screenY, pointer);
    }

}