package fileprocessing;

import java.util.logging.Filter;

/**
 * A section class that represents a section that contains filtering and ordering strategy.
 */
public class Section {

	FilterStrategy filterSec;
	OrderStrategy OrderSec;

	public Section(FilterStrategy filter, OrderStrategy order) {
		this.filterSec = filter;
		this.OrderSec = order;

	}

	public FilterStrategy getFilterSec() {
		return filterSec;
	}

	public OrderStrategy getOrderSec() {
		return OrderSec;
	}
}
