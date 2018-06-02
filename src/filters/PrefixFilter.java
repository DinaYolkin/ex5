package fileprocessing.filters;

import java.io.File;

public class PrefixFilter extends Filter {

	private boolean isNot;
	private String value;

	PrefixFilter(String filterValue, boolean isNot) {
		this.isNot = isNot;
		this.value = filterValue;
	}

	@Override
	public boolean passedFilter(File file) {
		String fileName = file.getName();
		String[] parsedFileName = parseFileName(fileName);
		if (isNot) {
			return !parsedFileName[FILE_NAME_INDEX].startsWith(value);
		}
		return parsedFileName[FILE_NAME_INDEX].startsWith(value);
	}
}
