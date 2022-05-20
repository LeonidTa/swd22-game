package at.compus02.swd.ss2022.game.gameobjects.factories;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.tiles.GrasTile;
import at.compus02.swd.ss2022.game.gameobjects.tiles.GravelTile;
import at.compus02.swd.ss2022.game.gameobjects.tiles.WallTile;
import at.compus02.swd.ss2022.game.gameobjects.tiles.WaterTile;

import java.util.ArrayList;

public class TileFactory  implements AbstractFactory {

    private ArrayList<GameObject> tileArray = new ArrayList<>();

    public ArrayList<GameObject> getTileArray() {
        return tileArray;
    }


    @Override
    public void createStartingObject(int numberOfObjects, String tileType) {
        for (int i = 0; i < numberOfObjects; i++) {
            switch (tileType) {
                case "GRAS":
                    tileArray.add(new GrasTile());
                case "GRAVEL":
                    tileArray.add(new GravelTile());
                case "WALL":
                    tileArray.add(new WallTile());
                case "WATER":
                    tileArray.add(new WaterTile());
            }
        }
    }
}