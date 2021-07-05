package sink;

import org.jetbrains.annotations.Contract;

public class Player {

	private String name;
	private Score score;
	private Board board;
	private Board attemptingBoard;

	public Player(String name, Score score, Board board) throws SinkException {
		this.setName(name);
		this.setScore(score);
		this.setBoard(board);
		this.attemptingBoard = new Board(board.getSize(), Constants.NOTHING);
	}

	@Contract(pure = true)
	public Player() {
		this.name = null;
		this.score = null;
		this.board = null;
		this.attemptingBoard = null;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) throws SinkException {
		if (name == null) {
			throw new SinkException("Cannot set a null name");
		}

		if (name.trim().length() == 0) {
			throw new SinkException("Name cannot be empty");
		}

		this.name = name;
	}

	public Score getScore() {
		return this.score;
	}

	public void setScore(Score score) throws SinkException {
		if (score == null) {
			throw new SinkException("Cannot set a null score");
		}

		this.score = score;
	}

	public Board getBoard() {
		return this.board;
	}

	public void setBoard(Board board) throws SinkException {
		if (board == null) {
			throw new SinkException("Cannot set a null board");
		}

		this.board = board;
		this.attemptingBoard = new Board(board.getSize(), Constants.NOTHING);
	}

	public Board getAttemptingBoard() {
		return this.attemptingBoard;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o instanceof Player) return this.toString().compareTo(o.toString()) == 0;

		return false;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode() + this.score.hashCode() + this.board.hashCode() + Constants.HASH_MAGIC;
	}

	public boolean isPossibleToPlay() {
		return this.board.isPossibleToPlay();
	}

	public String toLogString() {
		return this.name + "  " + this.score + "\n" + this.board.toLogString() + "\n\nAttempting board\n\n" +
				this.attemptingBoard.toLogString();
	}

	@Override
	public String toString() {
		return "Name: " + this.name + "  " + this.score.toString() + "\n\n" + this.board.toString() +
				"\n\n" + this.attemptingBoard.toString();
	}
}
