package com.pokemon.toronto.game.com.pokemon.toronto.pokemart.item;

import com.pokemon.toronto.game.com.pokemon.toronto.Ball.Ball;
import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;

/**
 * Created by Gregory on 8/18/2017.
 */

public class MartBall extends MartItem {
    private Ball ball;


    public MartBall(Ball ball, int price, int rubyPrice, String storeImage, String headerImage) {
        super(ball, price, rubyPrice, storeImage, headerImage);
    }
}
