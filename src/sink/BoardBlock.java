package sink;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BoardBlock {
	private static final Logger logger = LogManager.getLogger(BoardBlock.class);
	private int type;

	public BoardBlock(int type) {
		this.type = type;
	}

	public BoardBlock() {
		this(Constants.NOTHING);
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();

		switch (this.type) {
			case Constants.NOTHING:
				out.append(" ·");
				break;

			case Constants.WATER:
				out.append(Constants.BLUE + " ·");
				break;

			case Constants.HIT:
				out.append(Constants.RED + " ·");
				break;

			case Constants.AIRCRAFT_CARRIER:
				out.append(Constants.AIRCRAFT_CARRIER_COLOR + " ·");
				break;

			case Constants.SUBMARINE:
				out.append(Constants.SUBMARINE_COLOR + " ·");
				break;

			case Constants.DESTROYER:
				out.append(Constants.DESTROYER_COLOR + " ·");
				break;

			case Constants.FRIGATE:
				out.append(Constants.FRIGATE_COLOR + " ·");
				break;

			default:
				break;
		}

		return out.append(Constants.RESET).toString();
	}

	public void hit() {
		this.type = Constants.HIT;
	}

	public void water() {
		this.type = Constants.WATER;
	}
}
