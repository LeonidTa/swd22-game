package at.compus02.swd.ss2022.game;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.Player;
import at.compus02.swd.ss2022.game.gameobjects.Sign;
import at.compus02.swd.ss2022.game.gameobjects.factories.PlayerFactory;
import at.compus02.swd.ss2022.game.gameobjects.factories.TileFactory;
import at.compus02.swd.ss2022.game.gameobjects.tiles.GrasTile;
import at.compus02.swd.ss2022.game.input.GameInput;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
	private SpriteBatch batch;

	private ExtendViewport viewport = new ExtendViewport(512.0f, 512.0f, 512.0f, 512.0f);
	private GameInput gameInput = new GameInput();

	private Array<GameObject> gameObjects = new Array<>();

	private final float updatesPerSecond = 60;
	private final float logicFrameTime = 1 / updatesPerSecond;
	private float deltaAccumulator = 0;
	private BitmapFont font;
	TileFactory tileFactory = new TileFactory();
	PlayerFactory playerFactory = new PlayerFactory();

	@Override
	public void create() {
		batch = new SpriteBatch();


		//playerFactory.createStartingObject(1, "player1");
		gameObjects.add(new Player());

		tileFactory.createStartingObject(60, "GRAS");
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		Gdx.input.setInputProcessor(this.gameInput);


	}

	private void act(float delta) {
		for(GameObject gameObject : gameObjects) {
			gameObject.act(delta);
		}

		for (GameObject tile : tileFactory.getTileArray()) {
			tile.act(delta);
		}
	}



	private void draw() {
		batch.setProjectionMatrix(viewport.getCamera().combined);
		batch.begin();


		int x = -240;
		int y = -240;
		for(GameObject tileObject : tileFactory.getTileArray()) {
			x += 15;
			if(x == 240) {
				y += 15;
			}
			tileObject.setPosition(x, y);
			tileObject.draw(batch);
		}

		font.draw(batch, "Hello Game", -220, -220);
		batch.end();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		float delta = Gdx.graphics.getDeltaTime();
		deltaAccumulator += delta;
		while(deltaAccumulator > logicFrameTime) {
			deltaAccumulator -= logicFrameTime;
			act(logicFrameTime);
		}
		draw();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

	@Override
	public void resize(int width, int height){
		viewport.update(width,height);
	}
}