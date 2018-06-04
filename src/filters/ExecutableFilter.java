package filters;

import java.io.File;

/**
 * A class
 */
public class ExecutableFilter extends Filter {
	public String filterName = "executable";
	private boolean isExe;

	/**
	 * Creates a class that
	 *
	 * @param isExe indicates if the filter is negated.
	 */
	ExecutableFilter(boolean isExe) {
		this.isExe = isExe;
	}

	@Override
	public boolean passedFilter(File file) {
		if (isExe) {
			return file.canExecute();
		}
		return !file.canExecute();
	}
	//TODO delete
	public String getName(){
		return this.filterName;
	}
}
