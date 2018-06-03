package orders;

import java.io.File;

/**
 * A class that implements ordering by size.
 */
public class SizeOrder extends Order {
	private boolean isReversed;
	private AbsOrder absOrderComparator;

	SizeOrder(boolean isReversed) {
		this.isReversed = isReversed;
		this.absOrderComparator = new AbsOrder(isReversed);
	}


	@Override
	public int compare(File file1, File file2) {

		double fileSize1 = ((double) file1.length()) / BYTES_TO_K_BYTES;
		double fileSize2 = ((double) file2.length()) / BYTES_TO_K_BYTES;
		int comparison;

		if (isReversed) {
			comparison = Double.compare(fileSize2, fileSize1);
			if (comparison == EQUAL) {
				return this.absOrderComparator.compare(file1, file2); // pay attention to this line when
				// debugging. maybe should change the order of the files in args line.
			}

		} else {
			comparison = Double.compare(fileSize1, fileSize2);
			if (comparison == EQUAL) {
				return this.absOrderComparator.compare(file1, file2);
			}
		}
		return comparison;
	}
}
