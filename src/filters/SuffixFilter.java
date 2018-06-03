package filters;

import java.io.File;

/**
 *
 */
public class SuffixFilter extends Filter {
	public String filterName = "suffix";
	private boolean isNot;
	private String suffix;

	/**
	 * @param filterSuffix The file suffix we want to filter by.
	 * @param isNot        indicates if the filter is negated.
	 */
	SuffixFilter(String filterSuffix, boolean isNot) {
		this.isNot = isNot;
		this.suffix = filterSuffix;
	}

	@Override
	public boolean passedFilter(File file) {
		String fileName = file.getName();
		if (isNot) {
			return !fileName.endsWith(suffix);
		}
		return fileName.endsWith(suffix);
	}

	//TODO delete
	public String getName() {
		return this.filterName;
	}
}
