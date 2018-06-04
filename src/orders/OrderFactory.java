package orders;

public class OrderFactory {


    private static final String NAME_ABS = "abs";
    private static final String NAME_TYPE = "type";
    private static final String NAME_SIZE = "size";
    private static final int REVERSE_INDEX = 1;
    private static final int ORDER_NAME_INDEX = 0;
    private String[] orderLineArray;

    public Order getOrder(String orderLine) throws OrderExceptions {
        orderLineArray = orderLine.split("#");
        String orderName = orderLineArray[ORDER_NAME_INDEX];
        // check if there is REVERSE indication, if there something else return null (type 1 error)
        boolean isReverse = false;
		if(orderLineArray.length > 1){
			isReverse = checkIfReverse();
			if (!isReverse){
				return null;
			}
		}
        switch (orderName) {
            case NAME_ABS:
				return new AbsOrder(isReverse);
            case NAME_TYPE:
                return new TypeOrder(isReverse);
            case NAME_SIZE:
                return new SizeOrder(isReverse);
            default:
                throw new ExceptionNoSuchOrder(orderName);
        }

    }

    private boolean checkIfReverse() {
        return orderLineArray[REVERSE_INDEX].equals("REVERSE");
    }
}
