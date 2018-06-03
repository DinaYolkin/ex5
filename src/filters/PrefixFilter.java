package filters;

import java.io.File;

import filesprocessing.FileNameProcessor;

public class PrefixFilter extends Filter {
	public String filterName = "prefix";
	private boolean isNot;
	private String value;

	/**
	 * @param filterValue The string value we want to filter accordingly
	 * @param isNot       indicates if the filter is negated.
	 */
	PrefixFilter(String filterValue, boolean isNot) {
		this.isNot = isNot;
		this.value = filterValue;
	}

	@Override
	public boolean passedFilter(File file) {
		String fileName = file.getName();
		String[] parsedFileName = FileNameProcessor.parseFileName(fileName);
		if (isNot) {
			return !parsedFileName[FILE_NAME_INDEX].startsWith(value);
		}
		return parsedFileName[FILE_NAME_INDEX].startsWith(value);
	}

	//TODO delete
	public String getName() {
		return this.filterName;
	}
}
