package sink;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class UI {
	private static final Logger logger = LogManager.getLogger(UI.class);
	private Game game;

	@Contract(pure = true)
	public UI(@NotNull Game game) {
		this.game = game;
	}

	public UI(int boardSize) throws SinkException {
		this.game = new Game(new Player[] {SinkIO.createPlayer(1, boardSize),
				SinkIO.createPlayer(2, boardSize)}, new SinkTime()
		);
	}

	public Game getGame() {
		return this.game;
	}

	public void setGame(@NotNull Game game) {
		this.game = game;
	}

	public void shoot(int player, int row, int column) throws SinkException {
		this.game.shoot(player - 1, row, column);
	}

	public void start() {
		logger.info("Starting time: {}", this.game.getTime());
		int row, column;

		while (this.game.isPossibleToPlay()) {
			logger.trace("\n\n");
			this.logFormattedBoardToFileAndConsole();

			try {
				logger.info("Player {}: Introduce the row to shot", 1);
				row = Integer.parseInt(Keyboard.read()) - 1;

				logger.info("Player {}: Introduce the letter of the column to shot", 1);
				column = Keyboard.read().trim().toUpperCase().charAt(0) - 'A';
				this.shoot(1, row, column);

				logger.info("Player {}: Introduce the row to shot", 2);
				row = Integer.parseInt(Keyboard.read()) - 1;

				logger.info("Player {}: Introduce the letter of the column to shot", 2);
				column = Keyboard.read().trim().toUpperCase().charAt(0) - 'A';
				this.shoot(2, row, column);
			} catch (SinkException e1) {
				logger.warn(e1.getMessage());
			} catch (NumberFormatException e2) {
				logger.warn("Please introduce a valid input");
			}
		}
	}

	@Contract(pure = true)
	private void logFormattedBoardToFileAndConsole() {
		logger.trace(this.game);
		logger.debug(this.game.toLogString());
	}
}
