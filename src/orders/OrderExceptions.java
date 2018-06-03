package orders;

public class OrderExceptions extends Exception {

	private static final String MSG_ORDER_EXCEPTION = "ERROR: order error exception";

	OrderExceptions() {
		super(MSG_ORDER_EXCEPTION);
	}

	OrderExceptions(String msg_error) {
		super(msg_error);

	}
}