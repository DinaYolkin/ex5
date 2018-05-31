package fileprocessing;

import java.io.File;

public class SmallerThanFilter implements FilterStrategy{


    @Override
    public boolean passedFilter(File file) {
        return false;
    }
}
