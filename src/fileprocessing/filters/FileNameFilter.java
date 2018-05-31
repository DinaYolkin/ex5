package fileprocessing.filters;

import java.io.File;

/**
 * A
 */
public class FileNameFilter implements FilterStrategy {
	private String value;
	private boolean isNot;

	FileNameFilter(String value, boolean isNot) {
		this.isNot = isNot;
		this.value = value;
	}

	@Override
	public boolean passedFilter(File file) {
		String fileName = file.getName();
		if (isNot) {
			return !value.equals(fileName);
		}
		return value.equals(fileName);
	}
}
