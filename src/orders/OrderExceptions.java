package orders;

public class OrderExceptions extends Exception {

    private static final String MSG_ORDER_EXCEPTION = "order error exception";

    public OrderExceptions(){
        super(MSG_ORDER_EXCEPTION);
    }
    OrderExceptions(String msg_error){
        super(msg_error);
    }
}
