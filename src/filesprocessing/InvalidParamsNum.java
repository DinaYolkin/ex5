package filesprocessing;

import java.io.IOException;

 class InvalidParamsNum extends IOException {

	private static final String MSG_ERROR_NUMBER_ARGS = "ERROR: Invalid Number of arguments. Should be 2";

	InvalidParamsNum() {super(MSG_ERROR_NUMBER_ARGS);
	}

}
