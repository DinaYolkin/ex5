package fileprocessing.filters;


import java.io.File;

/**
 * This class implement a filter that return all the files.
 */
public class AllFilter implements FilterStrategy {


	@Override
	public boolean passedFilter(File file) {
		return false;
	}
}
