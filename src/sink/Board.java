package sink;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private BoardBlock[][] blocks;
	private ArrayList<Boat> boats;

	/**
	 * Fixed size of the boards during the game.
	 */
	private final int size;

	/**
	 * Creates a board with the specified table and boats.
	 *
	 * @param blocks blocks of the board.
	 * @param boats  boat list of the board.
	 */
	public Board(BoardBlock[][] blocks, List<Boat> boats) throws SinkException {
		this.setBlocks(blocks);
		this.setBoats(boats);
		this.size = blocks.length;
		Constants.setBoardSize(this.size);
	}

	/**
	 * Creates an empty board.
	 *
	 * @param size size of the board.
	 * @param type creates the board with the blocks filled with colors or not.
	 */
	public Board(int size, int type) {
		this.size = size;
		this.blocks = new BoardBlock[size][size];
		this.boats = new ArrayList<>();

		this.fillBoard(type);
		Constants.setBoardSize(this.size);
	}

	public BoardBlock[][] getBlocks() {
		return this.blocks;
	}

	public void setBlocks(BoardBlock[][] blocks) throws SinkException {
		if (blocks == null) {
			throw new SinkException("Null table");
		}

		this.blocks = blocks;
	}

	public List<Boat> getBoats() {
		return this.boats;
	}

	public void setBoats(List<Boat> boats) throws SinkException {
		if (boats == null) {
			throw new SinkException("Cannot set null list of boats");
		}

		this.boats = (ArrayList<Boat>) boats;
		this.setBoatsInBoard();
	}

	public int getSize() {
		return this.size;
	}

	private void fillBoard(int type) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				this.blocks[i][j] = new BoardBlock(type);
			}
		}
	}

	private void setBoatsInBoard() throws SinkException {
		for (int i = 0; i < this.boats.size(); i++) {
			for (BoatUnit unit : this.boats.get(i).getUnits()) {
				this.blocks[unit.getRow()][unit.getColumn()] = new BoardBlock(unit.getType());
				this.blocks[unit.getRow()][unit.getColumn()].setBoatNumber(i);
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder("    ");

		for (int i = 0; i < this.blocks[0].length; i++) {
			out.append((char) ('A' + i)).append(" ");
		}

		out.append("\n");

		for (int i = 0; i < this.blocks.length; i++) {
			if (i + 1 < 10) {
				out.append(" ");
			}

			out.append(i + 1).append("|");

			for (int j = 0; j < this.blocks[i].length; j++) {
				out.append(this.blocks[i][j].toString());
			}

			out.append("\n");
		}

		return out.toString();
	}

	public boolean isPossibleToPlay() {
		int i = 0;

		while (i < this.boats.size()) {
			if (this.boats.get(i).isSank()) {
				this.boats.remove(i--);
				// If we encounter a boat that is sunk, we maintain the position to check the next boat
				// since the ArrayList "shifts left"
			}

			i++;
		}

		return !this.boats.isEmpty();
	}
}
