package filters;

import java.io.File;

import filesprocessing.FileNameProcessor;

public class PrefixFilter extends Filter {
	public String filterName = "prefix";
	private boolean isNot;
	private String filterVal;

	/**
	 * @param filterValue The string filterVal we want to filter accordingly
	 * @param isNot       indicates if the filter is negated.
	 */
	PrefixFilter(String filterValue, boolean isNot) {
		this.isNot = isNot;
		this.filterVal = filterValue;
	}

	@Override
	public boolean passedFilter(File file) {

		String fileName = file.getName();

		String[] parsedFileName = FileNameProcessor.parseFileName(fileName);

		if (isNot) {
			return !parsedFileName[FILE_NAME_INDEX].startsWith(filterVal);
		}
		return parsedFileName[FILE_NAME_INDEX].startsWith(filterVal);
	}

	//TODO delete
	public String getName() {
		return this.filterName;
	}
}
