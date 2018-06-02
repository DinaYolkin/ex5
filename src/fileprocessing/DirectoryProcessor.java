package fileprocessing;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class DirectoryProcessor {

	private static final int SOURCE_DIR_INDEX = 0;
	private static final int COMMAND_FILE_INDEX = 1;
	private static final int ARGS_NUM = 2;


	public static void main(String[] args) {


		///check number of params.

		File sourceDir = new File(args[SOURCE_DIR_INDEX]);
		File[] files = sourceDir.listFiles();
		ArrayList<File> directoryFiles = new ArrayList<>(Arrays.asList(files));


		// call command reader
		ArrayList<Section> sections = new ArrayList<>();

		for (Section section : sections) {
			section.printAllFilteredFilesByOrder(directoryFiles);
		}
	}
}