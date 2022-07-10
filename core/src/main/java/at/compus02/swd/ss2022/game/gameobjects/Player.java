package at.compus02.swd.ss2022.game.gameobjects;

import at.compus02.swd.ss2022.game.gameobjects.Observer.PositionObserver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import jdk.vm.ci.code.Location;

import java.util.ArrayList;
import java.util.List;

public class Player implements GameObject, Status {
    private Texture image;
    private Sprite sprite;
    private double health;

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

    @Override
    public boolean isAlive() {
        if (this.health <= 0) {
            System.out.println("You Died!");
            return false;
        } else return true;
    }

    @Override
    public void setHealth(double health) {
        this.health = 10;
    }

    public void attack(double dmg) {

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

    public boolean isNearEnemy() {
        //write here code that checks if player 1 is in vacinity of an enemy

    return false;
    }


}
