package fileprocessing.filters;

import java.io.File;

/**
 * a class that represents file filtering by it's visibility in the directory.
 */
public class HiddenFilter implements FilterStrategy {
	private boolean isNot;

	HiddenFilter(boolean isNot) {
		this.isNot = isNot;
	}

	@Override
	public boolean passedFilter(File file) {
		if (isNot) {
			return !file.isHidden();
		}
		return file.isHidden();
	}
}
