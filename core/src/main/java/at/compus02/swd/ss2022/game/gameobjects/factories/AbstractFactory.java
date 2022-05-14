package at.compus02.swd.ss2022.game.gameobjects.factories;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface AbstractFactory {

    void createStartingObject(int numberOfObjects);
}
