package com.pokemon.toronto.game.com.pokemon.toronto.gamestate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;

/**
 * Created by Gregory on 6/12/2017.
 */
public class WildPokemonListState extends GameState {

    /** Instance Variables */

    //Constants
    private final int TOP_POSITION = 0;
    private final int MID_POSITION = 1;
    private final int BOT_POSITION = 2;
    private final int FIRST_PAGE = 0;

    //Textures
    private Texture background;
    private Texture backArrow;
    private Texture forwardArrow;
    private Texture panel;
    private Texture topTexture;
    private Texture middleTexture;
    private Texture bottomTexture;

    //Transition Variables
    private boolean initiateBattle;
    private ShapeRenderer transitionRenderer;
    private int transitionHeight;
    private boolean finishedTransition;

    //Fonts
    private BitmapFont name;
    private BitmapFont info;

    //Music
    private Music wildBgm;

    //Misc
    private GameStateManager gsm;
    private int currentPage;
    private int clickedPokemonPosition;

    private boolean hasMiddlePokemon;
    private boolean hasBottomPokemon;

    /**
     * Create the screen where the Player looks at each of the wild pokemon
     * available to them for capture.
     * @param gsm A callback to the GameStateManager to set the next state.
     */
    public WildPokemonListState(GameStateManager gsm) {
        this.gsm = gsm;
        currentPage = FIRST_PAGE;
        initTextures();
        initFonts();
        initNewSpriteTextures();
        wildBgm = Gdx.audio.newMusic(Gdx.files.internal("sounds/wildBgm.mp3"));
        initiateBattle = false;
        finishedTransition = false;
        transitionRenderer = new ShapeRenderer();
        transitionHeight = 0;
        clickedPokemonPosition = -1;

        hasMiddlePokemon = false;
        hasBottomPokemon = false;
    }

    /**
     * Initialize the Textures used for this screen.
     */
    private void initTextures() {
        background = gsm.getLoader().get("wildPokemonList/wildPokemonListBackground.png", Texture.class);
        backArrow = gsm.getLoader().get("wildPokemonList/backwardsArrow.png", Texture.class);
        forwardArrow = gsm.getLoader().get("wildPokemonList/forwardArrow.png", Texture.class);
        panel = gsm.getLoader().get("wildPokemonList/pokemonListPanel.png", Texture.class);
    }

    /**
     * Initialize the fonts used for this screen.
     */
    private void initFonts() {
        name = new BitmapFont(Gdx.files.internal("font/textHeaderFont.fnt"));
        name.setColor(Color.BLACK);
        info = new BitmapFont(Gdx.files.internal("font/textBoxNarrowFont.fnt"));
        info.setColor(Color.BLACK);
    }

    /**
     * Initialize the Pokemon sprite textures for the state's current
     * page.
     */
    private void initNewSpriteTextures() {
        topTexture = new Texture(gsm.getNearbyPokemon().get(currentPage * 3)
                .getPokemon().getMapIconPath());
        if (currentPage * 3 + 1 < gsm.getNearbyPokemon().size()) {
            middleTexture = new Texture(gsm.getNearbyPokemon()
                    .get(currentPage * 3 + 1).getPokemon().getMapIconPath());
            hasMiddlePokemon = true;
        } else {
            hasMiddlePokemon = false;
        }
        if (currentPage * 3 + 2 < gsm.getNearbyPokemon().size()) {
            bottomTexture = new Texture(gsm.getNearbyPokemon()
                    .get(currentPage * 3 + 2).getPokemon().getMapIconPath());
            hasBottomPokemon = true;
        } else {
            hasBottomPokemon = false;
        }
    }

    /**
     * Calculate distance between two points in latitude and longitude taking
     * into account height difference. If you are not interested in height
     * difference pass 0.0. Uses Haversine method as its base.
     *
     * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
     * el2 End altitude in meters
     * @returns Distance in Meters
     */
    public double distance(double lat1, double lat2, double lon1,
                                  double lon2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        //double height = el1 - el2;

        distance = Math.pow(distance, 2);// + Math.pow(height, 2);

        return Math.sqrt(distance);
    }

    /**
     * Set the colour of the Pokemon's name in the position pokemonPosition.
     * Green if they're close
     * Yellow if they're nearby.
     * Orange if they're within a kilometer
     * Red if they're Beyond a kilometer.
     * @param pokemonPosition The position of the Pokemon on the screen.
     *                        Top = 0, Middle = 1, Bottom = 2
     */
    private void setNameColor(int pokemonPosition) {
        double dist = distance(gsm.getLatitude(), gsm.getNearbyPokemon().get(currentPage * 3 + pokemonPosition).getLatitude(),
                gsm.getLongitude(), gsm.getNearbyPokemon().get(currentPage * 3 + pokemonPosition).getLongitude());
        if (dist <= 30) {
            name.setColor(Color.GREEN);
        } else if (dist <= 500) {
            name.setColor(Color.YELLOW);
        } else if (dist <= 1000) {
            name.setColor(Color.ORANGE);
        } else {
            name.setColor(Color.RED);
        }
    }

    /**
     * Return whether or not the Pokemon in pokemonPosition is close enough
     * to battle.
     * @param pokemonPosition The position of the Pokemon on the screen.
     *                        Top = 0, Middle = 1, Bottom = 2
     * @return Whether or not the Pokemon in pokemonPosition is close enough
     * to battle.
     */
    private boolean inBattlingRange(int pokemonPosition) {
        double dist = distance(gsm.getLatitude(), gsm.getNearbyPokemon().get(currentPage * 3 + pokemonPosition).getLatitude(),
                gsm.getLongitude(), gsm.getNearbyPokemon().get(currentPage * 3 + pokemonPosition).getLongitude());
        if (dist <= 1000) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Render the WildPokemonListState screen.
     * @param batch The SpriteBatch that the screen gets rendered to.
     */
    @Override
    public void render(SpriteBatch batch) {
        batch.draw(background, 0, 0);
        drawTopPokemon(batch);
        //Check if there are more Pokemon on the current page.
        if (currentPage * 3 + 1 < gsm.getNearbyPokemon().size()) {
            drawMiddlePokemon(batch);
            if (currentPage * 3 + 2 < gsm.getNearbyPokemon().size()) {
                drawBottomPokemon(batch);
                //Check if there is more Pokemon.
                if (currentPage * 3 + 3 < gsm.getNearbyPokemon().size()) {
                    //Draw an arrow to go to the next page.
                    batch.draw(forwardArrow, 880, 10);
                }
            }
        }
        drawBackBottomArrow(batch);
        drawTransition(batch);
    }

    /**
     * Render the Pokemon in the top position of the current page of the
     * screen. Render their sprite, name and description.
     * @param batch The SpriteBatch the Pokemon gets rendered to.
     */
    private void drawTopPokemon(SpriteBatch batch) {
        setNameColor(TOP_POSITION);
        name.draw(batch, gsm.getNearbyPokemon().get(currentPage * 3).getPokemon().getName() + " Lv " +
                Integer.toString(gsm.getNearbyPokemon().get(currentPage * 3).getPokemon().getLevel()), 30, 1700);

        batch.draw(topTexture,700,1300, 394, 394);
        //batch.draw(holder, 500, 200, 384, 384);
        info.draw(batch, "Distance: " + Math.round(distance(gsm.getLatitude(), gsm.getNearbyPokemon().get(currentPage * 3 + TOP_POSITION).getLatitude(),
                gsm.getLongitude(), gsm.getNearbyPokemon().get(currentPage * 3 + TOP_POSITION).getLongitude())) + "m\nNature: " +
                gsm.getNearbyPokemon().get(currentPage * 3).getPokemon().getNatureString() +
                "\nAbility: " +  gsm.getNearbyPokemon().get(currentPage * 3).getPokemon().getAbilityString() +
                "\nExpiration:" + gsm.getNearbyPokemon().get(currentPage * 3).getExpirationString(), 30, 1620);
    }

    /**
     * Render the Pokemon in the bottom position of the current page of the
     * screen. Render their sprite, name and description.
     * @param batch The SpriteBatch the Pokemon gets rendered to.
     */
    private void drawBottomPokemon(SpriteBatch batch) {
        batch.draw(panel, 0, 170);
        setNameColor(BOT_POSITION);
        name.draw(batch, gsm.getNearbyPokemon().get(currentPage * 3 + 2).getPokemon().getName() + " Lv " +
                Integer.toString(gsm.getNearbyPokemon().get(currentPage * 3 + 2).getPokemon().getLevel()), 30, 600);
        info.draw(batch, "Distance: " + Math.round(distance(gsm.getLatitude(), gsm.getNearbyPokemon().get(currentPage * 3 + BOT_POSITION).getLatitude(),
                gsm.getLongitude(), gsm.getNearbyPokemon().get(currentPage * 3 + BOT_POSITION).getLongitude())) + "m\nNature: " +
                gsm.getNearbyPokemon().get(currentPage * 3 + 2).getPokemon().getNatureString() +
                "\nAbility: " +  gsm.getNearbyPokemon().get(currentPage * 3 + 2).getPokemon().getAbilityString() +
                "\nExpiration:" + gsm.getNearbyPokemon().get(currentPage * 3 + 2).getExpirationString(), 30, 520);
        if (hasBottomPokemon) {
            batch.draw(bottomTexture, 700, 260, 394, 394);
        } else {
            hasBottomPokemon = true;
            bottomTexture = new Texture(gsm.getNearbyPokemon()
                    .get(currentPage * 3 + 2).getPokemon().getMapIconPath());
            batch.draw(bottomTexture, 700, 260, 394, 394);

        }
    }

    /**
     * Render the Pokemon in the middle position of the current page of the
     * screen. Render their sprite, name and description.
     * @param batch The SpriteBatch the Pokemon gets rendered to.
     */
    private void drawMiddlePokemon(SpriteBatch batch) {
        batch.draw(panel, 0, 710);
        setNameColor(MID_POSITION);
        name.draw(batch, gsm.getNearbyPokemon().get(currentPage * 3 + 1).getPokemon().getName() + " Lv " +
                Integer.toString(gsm.getNearbyPokemon().get(currentPage * 3 + 1).getPokemon().getLevel()), 30, 1150);
        info.draw(batch, "Distance: " + Math.round(distance(gsm.getLatitude(), gsm.getNearbyPokemon().get(currentPage * 3 + MID_POSITION).getLatitude(),
                gsm.getLongitude(), gsm.getNearbyPokemon().get(currentPage * 3 + MID_POSITION).getLongitude())) + "m\nNature: " +
                gsm.getNearbyPokemon().get(currentPage * 3 + 1).getPokemon().getNatureString() +
                "\nAbility: " +  gsm.getNearbyPokemon().get(currentPage * 3 + 1).getPokemon().getAbilityString() +
                "\nExpiration:" + gsm.getNearbyPokemon().get(currentPage * 3 + 1).getExpirationString(), 30, 1070);
        if (hasMiddlePokemon) {
            batch.draw(middleTexture, 700, 780, 394, 394);
        } else {
            hasMiddlePokemon = true;
            middleTexture = new Texture(gsm.getNearbyPokemon()
                    .get(currentPage * 3 + 1).getPokemon().getMapIconPath());
            batch.draw(middleTexture, 700, 780, 394, 394);

        }
    }

    /**
     * Render the back bottom arrow if the player is not on the first page.
     * Render The total number of pages and the current page the player is on.
     * @param batch The SpriteBatch the arrow and text get rendered to.
     */
    private void drawBackBottomArrow(SpriteBatch batch) {
        if (currentPage > FIRST_PAGE) {
            batch.draw(backArrow, 60, 10);
        }
        name.setColor(Color.BLACK);
        name.draw(batch, Integer.toString(currentPage + 1) + "/" + Integer.toString((int)Math.ceil(gsm.getNearbyPokemon().size() / 3.0)), 420, 70);
    }

    /**
     * Render the transition if the player was able to initiate a battle.
     * @param batch The SpriteBatch the transition gets drawn to.
     */
    private void drawTransition(SpriteBatch batch) {
        if (initiateBattle || finishedTransition) {
            batch.end();
            Gdx.gl.glEnable(GL20.GL_BLEND);
            Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
            transitionRenderer.begin(ShapeRenderer.ShapeType.Filled);
            transitionRenderer.setColor(0,0,0, 1);
            transitionRenderer.rect(0,0,1080, transitionHeight);
            transitionRenderer.end();
            Gdx.gl.glDisable(GL20.GL_BLEND);
            batch.begin();
        }
    }

    /**
     * Update the WildPokemonListState screen.
     * @param dt The time elapsed.
     */
    @Override
    public void update(double dt) {
        if (finishedTransition) {
            startWildBattle();
        }
        if (initiateBattle) {
            updateTransition(dt);
        }
        if (MyInput.clicked() && !initiateBattle) {
            if (MyInput.getX() >= 931 && MyInput.getX() <= 1080 &&
                    MyInput.getY() >= 0 && MyInput.getY() <= 152) {
                returnToMapState();
            } else if (MyInput.getX() >= 841 && MyInput.getX() <= 1021 &&
                    MyInput.getY() >= 1754 && MyInput.getY() <= 1920) {
                //Check if there is another page.
                if (currentPage * 3 + 3 < gsm.getNearbyPokemon().size()) {
                    goToNextPage();
                }
            } else if (MyInput.getX() >= 33 && MyInput.getX() <= 160 &&
                    MyInput.getY() >= 1819 && MyInput.getY() <= 1920) {
                //Make sure the player isn't on the first page.
                if (currentPage != FIRST_PAGE) {
                    goToPreviousPage();
                }
            } else if (MyInput.getX() >= 0 && MyInput.getX() <= 1080 && MyInput.getY() >= 246 && MyInput.getY() <= 671) {
                //Clicked top panel
                selectBattleOrMap(TOP_POSITION);
            } else if (MyInput.getX() >= 0 && MyInput.getX() <= 1080 && MyInput.getY() >= 777 && MyInput.getY() <= 1197) {
                //Clicked mid panel
                if (currentPage * 3 + 1 < gsm.getNearbyPokemon().size()) {
                    selectBattleOrMap(MID_POSITION);
                }
            } else if (MyInput.getX() >= 0 && MyInput.getX() <= 1080 && MyInput.getY() >= 1332 && MyInput.getY() <= 1690) {
                //Clicked bottom panel
                if (currentPage * 3 + 2 < gsm.getNearbyPokemon().size()) {
                    selectBattleOrMap(BOT_POSITION);
                }
            }
        }
    }

    /**
     * Start the wild battle depending on which Pokemon the player
     * clicked.
     */
    private void startWildBattle() {
        if (clickedPokemonPosition == TOP_POSITION) {
            gsm.setState(new BattleState(gsm, gsm.getNearbyPokemon()
                    .get(currentPage * 3 + TOP_POSITION).getPokemon(), wildBgm));
            gsm.getNearbyPokemon().remove(currentPage * 3 + TOP_POSITION);
        } else if (clickedPokemonPosition == MID_POSITION) {
            gsm.setState(new BattleState(gsm, gsm.getNearbyPokemon()
                    .get(currentPage * 3 + MID_POSITION).getPokemon(), wildBgm));
            gsm.getNearbyPokemon().remove(currentPage * 3 + MID_POSITION);
        } else if (clickedPokemonPosition == BOT_POSITION) {
            gsm.setState(new BattleState(gsm, gsm.getNearbyPokemon()
                    .get(currentPage * 3 + BOT_POSITION).getPokemon(), wildBgm));
            gsm.getNearbyPokemon().remove(currentPage * 3 + BOT_POSITION);
        }
    }

    /**
     * Update the transition.
     * Increases the size of the "curtain" every so often.
     * @param dt The time elapsed to measure how much to transition.
     */
    private void updateTransition(double dt) {
        transitionHeight += (dt * 760);
        if (transitionHeight >= 1920) {
            initiateBattle = false;
            finishedTransition = true;
        }
    }

    /**
     * Change the state to the map state where the playe chooses
     * between looking at the map or the wild pokemon list.
     */
    private void returnToMapState() {
        gsm.setState(new LoadingState(gsm, LoadingState.MAP_STATE));
        dispose();
    }

    /**
     * Go to the next page of the wild pokemon list.
     */
    private void goToNextPage() {
        currentPage++; //Update page number.
        //Dispose the current pokemon textures.
        topTexture.dispose();
        bottomTexture.dispose();
        middleTexture.dispose();
        //Get the pokemon textures for the pokemon
        //on the next page.
        initNewSpriteTextures();
    }

    /**
     * Go to the previous page of the wild pokemon list.
     */
    private void goToPreviousPage() {
        currentPage--; //Update the current page.
        //Dispose the current page pokemon textures and initialize the
        //previous page's pokemon textures.
        topTexture.dispose();
        topTexture = new Texture(gsm.getNearbyPokemon().get(currentPage * 3)
                .getPokemon().getMapIconPath());
        middleTexture.dispose();
        middleTexture = new Texture(gsm.getNearbyPokemon().get(currentPage * 3 + 1)
                .getPokemon().getMapIconPath());
        bottomTexture.dispose();
        bottomTexture = new Texture(gsm.getNearbyPokemon().get(currentPage * 3 + 2)
                .getPokemon().getMapIconPath());
        hasMiddlePokemon = true;
        hasBottomPokemon = true;
    }

    /**
     * Select whether to initiate the battle or open the map of the
     * Pokemon in position pos that was clicked.
     * @param pos The position of the Pokemon panel that was clicked.
     *            TOP_POSITION, MID_POSITION or BOT_POSITION
     */
    private void selectBattleOrMap(int pos) {
        if (inBattlingRange(pos)) {
            initiateBattle = true;
            clickedPokemonPosition = pos;
            gsm.stopBgm();
            wildBgm.play();
        } else {
            openMapActivity(pos);
        }
    }

    /**
     * Open the Google map activity where it shows the Player's position and
     * the position of the Pokemon that was clicked on at position pos.
     * @param pos The position of the Pokemon panel that was clicked.
     *            TOP_POSITION, MID_POSITION or BOT_POSITION
     */
    private void openMapActivity(int pos) {
        gsm.getGameCallBack().startPokemonMapActivity(gsm.getNearbyPokemon().get(currentPage * 3 + pos).getLatitude(),
                gsm.getNearbyPokemon().get(currentPage * 3 + pos).getLongitude(),
                gsm.getNearbyPokemon().get(currentPage * 3 + pos).getPokemon().getMapIconPath(),
                (int) Math.round(distance(gsm.getLatitude(), gsm.getNearbyPokemon().get(currentPage * 3 + pos).getLatitude(),
                        gsm.getLongitude(), gsm.getNearbyPokemon().get(currentPage * 3 + pos).getLongitude())));
    }

    /**
     * Dispose the textures, fonts and sounds.
     */
    @Override
    protected void dispose() {
        name.dispose();
        info.dispose();
        topTexture.dispose();
        if (!finishedTransition) {
            wildBgm.dispose();
        }
        try {
            middleTexture.dispose();
        } catch (Exception e) { }
        try {
            bottomTexture.dispose();
        } catch (Exception e) { }
        transitionRenderer.dispose();
        gsm.getLoader().unload("wildPokemonList/backwardsArrow.png");
        gsm.getLoader().unload("wildPokemonList/forwardArrow.png");
        gsm.getLoader().unload("wildPokemonList/pokemonListPanel.png");
        gsm.getLoader().unload("wildPokemonList/wildPokemonListBackground.png");
    }
}
