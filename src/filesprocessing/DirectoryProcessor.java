
package filesprocessing;

import filters.FilterExceptions;
import orders.OrderExceptions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DirectoryProcessor {
	final static int ERROR_EXIT_CODE = -1;
	final static int NUMBER_OF_ARGS = 2;
	final static int SOURCE_DIR_INDEX = 0;
	final static int COMMAND_FILE_INDEX = 1;

	public static void main(String[] args) throws IOException {

		try {
			if (args.length != NUMBER_OF_ARGS) {
				throw new InvalidParamsNum();
			}
			String sourceDir = args[SOURCE_DIR_INDEX];
			String commandFile = args[COMMAND_FILE_INDEX];

			File directory = new File(sourceDir);
			File[] files = directory.listFiles();

			ArrayList<File> allFiles = new ArrayList<>(Arrays.asList(files));

			CommandReader commandReader = new CommandReader(commandFile);

			ArrayList<Section> sections = commandReader.readFile();

			for (Section section : sections) {
				section.printAllFilteredFilesByOrder(allFiles);
			}

		} catch (SectionException | FilterExceptions | OrderExceptions e) {
			System.err.println(e.getMessage());
			System.exit(ERROR_EXIT_CODE);
		}


	}

}