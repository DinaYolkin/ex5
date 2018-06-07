package filesprocessing;
/*
This file have a class that create an instant of CommandReader.
 */

import filters.*;
import orders.*;

import java.io.*;
import java.util.ArrayList;

public class CommandReader {

	/* Constants represent messages of type two errors when there is no FILTER row or there is no ORDER row
	 in the given command file
	  */
	private static final String ERROR_NO_FILTER_LINE = "ERROR: no FILTER line";
	private static final String ERROR_NO_ORDER_LINE = "ERROR: no ORDER line";

	/* Constants representing the default objects of Order and Filter as describe in the exercise*/
	private static final String DEFAULT_ORDER = "abs";
	private static final String DEFAULT_FILTER = "all";

	/* Constant represents that we are in the first line of the next section*/
	private static final String NEXT_SECTION = "FILTER";

	/* Constants representing the header lines of Filter and Order*/
	private static final String FILTER_INDICATOR = "FILTER";
	private static final String ORDER_INDICATOR = "ORDER";

	/* constant representing the address of the file that the CommandReader can process and read*/
	private String fileAddress;

	/* Constant representing the factory that produces Filters*/
	private FilterFactory filterFactory;

	/* Constant representing the factory that produces Orders*/
	private OrderFactory orderFactory;

	/* The class constructor */
	CommandReader(String addressFile) {
		fileAddress = addressFile;
		filterFactory = new FilterFactory();
		orderFactory = new OrderFactory();
	}

	/*
	The method reads the command file and creates an ArrayList of Sections.
	While reading the command file, create for each Section a Filter, Order and ArrayList of integers
	 represent the number of the rows where is a type one error, according to the description in the file.
 	returns the ArrayList of Sections.
	 */
	ArrayList<Section> readFile() throws SectionException, FilterExceptions, OrderExceptions {

		ArrayList<Section> sectionList = new ArrayList<>();

		try {

			BufferedReader readFile = new BufferedReader(new FileReader(this.fileAddress));
			int numLine = 1;
			// boolean variable that indicate if there was a order sub-section line at the last section
			boolean isOrderLine = true;

			String line = readFile.readLine();

			while (line != null) {
				Section section;
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

				section = new Section(filter, order, warningsLines);
				if (isOrderLine) {
					line = readFile.readLine();
					numLine++;
				}
				sectionList.add(section);

			}
		} catch (IOException e) {
			throw new SectionException("ERROR: IOException");
		}

		return sectionList;
	}
}
