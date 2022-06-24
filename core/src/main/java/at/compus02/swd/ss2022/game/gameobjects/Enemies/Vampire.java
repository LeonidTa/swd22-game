package at.compus02.swd.ss2022.game.gameobjects.Enemies;

import at.compus02.swd.ss2022.game.gameobjects.AssetRepository;
import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Vampire implements GameObject {
    private Texture image;
    private Sprite sprite;

    public Vampire() {
        AssetRepository.preloadAssets();
        image = AssetRepository.getTexture("vampire");
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
