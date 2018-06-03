package filters;

import java.io.File;

/**
 *
 */
public class SuffixFilter extends Filter {
	private boolean isNot;
	private String suffix;

	/**
	 *
	 * @param newSuffix
	 * @param isNot indicates if the filter is negated.
	 */
	SuffixFilter(String newSuffix, boolean isNot) {
		this.isNot = isNot;
		this.suffix = newSuffix;
	}

	@Override
	public boolean passedFilter(File file) {
		String fileName = file.getName();
		if (isNot) {
			return !fileName.endsWith(suffix);
		}
		return fileName.endsWith(suffix);
	}
}
