package fileprocessing.orders;

import java.io.File;

/**
 * This class implements file ordering by absolute name from a to z.
 */
public class AbsOrder extends Order {

	private boolean isReversed;

	AbsOrder(boolean isReversed) {
		this.isReversed = isReversed;
	}


	@Override
	public int compare(File file1, File file2) {

		if (isReversed) {
			return file2.getName().compareTo(file1.getName());
		}
		return file1.getName().compareTo(file2.getName());
	}
}
