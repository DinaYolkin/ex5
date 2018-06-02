package filters;

import java.io.File;

public class SmallerThanFilter extends Filter {

	private boolean isNot;
	private double lowerBound;

	SmallerThanFilter(double lowerThreshold, boolean isNot) {

		this.isNot = isNot;
		this.lowerBound = lowerThreshold;
	}

	@Override
	public boolean passedFilter(File file) {
		double fileSize = file.getTotalSpace() / BYTES_TO_K_BYTES;
		if (isNot) {
			return fileSize >= lowerBound;
		}
		return fileSize < lowerBound;
	}
}
