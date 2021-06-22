package sink;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainSinkTheFloat {

	private static final Logger logger = LogManager.getLogger(MainSinkTheFloat.class);

	public static void main(String[] args) {
		try {
			logger.trace("Board size for the game? Enter a number: ");
			final int boardSize = Integer.parseInt(Keyboard.read());

			Player player1 = TextUI.createPlayer(1, boardSize);
			Player player2 = TextUI.createPlayer(2, boardSize);

			Game game = new Game(new Player[] {player1, player2}, new SinkTime(0, 0));
			TextUI ui = new TextUI(game);
			ui.start();
		} catch (SinkException e) {
			logger.error(e.getMessage());
		}
	}
}
