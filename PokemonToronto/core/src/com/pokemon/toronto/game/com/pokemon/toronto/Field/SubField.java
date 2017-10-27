package com.pokemon.toronto.game.com.pokemon.toronto.Field;

/**
 * Created by Gregory on 8/12/2017.
 */

public class SubField {
    //CONSTANTS
    private final int NO_SPIKES = 0;
    private final int NO_TOXIC_SPIKES = 0;
    private final boolean NO_STEALTH_ROCK = false;
    private final int NO_REFLECT = 0;
    private final int NO_LIGHT_SCREEN = 0;
    private final int MAX_SPIKE_LAYERS = 3;
    private final int MAX_TOXIC_SPIKE_LAYERS = 2;
    private final int DEFAULT_REFLECT_TURNS = 5;
    private final int DEFAULT_LIGHT_SCREEN_TURNS = 5;
    private final boolean HAS_STICKY_WEB = true;
    private final boolean NO_STICKY_WEB = false;
    private final int NO_MIST = 0;
    private final int TOTAL_MIST_TURNS = 5;
    private final int NO_TAILWIND = 0;
    private final int TOTAL_TAILWIND_TURNS = 4;
    private final int NO_SAFEGUARD = 0;
    private final int SAFEGUARD_TURNS = 5;

    //Instance Variables
    private boolean stealthRocked;
    private int spikeLayers;
    private int toxicSpikeLayers;
    private int reflect;
    private int lightScreen;
    private int mist;
    private int tailwind;
    private boolean stickyWeb;
    private int safeguard;

    /**
     * Create a SubField. A SubField is the area in which a Pokemon
     * stands on the field. Each player gets a SubField which can be
     * affected by light screen, spikes, stealth rocks etc. The SubField
     * only effects the Pokemon on it; wheras the Field effects both Pokemon.
     */
    public SubField() {
        stealthRocked = NO_STEALTH_ROCK;
        spikeLayers = NO_SPIKES;
        toxicSpikeLayers = NO_TOXIC_SPIKES;
        reflect = NO_REFLECT;
        lightScreen = NO_LIGHT_SCREEN;
        stickyWeb = NO_STICKY_WEB;
        mist = NO_MIST;
        tailwind = NO_TAILWIND;
        safeguard = NO_SAFEGUARD;
    }

    /**
     * Return whether or not the sub-field is protected by Safeguard.
     * @return Whether or not the sub-field is protected by Safeguard.
     */
    public boolean hasSafeguard() {
        if (safeguard != NO_SAFEGUARD) {
            return true;
        }
        return false;
    }

    /**
     * Protect the Sub-Field with Safeguard.
     */
    public void addSafeguard() {
        safeguard = SAFEGUARD_TURNS;
    }

    /**
     * Reduce the number of turns left for Safeguard if it is protecting the field.
     */
    public void adjustSafeguard() {
        if (hasSafeguard()) {
            safeguard--;
            safeguard = Math.max(safeguard, NO_SAFEGUARD);
        }
    }

    /**
     * Return whether or not this side of the field has a
     * Tailwind effect activated.
     * @return Whether or not this sub-field has a Tailwind
     * effect activated.
     */
    public boolean hasTailwind() {
        if (tailwind != NO_TAILWIND) {
            return true;
        }
        return false;
    }

    /**
     * Add tailwind to the SubField.
     */
    public void addTailwind() {
        tailwind = TOTAL_TAILWIND_TURNS;
    }

    /**
     * Remove tailwind from the SubField.
     */
    public void removeTailwind() {
        tailwind = NO_TAILWIND;
    }

    /**
     * Adjust the number of tailwind turns left
     * for the SubField.
     */
    public void adjustTailwind() {
        if (hasTailwind()) {
            tailwind--;
            tailwind = Math.max(NO_TAILWIND, tailwind);
        }
    }

    /**
     * Return whether or not the subfield is protected by Mist.
     * @return Whether or not the SubField is protected by Mist.
     */
    public boolean hasMist() {
        if (mist != NO_MIST) {
            return true;
        }
        return false;
    }

    /**
     * Add Mist to the field to protect stats from being lowered.
     */
    public void addMist() {
        mist = TOTAL_MIST_TURNS;
    }

    /**
     * Return the number of remaining turns mist will last on the field.
     * @return The remaining number of turns mist will last.
     */
    public int getRemainingMistTurns() {
       return mist;
    }

    /**
     * Adjust the number of turns left for the Mist effect.
     */
    public void adjustMist() {
        if (hasMist()) {
            mist--;
            mist = Math.max(NO_MIST, mist);
        }
    }

    /**
     * Adjust the number of turns left for the Light Screen effect.
     */
    public void adjustLightScreen() {
        if (hasLightScreen()) {
            lightScreen--;
            lightScreen = Math.max(NO_LIGHT_SCREEN, lightScreen);
        }
    }

    /**
     * Adjust the number of turns left for the Reflect effect.
     */
    public void adjustReflect() {
        if (hasReflect()) {
            reflect--;
            reflect = Math.max(NO_REFLECT, reflect);
        }
    }

    /**
     * Remove mist from the SubField.
     */
    public void removeMist() {
        mist = NO_MIST;
    }

    /**
     * Return whether or not the SubField has stealth rocks
     * up.
     * @return Whether or not the SubField has stealth rocks
     * up.
     */
    public boolean hasStealthRocks() {
        return stealthRocked;
    }

    /**
     * Add stealth rocks to the SubField.
     */
    public void addStealthRocks() {
        stealthRocked = true;
    }

    /**
     * Remove stealth rocks from the SubField
     */
    public void removeStealthRocks() {
        stealthRocked = NO_STEALTH_ROCK;
    }

    /**
     * Return the number of spike layers on the SubField.
     * @return The number of spike layers on the SubField.
     */
    public int getNumberOfSpikeLayers() {
        return spikeLayers;
    }

    /**
     * Add one spike layer to the SubField.
     */
    public void addSpikeLayer() {
        spikeLayers++;
        spikeLayers = Math.min(spikeLayers, MAX_SPIKE_LAYERS);
    }

    /**
     * Remove all layers of spikes on the SubField.
     */
    public void removeSpikes() {
        spikeLayers = NO_SPIKES;
    }

    /**
     * Return whether or not the SubField has spikes laid out.
     * @return Whether or not the SubField has spikes.
     */
    public boolean hasSpikes() {
        if (spikeLayers == NO_SPIKES) {
            return false;
        }
        return true;
    }

    /**
     * Return the maximum amount of spike layers that can
     * be laid out.
     * @return Maximum number of possible spike layers.
     */
    public int getMaxSpikeLayers() {
        return MAX_SPIKE_LAYERS;
    }

    /**
     * Return the maximum amount of toxic spike layers that can
     * be laid out.
     * @return Maximum number of possible toxic spike layers.
     */
    public int getMaxToxicSpikeLayers() {
        return MAX_TOXIC_SPIKE_LAYERS;
    }

    /**
     * Return the number of toxic spike layers on the SubField.
     * @return The number of toxic spike layers on the SubField.
     */
    public int getNumberOfToxicSpikeLayers() {
        return toxicSpikeLayers;
    }

    /**
     * Add one layer of toxic spikes to the SubField.
     */
    public void addToxicSpikeLayer() {
        toxicSpikeLayers++;
        toxicSpikeLayers = Math.min(toxicSpikeLayers, MAX_TOXIC_SPIKE_LAYERS);
    }

    /**
     * Remove all layers of toxic spikes.
     */
    public void removeToxicSpikes() {
        toxicSpikeLayers = NO_TOXIC_SPIKES;
    }

    /**
     * Return whether or not the SubField has toxic spikes laid out.
     * @return Whether or not the SubField has toxic spikes.
     */
    public boolean hasToxicSpikes() {
        if (toxicSpikeLayers == NO_TOXIC_SPIKES) {
            return false;
        }
        return true;
    }

    /**
     * Activate the Reflect move onto the SubField.
     */
    public void activateReflect() {
        reflect = DEFAULT_REFLECT_TURNS;
    }

    /**
     * Remove the Reflect move from the SubField.
     */
    public void removeReflect() {
        reflect = NO_REFLECT;
    }

    /**
     * Return whether or not Reflect is up on the SubField.
     * @return Whether or not Reflect is up on the SubField.
     */
    public boolean hasReflect() {
        if (reflect != NO_REFLECT) {
            return true;
        }
        return false;
    }

    /**
     * Activate the Light Screen move onto the SubField.
     */
    public void activateLightScreen() {
        lightScreen = DEFAULT_LIGHT_SCREEN_TURNS;
    }

    /**
     * Remove the Light Screen move from the SubField.
     */
    public void removeLightScreen() {
        lightScreen = NO_LIGHT_SCREEN;
    }

    /**
     * Return whether or not Light Screen is up on the SubField.
     * @return Whether or not Light Screen is up on the SubField.
     */
    public boolean hasLightScreen() {
        if (lightScreen != NO_LIGHT_SCREEN) {
            return true;
        }
        return false;
    }

    /**
     * Return whether or not the SubField has sticky web on it.
     * @return Whether or not the SubField has sticky web on it.
     */
    public boolean hasStickyWeb() {
        return stickyWeb;
    }

    /**
     * Add sticky web to the SubField.
     */
    public void addStickyWeb() {
        stickyWeb = HAS_STICKY_WEB;
    }

    /**
     * Remove sticky web from the SubField.
     */
    public void removeStickyWeb() {
        stickyWeb = NO_STICKY_WEB;
    }

    /**
     * Remove the SubField's entry hazzards.
     * - Spikes, Toxic Spikes, Stealth Rock, Sticky Web.
     */
    public void removeEntryHazzards() {
        stealthRocked = NO_STEALTH_ROCK;
        toxicSpikeLayers = NO_TOXIC_SPIKES;
        spikeLayers = NO_SPIKES;
        stickyWeb = NO_STICKY_WEB;
    }

    /**
     * Return whether or not the SubField has any entry hazzards.
     * @return Whether or not the SubField has any entry hazzards.
     */
    public boolean hasEntryHazzards() {
        if (stealthRocked || toxicSpikeLayers > NO_TOXIC_SPIKES || spikeLayers > NO_SPIKES || stickyWeb) {
            return true;
        }
        return false;
    }

}
