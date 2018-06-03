package filters;

public class ExceptionNoFilterLine extends FilterExceptions {

    private static final String MSG_NO_FILTER_LINE = "ERROR: there is no filterLine";

    ExceptionNoFilterLine(){
        super(MSG_NO_FILTER_LINE);
    }
}
