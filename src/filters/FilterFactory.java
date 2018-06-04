package filters;

public class FilterFactory {

	private static final String NAME_GREATER_THAN = "greater_than";
	private static final String NAME_BETWEEN = "between";
	private static final String NAME_SMALLER_THAN = "smaller_than";
	private static final String NAME_FILE_FILTER = "file";
	private static final String NAME_CONTAINS = "contains";
	private static final String NAME_PREFIX = "prefix";
	private static final String NAME_SUFFIX = "suffix";
	private static final String NAME_WRITABLE = "writable";
	private static final String NAME_EXECUTABLE = "executable";
	private static final String NAME_HIDDEN = "hidden";
	private static final String NAME_ALL = "all";

	private static final int NOT_INDEX = 2;
	private static final int FILTER_NAME = 0;
	private static final int FILTER_PARAM = 1;
	private static final int SECOND_PARAM = 2;
	private static final String NOT_SIGN = "NOT";
	private static final String NO_INDICATION = "NO";
	private static final String YES_INDICATION = "YES";
	private static final String SPLIT_SIGN = "#";


	private String[] lineValArray;

	public Filter getFilter(String filterLine) throws FilterExceptions {
		if (filterLine == null) {
			throw new ExceptionNoFilterLine();
		}
		lineValArray = filterLine.split(SPLIT_SIGN);
		String filterName = lineValArray[FILTER_NAME];
		Boolean checkNot = false;
		Double numVal;
		Boolean yesOrNo;
		switch (filterName) {

			case NAME_GREATER_THAN:
				if (!isValidNam()) {
					return null;
				}
				numVal = Double.parseDouble(lineValArray[FILTER_PARAM]);
				if (lineValArray.length > 2) {
					checkNot = isThereNot(lineValArray[NOT_INDEX]);
					if (!checkNot){
						return null;
					}
				}
				return new GreaterThanFilter(numVal, checkNot);
			case NAME_BETWEEN:
				if (lineValArray.length < 3 || !isValidBetweenParam()) {
					return null;
				}
				numVal = Double.parseDouble(lineValArray[FILTER_PARAM]);
				Double secondNumVal = Double.parseDouble(lineValArray[SECOND_PARAM]);
				// the between filter get NOT at the 3 index
				if (lineValArray.length > 3) {
					checkNot = isThereNot(lineValArray[NOT_INDEX + 1]);

					if (!checkNot) {
						return null;
					}
				}

				return new BetweenFilter(numVal, secondNumVal, checkNot);
			case NAME_SMALLER_THAN:
				if (!isValidNam()) {
					return null;
				}
				numVal = Double.parseDouble(lineValArray[FILTER_PARAM]);
				if (lineValArray.length > 2) {
					checkNot = isThereNot(lineValArray[NOT_INDEX]);
					if (!checkNot) {
						return null;
					}
				}
				return new SmallerThanFilter(numVal, checkNot);
			case NAME_FILE_FILTER:
				if (lineValArray.length < 2) {
					return null;
				}
				if (lineValArray.length > 2) {
					checkNot = isThereNot(lineValArray[NOT_INDEX]);
				}
				return new filters.FileNameFilter(lineValArray[FILTER_PARAM], checkNot);
			case NAME_CONTAINS:
				if (lineValArray.length < 2) {
					return null;
				}
				if (lineValArray.length > 2) {
					checkNot = isThereNot(lineValArray[NOT_INDEX]);
				}
				return new ContainsFilter(lineValArray[FILTER_PARAM], checkNot);
			case NAME_PREFIX:
				if (lineValArray.length < 2) {
					return null;
				}
				if (lineValArray.length > 2) {
					checkNot = isThereNot(lineValArray[NOT_INDEX]);
				}
				return new PrefixFilter(lineValArray[FILTER_PARAM], checkNot);
			case NAME_SUFFIX:
				if (lineValArray.length < 2) {
					return null;
				}
				if (lineValArray.length > 2) {
					checkNot = isThereNot(lineValArray[NOT_INDEX]);
				}
				return new SuffixFilter(lineValArray[FILTER_PARAM], checkNot);
			case NAME_WRITABLE:
				if ((lineValArray.length < 2 || !isYesOrNoVal())) {
					return null;
				}
				yesOrNo = checkYesOrNo();
				if (lineValArray.length > 2) {
					checkNot = isThereNot(lineValArray[NOT_INDEX]);
				}
				return new WritableFilter((yesOrNo == !checkNot));
			case NAME_EXECUTABLE:
				if ((lineValArray.length < 2 || !isYesOrNoVal())) {
					return null;
				}
				yesOrNo = checkYesOrNo();
				if (lineValArray.length > 2) {
					checkNot = isThereNot(lineValArray[NOT_INDEX]);
				}
				return new ExecutableFilter((yesOrNo == !checkNot));
			case NAME_HIDDEN:
				if ((lineValArray.length < 2 || !isYesOrNoVal())) {
					return null;
				}
				yesOrNo = checkYesOrNo();
				if (lineValArray.length > 2) {
					checkNot = isThereNot(lineValArray[NOT_INDEX]);
				}
				return new HiddenFilter((yesOrNo == !checkNot));
			case NAME_ALL:
				// the all filter get NOT at the 1 index


				if (lineValArray.length > 1) {
					checkNot = isThereNot(lineValArray[NOT_INDEX - 1]);
				}

				return new AllFilter(checkNot);
			default:
				throw new ExceptionNoSuchFilter(filterName);
		}
	}

	/*
	Check if the String in the filter line is valid (i.e. can pars the String to double, and if it
	positive.)
	return true if its valid and false otherwise
	 */
	private boolean isValidNam() {
		if (lineValArray.length < 2) {
			return false;
		}
		Double num;
		try {
			num = Double.parseDouble(lineValArray[FILTER_PARAM]);
		} catch (NumberFormatException e) {
			return false;
		}
		return (num >= 0);
	}

	/*
	Check is the values for the between filter are valid
	 */
	private boolean isValidBetweenParam() {
		Double firstNum;
		Double secondNum;
		try {
			firstNum = Double.parseDouble(lineValArray[FILTER_PARAM]);
			secondNum = Double.parseDouble(lineValArray[SECOND_PARAM]);
		} catch (NumberFormatException e) {
			return false;
		}

		return ( firstNum>=0 && secondNum>=0 )&& firstNum <= secondNum;
	}

	/*
	Check if the val is YES or No and return true if it is and false otherwise
	 */
	private boolean isYesOrNoVal() {
		String val = lineValArray[FILTER_PARAM];
		return (val.equals(YES_INDICATION) || val.equals(NO_INDICATION));
	}

	/*
	Check if the String is equals to "NOT"
	 */
	private boolean isThereNot(String check) {
		return check.equals(NOT_SIGN);
	}

	/*
	Assuming that the given param in the filter line is "YES" or "NO".
	if there is "YES" return true if there is "NOT' return False
	 */
	private boolean checkYesOrNo() {
		// if its not equals means there is "NOT"
		return lineValArray[FILTER_PARAM].equals(YES_INDICATION);
	}
}

