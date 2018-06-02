package filters;

public class FilterExceptions extends Exception {

    private static final String MSG_FILTER_EXCEPTION = "ERROR: filter error exception";

    public FilterExceptions(){
        System.err.println(MSG_FILTER_EXCEPTION);
        System.exit(0);
    }

    FilterExceptions (String massage){
        System.err.println(massage);
        System.exit(0);
    }
}
