package filters;

import java.io.File;

import filesprocessing.FileNameProcessor;

/**
 * A class that filters the
 */
public class FileNameFilter extends Filter {
	public String filterName = "file";
	private String filterValue;
	private boolean isNot;

	/**
	 * @param value The string we want to filter by.
	 * @param isNot indicates if the filter is negated.
	 */
	FileNameFilter(String value, boolean isNot) {
		this.isNot = isNot;
		this.filterValue = value;
	}

	@Override
	public boolean passedFilter(File file) {
		String fileName = file.getName();
		if (isNot) {
			return !filterValue.equals(fileName);
		}
		return filterValue.equals(fileName);
	}

	//TODO delete
	public String getName() {
		return this.filterName;
	}
}
