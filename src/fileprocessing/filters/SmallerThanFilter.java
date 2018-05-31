package fileprocessing.filters;

import java.io.File;

public class SmallerThanFilter implements FilterStrategy {

	private boolean isNot;
	private double lowerBound;

	SmallerThanFilter(long lowerThreshold, boolean isNot) {

		this.isNot = isNot;
		this.lowerBound = lowerThreshold;
	}

	@Override
	public boolean passedFilter(File file) {
		double fileSize = file.getTotalSpace();
		if (isNot) {
			return fileSize >= lowerBound;
		}
		return fileSize < lowerBound;
	}
}
