package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player implements GameObject{
    private Texture image;
    private Sprite sprite;

    public Player() {
        //tr.getTexture("Player");
        AssetRepository.preloadAssets();
        image = AssetRepository.getTexture("player");
        //image = new Texture("player.png");// <-- ursprünglich
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
