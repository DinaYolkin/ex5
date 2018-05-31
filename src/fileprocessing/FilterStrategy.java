package fileprocessing;

import java.io.File;

public interface FilterStrategy {
    // if the command line valid to filter
    public boolean isValidInput(String filterLine);
    // if the file is according to the filter condition
    public boolean passedFilter(File file);
}
