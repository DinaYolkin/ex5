package fileprocessing.filters;

import java.io.File;

/**
 * A class
 */
public abstract class FilterStrategy {

	public final int BYTES_TO_K_BYTES = 1024;

	/**
	 * @param file A file that we'de like to test if passes filter's condition.
	 * @return true if the file passes the filter's condition.
	 */
	public abstract boolean passedFilter(File file);
}