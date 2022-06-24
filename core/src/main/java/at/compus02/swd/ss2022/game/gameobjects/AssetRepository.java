package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

public class AssetRepository {

    private static AssetRepository assetRepository = new AssetRepository();
    private static Texture texture;
    private static Sound sound;
    private static HashMap<String, Texture> allTextures;


    public AssetRepository() {

    }

    private AssetRepository getInstance() {
        return assetRepository;
    }

    //getTexture(String type) takes the desired texture from allTextures Map
    public static Texture getTexture(String type) {
        if (allTextures.containsKey(type)) {
            return allTextures.get(type);
        } else {
            throw new IllegalArgumentException("Texture not found");
        }
    }


    // When preloadAssets() is called, all textures are created and saved in a map.
    // This map then instantiates the attribute "allTextures". Don't forget: The preloadAssets first needs to be called for it to actually work!
    //Another possible implementation would be to directly call the preloadAssets() in the getTexture(String type) method, but this would always then create all new textures
    public static void preloadAssets() {
        HashMap<String, Texture> textures = new HashMap<>();
        textures.put("player", new Texture("player.png"));
        textures.put("bush", new Texture("bush.png"));
        textures.put("log", new Texture("log.png"));
        textures.put("sign", new Texture("sign.png"));
        textures.put("stone", new Texture("stone.png"));
        textures.put("tile_gras", new Texture("tile_gras.png"));
        textures.put("tile_gravel", new Texture("tile_gravel.png"));
        textures.put("tile_wall", new Texture("tile_wall.png"));
        textures.put("tile_water", new Texture("tile_water.png"));
        textures.put("zombie", new Texture("zombie.png"));
        textures.put("vampire", new Texture("vampire.png"));


        allTextures = textures;
    }


    public void dispose() {
        texture.dispose();
    }
}

