package filters;

import java.io.File;

public class SmallerThanFilter extends Filter {
	public String filterName = "smaller_than";
	private boolean isNot;
	private double lowerBound;

	/**
	 * @param lowerThreshold the lower threshold the file size is filtered by.
	 * @param isNot          indicates if the filter is negated.
	 */
	SmallerThanFilter(double lowerThreshold, boolean isNot) {

		this.isNot = isNot;
		this.lowerBound = lowerThreshold;
	}

	@Override
	public boolean passedFilter(File file) {
		double fileSize = ((double) file.length()) / BYTES_TO_K_BYTES;
		if (isNot) {
			return fileSize >= lowerBound;
		}
		return fileSize < lowerBound;
	}

	//TODO delete
	public String getName() {
		return this.filterName;
	}
}
