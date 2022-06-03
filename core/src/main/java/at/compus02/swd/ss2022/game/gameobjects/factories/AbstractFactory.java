package at.compus02.swd.ss2022.game.gameobjects.factories;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;

import java.util.ArrayList;

public interface AbstractFactory {
    ArrayList<GameObject> createStartingObject(int numberOfObjects, String tiles);
}
