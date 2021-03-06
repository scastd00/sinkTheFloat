package sink;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Contract;

public class Game {
	private static final Logger logger = LogManager.getLogger(Game.class);
	private Player[] players;
	private SinkTime sinkTime;

	public Game(Player[] players, SinkTime sinkTime) throws SinkException {
		this.setPlayers(players);
		this.setTime(sinkTime);
	}

	@Contract(pure = true)
	public Game() {
		this.players = null;
		this.sinkTime = null;
	}

	public Player[] getPlayers() {
		return this.players;
	}

	public void setPlayers(Player[] players) throws SinkException {
		if (players == null) {
			throw new SinkException("Players cannot be null");
		}

		if (players[0] == null || players[1] == null) {
			throw new SinkException("Players cannot be null");
		}

		this.players = players;
		Constants.setBoardSize(this.players[0].getBoard().getSize());
	}

	public SinkTime getTime() {
		return this.sinkTime;
	}

	public void setTime(SinkTime sinkTime) {
		this.sinkTime = sinkTime;
	}

	public void shoot(int player, int row, int column) throws SinkException {
		if (outOfBoundsPosition(row) || outOfBoundsPosition(column)) {
			throw new SinkException("Position shot out of bounds");
		}

		// Take the other player's board to see if there is a boat or not
		Board opponentBoard = this.players[(player + 1) % 2].getBoard();
		BoardBlock opponentBlock = opponentBoard.getBlock(row, column);

		Board playerAttemptingBoard = this.players[player].getAttemptingBoard();

		if (opponentBlock.getType() == Constants.WATER) {
			playerAttemptingBoard.getBlock(row, column).water();
			this.players[player].getScore().reset();
		} else {
			playerAttemptingBoard.getBlock(row, column).hit();
			opponentBoard.hitBlock(row, column);
			this.players[player].getScore().increment(Constants.DEFAULT_SCORE);
		}
	}

	public boolean isPossibleToPlay() {
		return this.players[0].isPossibleToPlay() && this.players[1].isPossibleToPlay();
	}

	@Contract(pure = true)
	private boolean outOfBoundsPosition(int value) {
		return value < 0 || value > Constants.getBoardSize();
	}

	public String toLogString() {
		return this.players[0].toLogString() + "\n\n" + this.players[1].toLogString();
	}

	@Override
	public String toString() {
		return this.players[0].toString() + "\n\n\n" + this.players[1].toString();
	}
}
