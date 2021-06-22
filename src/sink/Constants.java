package sink;

public final class Constants {
	private Constants() {
		throw new UnsupportedOperationException("Constants class");
	}

	public static final int HASH_MAGIC = 0xb89f12;

	public static final int NOTHING = -1;
	public static final int WATER = 0;
	public static final int HIT = 1;

	public static final int AIRCRAFT_CARRIER = 2;
	public static final int SUBMARINE = 3;
	public static final int DESTROYER = 4;
	public static final int FRIGATE = 5;
	public static final int NO_BOAT = 6;

	public static final int MAX_SIZE = 20;
	public static final int MIN_SIZE = 4;

	public static final String BLUE = "\u001B[44m";
	public static final String RED = "\u001B[41m";
	public static final String RESET = "\u001B[0m";

	public static final String AIRCRAFT_CARRIER_COLOR = "\u001B[42m";
	public static final String SUBMARINE_COLOR = "\u001B[43m";
	public static final String DESTROYER_COLOR = "\u001B[45m";
	public static final String FRIGATE_COLOR = "\u001B[47m";
}
