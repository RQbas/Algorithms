package file;

import java.io.*;

/**
 * Created by Rafał on 2017-05-29.
 */
public class FileReaderHandler {
    private File file;
    private RandomAccessFile accessFile;
    private int lineNumber;

    private FileReaderHandler(String fileName) throws IOException {
        file = new File(fileName);
        accessFile = new RandomAccessFile(file, "r");
        readFile();
    }

    public static FileReaderHandler getInstanceOutput() throws IOException {
        return new FileReaderHandler("src/data/Output.txt");
    }
    public static FileReaderHandler getInstanceInput() throws IOException {
     return new FileReaderHandler("src/data/Input.txt");
    }

    public String getLine() throws IOException {
       return accessFile.readLine();
    }
    public int getLineNumber(){
        return lineNumber;
    }

    public void readFile() throws IOException {
        String text;
        while((text = accessFile.readLine()) != null)
            lineNumber++;
        accessFile.seek(0);
    }

    public void closeFileReader() throws IOException {
       accessFile.close();
    }
}
