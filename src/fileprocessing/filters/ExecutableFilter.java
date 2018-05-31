package fileprocessing.filters;

import java.io.File;

public class ExecutableFilter implements FilterStrategy {
	private boolean isNot;

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
