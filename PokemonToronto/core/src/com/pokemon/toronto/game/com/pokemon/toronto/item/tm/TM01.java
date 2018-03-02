package com.pokemon.toronto.game.com.pokemon.toronto.item.tm;

import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.item.ItemBlob;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Normal.WorkUp;

/**
 * Created by gregorykelsie on 2018-02-09.
 */

public class TM01 extends Tm {
    public TM01() {
        super(new ItemBlob.TM01Blob(), "bag/icons/normaltm.png", 1, new WorkUp());
    }

    @Override
    public boolean ableToUse(Pokemon p) {

        if (p.canLearnTM(tmId)) {
            return true;
        }
        return false;
    }
}
