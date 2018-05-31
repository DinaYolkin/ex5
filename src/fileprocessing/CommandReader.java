package fileprocessing;

import java.io.*;


public class CommandReader {
    private BufferedReader readFile;
    private String fileAddress;

    public CommandReader(String addressFile) {
        this.fileAddress = addressFile;
    }

    public void readFile() {
        try {
            readFile = new BufferedReader(new FileReader(this.fileAddress));
            int i = 1;
            String line = readFile.readLine();
            while (line != null) {
                // TODO add all the checks for the lines of the file
                line = readFile.readLine();
                i++;
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }


}
