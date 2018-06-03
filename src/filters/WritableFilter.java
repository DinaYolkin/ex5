package filters;

import java.io.File;

public class WritableFilter extends Filter {
	// TODO: delete
	public String filterName = "writable";
	private boolean isNot;

	/**
	 * @param isNot indicates if the filter is negated.
	 */
	WritableFilter(boolean isNot) {
		this.isNot = isNot;
	}

	@Override
	public boolean passedFilter(File file) {

		if (isNot) {
			return !file.canWrite();
		}
		return file.canWrite();
	}

	//TODO delete
	public String getName() {
		return this.filterName;
	}
}
