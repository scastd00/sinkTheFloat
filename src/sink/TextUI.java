package sink;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TextUI {
	private static final Logger logger = LogManager.getLogger(TextUI.class);
	private Game game;

	public TextUI(@NotNull Game game) {
		this.game = game;
	}

	public TextUI(int boardSize) {
		this.game = new Game(
			new Player[] {SinkIO.createPlayer(1, boardSize), SinkIO.createPlayer(2, boardSize)},
			new SinkTime(0, 0)
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

	public void start() {
		logger.info(this.game.toString());
	}
}
