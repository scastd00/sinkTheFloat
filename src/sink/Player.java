package sink;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Player {
	private static final Logger logger = LogManager.getLogger(Player.class);

	private String name;
	private Score score;
	private Board board;

	public Player(String name, Score score, Board board) throws SinkException {
		this.setName(name);
		this.setScore(score);
		this.setBoard(board);
	}

	public Player() {
		this.name = null;
		this.score = null;
		this.board = null;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) throws SinkException, NullPointerException {
		if (name == null) {
			throw new NullPointerException("Cannot set a null name");
		}

		if (name.trim().length() == 0) {
			throw new SinkException("Name cannot be empty");
		}

		this.name = name;
	}

	public Score getScore() {
		return this.score;
	}

	public void setScore(Score score) throws NullPointerException {
		if (score == null) {
			throw new NullPointerException("Cannot set a null score");
		}

		this.score = score;
	}

	public Board getBoard() {
		return this.board;
	}

	public void setBoard(Board board) throws NullPointerException {
		if (board == null) {
			throw new NullPointerException("Cannot set a null board");
		}

		this.board = board;
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

	@Override
	public String toString() {
		return "Name: " + this.name + " Score: " + this.score.toString() + "\n";
	}
}
