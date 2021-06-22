package sink;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Game {
	private static final Logger logger = LogManager.getLogger(Game.class);
	private Player[] players;
	private Time time;

	public Game(Player[] players, Time time) {
		this.players = players;
		this.time = time;
	}

	public Game() {
		this.players = null;
		this.time = null;
	}

	public Player[] getPlayers() {
		return this.players;
	}

	public void setPlayers(Player[] players) throws NullPointerException {
		if (players == null) {
			throw new NullPointerException("Players cannot be null");
		}

		if (players[0] == null || players[1] == null) {
			throw new NullPointerException("Players cannot be null");
		}

		this.players = players;
	}

	public Time getTime() {
		return this.time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
}
