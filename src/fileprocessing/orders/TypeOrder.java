package fileprocessing.orders;

import java.io.File;

/**
 * A class that implements ordering by file type.
 */
public class TypeOrder implements OrderStrategy {

	private boolean isReversed;

	TypeOrder(boolean isReversed) {
		this.isReversed = isReversed;
	}


	@Override
	public void orderFiles() {

	}
}
