package CustomExceptiopn;

public class InvaliedChoiseException extends Exception{
	private String Message;

	public InvaliedChoiseException(String message) {
		super();
		Message = message;
	}
	public String getMessage() {
		return Message;
	}

}
