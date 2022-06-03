package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class AssetRepository {

    private static AssetRepository assetRepository = new AssetRepository();
    private static Texture texture;
    private static Sound sound;


    public AssetRepository() {

    }

    private AssetRepository getInstance() {
        return assetRepository;
    }

    public static Texture getTexture(String type) {
        switch (type) {
            case "player":
                texture = new Texture("player.png");
                break;
            case "bush":
                texture = new Texture("bush.png");
                break;
            case "log":
                texture = new Texture("log.png");
                break;
            case "sign":
                texture = new Texture("sign.png");
                break;
            case "stone":
                texture = new Texture("stone.png");
                break;
            case "tile_gras":
                texture = new Texture("tile_gras.png");
                break;
            case "tile_gravel":
                texture = new Texture("tile_gravel.png");
                break;
            case "tile_wall":
                texture = new Texture("tile_wall.png");
                break;
            case "tile_water":
                texture = new Texture("tile_water.png");
                break;
        }
        return texture;
    }



    public void preloadAssets() {
        Texture tile_gras = new Texture("tile_gras");
        Texture tile_gravel = new Texture("tile_gras");
        Texture tile_wall = new Texture("tile_gras");
        Texture tile_water = new Texture("tile_gras");

    }


    public void dispose() {
        texture.dispose();
    }
}

