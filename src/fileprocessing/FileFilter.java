package fileprocessing;

import java.io.File;

public class FileFilter implements FilterStrategy{

    @Override
    public boolean passedFilter(File file) {
        return false;
    }
}
