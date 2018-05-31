package fileprocessing;

import java.io.File;

public interface FilterStrategy {

	/**
	 * @param file
	 * @return
	 */
	public boolean passedFilter(File file);
}
