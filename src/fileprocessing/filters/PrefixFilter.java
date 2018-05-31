package fileprocessing.filters;

import java.io.File;

public class PrefixFilter implements FilterStrategy {

	private boolean isNot;
	private String value;

	PrefixFilter(String value, boolean isNot) {
		this.isNot = isNot;
		this.value = value;
	}


	@Override
	public boolean passedFilter(File file) {
		return false;
	}
}
