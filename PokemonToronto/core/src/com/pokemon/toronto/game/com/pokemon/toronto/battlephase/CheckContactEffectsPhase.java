package com.pokemon.toronto.game.com.pokemon.toronto.battlephase;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;

/**
 * Created by Gregory on 8/11/2017.
 */

public class CheckContactEffectsPhase extends BattlePhase {
    private boolean isFirstAttackContact;

    private int state;
    private final int ABILITY_CONTACT = 0;
    private final int ITEM_CONTACT = 1;
    private final int DISPLAY_ABILITY_CONTACT_RESULTS = 2;
    private final int NO_CONTACT = 3;
    private Pokemon attacker;
    private Pokemon receiver;

    private double counter;
    private int textPosition;
    private String contactResults;
    private boolean enemyKilledUser;
    private boolean userKilledEnemy;
    public CheckContactEffectsPhase(PhaseUpdaterInterface pui, boolean isFirstAttackContact, Pokemon attacker,
                                    Pokemon receiver, Skill attackingSkill, boolean enemyKilledUser, boolean userKilledEnemy) {
        super(pui);
        this.enemyKilledUser = enemyKilledUser;
        this.userKilledEnemy = userKilledEnemy;
        this.isFirstAttackContact = isFirstAttackContact;
        if (attackingSkill.makesPhysicalContact()) {
            this.attacker = attacker;
            this.receiver = receiver;
            contactResults = "";
            counter = 0;
            textPosition = 0;
            state = ABILITY_CONTACT;
        } else {
            state = NO_CONTACT;
        }


    }

    @Override
    public void update(double dt) {
        if (state == ABILITY_CONTACT) {
            checkAbilityContact(dt);
        } else if (state == DISPLAY_ABILITY_CONTACT_RESULTS) {
            updateAbilityContactResults(dt);
        } else if (state == NO_CONTACT) {
            goToNextPhase();
        }
    }

    private void updateAbilityContactResults(double dt) {
        counter += dt;
        if (counter >= 0.05) {
            if (textPosition < contactResults.length()) {
                counter = 0;
                textPosition++;
            }
        }
        if (counter >= 1.5) {
            //go to next phase
            attacker.transferPreStatus();
            receiver.transferPreStatus();
            goToNextPhase();
        }
    }

    private void checkAbilityContact(double dt) {
        if (receiver.getAbility() == Pokemon.Ability.STATIC) {
            useStatic();
        } else if (receiver.getAbility() == Pokemon.Ability.POISON_POINT) {
            usePoisonPoint();
        } else if (receiver.getAbility() == Pokemon.Ability.POISON_TOUCH) {
            usePoisonTouch();
        } else if (receiver.getAbility() == Pokemon.Ability.FLAME_BODY) {
            useFlameBody();
        } else if (receiver.getAbility() == Pokemon.Ability.EFFECT_SPORE) {
            useEffectSpore();
        }

        if (!contactResults.equals("")) {
            state = DISPLAY_ABILITY_CONTACT_RESULTS;
        } else {
            //go to next phase
            goToNextPhase();
        }
    }

    private void goToNextPhase() {
        if (enemyKilledUser) {
            if (pui.playerHasMorePokemon() && !pui.waitingForNextPokemon()) {
                pui.setPhase(new PlayerPokemonFaintPhase(pui));
            } else if (!pui.playerHasMorePokemon()) {
                pui.setPhase(new BlackedOutPhase(pui));
            }
        }
        else if (userKilledEnemy) {
            pui.setPhase(new ExpPhase(pui));
        }
        else if (isFirstAttackContact) {
            pui.setPhase(new ParalysisCheckPhase(pui, false));
        } else {
            pui.setPhase(new PoisonCheckPhase(pui));
        }
    }

    private void useStatic() {
        if (!attacker.isStatused()) {
            double rand = Math.random();
            if (rand <= 1) {
                contactResults = attacker.getName() + " was paralyzed\nfrom " +
                        receiver.getName() + "s Static.";
                attacker.setPreStatus(Pokemon.Status.PARALYSIS);
            }
        }
    }

    private void usePoisonPoint() {
        if (!attacker.isStatused()) {
            double rand = Math.random();
            if (rand <= .30) {
                contactResults = attacker.getName() + " was poisoned\nfrom " +
                        receiver.getName() + "s Poison Point.";
                attacker.setPreStatus(Pokemon.Status.POISON);
            }
        }
    }

    private void usePoisonTouch() {
        if (!receiver.isStatused()) {
            double rand = Math.random();
            if (rand <= .30) {
                contactResults = receiver.getName() + " was poisoned\nfrom " +
                        attacker.getName() + "s Poison Touch.";
                receiver.setPreStatus(Pokemon.Status.POISON);
            }
        }
    }

    private void useFlameBody() {
        if (!attacker.isStatused()) {
            double rand = Math.random();
            if (rand <= .30) {
                contactResults = attacker.getName() + " was burned\nfrom " +
                        receiver.getName() + "s Flame Body.";
                attacker.setPreStatus(Pokemon.Status.BURN);
            }
        }
    }

    private void useEffectSpore() {
        if (!attacker.isStatused()) {
            double rand = Math.random();
            if (rand <= .9) {
                contactResults = receiver.getName() + " was poisoned\nfrom " +
                        attacker.getName() + "s Effect Spore.";
                attacker.setPreStatus(Pokemon.Status.POISON);
            } else if (rand > .9 && rand <= .19) {
                contactResults = receiver.getName() + " was paralyzed\nfrom " +
                        attacker.getName() + "s Effect Spore.";
                attacker.setPreStatus(Pokemon.Status.PARALYSIS);
            } else if (rand > .19 && rand <= .3) {
                contactResults = receiver.getName() + " was put to sleep\nfrom " +
                        attacker.getName() + "s Effect Spore.";
                attacker.setPreStatus(Pokemon.Status.SLEEP);
            }
        }
    }

    @Override
    public void renderText(SpriteBatch batch) {
        if (state == DISPLAY_ABILITY_CONTACT_RESULTS) {
            pui.getFont().draw(batch, contactResults.substring(0, textPosition), 54, 1143);
        }
    }
}
