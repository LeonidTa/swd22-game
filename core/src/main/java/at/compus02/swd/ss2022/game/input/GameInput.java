package at.compus02.swd.ss2022.game.input;

import at.compus02.swd.ss2022.game.gameobjects.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class GameInput extends InputAdapter {
    @Override
    public boolean keyDown(int keycode) {
        Player player1 = new Player();
        player1.setPosition(0,0);
        int x = 0;
        int y = 0;
        while (true) {
            if (keycode == Input.Keys.UP) {
                player1.setPosition(x, y += 32);
            } //VK_UP is a pre-defined constant value
			else if (keycode == Input.Keys.DOWN) {
                player1.setPosition(x, y -= 32);
            } else if (keycode == Input.Keys.LEFT) {
                player1.setPosition(x -= 8, y);
            } else if (keycode == Input.Keys.RIGHT) {
                player1.setPosition(x += 8, y);
            }
        }
    }
}
