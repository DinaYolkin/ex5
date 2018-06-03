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
		String[] parsedFileName = FileNameProcessor.parseFileName(fileName);
		if (isNot) {
			return !filterValue.equals(parsedFileName[FILE_NAME_INDEX]);
		}
		return filterValue.equals(parsedFileName[FILE_NAME_INDEX]);
	}
	//TODO delete
	public String getName(){
		return this.filterName;
	}
}
