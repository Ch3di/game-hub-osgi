package sokoban;

import gameApi.GameInterface;
import sokobanCoree.Sokoban;

public class SokobanGame implements GameInterface {

	@Override
	public void launchGame() {
		Sokoban.main(null);
	}

}
