package sink;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Boat {
	private static final Logger logger = LogManager.getLogger(Boat.class);

	private final int type;

	public Boat(int type) {
		this.type = type;
	}

	public Boat() {
		this(Constants.NO_BOAT);
	}
}
