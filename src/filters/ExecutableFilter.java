package filters;

import java.io.File;

public class ExecutableFilter extends Filter {
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
