package CustomExceptiopn;

public class EmployeeNotFoundException extends Exception {
	private String Message;

	public EmployeeNotFoundException(String message) {
		super();
		Message = message;
	}
	public String getMessage() {
		return Message;
	}

}
