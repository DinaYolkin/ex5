package filters;

public class ExceptionNoSuchFilter extends FilterExceptions {

	private static final String MSG_NO_SUCH_FILTER_NAME = "ERROR: Exception no such Filter name: ";

	ExceptionNoSuchFilter(String filterName) {
		super(MSG_NO_SUCH_FILTER_NAME + filterName);

	}
}