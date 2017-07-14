package com.pokemon.toronto.game.com.pokemon.toronto.animation;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 6/5/2017.
 */
public class AnimationFactory {
    public static Animation getIvyAnimation(AssetManager loader) {
        RotatingAnimation animation;
        List<Frame> frames = new ArrayList<Frame>();
        frames.add(new Frame(loader.get("professor_ivy.png", Texture.class), 0, 0));
        frames.add(new Frame(loader.get("professor_ivy2.png", Texture.class), 0, 0));
        animation = new RotatingAnimation(frames, 4, 0.1);
        return animation;
    }

    public static Animation getCharmanderAnimation(AssetManager loader) {
        Animation animation;
        List<Frame> frames = new ArrayList<Frame>();
        frames.add(new Frame(loader.get("starterImages/charmander.png", Texture.class), 0, 0));
        frames.add(new Frame(loader.get("starterImages/charmander02.png", Texture.class), 0, 0));
        frames.add(new Frame(loader.get("starterImages/charmander03.png", Texture.class), 0, 0));
        frames.add(new Frame(loader.get("starterImages/charmander04.png", Texture.class), 0, 0));
        frames.add(new Frame(loader.get("starterImages/charmander05.png", Texture.class), 0, 0));
        animation = new Animation(frames, 0.2);
        animation.setLooping(false);
        return animation;
    }

    public static Animation getPlayerTrainerAnimation() {
        Animation animation;
        List<Frame> frames = new ArrayList<Frame>();
        frames.add(new Frame(new Texture("battle/trainer/01.png"), 1080, 1341));
        frames.add(new Frame(new Texture("battle/trainer/02.png"), 1080, 1341));
        frames.add(new Frame(new Texture("battle/trainer/03.png"), 1080, 1341));
        frames.add(new Frame(new Texture("battle/trainer/04.png"), 1080, 1341));
        animation = new Animation(frames, 0.2, 249, 198);
        animation.setLooping(false);
        return animation;
    }

    public static Animation getBulbasaurAnimation(AssetManager loader) {
        Animation animation;
        List<Frame> frames = new ArrayList<Frame>();
        frames.add(new Frame(loader.get("starterImages/bulbasaur.png", Texture.class), 0, 0));
        frames.add(new Frame(loader.get("starterImages/bulbasaur02.png", Texture.class), 0, 0));
        frames.add(new Frame(loader.get("starterImages/bulbasaur03.png", Texture.class), 0, 0));
        frames.add(new Frame(loader.get("starterImages/bulbasaur04.png", Texture.class), 0, 0));
        frames.add(new Frame(loader.get("starterImages/bulbasaur05.png", Texture.class), 0, 0));
        animation = new Animation(frames, 0.2);
        animation.setLooping(false);
        return animation;
    }

    public static Animation getSquirtleAnimation(AssetManager loader) {
        Animation animation;
        List<Frame> frames = new ArrayList<Frame>();
        frames.add(new Frame(loader.get("starterImages/squirtle.png", Texture.class), 0, 0));
        frames.add(new Frame(loader.get("starterImages/squirtle02.png", Texture.class), 0, 0));
        frames.add(new Frame(loader.get("starterImages/squirtle03.png", Texture.class), 0, 0));
        frames.add(new Frame(loader.get("starterImages/squirtle04.png", Texture.class), 0, 0));
        frames.add(new Frame(loader.get("starterImages/squirtle05.png", Texture.class), 0, 0));
        animation = new Animation(frames, 0.2);
        animation.setLooping(false);
        return animation;
    }

    public static StraightLineAnimation getDroppingPokeballAnimation(AssetManager loader) {
        Texture t = loader.get("closedPokeball.png", Texture.class);
        Texture t2 = loader.get("openPokeball.png", Texture.class);
        int startingX = 540 - t.getWidth() / 2;
        StraightLineAnimation animation = new StraightLineAnimation(t, t2,
                5, StraightLineAnimation.DIRECTION_DOWN, startingX, 1920, startingX, 900);
        return animation;
    }
}
