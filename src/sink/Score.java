package sink;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Score {
	private static final Logger logger = LogManager.getLogger(Score.class);
	private int points;
	private int sankBoats;

	public Score(int points, int sankBoats) {
		this.points = points;
		this.sankBoats = sankBoats;
	}

	public Score() {
		this.points = 0;
		this.sankBoats = 0;
	}

	public int getPoints() {
		return this.points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getSankBoats() {
		return this.sankBoats;
	}

	public void setSankBoats(int sankBoats) {
		this.sankBoats = sankBoats;
	}
}
