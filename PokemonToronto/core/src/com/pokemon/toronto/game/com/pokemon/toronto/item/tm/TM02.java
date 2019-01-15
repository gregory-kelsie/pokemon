package com.pokemon.toronto.game.com.pokemon.toronto.item.tm;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemBlob;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Dragon.DragonClaw;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.WorkUp;

/**
 * Created by gregorykelsie on 2018-02-09.
 */

public class TM02 extends Tm {
    public TM02() {
        super(new ItemBlob.TM02Blob(), "bag/icons/dragontm.png", 2, new DragonClaw());
    }

    @Override
    public boolean ableToUse(Pokemon p) {
        if (p.canLearnTM(tmId)) {
            return true;
        }
        return false;
    }
}
