package sink;

public class Score {
	private int points;
	private int sankBoats;

	public Score(int points, int sankBoats) {
		this.points = points;
		this.sankBoats = sankBoats;
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
