package sink;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TextUI {
	private static final Logger logger = LogManager.getLogger(TextUI.class);
	private Game game;

	public TextUI(Game game) {
		this.game = game;
	}

	public TextUI(int boardSize) {
		this.game = new Game(
			new Player[] {this.createPlayer(1, boardSize), this.createPlayer(2, boardSize)},
			new SinkTime(0, 0)
		);
	}

	public Game getGame() {
		return this.game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Player createPlayer(int playerNumber, int boardSize) {
		logger.debug("Creating player {}", playerNumber);
		logger.trace("Introduce the name of the player {}", playerNumber);

		Player player = new Player();

		try {
			player.setName(Keyboard.read().trim());
			player.setScore(createScore(playerNumber));
			player.setBoard(createBoard(playerNumber, boardSize));
		} catch (SinkException | NullPointerException e) {
			logger.warn(e.getMessage());
		}

		return player;
	}

	public Score createScore(int playerNumber) {
		logger.debug("Creating initial score for player {}", playerNumber);

		return new Score();
	}

	public Board createBoard(int playerNumber, int boardSize) throws SinkException {
		logger.debug("Creating board for player {}", playerNumber);

		Board board = new Board(boardSize, Constants.WATER);
		board.setBoats(createBoats(playerNumber, boardSize));

		return board;
	}

	public List<Boat> createBoats(int playerNumber, int boardSize) throws SinkException {
		logger.info("Player {} insert the coordinates and direction of the boats", playerNumber);

		List<Boat> boatList = new ArrayList<>(10);

		logger.info("Player {} insert the head coordinates and direction of the aircraft carrier", playerNumber);
		boatList.add(parseBoat(Keyboard.read().trim(), Constants.AIRCRAFT_CARRIER_SIZE, Constants.AIRCRAFT_CARRIER));

		logger.info("Player {} insert the head coordinates and direction of the 3 submarines", playerNumber);
		for (int i = 0; i < 3; i++) {
			boatList.add(parseBoat(Keyboard.read().trim(), Constants.SUBMARINE_SIZE, Constants.SUBMARINE));
		}

		logger.info("Player {} insert the head coordinates and direction of the 3 destroyers", playerNumber);
		for (int i = 0; i < 3; i++) {
			boatList.add(parseBoat(Keyboard.read().trim(), Constants.DESTROYER_SIZE, Constants.DESTROYER));
		}

		logger.info("Player {} insert the head coordinates and direction of the 2 frigates", playerNumber);
		for (int i = 0; i < 2; i++) {
			boatList.add(parseBoat(Keyboard.read().trim(), Constants.FRIGATE_SIZE, Constants.FRIGATE));
		}

		for (Boat boat : boatList) {
			if (isValidBoat(boat, boardSize)) {
				throw new SinkException("An error occurred while creating boats");
			}
		}

		return boatList;
	}

	private Boat parseBoat(String s, int boatSize, int type) {
		String[] tokens = s.toLowerCase().split(" ");
		int row = Integer.parseInt(tokens[0]);
		int column = Integer.parseInt(tokens[1]);
		int[] dir = this.getDirectionVectorFromString(tokens[2]);

		return new Boat(type, row, column, boatSize, dir);
	}

	public int[] getDirectionVectorFromString(String direction) {
		switch (direction) {
			case "U":
				return Constants.DIR_UP;
			case "D":
				return Constants.DIR_DOWN;
			case "R":
				return Constants.DIR_RIGHT;
			case "L":
				return Constants.DIR_LEFT;
			default:
				return new int[0];
		}
	}

	private boolean isValidBoat(Boat boat, int boardSize) {
		int[] dir = boat.getDirection();
		int columnVector = dir[0] * -boat.getSize();
		int rowVector = dir[1] * -boat.getSize();

		return (boat.getRow() - rowVector) >= 0 &&
			(boat.getRow() - rowVector) <= boardSize &&
			(boat.getColumn() - columnVector) >= 0 &&
			(boat.getColumn() - columnVector) <= boardSize;
	}

	public String printBoard() {
		return "";
//		return this.game.getPlayers()[0].toString() + "\n\n\n" + this.game.getPlayers()[1].toString();
	}

	public void start() {
		logger.info(this.game);
	}
}
