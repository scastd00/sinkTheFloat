package sink;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private BoardBlock[][] blocks;
	private ArrayList<Boat> boats;
	private final int size;

	/**
	 * Creates a board with the specified table and boats.
	 *
	 * @param blocks blocks of the board.
	 * @param boats  boat list of the board.
	 */
	public Board(BoardBlock[][] blocks, List<Boat> boats) {
		this.setBlocks(blocks);
		this.setBoats(boats);
		this.size = blocks.length;
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
	}

	public BoardBlock[][] getBlocks() {
		return this.blocks;
	}

	public void setBlocks(BoardBlock[][] blocks) throws NullPointerException {
		if (blocks == null) {
			throw new NullPointerException("Null table");
		}

		this.blocks = blocks;
	}

	public List<Boat> getBoats() {
		return this.boats;
	}

	public void setBoats(List<Boat> boats) throws NullPointerException {
		if (boats == null) {
			throw new NullPointerException("Cannot set null list of boats");
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

	// Todo: colocar los barcos recorriendo y poniendo los bloques del tablero del tipo del barco
	private void setBoatsInBoard() {
		for (Boat boat : this.boats) {

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
			if (i < 10) {
				out.append(" ");
			}

			out.append(i).append("|");

			for (int j = 0; j < this.blocks[i].length; j++) {
				out.append(this.blocks[i][j].toString());
			}
			out.append("\n");
		}

		return out.toString();
	}
}
