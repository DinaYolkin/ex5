package fileprocessing;

import java.io.File;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * A section class that represents a section that contains filtering and ordering strategy.
 */
public class Section {

	private fileprocessing.filters.Filter filter;
	private Comparator<File> order;

	public Section(fileprocessing.filters.Filter filter, fileprocessing.orders.Order order) {
		this.filter = filter;
		this.order = order;
	}

	public void printAllFilterdFilesByOrder(ArrayList<File> files) {


		// Todo: add here warning print.

		ArrayList<File> filteredFiles = new ArrayList<>();
		files.sort(getOrder());

		for (File file : files) {
			if (filter.passedFilter(file)) {
				filteredFiles.add(file);
			}
		}
	}

	public fileprocessing.filters.Filter getFilterSec() {
		return filter;
	}

	public Comparator<File> getOrder() {
		return order;
	}



}
