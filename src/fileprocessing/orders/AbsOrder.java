package fileprocessing.orders;

import java.io.File;

/**
 * This class implements file ordering by absolute name from a to z.
 */
public class AbsOrder implements OrderStrategy {
	private boolean isReversed;

	AbsOrder(boolean isReversed) {
		this.isReversed = isReversed;
	}

	@Override
	public void orderFiles() {

	}

}
