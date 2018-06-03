package filesprocessing;

import java.io.File;


import java.util.ArrayList;
import java.util.Comparator;

/**
 * A section class that represents a section that contains filtering and ordering strategy.
 */
public class Section {

	private filters.Filter filter;
	private Comparator<File> order;
	private ArrayList<Integer> warningsLines;

	public Section(filters.Filter filter, orders.Order order, ArrayList<Integer> warningsLines) {
		this.filter = filter;
		this.order = order;
		this.warningsLines = warningsLines;
	}

	public void printAllFilteredFilesByOrder(ArrayList<File> files) {

		for (Integer line : warningsLines) {
			System.out.println("Warning in line " + line);
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

	public filters.Filter getFilterSec() {
		return filter;
	}

	public Comparator<File> getOrder() {
		return order;
	}


}
