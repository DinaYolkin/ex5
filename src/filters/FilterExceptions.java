package filters;

public class FilterExceptions extends Exception {

	private static final String MSG_FILTER_EXCEPTION = "ERROR: filter error exception";

	FilterExceptions() {
		super(MSG_FILTER_EXCEPTION);
	}

	FilterExceptions(String massage) {
		super(massage);
	}
}