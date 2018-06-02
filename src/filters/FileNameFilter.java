package fileprocessing.filters;

import java.io.File;

/**
 * A
 */
public class FileNameFilter extends Filter {
	private String filterValue;
	private boolean isNot;

	FileNameFilter(String value, boolean isNot) {
		this.isNot = isNot;
		this.filterValue = value;
	}

	@Override
	public boolean passedFilter(File file) {
		String fileName = file.getName();
		String[] parsedFileName = parseFileName(fileName);
		if (isNot) {
			return !filterValue.equals(parsedFileName[FILE_NAME_INDEX]);
		}
		return filterValue.equals(parsedFileName[FILE_NAME_INDEX]);
	}
}
