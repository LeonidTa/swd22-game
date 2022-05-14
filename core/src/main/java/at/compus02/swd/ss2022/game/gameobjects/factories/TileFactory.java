package at.compus02.swd.ss2022.game.gameobjects.factories;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.tiles.GrasTile;

import java.util.ArrayList;

public class TileFactory  implements AbstractFactory{


    @Override
    public void createStartingObject(int numberOfObjects, String tileType) {
        ArrayList<GameObject> tileArray = new ArrayList<>();

        for (int i = 0; i < numberOfObjects; i++){
            switch (tileType) {
                case "GRAS":
                    GrasTile grasTile = new GrasTile();
                    tileArray.add(grasTile);
                case "GRAVEL":


            }
        }

    }
}
