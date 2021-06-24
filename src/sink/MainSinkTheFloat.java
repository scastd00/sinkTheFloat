package sink;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainSinkTheFloat {

	private static final Logger logger = LogManager.getLogger(MainSinkTheFloat.class);

	public static void main(String[] args) {
		try {
			logger.trace("Board size for the game? Enter a number: ");
			TextUI ui = new TextUI(Integer.parseInt(Keyboard.read()));
			ui.start();
		} catch (SinkException e) {
			logger.error(e.getMessage());
		}
	}
}
