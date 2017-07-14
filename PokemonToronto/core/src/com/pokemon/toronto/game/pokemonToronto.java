package com.pokemon.toronto.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.pokemon.toronto.game.com.pokemon.toronto.gamestate.GameStateManager;
import com.pokemon.toronto.game.com.pokemon.toronto.input.InputHandler;
import com.pokemon.toronto.game.com.pokemon.toronto.input.MyInput;
import com.pokemon.toronto.game.com.pokemon.toronto.textbox.TextBoxText;

import java.util.ArrayList;

public class pokemonToronto extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private GameStateManager gsm;
	private ShapeRenderer sr;
	TextBoxText tbt;
	private OrthographicCamera camera;
	private MyGameCallBack gameCallBack;

	public interface MyGameCallBack {
		public void startMapActivity(double[] pokemonLatitude, double[] pokemonLongitude, String[] pokemonIcon);
		public void startWildPokemonService();
		public void startPokemonMapActivity(double pokemonLatitude, double pokemonLongitude, String pokemonIcon, int distance);
		public void spawnNewGamePokemon();
	}

	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1080, 1920);
		batch = new SpriteBatch();

		Gdx.input.setInputProcessor(new InputHandler());
		/*stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		Skin skin = new Skin(Gdx.files.internal("uiskin.json"), new TextureAtlas(Gdx.files.internal("uiskin.atlas")));
		textField = new TextField(Integer.toString(Gdx.graphics.getWidth()), skin);
		textField.setPosition(200, 200);
		textField.setSize(300, 40);
		*/
		gsm = new GameStateManager();
		//gsm.setNotificationSound();
		gsm.setInitialState();
		gsm.setGameCallBack(gameCallBack);
		gsm.getGameCallBack().spawnNewGamePokemon();
		img = new Texture("badlogic.jpg");
		sr = new ShapeRenderer();
		//stage.addActor(textField);
	}

	public GameStateManager getGsm() {
		return gsm;
	}
	public void setLatitude(double lat) {
		gsm.setLatitude(lat);
	}

	public void setLongitude(double longitude) {
		gsm.setLongitude(longitude);
	}

	public void wildPokemonNotification(double latitude, double longitude, String country, String state,
										String city) {
		gsm.addNewWildPokemon(longitude, latitude, country, state, city);
	}

	public void coordinateUpdate(double latitude, double longitude) {
		Gdx.app.log("GDX LOGGERs - ", "COORDINATE UPDATE - LAT: " + latitude + ", LON: " + longitude);
		gsm.coordinateUpdate(latitude, longitude);
	}

	public void setGameCallBack(MyGameCallBack callBack) {
		this.gameCallBack = callBack;

	}



	@Override
	public void render () {
		double dt = Gdx.graphics.getDeltaTime();
		gsm.update(dt);
		MyInput.update();

		Gdx.gl.glClearColor(0, 0,0,1); // set color
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT ); //clear buffer
		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		gsm.render(batch);
		batch.end();
		//drawStage();
		Gdx.gl.glDisable(GL20.GL_BLEND);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		sr.dispose();
	}

	protected void drawStage() {
		// TODO Auto-generated method stub
		/*stage.act();
		stage.draw();*/
	}
}
