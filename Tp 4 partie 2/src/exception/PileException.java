package exception;

public class PileException extends RuntimeException

{
	public PileException() {
	}

	public PileException(String message) {
		super(message);
	}
}