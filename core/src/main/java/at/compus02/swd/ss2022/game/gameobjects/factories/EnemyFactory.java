package at.compus02.swd.ss2022.game.gameobjects.factories;

import at.compus02.swd.ss2022.game.gameobjects.Enemies.Vampire;
import at.compus02.swd.ss2022.game.gameobjects.Enemies.Zombie;
import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.tiles.GrasTile;
import at.compus02.swd.ss2022.game.gameobjects.tiles.GravelTile;
import at.compus02.swd.ss2022.game.gameobjects.tiles.WallTile;
import at.compus02.swd.ss2022.game.gameobjects.tiles.WaterTile;

import java.util.ArrayList;

public class EnemyFactory implements AbstractFactory{

    @Override
    public ArrayList<GameObject> createStartingObject(int numberOfObjects, String tileType) {
        ArrayList<GameObject> tileArray = new ArrayList<>();

        for (int i = 0; i < numberOfObjects; i++) {
            switch (tileType) {
                case "ZOMBIE":
                    tileArray.add(new Zombie());
                    break;
                case "VAMPIRE":
                    tileArray.add(new Vampire());
                    break;
            }
        }
        return tileArray;
    }

}
