package at.compus02.swd.ss2022.game.gameobjects.factories;

import at.compus02.swd.ss2022.game.gameobjects.GrasTile;
import at.compus02.swd.ss2022.game.gameobjects.Tile;

import java.util.ArrayList;

public class TileFactory implements AbstractFactory{


    @Override
    public void createStartingObject(int numberOfObjects, Tile tile) {
        ArrayList<Tile> tiles = new ArrayList<>();

        for (int i = 0; i < numberOfObjects; i++){

            tiles.add(tile);

        }
    }
}
