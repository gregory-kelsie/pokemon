package com.pokemon.toronto.game.com.pokemon.toronto.battle;

import com.badlogic.gdx.Gdx;
import com.pokemon.toronto.game.com.pokemon.toronto.gamestate.BattleState;

/**
 * Created by Gregory on 8/3/2017.
 */

public class BattleClickController {
    private BattleState model;
    public BattleClickController(BattleState model) {
        this.model = model;
    }

    public void clicked(int x, int y) {
        if (model.isFinishedIntroAnimation()) {
            if (model.isDisplayingNewMoveYesNoOptions()) {
                Gdx.app.log("Coords", "X: " + x + ", Y: " + y);
                if (x >= 813 && x <= 1005 && y >= 754 && y <= 841) {
                    model.acceptedNewMove();
                } else if (x >= 813 && x <= 1005 && y >= 899 && y <= 994) {
                    model.declinedNewMove();
                }
            }

            if (x >= 309 && x <= 776 && y >= 1107 && y <= 1243) {
                if (model.isOnMainPanel() && !model.startedAttack()) {
                    model.setNormalMoveSelectText();
                    model.setPanelPosition(model.BATTLE_PANEL);
                    model.playClickSound();
                }
            } else if (x >= 0 && x <= 421 && y >= 1361 && y <= 1441 && model.isOnMainPanel() && !model.startedAttack()) {
                //Clicked Bag
                model.setPanelPosition(model.BAG_OPTION_PANEL);
                model.playClickSound();
            } else if (x >= 627 && x <= 1051 && y >= 1353 && y <= 1464 && model.isOnMainPanel() && !model.startedAttack()) {
                //Clicked Pokemon
                model.setPanelPosition(model.POKEMON_SELECT_PANEL);
                model.playClickSound();
            } else if (x >= 0 && x <= 180 && y >= 1830 && y <= 1920 && model.isOnPartyPanel()) {
                //Clicked back on pokemon select screen
                if (!model.isWaitingForNextPokemon()) {
                    model.setNormalMoveSelectText();
                    model.setPanelPosition(model.FIRST_PANEL);
                    model.playClickSound();
                }
            } else if (x >= 777 && x <= 1080 && y >= 1703 && y <= 1920 && (model.isOnMoveSelectPanel()
                    || model.isOnBagOptionPanel() || model.isOnPokeballBagPanel())) {
                //Clicked Back
                if (model.isOnPokeballBagPanel()) {
                    model.setPanelPosition(model.BAG_OPTION_PANEL);
                    model.setCurrentItemPage(model.FIRST_ITEM_PAGE);
                } else {
                    //Don't allow back button when the battle is ongoing.
                    if (!model.startedAttack()) {
                        model.setPanelPosition(model.FIRST_PANEL);
                    }
                }
                model.playClickSound();
            } else if (x >= 147 && x <= 879 && y >= 1204 && y <= 1329 && model.isOnBagOptionPanel()) {
                //Clicked Usable Items
                model.playClickSound();
            } else if (x >= 200 && x <= 919 && y >= 1441 && y <= 1583 && model.isOnBagOptionPanel()) {
                //Clicked Pokeballs
                if (model.isWildBattle()) {
                    if ((!model.hasAFullParty() || !model.hasFullBoxes()) && !model.cameFromSimulator()) {
                        model.setPanelPosition(model.POKEBALL_BAG);
                        model.getBattleTextures().initPokeballIconTextures(model.getPokeballBag(), model.getCurrentItemPage());
                        model.playClickSound();
                    }
                }
            } else if (x >= 0 && x <= 473 && y >= 1203 && y <= 1337 && model.isOnPokeballBagPanel()) {
                //Clicked Pokeballs
                if (model.getPokeballBag().size() >= 1) {
                    if (!model.getEnemyPokemon().hasNextTurnSkill()) {
                        int enemyAttack = (int) Math.round(Math.random() * (model.getEnemyPokemon().getSkills().size() - 1));
                        model.startPokeballThrow(model.getPokeballBag().get(0).getId(), model.getEnemyPokemon().getSkills().get(enemyAttack));
                    } else {
                        model.startPokeballThrow(model.getPokeballBag().get(0).getId(), model.getEnemyPokemon().getNextTurnSkill());
                    }

                    model.getPokeballBag().get(0).subtractQuantity(1);
                    if (model.getPokeballBag().get(0).getQuantity() == 0) {
                        model.getPokeballBag().remove(0);
                    }
                    model.playClickSound();
                    model.setPanelPosition(model.FIRST_PANEL);
                }

            } else if (x >= 81 && x <= 479 && y >= 1217 && y <= 1337 && model.isOnMoveSelectPanel()) {
                //Clicked First Skill
                Gdx.app.log("Battle Log", "Clicked first skill");
                if (model.isWaitingForMoveDeletion()) {
                    model.removeFirstSkill();
                }
                if (!model.startedAttack()) {
                    model.setPanelPosition(model.FIRST_PANEL);
                    if (!model.getEnemyPokemon().hasNextTurnSkill()) {
                        int enemyAttack = (int) Math.round(Math.random() * (model.getEnemyPokemon().getSkills().size() - 1));
                        model.start(model.getCurrentPokemon().getSkills().get(0),
                                model.getEnemyPokemon().getSkills().get(enemyAttack));
                    } else {
                        model.start(model.getCurrentPokemon().getSkills().get(0),
                                model.getEnemyPokemon().getNextTurnSkill());
                    }
                }
                model.playClickSound();

            } else if (x >= 577 && x <= 1017 && y >= 1205 && y <= 1340 && model.isOnMoveSelectPanel()) {
                //Clicked Second Skill
                Gdx.app.log("Battle Log", "Clicked second skill");
                if (model.getCurrentPokemon().getSkills().size() > 1) {
                    if (model.isWaitingForMoveDeletion()) {
                        model.removeSecondSkill();
                    }
                    if (!model.startedAttack()) {
                        model.setPanelPosition(model.FIRST_PANEL);
                        if (!model.getEnemyPokemon().hasNextTurnSkill()) {
                            int enemyAttack = (int) Math.round(Math.random() * (model.getEnemyPokemon().getSkills().size() - 1));
                            model.start(model.getCurrentPokemon().getSkills().get(1),
                                    model.getEnemyPokemon().getSkills().get(enemyAttack));
                        } else {
                            model.start(model.getCurrentPokemon().getSkills().get(1),
                                    model.getEnemyPokemon().getNextTurnSkill());
                        }
                    }
                    model.playClickSound();
                }
            } else if (x >= 26 && x <= 485 && y >= 1443 && y <= 1555 && model.isOnMoveSelectPanel()) {
                //Clicked third skill
                Gdx.app.log("Battle Log", "Clicked third skill");
                if (model.getCurrentPokemon().getSkills().size() > 2) {
                    if (model.isWaitingForMoveDeletion()) {
                        model.removeThirdSkill();
                    }
                    if (!model.startedAttack()) {
                        model.setPanelPosition(model.FIRST_PANEL);
                        if (!model.getEnemyPokemon().hasNextTurnSkill()) {
                            int enemyAttack = (int) Math.round(Math.random() * (model.getEnemyPokemon().getSkills().size() - 1));
                            model.start(model.getCurrentPokemon().getSkills().get(2),
                                    model.getEnemyPokemon().getSkills().get(enemyAttack));
                        } else {
                            model.start(model.getCurrentPokemon().getSkills().get(2),
                                    model.getEnemyPokemon().getNextTurnSkill());
                        }
                    }
                    model.playClickSound();
                }
            } else if (x >= 577 && x <= 1017 && y >= 1443 && y <= 1555 && model.isOnMoveSelectPanel()) {
                //Clicked fourth skill
                Gdx.app.log("Battle Log", "Clicked fourth skill");
                if (model.getCurrentPokemon().getSkills().size() > 3) {
                    if (model.isWaitingForMoveDeletion()) {
                        model.removeFourthSkill();
                    }
                    if (!model.startedAttack()) {
                        model.setPanelPosition(model.FIRST_PANEL);
                        if (!model.getEnemyPokemon().hasNextTurnSkill()) {
                            int enemyAttack = (int) Math.round(Math.random() * (model.getEnemyPokemon().getSkills().size() - 1));
                            model.start(model.getCurrentPokemon().getSkills().get(3),
                                    model.getEnemyPokemon().getSkills().get(enemyAttack));
                        } else {
                            model.start(model.getCurrentPokemon().getSkills().get(3),
                                    model.getEnemyPokemon().getNextTurnSkill());
                        }
                    }
                    model.playClickSound();
                }
            } else if (x >= 272 && x <= 759 && y >= 1540 && y <= 1674 && model.isOnMainPanel() && !model.startedAttack()) {
                //Clicked Run
                if (model.isWildBattle()) {
                    if (!cannotSwitchOut()) {
                        if (model.cameFromSimulator()) { //came from simulator
                            model.goToRouteState();
                        } else { // came from map
                            model.goToMainMenuState();
                        }
                        model.dispose();
                    } else {
                        model.setNoSwitchText();
                    }
                }
            } else if (x >= 88 && x <= 411 && y >= 1186 && y <= 1302 && model.isOnPartyPanel() && !model.hasFirstPokemonOnField()) {
                //First Pokemon
                if (model.getParty().get(0).getCurrentHealth() > 0) {
                    if (cannotSwitchOut() &&
                            !model.isWaitingForNextPokemon()) {
                        model.setNoSwitchText();
                    } else {
                        model.transferPositionalBattleVariables(0);
                        model.removeBattleVariablesFromCurrentPokemon();
                        model.setCurrentPokemonPosition(0);
                        if (model.isWaitingForNextPokemon()) {
                            model.switchCurrentPokemon();
                        } else {
                            if (!model.getEnemyPokemon().hasNextTurnSkill()) {
                                int enemyAttack = (int) Math.round(Math.random() * (model.getEnemyPokemon().getSkills().size() - 1));
                                model.start(0, model.getEnemyPokemon().getSkills().get(enemyAttack));
                            } else {
                                model.start(0, model.getEnemyPokemon().getNextTurnSkill());
                            }
                        }
                        model.setPanelPosition(model.FIRST_PANEL);
                    }
                    model.playClickSound();
                }
            } else if (x >= 594 && x <= 916 && y >= 1268 && y <= 1431 && model.isOnPartyPanel() && !model.hasSecondPokemonOnField()) {
                //Second Pokemon
                if (model.getParty().size() > 1) {
                    if (model.getParty().get(1).getCurrentHealth() > 0) {
                        if (cannotSwitchOut() &&
                                !model.isWaitingForNextPokemon()) {
                            model.setNoSwitchText();
                        } else {
                            model.transferPositionalBattleVariables(1);
                            model.removeBattleVariablesFromCurrentPokemon();
                            model.setCurrentPokemonPosition(1);
                            if (model.isWaitingForNextPokemon()) {
                                model.switchCurrentPokemon();
                            } else {
                                if (!model.getEnemyPokemon().hasNextTurnSkill()) {
                                    int enemyAttack = (int) Math.round(Math.random() * (model.getEnemyPokemon().getSkills().size() - 1));
                                    model.start(1, model.getEnemyPokemon().getSkills().get(enemyAttack));
                                } else {
                                    model.start(1, model.getEnemyPokemon().getNextTurnSkill());
                                }
                            }
                            model.setPanelPosition(model.FIRST_PANEL);
                        }
                        model.playClickSound();
                    }
                }
            } else if (x >= 88 && x <= 411 && y >= 1422 && y <= 1554 && model.isOnPartyPanel() && !model.hasThirdPokemonOnField()) {
                //Third Pokemon
                if (model.getParty().size() > 2) {
                    if (model.getParty().get(2).getCurrentHealth() > 0) {
                        if (cannotSwitchOut() &&
                                !model.isWaitingForNextPokemon()) {
                            model.setNoSwitchText();
                        } else {
                            model.transferPositionalBattleVariables(2);
                            model.removeBattleVariablesFromCurrentPokemon();
                            model.setCurrentPokemonPosition(2);
                            if (model.isWaitingForNextPokemon()) {
                                model.switchCurrentPokemon();
                            } else {
                                if (!model.getEnemyPokemon().hasNextTurnSkill()) {
                                    int enemyAttack = (int) Math.round(Math.random() * (model.getEnemyPokemon().getSkills().size() - 1));
                                    model.start(2, model.getEnemyPokemon().getSkills().get(enemyAttack));
                                } else {
                                    model.start(2, model.getEnemyPokemon().getNextTurnSkill());
                                }
                            }
                            model.setPanelPosition(model.FIRST_PANEL);
                        }
                        model.playClickSound();
                    }
                }
            } else if (x >= 594 && x <= 916 && y >= 1498 && y <= 1662 && model.isOnPartyPanel() && !model.hasFourthPokemonOnField()) {
                //Fourth Pokemon
                if (model.getParty().size() > 3) {
                    if (model.getParty().get(3).getCurrentHealth() > 0) {
                        if (cannotSwitchOut() &&
                                !model.isWaitingForNextPokemon()) {
                            model.setNoSwitchText();
                        } else {
                            model.transferPositionalBattleVariables(3);
                            model.removeBattleVariablesFromCurrentPokemon();
                            model.setCurrentPokemonPosition(3);
                            if (model.isWaitingForNextPokemon()) {
                                model.switchCurrentPokemon();
                            } else {
                                if (!model.getEnemyPokemon().hasNextTurnSkill()) {
                                    int enemyAttack = (int) Math.round(Math.random() * (model.getEnemyPokemon().getSkills().size() - 1));
                                    model.start(3, model.getEnemyPokemon().getSkills().get(enemyAttack));
                                } else {
                                    model.start(3, model.getEnemyPokemon().getNextTurnSkill());
                                }

                            }
                            model.setPanelPosition(model.FIRST_PANEL);
                        }
                        model.playClickSound();
                    }
                }
            } else if (x >= 88 && x <= 411 && y >= 1662 && y <= 1823 && model.isOnPartyPanel() && !model.hasFifthPokemonOnField()) {
                //Fifth Pokemon
                if (model.getParty().size() > 4) {
                    if (model.getParty().get(4).getCurrentHealth() > 0) {
                        if (cannotSwitchOut() &&
                                !model.isWaitingForNextPokemon()) {
                            model.setNoSwitchText();
                        } else {
                            model.transferPositionalBattleVariables(4);
                            model.removeBattleVariablesFromCurrentPokemon();
                            model.setCurrentPokemonPosition(4);
                            if (model.isWaitingForNextPokemon()) {
                                model.switchCurrentPokemon();
                            } else {
                                if (!model.getEnemyPokemon().hasNextTurnSkill()) {
                                    int enemyAttack = (int) Math.round(Math.random() * (model.getEnemyPokemon().getSkills().size() - 1));
                                    model.start(4, model.getEnemyPokemon().getSkills().get(enemyAttack));
                                } else {
                                    model.start(4, model.getEnemyPokemon().getNextTurnSkill());
                                }
                            }
                            model.setPanelPosition(model.FIRST_PANEL);
                        }
                        model.playClickSound();
                    }
                }
            } else if (x >= 594 && x <= 916 && y >= 1749 && y <= 1907 && model.isOnPartyPanel() && !model.hasSixthPokemonOnField()) {
                //Sixth Pokemon
                if (model.getParty().size() > 5) {
                    if (model.getParty().get(5).getCurrentHealth() > 0) {
                        if (cannotSwitchOut() &&
                                !model.isWaitingForNextPokemon()) {
                            model.setNoSwitchText();
                        } else {
                            model.transferPositionalBattleVariables(5);
                            model.removeBattleVariablesFromCurrentPokemon();
                            model.setCurrentPokemonPosition(5);
                            if (model.isWaitingForNextPokemon()) {
                                model.switchCurrentPokemon();
                            } else {
                                if (!model.getEnemyPokemon().hasNextTurnSkill()) {
                                    int enemyAttack = (int) Math.round(Math.random() * (model.getEnemyPokemon().getSkills().size() - 1));
                                    model.start(5, model.getEnemyPokemon().getSkills().get(enemyAttack));
                                } else {
                                    model.start(5, model.getEnemyPokemon().getNextTurnSkill());
                                }
                            }
                            model.setPanelPosition(model.FIRST_PANEL);
                        }
                        model.playClickSound();
                    }
                }

            }
            else if (y > 900 && y <= 1920) {
                Gdx.app.log("Coordinates", "X: " + x + ", Y: " + y);
            }
        }
        else {
            if (model.getBattleType() == model.WILD_BATTLE && model.getPlayerTrainerAnimation().isPaused() && model.getPlayerTrainerAnimation().finishedPauseText()) {
                model.getPlayerTrainerAnimation().unPause();
                model.playClickSound();
            }
        }
    }

    private boolean cannotSwitchOut() {
        if (model.getCurrentPokemon().isIngrained() ||
                model.getCurrentPokemon().isSkyDropped() ||
                model.getCurrentPokemon().isSpiderWebbed()) {
            return true;
        }
        return false;
    }
}
