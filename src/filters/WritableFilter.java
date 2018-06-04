package filters;

import java.io.File;

public class WritableFilter extends Filter {
	// TODO: delete
	public String filterName = "writable";
	private boolean isWritable;

	/**
	 * @param isWritable indicates if the filter is negated.
	 */
	WritableFilter(boolean isWritable) {
		this.isWritable = isWritable;
	}

	@Override
	public boolean passedFilter(File file) {

		if (isWritable) {
			return file.canWrite();
		}
		return !file.canWrite();
	}

	//TODO delete
	public String getName() {
		return this.filterName;
	}
}
