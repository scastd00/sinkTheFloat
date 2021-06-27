package sink;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public class UI {
	private static final Logger logger = LogManager.getLogger(UI.class);
	private Game game;

	public UI(@NotNull Game game) {
		this.game = game;
	}

	public UI(int boardSize) throws SinkException {
		this.game = new Game(
			new Player[] {SinkIO.createPlayer(1, boardSize), SinkIO.createPlayer(2, boardSize)},
			new SinkTime()
		);
	}

	public Game getGame() {
		return this.game;
	}

	public void setGame(@NotNull Game game) {
		this.game = game;
	}

	public String printBoard() {
		return this.game.getPlayers()[0].toString() + "\n\n\n" + this.game.getPlayers()[1].toString();
	}

	public void shoot(int player) throws SinkException {
		logger.info("Player {}: Introduce the row to shot", player);
		int row = Integer.parseInt(Keyboard.read()) - 1;

		logger.info("Player {}: Introduce the column to shot", player);
		int column = Keyboard.read().toUpperCase().trim().charAt(0) - 'A';

		this.game.shoot(player - 1, row, column);
	}

	public void start() {
		logger.info("Starting time: {}", this.game.getTime());

		while (this.game.isPossibleToPlay()) {
			logger.trace("\n\n");
			logger.info(this.game);

			try {
				this.shoot(1);
				this.shoot(2);
			} catch (SinkException e) {
				logger.warn(e.getMessage());
			}
		}
	}
}
