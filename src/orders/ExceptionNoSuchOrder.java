package orders;

public class ExceptionNoSuchOrder extends OrderExceptions {

	private static final String MSG_NO_SUCH_ORDER_EXCEPTION = "ERROR: no such order name: ";

	ExceptionNoSuchOrder(String orderName) {

		super(MSG_NO_SUCH_ORDER_EXCEPTION + orderName);
	}

}