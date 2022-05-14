package at.compus02.swd.ss2022.game.gameobjects.tiles;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GrasTile implements GameObject {
    private Texture image;
    private Sprite sprite;

    public GrasTile() {
        image = new Texture("tile_gras.png");
        sprite = new Sprite(image);
    }

    @Override
    public void act(float delta) {

    }

    @Override
    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }
}