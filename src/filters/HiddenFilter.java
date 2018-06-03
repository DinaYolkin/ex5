package filters;

import java.io.File;

/**
 * a class that represents file filtering by it's visibility in the directory.
 */
public class HiddenFilter extends Filter {
	public String filterName = "hidden";
	private boolean isNot;

	/**
	 * @param isNot indicates if the filter is negated.
	 */
	HiddenFilter(boolean isNot) {
		this.isNot = isNot;
	}

	@Override
	public boolean passedFilter(File file) {
		if (isNot) {
			return !file.isHidden();
		}
		return file.isHidden();
	}
	//TODO delete
	public String getName(){
		return this.filterName;
	}
}
