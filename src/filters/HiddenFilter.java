package filters;

import java.io.File;

/**
 * a class that represents file filtering by it's visibility in the directory.
 */
public class HiddenFilter extends Filter {
	public String filterName = "hidden";
	private boolean isHidden;

	/**
	 * @param isHidden indicates if the filter is negated.
	 */
	HiddenFilter(boolean isHidden) {
		this.isHidden = isHidden;
	}

	@Override
	public boolean passedFilter(File file) {
		if (isHidden) {
			return file.isHidden();
		}
		return !file.isHidden();
	}

	//TODO delete
	public String getName() {
		return this.filterName;
	}
}
