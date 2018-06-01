package fileprocessing.filters;

import java.io.File;

/**
 * This class implements a class that filters files if their size is greater than some value.
 */
public class GreaterThanFilter implements FilterStrategy {

	private boolean isNot;
	private double lowerBound;


	GreaterThanFilter(double lowerThreshold, boolean isNot) {
		this.lowerBound = lowerThreshold;
		this.isNot = isNot;
	}

	@Override
	public boolean passedFilter(File file) {
		long fileSize = file.getTotalSpace() / BYTES_TO_K_BYTES;
		if (isNot) {
			return fileSize <= lowerBound;
		}
		return fileSize > lowerBound;
	}
}
