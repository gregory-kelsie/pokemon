package com.pokemon.toronto.game.com.pokemon.toronto.skill;

import java.util.List;

/**
 * Created by Gregory on 6/18/2017.
 */
public class MoveResultPackage {

    private final int DAMAGE_ENEMY = 0;
    private final int NO_DAMAGE = 1;
    private final int RECOIL = 2;
    private final int SELF_DESCRUCT = 3;

    private List<String> initialResult;
    private List<String> afterResult; //usually empty or "X Lost health due to recoil"
    private boolean skillFailed; //Miss, Faint, Failed

    private int skillAction; //Refer to constants
    private int timesUsed; //0 - 5, 0 for non damage moves, 1 for normal moves, 1-5 for double slap / kick etc

    public MoveResultPackage(List<String> initialResult, List<String> afterResult, boolean skillFailed, int skillAction, int timesUsed) {
        this.initialResult = initialResult;
        this.afterResult = afterResult;
        this.skillFailed = skillFailed;
        this.skillAction = skillAction;
        this.timesUsed = timesUsed;
    }

    public List<String> getTextResult() {
        return initialResult;
    }

    public List<String> getAfterResult() {
        return afterResult;
    }
}
