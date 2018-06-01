package fileprocessing.orders;

import java.io.File;

/**
 * A class that implements ordering by size.
 */
public class SizeOrder implements OrderStrategy {
	private boolean isReversed;

	SizeOrder(boolean isReversed) {
		this.isReversed = isReversed;
	}

	@Override
	public void orderFiles() {
		
	}


}
