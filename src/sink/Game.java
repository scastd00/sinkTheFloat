package sink;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Game {
	private static final Logger logger = LogManager.getLogger(Game.class);
	private Player[] players;
	private SinkTime sinkTime;

	public Game(Player[] players, SinkTime sinkTime) {
		this.players = players;
		this.sinkTime = sinkTime;
	}

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
	}

	public SinkTime getTime() {
		return this.sinkTime;
	}

	public void setTime(SinkTime sinkTime) {
		this.sinkTime = sinkTime;
	}

	@Override
	public String toString() {
		return this.players[0].toString() + "\n\n\n\n\n" + this.players[1].toString();
	}
}
