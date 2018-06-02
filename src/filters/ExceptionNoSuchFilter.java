package filters;

public class ExceptionNoSuchFilter extends FilterExceptions {

	private static final String MSG_NO_SUCH_FILTER_NAME = "ERROR: Exception no such Filter name";

	public ExceptionNoSuchFilter() {
		super(MSG_NO_SUCH_FILTER_NAME);

	}
}
