package sink;

import org.jetbrains.annotations.Contract;

// Todo: Hacer comprobaciones de coordenadas
public class BoatUnit {
	private boolean hit = false;
	private int type;
	private int row;
	private int column;

	@Contract(pure = true)
	public BoatUnit(int type, int row, int column) {
		this.type = type;
		this.row = row;
		this.column = column;
	}

	@Contract(pure = true)
	public BoatUnit() {
		this(Constants.NO_BOAT, 0, 0);
	}

	public boolean isHit() {
		return this.hit;
	}

	public void setHit(boolean hit) {
		this.hit = hit;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		BoatUnit boatUnit = (BoatUnit) o;

		if (row != boatUnit.row) {
			return false;
		}
		return column == boatUnit.column;
	}

	@Override
	public int hashCode() {
		return 31 * row + column;
	}
}
