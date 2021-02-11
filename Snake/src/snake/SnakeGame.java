package snake;

import gameApi.GameInterface;
import snakeCore.Snake;

public class SnakeGame implements GameInterface {

	@Override
	public void launchGame() {
		Snake.main(null);
	}

}
