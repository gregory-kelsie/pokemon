package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.Skill;
import com.pokemon.toronto.game.com.pokemon.toronto.skill.SkillFactory;
import com.pokemon.toronto.game.com.pokemon.toronto.trainer.Trainer;

import java.util.List;

/**
 * Created by Gregory on 8/16/2017.
 */

public class EvolutionState extends GameState {

    private GameStateManager gsm;
    private List<Pokemon> preEvolutions;
    private List<Pokemon> evolvedPokemon;
    private List<Integer> partyIndicies;
    private int evolvedListPosition;//which index in the party is the pokemon evolving at
    private int currentEvolutionCount; //how many pokemon evolved so far
    private Texture lowerPanel;
    private Texture textPanel;
    private Texture background;

    private Texture preEvolutionTexture;
    private Texture evolutionTexture;
    private Texture yesNoTexture;

    private Texture firstSkill;
    private Texture secondSkill;
    private Texture thirdSkill;
    private Texture fourthSkill;

    private String text;
    private double counter;
    private int textPosition;
    private BitmapFont textFont =
            new BitmapFont(Gdx.files.internal("battle/font/regularFont.fnt"));

    private int currentState;
    private int afterTextState;
    private final int TEXT_STATE = 0;
    private final int EVOLVING = 1;
    private final int CONGRATS = 2;
    private final int WAIT_FOR_EVOLUTION_CLICK = 3;
    private final int WAIT_FOR_CONGRATS_CLICK = 4;
    private final int WAIT_YES_NO = 5;
    private final int ADD_LEVEL_UP_MOVES = 6;
    private final int ADD_EVOLUTION_MOVES = 7;
    private final int DISPLAY_SKILLS = 8;

    private int displayPokemon;
    private final int DISPLAY_PREEVOLUTION = 0;
    private final int DISPLAY_EVOLUTION = 1;

    private double displayTime;
    private boolean finishedFlip;

    private boolean clickAfterText;

    //Whether or not after evolution it goes to map or simulator.
    private boolean goToMapState;
    private int startingRoute;
    private int region;
    private boolean isRoute;

    //Flags determining if the Pokemon was evolved from
    //the bag (stones) and which bag to go back to (main or store)
    private boolean cameFromBag;
    private boolean cameFromStore;

    //Move Indicies
    private int moveIndex;
    private boolean displayYesNoOptions;

    private boolean checkedAllEvolutionMoves;
    private boolean checkedAllLevelUpMoves;

    private SkillFactory sf;
    private Skill newMove;

    //New Skill Lists
    List<Integer> evolutionSkills;
    List<Integer> levelUpSkills;

    //Music and Sounds
    private Music evolvingMusic;
    private Music evolvingStartSound;
    private Music evolutionFanfare;
    private Sound clickSound;

    private Trainer.Badge badgeType; //In case the trainer evolved during an elite 4 battle.

    //Music Flags
    private boolean startSoundFinished;

    public EvolutionState(GameStateManager gsm, List<Pokemon> preEvolutions,
                          List<Pokemon> evolvedPokemon, List<Integer> partyIndices) {
        init(gsm, preEvolutions, evolvedPokemon, partyIndices);
        goToMapState = true;
        startingRoute = -1;
        region = -1;
        isRoute = false;
        cameFromBag = false;
        badgeType = Trainer.Badge.NO_BADGE;

    }

    public EvolutionState(GameStateManager gsm, List<Pokemon> preEvolutions,
                          List<Pokemon> evolvedPokemon, List<Integer> partyIndices, Trainer.Badge badgeType) {
        init(gsm, preEvolutions, evolvedPokemon, partyIndices);
        goToMapState = false;
        startingRoute = -1;
        region = -1;
        isRoute = false;
        cameFromBag = false;
        this.badgeType = badgeType;

    }

    //Open EvolutionState from Bag (A result of using stones)
    public EvolutionState(GameStateManager gsm, List<Pokemon> preEvolutions,
                          List<Pokemon> evolvedPokemon, List<Integer> partyIndices, boolean cameFromStore) {
        init(gsm, preEvolutions, evolvedPokemon, partyIndices);
        goToMapState = true;
        startingRoute = -1;
        region = -1;
        isRoute = false;
        cameFromBag = true;
        this.cameFromStore = cameFromStore;
        badgeType = Trainer.Badge.NO_BADGE;
    }

    public EvolutionState(GameStateManager gsm, List<Pokemon> preEvolutions,
                          List<Pokemon> evolvedPokemon, List<Integer> partyIndicies, int startingRoute, int region, boolean isRoute) {
        init(gsm, preEvolutions, evolvedPokemon, partyIndicies);
        goToMapState = false;
        this.startingRoute = startingRoute;
        this.region = region;
        this.isRoute = isRoute;
        cameFromBag = false;
        badgeType = Trainer.Badge.NO_BADGE;
    }



    private void init(GameStateManager gsm, List<Pokemon> preEvolutions, List<Pokemon> evolvedPokemon, List<Integer> partyIndicies) {
        this.gsm = gsm;
        this.preEvolutions = preEvolutions;
        this.evolvedPokemon = evolvedPokemon;
        this.partyIndicies = partyIndicies;
        evolvedListPosition = partyIndicies.get(0);
        currentEvolutionCount = 0;
        moveIndex = 0;
        text = "What?\n" + preEvolutions.get(currentEvolutionCount).getName() + " is evolving!";
        counter = 0;
        textPosition = 0;
        displayPokemon = DISPLAY_PREEVOLUTION;
        displayTime = 0.8;
        displayYesNoOptions = false;
        finishedFlip = false;
        currentState = TEXT_STATE;
        afterTextState = WAIT_FOR_EVOLUTION_CLICK;
        startSoundFinished = false;
        sf = new SkillFactory();
        checkedAllEvolutionMoves = false;
        checkedAllLevelUpMoves = false;
        clickAfterText = true;
        initTextures();
        initMusic();
        evolvingStartSound.play();
        evolvingStartSound.setLooping(false);
    }

    private void initTextures() {
        lowerPanel = new Texture("battle/emptyBottomPanel.png");
        textPanel = new Texture("battle/textarea.png");
        background = new Texture("battle/evolutionStage.png");

        preEvolutionTexture = new Texture(preEvolutions.get(currentEvolutionCount).getMapIconPath());
        evolutionTexture = new Texture(evolvedPokemon.get(currentEvolutionCount).getMapIconPath());

        yesNoTexture = new Texture("battle/yesno.png");
    }

    private void initSkillTextures() {
        if (firstSkill != null) {
            firstSkill.dispose();
        }
        firstSkill = initTypeTexture(gsm.getParty()
                .get(evolvedListPosition).getFirstSkill().getType());
        if (secondSkill != null) {
            secondSkill.dispose();
        }
        secondSkill = initTypeTexture(gsm.getParty()
                .get(evolvedListPosition).getSecondSkill().getType());
        if (thirdSkill != null) {
            thirdSkill.dispose();
        }
        thirdSkill = initTypeTexture(gsm.getParty()
                .get(evolvedListPosition).getThirdSkill().getType());
        if (fourthSkill != null) {
            fourthSkill.dispose();
        }
        fourthSkill = initTypeTexture(gsm.getParty()
                .get(evolvedListPosition).getFourthSkill().getType());
    }

    private Texture initTypeTexture(Pokemon.Type type) {
        if (type == Pokemon.Type.BUG) {
            return new Texture("battle/skillBorders/bug.png");
        } else if (type == Pokemon.Type.DARK) {
            return new Texture("battle/skillBorders/dark.png");
        } else if (type == Pokemon.Type.DRAGON) {
            return new Texture("battle/skillBorders/dragon.png");
        } else if (type == Pokemon.Type.ELECTRIC) {
            return new Texture("battle/skillBorders/electric.png");
        } else if (type == Pokemon.Type.FIGHTING) {
            return new Texture("battle/skillBorders/fighting.png");
        } else if (type == Pokemon.Type.FIRE) {
            return new Texture("battle/skillBorders/fire.png");
        } else if (type == Pokemon.Type.FLYING) {
            return new Texture("battle/skillBorders/flying.png");
        } else if (type == Pokemon.Type.GHOST) {
            return new Texture("battle/skillBorders/ghost.png");
        } else if (type == Pokemon.Type.GRASS) {
            return new Texture("battle/skillBorders/grass.png");
        } else if (type == Pokemon.Type.GROUND) {
            return new Texture("battle/skillBorders/ground.png");
        } else if (type == Pokemon.Type.ICE) {
            return new Texture("battle/skillBorders/ice.png");
        } else if (type == Pokemon.Type.NORMAL) {
            return new Texture("battle/skillBorders/normal.png");
        } else if (type == Pokemon.Type.POISON) {
            return new Texture("battle/skillBorders/poison.png");
        } else if (type == Pokemon.Type.PSYCHIC) {
            return new Texture("battle/skillBorders/psychic.png");
        } else if (type == Pokemon.Type.ROCK) {
            return new Texture("battle/skillBorders/rock.png");
        } else if (type == Pokemon.Type.STEEL) {
            return new Texture("battle/skillBorders/steel.png");
        } else if (type == Pokemon.Type.WATER) {
            return new Texture("battle/skillBorders/water.png");
        } else {
            return new Texture("battle/skillBorders/normal.png");
        }
    }

    private void initMusic() {
        evolvingMusic = Gdx.audio.newMusic(Gdx.files.internal("bgm/evolving.mp3"));
        evolvingStartSound = Gdx.audio.newMusic(Gdx.files.internal("sounds/evolutionStart.mp3"));
        evolutionFanfare = Gdx.audio.newMusic(Gdx.files.internal("sounds/evolvedFanfare.mp3"));
        clickSound = Gdx.audio.newSound(Gdx.files.internal("sounds/click.wav"));
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(background, 0, 1205);
        batch.draw(textPanel, 0, 954);
        batch.draw(lowerPanel, 0, 0);
        renderPokemon(batch);
        renderText(batch);
        if (currentState == WAIT_YES_NO) {
            batch.draw(yesNoTexture, 760, 950);
        }
        if (currentState == DISPLAY_SKILLS) {
            drawSkills(batch);
        }
    }

    private void renderPokemon(SpriteBatch batch) {
        if (displayPokemon == DISPLAY_PREEVOLUTION) {
            batch.draw(preEvolutionTexture, 358, 1391, 394, 394);
        } else {
            //Draw Evolved Pokemon
            batch.draw(evolutionTexture, 358, 1391, 394, 394);
        }
    }

    private void drawSkills(SpriteBatch batch) {
        drawSkillTextures(batch);
        drawSkillNames(batch);
    }

    private void drawSkillTextures(SpriteBatch batch) {
        batch.draw(firstSkill, 6, 555);
        batch.draw(secondSkill, 548, 555);
        batch.draw(thirdSkill, 6, 348);
        batch.draw(fourthSkill, 548, 348);
    }

    private void drawSkillNames(SpriteBatch batch) {
        //Move names
        textFont.draw(batch, gsm.getParty().get(evolvedListPosition).getSkills().get(0).getName(), 141, 708);
        textFont.draw(batch,
                gsm.getParty().get(evolvedListPosition).getSkills().get(0).getCurrentPP() + " / " +
                        gsm.getParty().get(evolvedListPosition).getSkills().get(0).getMaxPP(), 320, 630);
        if (gsm.getParty().get(evolvedListPosition).getSkills().size() > 1) {
            textFont.draw(batch,
                    gsm.getParty().get(evolvedListPosition).getSkills().get(1).getName(), 676, 708);
            textFont.draw(batch,
                    gsm.getParty().get(evolvedListPosition).getSkills().get(1).getCurrentPP() + " / " +
                            gsm.getParty().get(evolvedListPosition).getSkills().get(1).getMaxPP(), 860, 630);
            if (gsm.getParty().get(evolvedListPosition).getSkills().size() > 2) {
                textFont.draw(batch,
                        gsm.getParty().get(evolvedListPosition).getSkills().get(2).getName(), 141, 498);
                textFont.draw(batch,
                        gsm.getParty().get(evolvedListPosition).getSkills().get(2).getCurrentPP() + " / " +
                                gsm.getParty().get(evolvedListPosition).getSkills().get(2).getMaxPP(), 320, 423);
                if (gsm.getParty().get(evolvedListPosition).getSkills().size() > 3) {
                    textFont.draw(batch,
                            gsm.getParty().get(evolvedListPosition).getSkills().get(3).getName(), 676, 498);
                    textFont.draw(batch, gsm.getParty().get(evolvedListPosition)
                            .getSkills().get(3).getCurrentPP() + " / " +
                                    gsm.getParty().get(evolvedListPosition)
                                            .getSkills().get(3).getMaxPP(), 860, 423);
                }
            }
        }
    }

    private void renderText(SpriteBatch batch) {
        if (currentState != DISPLAY_SKILLS) {
            textFont.draw(batch, text.substring(0, textPosition), 54, 1143);
        }
    }

    @Override
    public void update(double dt) {
        if (currentState == TEXT_STATE) {
            updateText(dt);
        } else if (currentState == EVOLVING) {
            updateEvolution(dt);
        } else if (currentState == ADD_EVOLUTION_MOVES) {
            addEvolutionMoves();
        } else if (currentState == ADD_LEVEL_UP_MOVES) {
            addLevelUpMoves();
        }
        if (!evolvingStartSound.isPlaying()) {
            if (!startSoundFinished) {
                startSoundFinished = true;
                evolvingMusic.setLooping(true);
                evolvingMusic.play();
            }
        }
        if (MyInput.clicked()) {
            int x = MyInput.getX();
            int y = MyInput.getY();
            if (currentState == WAIT_FOR_EVOLUTION_CLICK) {
                clickSound.play();
                currentState = EVOLVING;
            } else if (currentState == WAIT_FOR_CONGRATS_CLICK) {
                clickSound.play();
                checkForNewMoves();
            }   else if (currentState == WAIT_YES_NO && x >= 813
                    && x <= 1005 && y >= 754 && y <= 841) {
                currentState = DISPLAY_SKILLS;
                initSkillTextures();
                clickSound.play();
            } else if (currentState == WAIT_YES_NO && x >= 813 && x <= 1005
                    && y >= 899 && y <= 994) {
                declinedNewMove();
            } else if (currentState == DISPLAY_SKILLS && x >= 81 && x <= 479
                    && y >= 1217 && y <= 1337) { //First Skill
                acceptedNewMove(0);
            }  else if (currentState == DISPLAY_SKILLS && x >= 577 && x <= 1017 &&
                    y >= 1205 && y <= 1340) { //Second Skill
                acceptedNewMove(1);
            } else if (currentState == DISPLAY_SKILLS && x >= 26 && x <= 485 &&
                    y >= 1443 && y <= 1555) { //Third Skill
                acceptedNewMove(2);
            } else if (currentState == DISPLAY_SKILLS && x >= 577 && x <= 1017 &&
                    y >= 1443 && y <= 15557) { //Fourth Skill
                acceptedNewMove(3);
            }
        }
    }

    private void acceptedNewMove(int position) {
        clickSound.play();
        textPosition = 0;
        gsm.getParty().get(evolvedListPosition).getSkills().set(position, newMove);
        text = gsm.getParty().get(evolvedListPosition).getName() + " learned\n" +
                newMove.getName() + "!";
        currentState = TEXT_STATE;
        if (checkedAllEvolutionMoves) {
            afterTextState = ADD_LEVEL_UP_MOVES;
        } else {
            afterTextState = ADD_EVOLUTION_MOVES;
        }
    }

    private  void declinedNewMove() {
        clickSound.play();
        textPosition = 0;
        text = gsm.getParty().get(evolvedListPosition).getName() + " did not learn\n" +
                newMove.getName() + ".";
        currentState = TEXT_STATE;
        if (checkedAllEvolutionMoves) {
            afterTextState = ADD_LEVEL_UP_MOVES;
        } else {
            afterTextState = ADD_EVOLUTION_MOVES;
        }
    }

    private void exit() {
        if (cameFromBag) {
            if (cameFromStore) {
                gsm.setState(new BagState(gsm, true));

            } else {
                gsm.setState(new BagState(gsm, false));
            }
        }
        else if (goToMapState) {
            //Go to Map State
            gsm.setState(new LoadingState(gsm, LoadingState.MAP_STATE));
            gsm.playBgm();
        } else if (badgeType == Trainer.Badge.NO_BADGE){
            //Go back to last simulator page
            gsm.setState(new SimulatorState(gsm, region, startingRoute));
            gsm.playBgm();
        } else {
            if (badgeType == Trainer.Badge.KANTO_LORELEI) {
                //Go to Bruno
            } else if (badgeType == Trainer.Badge.KANTO_BRUNO) {
                //Go to Agatha
            } else if (badgeType == Trainer.Badge.KANTO_AGATHA) {
                //Go to Lance
            } else if (badgeType == Trainer.Badge.KANTO_LANCE) {
                //Go to champion Blue
            } else if (badgeType == Trainer.Badge.KANTO_CHAMPION) {
                //Exit
                //TODO: Change to a credits state.
                gsm.setState(new LoadingState(gsm, LoadingState.HUB_STATE));
                gsm.playBgm();
            }
        }
        dispose();
    }

    private void checkForNewMoves() {
        if (gsm.getParty().get(evolvedListPosition).hasEvolutionSkills()) {
            //Add evolution skills
            evolutionSkills = gsm.getParty()
                    .get(evolvedListPosition).getEvolutionSkills();
            currentState = ADD_EVOLUTION_MOVES;
        } else {
            checkedAllEvolutionMoves = true;
            levelUpSkills = gsm.getParty()
                    .get(evolvedListPosition).getCurrentLevelUpSkills();
            if (levelUpSkills != null) {
                //Add level up skills.
                currentState = ADD_LEVEL_UP_MOVES;
            } else {
                //Exit
                //TODO: Check next pokemon to evolve.
                exit();
            }
        }
    }
    private boolean hasMove(int skillId) {
        for (int i = 0; i < gsm.getParty().get(evolvedListPosition).getSkills().size(); i++) {
            if (gsm.getParty().get(evolvedListPosition).getSkills().get(i).getId() == skillId) {
                return true;
            }
        }
        return false;
    }
    private void addLevelUpMoves() {
        if (levelUpSkills.size() > 0) {
            if (!hasMove(levelUpSkills.get(0))) {
                //Add level up skills.
                textPosition = 0;
                newMove = sf.createSkill(levelUpSkills.get(0));
                currentState = TEXT_STATE;
                if (gsm.getParty().get(evolvedListPosition).getSkills().size() < 4) {
                    text = gsm.getParty().get(evolvedListPosition).getName() + " learned " +
                            newMove.getName() + "!";
                    gsm.getParty().get(evolvedListPosition).addMove(newMove);
                    afterTextState = ADD_LEVEL_UP_MOVES;
                } else {
                    clickAfterText = true;
                    text = "Should a move be deleted for\n" + newMove.getName() + "?";
                    afterTextState = WAIT_YES_NO;
                }
                levelUpSkills.remove(0);
            } else {
                levelUpSkills.remove(0);
                currentState = ADD_LEVEL_UP_MOVES;
            }
        } else {
            //Exit
            exit();
        }

    }
    private void addEvolutionMoves() {
        if (evolutionSkills.size() == 0) {
            //Add level up skills
            checkedAllEvolutionMoves = true;
            levelUpSkills = gsm.getParty()
                    .get(evolvedListPosition).getCurrentLevelUpSkills();
            if (levelUpSkills != null) {
                //Add level up skills.
                currentState = ADD_LEVEL_UP_MOVES;
            } else {
                //Exit
                exit();
            }
        } else {
            currentState = TEXT_STATE;
            textPosition = 0;
            if (!hasMove(evolutionSkills.get(0))) {
                newMove = sf.createSkill(evolutionSkills.get(0));
                if (gsm.getParty().get(evolvedListPosition).getSkills().size() < 4) {
                    text = gsm.getParty().get(evolvedListPosition).getName() + " learned " +
                            newMove.getName() + "!";
                    gsm.getParty().get(evolvedListPosition).addMove(newMove);
                    afterTextState = ADD_EVOLUTION_MOVES;
                } else {
                    clickAfterText = true;
                    text = "Should a move be deleted for\n" + newMove.getName() + "?";
                    afterTextState = WAIT_YES_NO;
                }
                Gdx.app.log("evolution", text + ":" + counter + ":" + textPosition);
                evolutionSkills.remove(0);
            } else {
                currentState = ADD_EVOLUTION_MOVES;
                evolutionSkills.remove(0);
            }
        }
    }

    private void updateEvolution(double dt) {
        counter += dt;
        if (counter >= displayTime) {
            counter = 0;
            if (finishedFlip) {
                displayTime -= 0.05;
            }
            flipPokemonTexture();
            if (displayTime <= 0) {
                displayTime = 0.8; //reset displayTime for next evolution.
                displayPokemon = DISPLAY_EVOLUTION;
                afterTextState = WAIT_FOR_CONGRATS_CLICK;
                currentState = TEXT_STATE;
                if (evolvingMusic.isPlaying()) {
                    evolvingMusic.stop();
                }
                evolutionFanfare.setLooping(false);
                evolutionFanfare.play();
                text = "Congratulations! Your " + preEvolutions.get(currentEvolutionCount).getName() +
                        "\nevolved into " + evolvedPokemon.get(currentEvolutionCount).getName() + "!";
                textPosition = 0;
                counter = 0;
            }
        }
    }

    private void flipPokemonTexture() {
        if (displayPokemon == DISPLAY_PREEVOLUTION) {
            displayPokemon = DISPLAY_EVOLUTION;
        } else {
            displayPokemon = DISPLAY_PREEVOLUTION;
        }
        finishedFlip = !finishedFlip;
    }

    private void updateText(double dt) {
        counter += dt;
        if (counter >= 0.05) {
            if (textPosition < text.length()) {
                textPosition++;
                counter = 0;
            } else {
                if (clickAfterText) {
                    counter = 0;
                    currentState = afterTextState;
                    clickAfterText = false;
                }
            }
        }
        if (counter >= 1.5) {
            counter = 0;
            currentState = afterTextState;
        }
    }


    @Override
    public void dispose() {
        lowerPanel.dispose();
        textPanel.dispose();
        background.dispose();
        preEvolutionTexture.dispose();
        evolutionTexture.dispose();
        textFont.dispose();
        evolvingMusic.dispose();
        evolvingStartSound.dispose();
        evolutionFanfare.dispose();
        clickSound.dispose();
        yesNoTexture.dispose();
    }
}
