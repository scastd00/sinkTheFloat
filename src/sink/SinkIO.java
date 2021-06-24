package sink;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that manages the I/O of the game with files.
 */
public final class SinkIO {

	private static final Logger logger = LogManager.getLogger(SinkIO.class);

	private SinkIO() {
		throw new UnsupportedOperationException("Utility class");
	}

	public static Game createGameFromFile(@NotNull String filename) throws SinkException {
		return parseInput(new File(filename));
	}

	public static void writeGameToFile(@NotNull Game game, String filename) throws SinkException {
		File file = new File(filename);
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			writer.write(Integer.toString(game.getPlayers()[0].getBoard().getSize()));
			writer.newLine();
			writer.write(game.getPlayers()[0].getName());
			writer.newLine();
			writer.write(getBoatsFormatted(game.getPlayers()[0].getBoard().getBoats()));
			writer.newLine();
			writer.write(game.getPlayers()[1].getName());
			writer.newLine();
			writer.write(getBoatsFormatted(game.getPlayers()[1].getBoard().getBoats()));
		} catch (IOException e) {
			throw new SinkException("Could not write in the file correctly");
		}

	}

	public static Player createPlayer(int playerNumber, int boardSize) {
		logger.debug("Creating player {}", playerNumber);
		logger.trace("Introduce the name of the player {}", playerNumber);

		Player player = new Player();

		try {
			player.setName(Keyboard.read().trim());
			player.setScore(new Score());
			player.setBoard(createBoard(playerNumber, boardSize));
		} catch (SinkException e) {
			logger.warn(e.getMessage());
		}

		return player;
	}

	private static Board createBoard(int playerNumber, int boardSize) throws SinkException {
		logger.debug("Creating board for player {}", playerNumber);

		Board board = new Board(boardSize, Constants.WATER);
		board.setBoats(readBoats(playerNumber, boardSize));

		return board;
	}

	private static List<Boat> readBoats(int playerNumber, int boardSize) throws SinkException {
		logger.info("Player {} insert the coordinates and direction of the boats", playerNumber);
		logger.info("Structure of the input: Row: 1 - {}  Column: A - {}  Direction: {U D L R}",
			boardSize, (char) ('A' + boardSize - 1));

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
			if (!isValidBoat(boat, boardSize)) {
				throw new SinkException("An error occurred while creating boats");
			}
		}

		return boatList;
	}

	private static Boat parseBoat(String s, int boatSize, int type) {
		String[] tokens = s.toUpperCase().split(" ");
		int row = Integer.parseInt(tokens[0]) - 1;
		int column = tokens[1].charAt(0) - 'A';
		int[] dir = getDirectionVectorFromString(tokens[2]);

		return new Boat(type, row, column, boatSize, dir);
	}

	private static int[] getDirectionVectorFromString(String direction) {
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

	private static boolean isValidBoat(Boat boat, int boardSize) {
		int[] dir = boat.getDirection();
		int columnVector = dir[0] * boat.getSize() - 1;
		int rowVector = dir[1] * boat.getSize() - 1;

		return (boat.getRow() - rowVector) >= 0 &&
			(boat.getRow() - rowVector) <= boardSize &&
			(boat.getColumn() - columnVector) >= 0 &&
			(boat.getColumn() - columnVector) <= boardSize;
	}

	private static Game parseInput(File file) throws SinkException {
		Game game = new Game();

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
			int boardSize = Integer.parseInt(reader.readLine());
			Player[] players = new Player[2];

			for (int i = 0; i < 2; i++) {
				String name = reader.readLine(); // split \n  ??
				Board board = new Board(boardSize, Constants.WATER);
				List<Boat> boats = new ArrayList<>();
				boats.add(parseBoat(reader.readLine(), Constants.AIRCRAFT_CARRIER_SIZE, Constants.AIRCRAFT_CARRIER));

				for (int j = 0; j < 8; j++) {
					if (j < 3) {
						boats.add(parseBoat(reader.readLine(), Constants.SUBMARINE_SIZE, Constants.SUBMARINE));
					} else if (j < 6) {
						boats.add(parseBoat(reader.readLine(), Constants.DESTROYER_SIZE, Constants.DESTROYER));
					} else {
						boats.add(parseBoat(reader.readLine(), Constants.FRIGATE_SIZE, Constants.FRIGATE));
					}
				}

				board.setBoats(boats);
				players[i] = new Player(name, new Score(), board);
			}

			game.setPlayers(players);
		} catch (IOException e) {
			throw new SinkException("Error occurred while parsing the input file");
		}

		return game;
	}

	private static String getBoatsFormatted(List<Boat> boats) {
		StringBuilder out = new StringBuilder();

		for (Boat boat : boats) {
			out.append(boat.getRow() + 1).append(" ")
			   .append((char) (boat.getColumn() + 'A')).append(" ")
			   .append(boat.getDirectionStringFromVector(boat.getDirection()))
			   .append("\n");
		}

		out.replace(out.length() - 1, out.length(), ""); // Removing the last \n of the output String

		return out.toString();
	}
}
