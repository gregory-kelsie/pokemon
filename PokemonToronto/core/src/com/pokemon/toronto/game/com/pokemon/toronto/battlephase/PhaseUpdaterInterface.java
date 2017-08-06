package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

/**
 * Created by Gregory on 7/30/2017.
 */

public interface PhaseUpdaterInterface {
    public void setPhase(BattlePhase p);
    public void setUserFirstAttacker(Skill userSkill, Skill enemySkill);
    public void setEnemyFirstAttacker(Skill userSkill, Skill enemySkill);
    public boolean isUserPokemonFirstAttacker();
    public Pokemon getUserPokemon();
    public Pokemon getEnemyPokemon();
    public Skill getUserSkill();
    public Skill getEnemySkill();
    public boolean playerHasMorePokemon();
    public void endBattle();
    public BitmapFont getFont();
}
