package filters;

import java.io.File;

/**
 * A class implements a filter that filter files that contains a specific value in their name.
 */
public class ContainsFilter extends Filter {

	public String filterName = "contains";
	private boolean isNot;
	private String value;

	/**
	 * @param value The value the file name has to contain to be filtered.
	 * @param isNot indicates if the filter is negated.
	 */
	ContainsFilter(String value, boolean isNot) {
		this.isNot = isNot;
		this.value = value;
	}

	@Override
	public boolean passedFilter(File file) {

		String fileName = file.getName();
		if (isNot) {
			return !fileName.contains(value);
		}
		return fileName.contains(value);
	}

	//TODO delete
	public String getName() {
		return this.filterName;
	}

}
