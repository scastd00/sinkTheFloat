package sink;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Con threads para saber el tiempo de partida
public class SinkTime {
	private static final Logger logger = LogManager.getLogger(SinkTime.class);
	private int hour;
	private int minute;

	public SinkTime(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}
}
