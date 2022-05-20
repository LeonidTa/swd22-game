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

import java.awt.event.KeyEvent;
import java.util.Scanner;

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
	TileFactory grasFactory = new TileFactory();
	TileFactory waterFactory = new TileFactory();
	Player player1 = new Player();

	@Override
	public void create() {
		batch = new SpriteBatch();

		grasFactory.createStartingObject(240, "GRAS");
		waterFactory.createStartingObject(32, "WATER");
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		Gdx.input.setInputProcessor(this.gameInput);


	}

	private void act(float delta) {
		for(GameObject gameObject : gameObjects) {
			gameObject.act(delta);
		}
		for (GameObject tile : grasFactory.getTileArray()) {
			tile.act(delta);
		}
		for (GameObject tile : waterFactory.getTileArray()) {
			tile.act(delta);
		}
	}



	private void draw() {
		batch.setProjectionMatrix(viewport.getCamera().combined);
		batch.begin();


		int x = -240;
		int y = -240;
		for(GameObject tileObject : grasFactory.getTileArray()) {
			x += 8;
			if(x == 240) {
				x = -240;
				y += 32;
			}
			tileObject.setPosition(x, y);
			tileObject.draw(batch);
		}

		x = -250;
		for (GameObject waterObject : waterFactory.getTileArray()) {
			if (x == 250){
				break;
			} else {
				waterObject.setPosition(x+=32,0);
				waterObject.draw(batch);

			}
		}


		font.draw(batch, "Hello Game", -220, -220);
		batch.end();
	}

	public void movingPlayer(KeyEvent ke){
		int x = 0;
		int y = 0;
		while (true) {
			if (ke.getKeyCode() == KeyEvent.VK_UP) {
				player1.setPosition(x = 0, y += 32);
			} //VK_UP is a pre-defined constant value
			else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {

			}
			else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {

			}
			else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {

			}
		}
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