package filters;

import java.io.File;

/**
 * A class that
 */
public abstract class Filter {
	final int BYTES_TO_K_BYTES = 1024;
	private final String DOT_SPLIT = "\\.";
	final int FILE_NAME_INDEX = 0;
	final int SUFFIX_INDEX = 1;

	/**
	 * @param file A file that we'de like to test if passes filter's condition.
	 * @return true if the file passes the filter's condition.
	 */
	public abstract boolean passedFilter(File file);

	/**
	 * @param fileName the name of the file we want to parse.
	 * @return an array of string with 2 indexes, including the name of the file and
	 */
	protected String[] parseFileName(String fileName) {

		String[] parsedFileName = {"", ""};
		String[] splitFileName;

		if (fileName.lastIndexOf(DOT_SPLIT) == 0) {
			splitFileName = fileName.split(DOT_SPLIT);  // exclude dots.
			parsedFileName[FILE_NAME_INDEX] = "";
			parsedFileName[SUFFIX_INDEX] = splitFileName[0];
			return parsedFileName;
		}

		if (fileName.endsWith(DOT_SPLIT)) {
			splitFileName = fileName.split(DOT_SPLIT); // exclude dots.
			parsedFileName[FILE_NAME_INDEX] = splitFileName[0];
			parsedFileName[SUFFIX_INDEX] = "";
			return parsedFileName;
		}

		splitFileName = fileName.split(DOT_SPLIT);

		if (splitFileName.length == 2) {
			return splitFileName;
		}

		for (int i = 0; i < splitFileName.length; i++) {
			if (i == splitFileName.length - 1) {
				parsedFileName[SUFFIX_INDEX] = splitFileName[i];
				return parsedFileName;
			} else if (i == splitFileName.length - 2) {
				parsedFileName[FILE_NAME_INDEX] += splitFileName[i];
			} else {
				parsedFileName[FILE_NAME_INDEX] += splitFileName[i] + ".";
			}
		}
		System.out.println(parsedFileName[FILE_NAME_INDEX]);
		return splitFileName;
	}
}
