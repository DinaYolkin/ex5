package filters;

import java.io.File;

/**
 * This class implements filtering of values in a specific range.
 */
public class BetweenFilter extends Filter {

	private boolean isNot;
	private double lowerBound;
	private double upperBound;

	BetweenFilter(double lowerThreshold, double upperThreshold, boolean isNot) {

		this.lowerBound = lowerThreshold;
		this.upperBound = upperThreshold;
		this.isNot = isNot;
	}


	@Override
	public boolean passedFilter(File file) {
		double fileSize = file.getTotalSpace() / BYTES_TO_K_BYTES;
		if (isNot) {
			return (fileSize < lowerBound && fileSize > upperBound);
		}
		return (fileSize >= lowerBound && fileSize <= upperBound);
	}
}

