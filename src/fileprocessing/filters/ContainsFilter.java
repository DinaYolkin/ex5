package fileprocessing.filters;

import java.io.File;

/**
 * A class implements a filter that filter files that contains a specific value in their name.
 */
public class ContainsFilter extends Filter {

	private boolean isNot;
	private String value;

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
}
