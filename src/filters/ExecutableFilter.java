package filters;

import java.io.File;

/**
 * A class
 */
public class ExecutableFilter extends Filter {
	private boolean isNot;

	/** Creates a class that
	 * @param isNot indicates if the filter is negated.
	 */
	ExecutableFilter(boolean isNot) {
		this.isNot = isNot;
	}

	@Override
	public boolean passedFilter(File file) {
		if (isNot) {
			return !file.canExecute();
		}
		return file.canExecute();
	}
}
