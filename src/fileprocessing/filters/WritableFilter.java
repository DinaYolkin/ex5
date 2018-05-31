package fileprocessing.filters;

import java.io.File;

public class WritableFilter implements FilterStrategy {
	private boolean isNot;

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
}
