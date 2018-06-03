package orders;


import java.io.File;
import java.util.Comparator;

/**
 * A class that implements an ordering strategy.
 */
public abstract class Order implements Comparator<File> {
	final int EQUAL = 0;
	final int BYTES_TO_K_BYTES = 1024;
	final int SUFFIX_INDEX = 1;

}
