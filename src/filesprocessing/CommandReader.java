package filesprocessing;

import filters.*;
import orders.*;


import java.io.*;
import java.util.ArrayList;


public class CommandReader {

	private static final String ERROR_NO_FILTER_LINE = "ERROR: no FILTER line";
	private static final String ERROR_NO_ORDER_LINE = "ERROR: no ORDER line";
	private static final String NEXT_SECTION = "FILTER";
	private static final String DEFAULT_ORDER = "abs";
	private static final String DEFAULT_FILTER = "all";
	private static final String FILTER_INDICATOR = "FILTER";
	private BufferedReader readFile;
	private String fileAddress;
	private FilterFactory filterFactory;
	private OrderFactory orderFactory;

	public CommandReader(String addressFile) {

		this.fileAddress = addressFile;
		filterFactory = new FilterFactory();
		orderFactory = new OrderFactory();
	}

	public ArrayList<Section> readFile() throws SectionException, FilterExceptions, OrderExceptions {

		ArrayList<Section> sectionList = new ArrayList<>();
		try {
			readFile = new BufferedReader(new FileReader(this.fileAddress));
			int numLine = 1;
			boolean isOrderLine = true;
			String line = readFile.readLine();
			while (line != null) {
				Section section;
				ArrayList<Integer> warningsLines = new ArrayList<>();
				// filter handling
				if (isOrderLine && !line.equals(FILTER_INDICATOR)) {
					//TODO if this is the way?
					throw new SectionException(ERROR_NO_FILTER_LINE);
				}
				line = readFile.readLine();
				numLine++;
				// set back the isOrderLine to true
				isOrderLine = true;

				Filter filter;
				try {
					filter = filterFactory.getFilter(line);
				} catch (ExceptionNoSuchFilter e) {
					// catch type 1 exceptions
					filter = null;
				}
				// if filter is null means we have type 1 error
				if (filter == null) {
					warningsLines.add(numLine);
					filter = filterFactory.getFilter(DEFAULT_FILTER);
				}

				line = readFile.readLine();
				numLine++;


				// order handling

				if (!line.equals("ORDER")) {
					//TODO if this is the way?
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
					} catch (ExceptionNoSuchOrder e) {
						order = null;
					}
				}

				if (order == null) {
					warningsLines.add(numLine);
					order = orderFactory.getOrder(DEFAULT_ORDER);
				}
				section = new Section(filter, order, warningsLines);
				if (isOrderLine) {
					line = readFile.readLine();
					numLine++;
				}
				sectionList.add(section);

			}
		} catch (IOException e) {
			//TODO check is its ok
			System.err.println(e.getMessage());
		}
		return sectionList;
	}
}
