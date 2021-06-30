package sink;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Boat {
	private static final Logger logger = LogManager.getLogger(Boat.class);
	private final BoatUnit[] units;
	private int type;
	private int headRow;
	private int headColumn;
	private int size;
	private int[] directionVector;

	public Boat(int type, int headRow, int headColumn, int size, int[] directionVector) {
		this.type = type;
		this.headRow = headRow;
		this.headColumn = headColumn;
		this.size = size;
		this.directionVector = directionVector;
		this.units = new BoatUnit[size];
		this.fillUnits();
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

	public BoatUnit[] getUnits() {
		return this.units;
	}

	public int getHeadRow() {
		return this.headRow;
	}

	public void setHeadRow(int headRow) {
		this.headRow = headRow;
	}

	public int getHeadColumn() {
		return this.headColumn;
	}

	public void setHeadColumn(int headColumn) {
		this.headColumn = headColumn;
	}

	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int[] getDirectionVector() {
		return this.directionVector;
	}

	public void setDirectionVector(int[] directionVector) {
		this.directionVector = directionVector;
	}

	public @NotNull String getDirectionStringFromVector(int[] direction) {
		if (Arrays.equals(direction, Constants.DIR_UP)) {
			return "U";
		} else if (Arrays.equals(direction, Constants.DIR_DOWN)) {
			return "D";
		} else if (Arrays.equals(direction, Constants.DIR_LEFT)) {
			return "L";
		}

		return "R"; // The boat always has a direction
	}

	private void fillUnits() {
		for (int i = 0; i < this.units.length; i++) {
			this.units[i] = new BoatUnit(this.type, this.headRow - i * this.directionVector[1],
				this.headColumn - i * this.directionVector[0]);
		}
	}

	public boolean isSank() {
		boolean sank = true;

		for (BoatUnit unit : this.units) {
			sank = sank && unit.isHit();
		}

		return sank;
	}

	public void hit(int row, int column) {
		for (BoatUnit unit : this.units) {
			if (unit.getRow() == row && unit.getColumn() == column) {
				unit.setHit(true);
				return;
			}
		}
	}
}
