package filters;

import java.io.File;

/**
 * A class that
 */
public abstract class Filter {
	final int BYTES_TO_K_BYTES = 1024;
	final int FILE_NAME_INDEX = 0;


	/**
	 * @param file A file that we'de like to test if passes filter's condition.
	 * @return true if the file passes the filter's condition.
	 */
	public abstract boolean passedFilter(File file);


	//TODO delete
	public abstract String getName();
}
