package at.compus02.swd.ss2022.game;

import at.compus02.swd.ss2022.game.gameobjects.Enemies.Zombie;
import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.Player;
import at.compus02.swd.ss2022.game.gameobjects.factories.EnemyFactory;
import at.compus02.swd.ss2022.game.gameobjects.factories.PlayerFactory;
import at.compus02.swd.ss2022.game.gameobjects.factories.TileFactory;
import at.compus02.swd.ss2022.game.input.GameInput;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import java.util.ArrayList;
import java.util.Random;

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
	private PlayerFactory playerFactory = new PlayerFactory();
	private ArrayList<GameObject> players;
	private Player player;
	private TileFactory tilefactory = new TileFactory();
	private ArrayList<GameObject> tileObjects;
	private EnemyFactory enemyFactory = new EnemyFactory();
	private ArrayList<GameObject> enemies;



	@Override
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		Gdx.input.setInputProcessor(this.gameInput);

		players = playerFactory.createStartingObject(1,"player1");
		player	= (Player) players.get(0);

		enemies = enemyFactory.createStartingObject(10, "ZOMBIE");
		tileObjects = tilefactory.createStartingObject(255, "GRAS");

		enemies = enemyFactory.createStartingObject(10, "ZOMBIE");
		for (GameObject enemy : enemies) {
			//Zombieherde
			Random random = new Random();
			int enemyRandomX = random.ints(-240, 240)
					.findFirst()
					.getAsInt();
			int enemyRandomY = random.ints(-240, 240)
					.findFirst()
					.getAsInt();
			System.out.println(Math.random()*64);
			enemy.setPosition(enemyRandomX, enemyRandomY);
		}
	}

	private void act(float delta) {
		for(GameObject gameObject : gameObjects) {
			gameObject.act(delta);
		}
		gameInput.setPlayer1(player);
		player.getYPosition();
		player.getYPosition();
	}



	private void draw() {
		batch.setProjectionMatrix(viewport.getCamera().combined);
		batch.begin();


		int x = -272;
		int y = -240;


		for(GameObject tile : tileObjects) {
			x += 32;
			if(x == 240) {
				x = -240;
				y += 32;
			}
			tile.setPosition(x, y);
			tile.draw(batch);
		}

		for (GameObject enemy : enemies) {
			enemy.draw(batch);
		}
		player.draw(batch);

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