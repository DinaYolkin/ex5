package fileprocessing.orders;

import java.io.File;

/**
 * A class that implements ordering by file type.
 */
public class TypeOrder extends Order {

	private boolean isReversed;
	private AbsOrder absOrderComparator;

	TypeOrder(boolean isReversed) {
		this.isReversed = isReversed;
		this.absOrderComparator = new AbsOrder(isReversed);
	}

	public int compare(File file1, File file2) {
		String file1Name = file1.getName();
		String file2Name = file2.getName();

		String[] parsedFile1Name = parseFileName(file1Name);
		String[] parsedFile2Name = parseFileName(file2Name);

		int comparison;

		if (isReversed) {
			comparison = parsedFile2Name[SUFFIX_INDEX].compareTo(parsedFile1Name[SUFFIX_INDEX]);
			if (comparison == EQUAL) {
				return absOrderComparator.compare(file1, file2);
			}
		}
		comparison = parsedFile1Name[SUFFIX_INDEX].compareTo(parsedFile2Name[SUFFIX_INDEX]);

		if (comparison == EQUAL) {
			return absOrderComparator.compare(file1, file2);
		}
		return comparison;
	}

}
