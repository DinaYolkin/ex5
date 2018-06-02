package orders;



public class OrderFactory {


    private static final String NAME_ABS = "abs";
    private static final String NAME_TYPE = "type";
    private static final String NAME_SIZE = "size";
    private static final int REVERSE_INDEX = 1;
    private String[] orderLineArray;

    public Order getOrder(String orderLine) throws OrderExceptions {
        orderLineArray = orderLine.split("#");
        boolean isReverse = checkIfReverse();
        switch (orderLine) {
            case NAME_ABS:
                return new AbsOrder(isReverse);
            case NAME_TYPE:
                return new TypeOrder(isReverse);
            case NAME_SIZE:
                return new SizeOrder(isReverse);
            default:
                throw new ExceptionNoSuchOrder();
        }

    }

    private boolean checkIfReverse() {
        return orderLineArray.length > 1 && orderLineArray[REVERSE_INDEX].equals("REVERSE");
    }
}
