package filters;

import java.io.File;

/**
 * This class implement a filter that return all the files.
 */
public class AllFilter extends Filter {

	private boolean isNot;

	AllFilter(boolean isNot) {
		this.isNot = isNot;
	}

	@Override
	public boolean passedFilter(File file) {
		if (isNot) {
			return false;
		}
		return true;

	}
}
