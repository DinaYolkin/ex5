package orders;

public class ExceptionNoSuchOrder extends OrderExceptions {

    private static final String MSG_NO_SUCH_ORDER_EXCEPTION = "ERROR: filter error exception";

    public ExceptionNoSuchOrder(){
        super(MSG_NO_SUCH_ORDER_EXCEPTION);
    }

}
