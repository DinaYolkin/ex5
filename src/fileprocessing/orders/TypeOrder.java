package fileprocessing.orders;

import java.io.File;

/**
 * A class that implements ordering by file type.
 */
public class TypeOrder extends Order {

	private boolean isReversed;

	TypeOrder(boolean isReversed) {
		this.isReversed = isReversed;
	}


	public int compare(File file1, File file2) {
		return 0;
	}

}
