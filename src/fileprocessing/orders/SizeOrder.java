package fileprocessing.orders;

import java.io.File;

/**
 * A class that implements ordering by size.
 */
public class SizeOrder extends Order {
	private boolean isReversed;

	SizeOrder(boolean isReversed) {
		this.isReversed = isReversed;
	}


	@Override
	public int compare(File file1, File file2) {

		double fileSize1 = file1.getTotalSpace();
		double fileSize2 = file2.getTotalSpace();

		if (fileSize1 > fileSize2) {
			return FIRST_SMALLER;
		} else if (fileSize1 < fileSize2) {
			return FIRST_GREATER;
		} else {
			return EQUAL;
		}
	}
}
