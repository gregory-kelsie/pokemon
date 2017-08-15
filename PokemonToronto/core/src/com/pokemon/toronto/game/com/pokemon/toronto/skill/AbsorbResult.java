package com.pokemon.toronto.game.com.pokemon.toronto.skill;

import java.util.List;

/**
 * Created by Gregory on 8/15/2017.
 */

public class AbsorbResult {
    private boolean absorbed;
    private List<String> absorbText;


    public AbsorbResult(List<String> absorbText) {
        this.absorbed = true;
        this.absorbText = absorbText;
    }

    public AbsorbResult(boolean absorbed) {
        this.absorbed = absorbed;
        this.absorbText = null;
    }

    public boolean hasAbsorbed() {
        return absorbed;
    }

    public List<String> getAbsorbResult() {
        return absorbText;
    }
}
