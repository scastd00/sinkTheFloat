package sink;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private BoardBlock[][] blocks;
	private ArrayList<Boat> boats;

	public Board(BoardBlock[][] blocks, List<Boat> boats) {
		this.setBlocks(blocks);
		this.setBoats(boats);
	}

	public Board() {
		this.blocks = new BoardBlock[12][12];

		for (int i = 0; i < this.blocks[0].length; i++) {
			for (int j = 0; j < this.blocks.length; j++) {
				this.blocks[i][j] = new BoardBlock();
			}
		}
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
	}

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
