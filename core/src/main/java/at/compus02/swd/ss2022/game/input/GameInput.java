package at.compus02.swd.ss2022.game.input;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class GameInput extends InputAdapter{
    private Player player1;
    private int x = 0;
    private int y = 0;

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    @Override
    public boolean keyDown(int keycode) {
            if (keycode == Input.Keys.UP) {
                player1.setPosition(x, y += 32);
            } //VK_UP is a pre-defined constant value
			else if (keycode == Input.Keys.DOWN) {
                player1.setPosition(x, y -= 32);
            } else if (keycode == Input.Keys.LEFT) {
                player1.setPosition(x -= 32, y);
            } else if (keycode == Input.Keys.RIGHT) {
                player1.setPosition(x += 32, y);
            }
            return true;
    }


}
