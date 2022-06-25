package at.compus02.swd.ss2022.game.gameobjects.Enemies;

import at.compus02.swd.ss2022.game.gameobjects.AssetRepository;
import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.Player;
import at.compus02.swd.ss2022.game.input.GameInput;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Zombie implements GameObject, Enemies{
    private Texture image;
    private Sprite sprite;
    private float x;
    private float y;

    public Zombie() {
        AssetRepository.preloadAssets();
        image = AssetRepository.getTexture("zombie");
        sprite = new Sprite(image);
    }

    @Override
    public void act(float delta) {

    }

    @Override
    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    @Override
    public boolean move(Player player) {
        float playerX = player.getXPosition();
        float playerY = player.getYPosition();
        float abstandX = playerX - this.x;
        float abstandY = playerY - this.y;

        if (abstandX == -64 || abstandX == -64 && abstandY ==-64 || abstandY == 64) {
            setPosition(playerX - 32, playerY -32);
            return true;
        }

        return false;
    }
}
