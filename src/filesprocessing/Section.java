package filesprocessing;

import filters.Filter;
import orders.Order;

import java.io.File;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * A section class that represents a section that contains filtering and ordering strategy.
 */
public class Section {

	private Filter filter;
	private Comparator<File> order;
	private ArrayList<Integer> warningsLines;

	/**
	 * @param filter        The filter object of this section.
	 * @param order         The order object of this section
	 * @param warningsLines An array that contains the lines in which warning occurred.
	 */
	public Section(Filter filter, Order order, ArrayList<Integer> warningsLines) {
		this.filter = filter;
		this.order = order;
		this.warningsLines = warningsLines;
	}

	/**
	 * @param files the files we want to filter and print.
	 */
	public void printAllFilteredFilesByOrder(ArrayList<File> files) {

		for (Integer line : warningsLines) {
			System.err.println("Warning in line " + line);
		}

		ArrayList<File> filteredFiles = new ArrayList<>();
		files.sort(getOrder());

		for (File file : files) {
			if (filter.passedFilter(file)) {
				filteredFiles.add(file);
			}
		}

		for (File file : filteredFiles) {
			System.out.println(file.getName());
		}
	}

	/**
	 * @return the order object of this section.
	 */
	public Comparator<File> getOrder() {
		return order;
	}


}
