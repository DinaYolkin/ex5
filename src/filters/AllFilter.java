package filters;

import java.io.File;

/**
 * This class implement a filter that return all the files in a directory.
 */
public class AllFilter extends Filter {

	private boolean isNot;

	/** Creates an instance of the filter with the given params.
	 * @param isNot indicates if the filter is negated.
	 */
	AllFilter(boolean isNot)
	{
		this.isNot = isNot;
	}

	@Override
	public boolean passedFilter(File file) {
		return !isNot;

	}
}
