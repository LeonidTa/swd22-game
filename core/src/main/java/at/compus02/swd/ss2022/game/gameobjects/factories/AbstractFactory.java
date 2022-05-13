package at.compus02.swd.ss2022.game.gameobjects.factories;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface AbstractFactory {
    void act(float delta);
    void setPosition(float x, float y);
    void draw(SpriteBatch batch);
}
