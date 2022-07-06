package at.compus02.swd.ss2022.game.gameobjects;

import at.compus02.swd.ss2022.game.gameobjects.Observer.PositionObserver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class Player implements GameObject {
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


    float x;
    float y;

    @Override
    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
        this.x = x;
        this.y = y;

        for (PositionObserver obs : observers) {
            obs.update(this.x, this.y);
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public void attack(int dmg) {

    }

    public float getXPosition() {
        System.out.println(x);
        return this.x;
    }

    public float getYPosition() {
        System.out.println(y);
        return this.y;
    }

    //########### OBSERVER ###########
    private List<PositionObserver> observers = new ArrayList<>();

    public void addObserver(PositionObserver obs) {
        this.observers.add(obs);
    }

    public void removeObserver(PositionObserver obs) {
        this.observers.remove(obs);
    }

}
