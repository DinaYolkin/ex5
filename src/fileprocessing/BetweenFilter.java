package fileprocessing;

import java.io.File;

public class BetweenFilter implements FilterStrategy {
    @Override
    public boolean isValidInput(String filterLine) {
        return false;
    }

    @Override
    public boolean passedFilter(File file) {
        return false;
    }
}
