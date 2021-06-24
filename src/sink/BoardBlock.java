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
		this(Constants.NOTHING);
	}

	public int getType() {
		return this.type;
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();

		switch (this.type) {
			case Constants.NOTHING:
				out.append(" ·");
				break;

			case Constants.WATER:
				out.append(Constants.BLUE + " 0");
				break;

			case Constants.HIT:
				out.append(Constants.RED + " X");
				break;

			case Constants.AIRCRAFT_CARRIER:
				out.append(Constants.AIRCRAFT_CARRIER_COLOR + " A");
				break;

			case Constants.SUBMARINE:
				out.append(Constants.SUBMARINE_COLOR + " S");
				break;

			case Constants.DESTROYER:
				out.append(Constants.DESTROYER_COLOR + " D");
				break;

			case Constants.FRIGATE:
				out.append(Constants.FRIGATE_COLOR + " F");
				break;

			default:
				break;
		}

		return out.append(Constants.RESET).toString();
	}
}
