package at.compus02.swd.ss2022.game.gameobjects.Enemies;

import at.compus02.swd.ss2022.game.gameobjects.AssetRepository;
import at.compus02.swd.ss2022.game.gameobjects.Enemies.strategyPattern.Enemies;
import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.Observer.PositionObserver;
import at.compus02.swd.ss2022.game.gameobjects.Status;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class Zombie implements GameObject, Enemies, Status {
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

        for (PositionObserver obs : observers) {
            obs.update(this.x, this.y);
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    @Override
    public boolean move(float playerX, float playerY) {

        return false;
    }


    //########### OBSERVER ###########
    private List<PositionObserver> observers = new ArrayList<>();

    public void addObserver(PositionObserver obs) {
        this.observers.add(obs);
    }

    public void removeObserver(PositionObserver obs) {
        this.observers.remove(obs);
    }

    @Override
    public boolean isAlive() {
        return true;
    }
}
