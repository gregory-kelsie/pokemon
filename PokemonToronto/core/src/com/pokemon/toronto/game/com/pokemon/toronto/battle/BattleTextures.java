package com.pokemon.toronto.game.com.pokemon.toronto.battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.pokemon.toronto.game.com.pokemon.toronto.Ball.Ball;
import com.pokemon.toronto.game.com.pokemon.toronto.Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gregory on 8/3/2017.
 */

public class BattleTextures {

    /** Instance Variables */

    //Background Textures
    private Texture battleBackground;

    //Bottom Panel Textures
    private Texture initPanel;
    private Texture battlePanel;
    private Texture bagOptionPanel;
    private Texture pokemonSelectPanel;
    private Texture pokemonPanel;
    private Texture itemSlotPanel;

    //Text Area in the Middle
    private Texture textArea;

    //Health HUD Textures
    private Texture healthBorder; //for pokemon select screen
    private Texture pokeSelectGreenHealth;
    private Texture userHealthPanel;
    private Texture enemyHealthPanel;
    private Texture expBar;
    private Texture greenHealth;

    //GUI Button Textures
    private Texture leftArrow;
    private Texture rightArrow;
    private Texture yesNo;

    //Pokemon Icon Textures
    private List<Texture> iconTextures;

    //Fonts
    private BitmapFont healthText;
    private BitmapFont regularFont; //Textbox and Skill
    private BitmapFont itemDescFont;
    private BitmapFont smallFont; //Pokemon panel font

    //Pokemon Sprite Textures
    private Texture userPokemonTexture;
    private Texture enemyPokemonTexture;

    //Skill Textures
    private Texture firstSkill;
    private Texture secondSkill;
    private Texture thirdSkill;
    private Texture fourthSkill;

    //Item Textures
    private Texture firstItem;
    private Texture secondItem;
    private Texture thirdItem;
    private Texture fourthItem;

    //Status Textures
    private Texture burnTexture;
    private Texture frozenTexture;
    private Texture poisonTexture;
    private Texture paralysisTexture;
    private Texture sleepTexture;

    /**
     *
     * @param backPath
     * @param enemyPath
     * @param partyIcons
     * @param currentPokemon
     */
    public BattleTextures(String backPath, String enemyPath, List<String> partyIcons, Pokemon currentPokemon) {
        initTextures(backPath, enemyPath, partyIcons);
        createSkillButtonTextures(currentPokemon);
    }

    private void initTextures(String backPath, String enemyPath,
                              List<String> partyIcons) {
        healthText = new BitmapFont(Gdx.files.internal("battle/healthFont.fnt"));
        healthText.setColor(Color.BLACK);
        regularFont = new BitmapFont(Gdx.files.internal("battle/font/regularFont.fnt"));
        itemDescFont = new BitmapFont(Gdx.files.internal("battle/itemDesc.fnt"));
        smallFont = new BitmapFont(Gdx.files.internal("battle/textFont.fnt"));
        regularFont.setColor(Color.WHITE);
        battleBackground = new Texture("battle/field.png");
        battlePanel = new Texture("battle/battlePanel.png");
        initPanel = new Texture("battle/firstBottomPanel.png");
        pokemonSelectPanel = new Texture("battle/pokemonSelect/pokeSelectPanel.png");
        pokemonPanel = new Texture("battle/pokemonSelect/pokemonPanel.png");
        healthBorder = new Texture("battle/pokemonSelect/healthBorder.png");
        pokeSelectGreenHealth = new Texture("battle/pokemonSelect/greenHealth.png");
        textArea = new Texture("battle/textarea.png");
        userPokemonTexture = new Texture(backPath);
        enemyPokemonTexture = new Texture(enemyPath);
        expBar = new Texture("battle/expBar.png");
        greenHealth = new Texture("battle/greenHealth.png");
        userHealthPanel = new Texture("battle/userHealthBar.png");
        enemyHealthPanel = new Texture("battle/enemyHealthBar.png");
        bagOptionPanel = new Texture("battle/bagOptions.png");
        leftArrow = new Texture("battle/leftArrow.png");
        rightArrow = new Texture("battle/rightArrow.png");
        itemSlotPanel = new Texture("battle/itemSlot.png");
        yesNo = new Texture("battle/yesno.png");

        //Init Pokemon Icon Textures
        iconTextures = new ArrayList<Texture>();
        for (int i = 0; i < partyIcons.size(); i++) {
            iconTextures.add(new Texture(partyIcons.get(i)));
        }

        //Init Status Textures
        burnTexture = new Texture("battle/status/burn.png");
        frozenTexture = new Texture("battle/status/frozen.png");
        poisonTexture = new Texture("battle/status/poison.png");
        paralysisTexture = new Texture("battle/status/paralysis.png");
        sleepTexture = new Texture("battle/status/sleep.png");

        secondSkill = null;
        thirdSkill = null;
        fourthSkill = null;

    }

    private void createSkillButtonTextures(Pokemon currentPokemon) {
        Gdx.app.log("Skills", currentPokemon.getName() + ": " + currentPokemon.getSkills().size());
        firstSkill = initTypeTexture(currentPokemon.getSkills().get(0).getType());
        if (currentPokemon.getSkills().size() > 1) {
            secondSkill = initTypeTexture(currentPokemon.getSkills().get(1).getType());
            if (currentPokemon.getSkills().size() > 2) {
                thirdSkill = initTypeTexture(currentPokemon.getSkills().get(2).getType());
                if (currentPokemon.getSkills().size() > 3) {
                    fourthSkill = initTypeTexture(currentPokemon.getSkills().get(3).getType());

                }
            }
        }

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
        }
        else if (type == Pokemon.Type.FAIRY) {
            return new Texture("battle/skillBorders/fairy.png");
        }
        else {
            return new Texture("battle/skillBorders/normal.png");
        }
    }

    public void resetSkillButtonTextures(Pokemon currentPokemon) {
        try {
            firstSkill.dispose();
            secondSkill.dispose();
            thirdSkill.dispose();
            fourthSkill.dispose();
        } catch (Exception e) { }
        secondSkill = null;
        thirdSkill = null;
        fourthSkill = null;
        createSkillButtonTextures(currentPokemon);
    }

    public void initPokeballIconTextures(List<Ball> pokeballBag,
                                         int currentItemPage) {
        disposeItemTextures();
        if (hasFirstItem(pokeballBag, currentItemPage)) {
            firstItem = new Texture(pokeballBag
                    .get(currentItemPage * 4).getImage());
            if (hasSecondItem(pokeballBag, currentItemPage)) {
                secondItem = new Texture(pokeballBag
                        .get(currentItemPage * 4 + 1).getImage());
                if (hasThirdItem(pokeballBag, currentItemPage)) {
                    thirdItem = new Texture(pokeballBag
                            .get(currentItemPage * 4 + 2).getImage());
                    if (hasFourthItem(pokeballBag, currentItemPage)) {
                        fourthItem = new Texture(pokeballBag
                                .get(currentItemPage * 4 + 3).getImage());
                    }
                }
            }
        }
    }

    private boolean hasFirstItem(List<Ball> pokeballBag, int currentItemPage) {
        if (currentItemPage * 4 < pokeballBag.size()) {
            return true;
        } else {
            return false;
        }
    }
    private boolean hasSecondItem(List<Ball> pokeballBag, int currentItemPage) {
        if (currentItemPage * 4 + 1 < pokeballBag.size()) {
            return true;
        }
        return false;
    }
    private boolean hasThirdItem(List<Ball> pokeballBag, int currentItemPage) {
        if (currentItemPage * 4 + 2 < pokeballBag.size()) {
            return true;
        }
        return false;
    }
    private boolean hasFourthItem(List<Ball> pokeballBag, int currentItemPage) {
        if (currentItemPage * 4 + 3 < pokeballBag.size()) {
            return true;
        }
        return false;
    }
    public BitmapFont getRegularFont() {
        return regularFont;
    }

    public Texture getBattleBackground() {
        return battleBackground;
    }

    public Texture getInitPanel() {
        return initPanel;
    }

    public Texture getBattlePanel() {
        return battlePanel;
    }

    public Texture getBagOptionPanel() {
        return bagOptionPanel;
    }

    public Texture getPokemonSelectPanel() {
        return pokemonSelectPanel;
    }

    public Texture getPokemonPanel() {
        return pokemonPanel;
    }

    public Texture getHealthBorder() {
        return healthBorder;
    }

    public Texture getPokeSelectGreenHealth() {
        return pokeSelectGreenHealth;
    }

    public Texture getLeftArrow() {
        return leftArrow;
    }

    public Texture getRightArrow() {
        return rightArrow;
    }

    public Texture getItemSlotPanel() {
        return itemSlotPanel;
    }

    public Texture getExpBar() {
        return expBar;
    }

    public Texture getUserHealthPanel() {
        return userHealthPanel;
    }

    public Texture getEnemyHealthPanel() {
        return enemyHealthPanel;
    }

    public Texture getTextArea() {
        return textArea;
    }

    public Texture getGreenHealth() {
        return greenHealth;
    }

    public Texture getYesNo() {
        return yesNo;
    }

    public List<Texture> getIconTextures() {
        return iconTextures;
    }

    public BitmapFont getHealthText() {
        return healthText;
    }

    public BitmapFont getItemDescFont() {
        return itemDescFont;
    }

    public BitmapFont getSmallFont() {
        return smallFont;
    }

    public Texture getUserPokemonTexture() {
        return userPokemonTexture;
    }

    public Texture getEnemyPokemonTexture() {
        return enemyPokemonTexture;
    }

    public Texture getFirstSkill() {
        return firstSkill;
    }

    public Texture getSecondSkill() {
        return secondSkill;
    }

    public Texture getThirdSkill() {
        return thirdSkill;
    }

    public Texture getFourthSkill() {
        return fourthSkill;
    }

    public Texture getFirstItem() {
        return firstItem;
    }

    public Texture getSecondItem() {
        return secondItem;
    }

    public Texture getThirdItem() {
        return thirdItem;
    }

    public Texture getFourthItem() {
        return fourthItem;
    }

    public Texture getBurnTexture() {
        return burnTexture;
    }

    public Texture getFrozenTexture() {
        return frozenTexture;
    }

    public Texture getPoisonTexture() {
        return poisonTexture;
    }

    public Texture getParalysisTexture() {
        return paralysisTexture;
    }

    public Texture getSleepTexture() {
        return sleepTexture;
    }

    public void setUserPokemonTexture(Texture newTexture) {
        userPokemonTexture.dispose();
        userPokemonTexture = newTexture;
    }

    public void setFirstItem(Texture firstItem) {
        this.firstItem = firstItem;
    }

    public void setSecondItem(Texture secondItem) {
        this.secondItem = secondItem;
    }

    public void setThirdItem(Texture thirdItem) {
        this.thirdItem = thirdItem;
    }

    public void setFourthItem(Texture fourthItem) {
        this.fourthItem = fourthItem;
    }

    public void disposeItemTextures() {
        try {
            firstItem.dispose();
        } catch (Exception e) {}
        try {
            secondItem.dispose();
        } catch (Exception e) { }
        try {
            thirdItem.dispose();
        } catch (Exception e) { }
        try {
            fourthItem.dispose();
        } catch (Exception e) { }
    }

    public void dispose() {
        battleBackground.dispose();
        battlePanel.dispose();
        initPanel.dispose();
        pokemonSelectPanel.dispose();
        pokemonPanel.dispose();
        bagOptionPanel.dispose();
        itemSlotPanel.dispose();

        leftArrow.dispose();
        rightArrow.dispose();

        textArea.dispose();
        itemDescFont.dispose();
        userPokemonTexture.dispose();
        enemyPokemonTexture.dispose();

        healthBorder.dispose();
        pokeSelectGreenHealth.dispose();
        greenHealth.dispose();
        expBar.dispose();
        userHealthPanel.dispose();
        enemyHealthPanel.dispose();

        healthText.dispose();
        regularFont.dispose();
        smallFont.dispose();

        firstSkill.dispose();
        yesNo.dispose();
        try {
            secondSkill.dispose();
            thirdSkill.dispose();
            fourthSkill.dispose();
        } catch (Exception e) { }
        for (int i = 0; i < iconTextures.size(); i++) {
            iconTextures.get(i).dispose();
        }

        burnTexture.dispose();
        frozenTexture.dispose();
        sleepTexture.dispose();
        poisonTexture.dispose();
        paralysisTexture.dispose();

        disposeItemTextures();
    }
}
