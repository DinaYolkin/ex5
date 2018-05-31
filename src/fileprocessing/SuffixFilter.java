package fileprocessing;

import java.io.File;

public class SuffixFilter implements FilterStrategy{


    @Override
    public boolean passedFilter(File file) {
        return false;
    }
}
