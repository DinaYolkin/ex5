package fileprocessing;


import fileprocessing.filters.Filter;
import fileprocessing.orders.Order;

import java.io.File;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * A section class that represents a section that contains filtering and ordering strategy.
 */
public class Section {

	private Filter filter;
	private Comparator<File> order;

	public Section(Filter filter, Order order) {
		this.filter = filter;
		this.order = order;
	}

	public void printAllFilterdFilesByOrder(ArrayList<File> files) {


		// Todo: add here warning print.

		ArrayList<File> filteredFiles = new ArrayList<>();
		files.sort(getOrderSec());

		for (File file : files) {
			if (filter.passedFilter(file)) {
				filteredFiles.add(file);
			}
		}
	}

	public Filter getFilterSec() {
		return filter;
	}

	public Comparator<File> getOrderSec() {
		return order;
	}
}
