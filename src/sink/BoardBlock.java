package sink;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BoardBlock {
	private static final Logger logger = LogManager.getLogger(BoardBlock.class);
	private final int type;

	public BoardBlock(int type) {
		this.type = type;
	}

	public BoardBlock() {
		this(Constants.WATER);
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();

		switch (this.type) {
			case Constants.WATER:
				out.append(Constants.BLUE + " 0" + Constants.RESET);
				break;

			case Constants.HIT:
				out.append(Constants.RED + " X" + Constants.RESET);
				break;

			case Constants.AIRCRAFT_CARRIER:
				out.append(Constants.AIRCRAFT_CARRIER_COLOR + " A" + Constants.RESET);
				break;

			case Constants.SUBMARINE:
				out.append(Constants.SUBMARINE_COLOR + " S" + Constants.RESET);
				break;

			case Constants.DESTROYER:
				out.append(Constants.DESTROYER_COLOR + " D" + Constants.RESET);
				break;

			case Constants.FRIGATE:
				out.append(Constants.FRIGATE_COLOR + " F" + Constants.RESET);
				break;

			default:
				break;
		}

		return out.toString();
	}
}
