package filters;

import java.io.File;

/**
 * This is a filter object that filters files by size in a specific range.
 */
public class BetweenFilter extends Filter {

	public String filterName = "between";
	private boolean isNot;
	private double lowerBound;
	private double upperBound;

	/**
	 * Creates a filter object with given params.
	 *
	 * @param lowerThreshold The lower bound for the file size we want to filter.
	 * @param upperThreshold The upper bound for the file size we want to filter.
	 * @param isNot          indicates if the filter is negated.
	 */
	BetweenFilter(double lowerThreshold, double upperThreshold, boolean isNot) {

		this.lowerBound = lowerThreshold;
		this.upperBound = upperThreshold;
		this.isNot = isNot;
	}


	@Override
	public boolean passedFilter(File file) {
		double fileSize = ((double) file.length()) / BYTES_TO_K_BYTES;
		if (isNot) {
			return (fileSize < lowerBound && fileSize > upperBound);
		}
		return (fileSize >= lowerBound && fileSize <= upperBound);
	}
	//TODO delete
	public String getName(){
		return this.filterName;
	}
}

