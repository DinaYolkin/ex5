package filters;

import java.io.File;

/**
 * This class implements a class that filters files if their size is greater than some value.
 */
public class GreaterThanFilter extends Filter {
	public String filterName = "greater_than";
	private boolean isNot;
	private double lowerBound;

	/**
	 * @param lowerThreshold The lower the
	 * @param isNot          indicates if the filter is negated.
	 */
	GreaterThanFilter(double lowerThreshold, boolean isNot) {
		this.lowerBound = lowerThreshold;
		this.isNot = isNot;
	}

	@Override
	public boolean passedFilter(File file) {
		double fileSize = ((double) file.length()) / BYTES_TO_K_BYTES;
		if (isNot) {
			return fileSize <= lowerBound;
		}
		return fileSize > lowerBound;
	}
	//TODO delete
	public String getName(){
		return this.filterName;
	}
}
