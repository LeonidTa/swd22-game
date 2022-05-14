package at.compus02.swd.ss2022.game.gameobjects.factories;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.Tile;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class TileFactory  {

    public void createStartingTiles(int numberOfTiles) {

        ArrayList<Tile> tiles = new ArrayList<>();

        for (int i = 0; i < numberOfTiles; i++){

            Tile tile = new Tile();
            tiles.add(tile);

        }
    }
}
