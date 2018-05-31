package fileprocessing.filters;

import java.io.File;

/**
 *
 */
public class SuffixFilter implements FilterStrategy {
	private boolean isNot;
	private String suffix;

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
