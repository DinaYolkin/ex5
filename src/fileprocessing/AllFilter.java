package fileprocessing;

import java.io.File;

/**
 * This class implement
 */
public class AllFilter implements FilterStrategy{
	/**
	 *
	 * @param file
	 * @return
	 */

    @Override
    public boolean passedFilter(File file) {
        return false;
    }
}
