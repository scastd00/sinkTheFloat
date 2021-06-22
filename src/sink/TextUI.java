package sink;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextUI {
	private static final Logger logger = LogManager.getLogger(TextUI.class);
	private final Game game;

	public TextUI() {
		this.game = new Game();
	}

	public Player createPlayer(int playerNumber) {
		logger.debug("Creating player");
		logger.trace("Introduce the name of the player {}", playerNumber);
		Player player = new Player();

		try {
			player.setName(Keyboard.getInput().trim());
		} catch (SinkException | NullPointerException e) {
			logger.warn(e.getMessage());
			return null;
		}

		return player;
	}

	public String printBoard() {
		return this.game.getPlayers()[0].toString();
	}
}
