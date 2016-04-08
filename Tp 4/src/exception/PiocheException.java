package exception;

public class PiocheException extends RuntimeException {

	public PiocheException() {
	}

	public PiocheException(String message) {
		super(message);
	}
}