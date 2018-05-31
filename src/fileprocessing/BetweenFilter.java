package fileprocessing;

import java.io.File;

/**
 * This class implements filtering of values in a specific range.
 */
public class BetweenFilter implements FilterStrategy {

	private long lowerBound;
	private long upperBound;

	BetweenFilter(long lowerThreshold, long upperThreshold) {
		this.lowerBound = lowerThreshold;
		this.upperBound = upperThreshold;

	}


	@Override
	public boolean passedFilter(File file) {
		long fileSize = file.getTotalSpace();
		return (fileSize > lowerBound && fileSize < upperBound);
	}
}

