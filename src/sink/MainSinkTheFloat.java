package sink;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainSinkTheFloat {

	private static final Logger logger = LogManager.getLogger(MainSinkTheFloat.class);

	public static void main(String[] args) {
		try {
//			logger.trace("Board size for the game? Enter a number: ");
//			Constants.setBoardSize(Integer.parseInt(Keyboard.read()));
//			TextUI ui = new TextUI(Constants.getBoardSize());
//			ui.start();

			new TextUI(SinkIO.createGameFromFile(
				"/home/samuel/IdeaProjects/IntelliJ/myProjects/java/sinkTheFloat/inputs/io1.txt")).start();

		} catch (SinkException e) {
			logger.error(e.getMessage());
		}
	}
}
