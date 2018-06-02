package fileprocessing.orders;


import java.io.File;
import java.util.Comparator;

/**
 * A class that implements an ordering strategy.
 */
public abstract class Order implements Comparator<File> {
	final int FIRST_SMALLER = -1;
	final int EQUAL = 0;
	final int FIRST_GREATER = 1;

}
