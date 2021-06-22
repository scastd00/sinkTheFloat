package sink;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextUI {
	private static final Logger logger = LogManager.getLogger(TextUI.class);
	private final Game game;

	public TextUI(Game game) {
		this.game = game;
	}

	public TextUI() {
		this(new Game());
	}

	public static Player createPlayer(int playerNumber, int boardSize) {
		logger.debug("Creating player {}", playerNumber);
		logger.trace("Introduce the name of the player {}", playerNumber);
		Player player = new Player();

		try {
			player.setName(Keyboard.read().trim());
			player.setScore(createScore(playerNumber));
			player.setBoard(createBoard(playerNumber, boardSize));
		} catch (SinkException | NullPointerException e) {
			logger.warn(e.getMessage());
		}

		return player;
	}

	public static Board createBoard(int playerNumber, int size) {
		logger.debug("Creating board for player {}", playerNumber);
		return new Board(size, Constants.WATER);
	}

	public static Score createScore(int playerNumber) {
		logger.debug("Creating initial score for player {}", playerNumber);
		return new Score();
	}

	public String printBoard() {
		StringBuilder out = new StringBuilder();

		out.append(this.game.getPlayers()[0].toString()).append("\n\n\n")
		   .append(this.game.getPlayers()[1].toString());

		return out.toString();
	}

	public void start() {
		logger.info(this.game.toString());
	}
}
