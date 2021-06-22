package sink;

public class Player {
	private String name;
	private Score score;
	private Boat[] boats;

	public Player(String name, Score score, Boat[] boats) throws SinkException {
		if (name == null || score == null || boats == null) {
			throw new SinkException("Cannot set null parameters");
		}

		if (name.trim().length() == 0) {
			throw new SinkException("Name cannot be empty");
		}

		this.name = name.trim();
		this.score = score;
		this.boats = boats;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Score getScore() {
		return this.score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public Boat[] getBoats() {
		return this.boats;
	}

	public void setBoats(Boat[] boats) {
		this.boats = boats;
	}
}
