package sink;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public final class Keyboard {
	private Keyboard() {
		throw new UnsupportedOperationException("Utility class");
	}

	public static String getInput() throws SinkException {
		String line;

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			line = br.readLine();
		} catch (IOException e) {
			throw new SinkException("I/O error occurred");
		}

		return line;
	}
}
