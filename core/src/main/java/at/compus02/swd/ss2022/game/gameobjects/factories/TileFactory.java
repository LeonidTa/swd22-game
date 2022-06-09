package at.compus02.swd.ss2022.game.gameobjects.factories;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.tiles.GrasTile;
import at.compus02.swd.ss2022.game.gameobjects.tiles.GravelTile;
import at.compus02.swd.ss2022.game.gameobjects.tiles.WallTile;
import at.compus02.swd.ss2022.game.gameobjects.tiles.WaterTile;

import java.util.ArrayList;

public class TileFactory  implements AbstractFactory {
    ArrayList<GameObject> tileArray = new ArrayList<>();


    @Override
    public ArrayList<GameObject> createStartingObject(int numberOfObjects, String tileType) {


        for (int i = 0; i < numberOfObjects; i++) {
            switch (tileType) {
                case "GRAS":
                    tileArray.add(new GrasTile());
                    break;
                case "GRAVEL":
                    tileArray.add(new GravelTile());
                    break;
                case "WALL":
                    tileArray.add(new WallTile());
                    break;
                case "WATER":
                    tileArray.add(new WaterTile());
                    break;
            }
       }
        return tileArray;
    }
}