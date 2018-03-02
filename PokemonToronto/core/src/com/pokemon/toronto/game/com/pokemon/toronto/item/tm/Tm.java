package com.pokemon.toronto.game.com.pokemon.toronto.item.tm;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.item.Item;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemBlob;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemId;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

/**
 * Created by gregorykelsie on 2018-02-09.
 */

public class Tm extends Item {
    protected int tmId;
    protected Skill skill;
    public Tm(ItemBlob info, String image, int tmId, Skill skill) {
        super(info, image);
        this.tmId = tmId;
        this.skill = skill;
    }

    @Override
    public boolean ableToUse(Pokemon p) {
        if (p.canLearnTM(tmId)) {
            return true;
        }
        return false;
    }

    public Skill getSkill() {
        return skill;
    }

    public int getTmId() {
        return tmId;
    }
}
