package sink;

import org.jetbrains.annotations.Contract;

import java.util.HashMap;
import java.util.Map;

public final class Constants {
	@Contract(value = " -> fail", pure = true)
	private Constants() {
		throw new UnsupportedOperationException("Constants class");
	}

	public static final int HASH_MAGIC = 0xb89f12;
	public static final int DEFAULT_SCORE = 100;

	public static final int NOTHING = -1;
	public static final int WATER = 0;
	public static final int HIT = 1;

	public static final int AIRCRAFT_CARRIER = 2;
	public static final int AIRCRAFT_CARRIER_SIZE = 4;
	public static final int SUBMARINE = 3;
	public static final int SUBMARINE_SIZE = 3;
	public static final int DESTROYER = 4;
	public static final int DESTROYER_SIZE = 2;
	public static final int FRIGATE = 5;
	public static final int FRIGATE_SIZE = 1;
	public static final int NO_BOAT = 6;

	private static int boardSize;


	@Contract(pure = true)
	public static int getBoardSize() {
		return boardSize;
	}

	public static void setBoardSize(int boardSize) {
		Constants.boardSize = boardSize;
	}

	@Contract(pure = true)
	public static boolean badBoatType(int type) {
		return type < Constants.AIRCRAFT_CARRIER || type > Constants.NO_BOAT;
	}

	public static final int MAX_SIZE = 20;
	public static final int MIN_SIZE = 4;

	public static final String BLUE = "\u001B[44m";
	public static final String RED = "\u001B[41m";
	public static final String RESET = "\u001B[0m";

	public static final String AIRCRAFT_CARRIER_COLOR = "\u001B[42m\u001B[30m";
	public static final String SUBMARINE_COLOR = "\u001B[43m\u001B[30m";
	public static final String DESTROYER_COLOR = "\u001B[45m\u001B[30m";
	public static final String FRIGATE_COLOR = "\u001B[47m\u001B[30m";

	/**
	 * Direction that each boat follows  {column, row}
	 */
	protected static final int[] NO_DIR = {0, 0};
	protected static final int[] DIR_UP = {0, -1}; // To negative coordinates
	protected static final int[] DIR_DOWN = {0, 1}; // Array increments
	protected static final int[] DIR_RIGHT = {1, 0};
	protected static final int[] DIR_LEFT = {-1, 0};

	protected static final Map<String, int[]> DIRECTIONS = new HashMap<>();

	static {
		DIRECTIONS.put("U", DIR_UP);
		DIRECTIONS.put("D", DIR_DOWN);
		DIRECTIONS.put("R", DIR_RIGHT);
		DIRECTIONS.put("L", DIR_LEFT);
	}
}
