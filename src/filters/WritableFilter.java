package fileprocessing.filters;

import java.io.File;

public class WritableFilter extends Filter {
	private boolean isNot;

	WritableFilter(boolean isNot) {
		this.isNot = isNot;
	}

	public boolean passedFilter(File file) {

		if (isNot) {
			return !file.canWrite();
		}
		return file.canWrite();
	}
}
