package sink;

import org.jetbrains.annotations.Contract;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Keyboard {
	@Contract(value = " -> fail", pure = true)
	private Keyboard() {
		throw new UnsupportedOperationException("Utility class");
	}

	public static String read() throws SinkException {
		String line;

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			line = br.readLine();
		} catch (IOException e) {
			throw new SinkException("I/O error occurred");
		}

		return line;
	}
}
