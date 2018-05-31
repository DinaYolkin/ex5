package fileprocessing;

import java.io.File;

public class SizeOrder implements FilterStrategy {


    @Override
    public boolean passedFilter(File file) {
        return false;
    }
}
