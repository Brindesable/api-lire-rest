package LireApiRest;

public class Response {

	int status;
	String message;

	public Response(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return this.status;
	}

	public String getMessage() {
		return this.message;
	}
}