package sink;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * Class that represents the boats that players have to sink.
 * <b>Their properties cannot change at any time.</b>
 */
public class Boat {
	private final BoatUnit[] units;
	private final int type;
	private final int headRow;
	private final int headColumn;
	private final int size;
	private final int[] directionVector;

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

	public BoatUnit[] getUnits() {
		return this.units;
	}

	public int getHeadRow() {
		return this.headRow;
	}

	public int getHeadColumn() {
		return this.headColumn;
	}

	public int getSize() {
		return this.size;
	}

	public int[] getDirectionVector() {
		return this.directionVector;
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
