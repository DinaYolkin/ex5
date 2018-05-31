package fileprocessing;

import java.io.File;

public class GreaterThanFilter implements FilterStrategy {


	public GreaterThanFilter(){

	}


//    @Override
//    public boolean isValidInput(String filterLine) {
//        //TODO add to all the methods a parameter with the line of the filterLine!!
//        // assuming that the line has been check for errors and now just check if
//        // the line make sense to the filter condition
//        String[] values = filterLine.split("#");
//        try {
//            double threhold = Double.parseDouble(values[1]);
//        }catch (NumberFormatException e){
//            // TODO add line
//            System.err.println("Warning in line ADDLINE");
//        }
//        return false;
//
//    }

    @Override
    public boolean passedFilter(File file) {
        long size = file.getTotalSpace(); // get the size in bytes of the file.
        return false;
    }
}
