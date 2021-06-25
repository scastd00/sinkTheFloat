package sink;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;

public class SinkTime {
	private static final Logger logger = LogManager.getLogger(SinkTime.class);
	private final int hour;
	private final int minute;
	private final int second;
	private final int millisecond;

	public SinkTime(int hour, int minute, int second, int millisecond) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		this.millisecond = millisecond;
	}

	public SinkTime() {
		this(Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE),
			Calendar.getInstance().get(Calendar.SECOND), Calendar.getInstance().get(Calendar.MILLISECOND));
	}

	@Override
	public String toString() {
		return String.format("%02d:%02d:%02d:%03d", this.hour, this.minute, this.second, this.millisecond);
	}
}
