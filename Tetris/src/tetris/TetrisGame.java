package tetris;

import gameApi.GameInterface;
import tetrisCore.Tetris;

public class TetrisGame implements GameInterface {

	@Override
	public void launchGame() {
		Tetris.main(null);
	}

}
