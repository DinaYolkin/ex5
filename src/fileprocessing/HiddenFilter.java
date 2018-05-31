package fileprocessing;

import java.io.File;

public class HiddenFilter implements FilterStrategy {


    @Override
    public boolean passedFilter(File file) {
        return false;
    }
}
