package sink;

import org.jetbrains.annotations.Contract;

public class Score {
	private int points;
	private int sankBoats;
	private float multiplier;
	private int streak;

	@Contract(pure = true)
	public Score(int points, int sankBoats) {
		this.points = points;
		this.sankBoats = sankBoats;
		this.multiplier = 1;
		this.streak = 0;
	}

	@Contract(pure = true)
	public Score() {
		this.points = 0;
		this.sankBoats = 0;
		this.multiplier = 1;
		this.streak = 0;
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

	public float getMultiplier() {
		return this.multiplier;
	}

	public void setMultiplier(float multiplier) {
		this.multiplier = multiplier;
	}

	public int getStreak() {
		return this.streak;
	}

	public void setStreak(int streak) {
		this.streak = streak;
	}

	public void increment(int score) {
		this.points += score * this.multiplier;
		this.streak++;
		this.multiplier += 1.25;
	}

	public void reset() {
		this.streak = 0;
		this.multiplier = 1;
	}

	@Override
	public String toString() {
		return "|  Score: " + this.points +
				" points  |  Multiplier: x" + this.multiplier +
				"  |  Streak: " + this.streak + "  |";
	}
}
