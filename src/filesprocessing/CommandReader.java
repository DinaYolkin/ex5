package filesprocessing;

import filters.*;
import orders.*;


import java.io.*;
import java.util.ArrayList;


class CommandReader {

	private static final String ERROR_NO_FILTER_LINE = "ERROR: no FILTER line";
	private static final String ERROR_NO_ORDER_LINE = "ERROR: no ORDER line";
	private static final String NEXT_SECTION = "FILTER";
	private static final String DEFAULT_ORDER = "abs";
	private static final String DEFAULT_FILTER = "all";
	private static final String FILTER_INDICATOR = "FILTER";
	private static final String ORDER_INDICATOR = "ORDER";
	private static final String ERROR_IO_EXCEPTION = "ERROR: IOException";


	private String fileAddress;
	private FilterFactory filterFactory;
	private OrderFactory orderFactory;

	CommandReader(String addressFile) {

		fileAddress = addressFile;
		filterFactory = new FilterFactory();
		orderFactory = new OrderFactory();
	}

	ArrayList<Section> readFile() throws SectionException, FilterExceptions, OrderExceptions {

		ArrayList<Section> sectionList = new ArrayList<>();

		try {

			BufferedReader readFile = new BufferedReader(new FileReader(this.fileAddress));
			int numLine = 1;
			boolean isOrderLine = true;

			String line = readFile.readLine();

			while (line != null) {

				ArrayList<Integer> warningsLines = new ArrayList<>();

				// filter handling
				if (isOrderLine && !line.equals(FILTER_INDICATOR)) {
					throw new SectionException(ERROR_NO_FILTER_LINE);
				}

				line = readFile.readLine();
				numLine++;

				// set back the isOrderLine to true.
				isOrderLine = true;

				Filter filter;
				try {
					filter = filterFactory.getFilter(line);
				} catch (FilterExceptions e) {
					// catch type 1 exceptions
					warningsLines.add(numLine);
					filter = filterFactory.getFilter(DEFAULT_FILTER);
				}
				line = readFile.readLine();
				numLine++;

				// order handling

				if (line == null || !line.equals(ORDER_INDICATOR)) {
					throw new SectionException(ERROR_NO_ORDER_LINE);
				}
				line = readFile.readLine();
				numLine++;

				Order order;
				if (line == null) {
					order = orderFactory.getOrder(DEFAULT_ORDER);

				} else if (line.equals(NEXT_SECTION)) {
					order = orderFactory.getOrder(DEFAULT_ORDER);
					isOrderLine = false;

				} else {
					try {
						order = orderFactory.getOrder(line);
					} catch (OrderExceptions e) {
						warningsLines.add(numLine);
						order = orderFactory.getOrder(DEFAULT_ORDER);
					}
				}

				Section section = new Section(filter, order, warningsLines);
				if (isOrderLine) {
					line = readFile.readLine();
					numLine++;
				}
				sectionList.add(section);
			}
		} catch (IOException e) {
			throw new SectionException(ERROR_IO_EXCEPTION);
		}

		return sectionList;
	}
}
