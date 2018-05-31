package fileprocessing;

import java.util.logging.Filter;

public class Section {
    FilterStrategy filterSec ;
    OrderStrategy OrderSec;

    public Section(FilterStrategy filter, OrderStrategy order){
        this.filterSec = filter;
        this.OrderSec = order;

    }
}
