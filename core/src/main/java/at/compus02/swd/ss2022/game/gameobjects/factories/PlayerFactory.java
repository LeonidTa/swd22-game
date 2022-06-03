package at.compus02.swd.ss2022.game.gameobjects.factories;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.Player;
import at.compus02.swd.ss2022.game.gameobjects.tiles.GrasTile;
import at.compus02.swd.ss2022.game.gameobjects.tiles.GravelTile;
import at.compus02.swd.ss2022.game.gameobjects.tiles.WallTile;
import at.compus02.swd.ss2022.game.gameobjects.tiles.WaterTile;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class PlayerFactory implements AbstractFactory{


    @Override
    public ArrayList<GameObject> createStartingObject(int numberOfObjects, String playerType) {
        ArrayList<GameObject> playerArray = new ArrayList<>();

        if (playerType.equals("player1")) {
            playerArray.add(new Player());
        }
        return playerArray;
    }
}
