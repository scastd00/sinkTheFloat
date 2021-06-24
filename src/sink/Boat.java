package sink;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Boat {
	private static final Logger logger = LogManager.getLogger(Boat.class);

	private int type;
	private int row;
	private int column;
	private int size;
	private int[] direction;

	public Boat(int type, int row, int column, int size, int[] direction) {
		this.type = type;
		this.row = row;
		this.column = column;
		this.size = size;
		this.direction = direction;
	}

	public Boat() {
		this(Constants.NO_BOAT, 0, 0, 0, Constants.NO_DIR);
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		if (type < Constants.AIRCRAFT_CARRIER || type > Constants.NO_BOAT) {
			throw new IllegalArgumentException("Bad boat type");
		}

		this.type = type;
	}

	public int getRow() {
		return this.row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return this.column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int[] getDirection() {
		return this.direction;
	}

	public void setDirection(int[] direction) {
		this.direction = direction;
	}
}
