package file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Rafał on 2017-05-29.
 */
public class FileWriterHandler {
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;

    private FileWriterHandler(String sourcePath) throws IOException {
        fileWriter = new FileWriter(sourcePath);
        bufferedWriter= new BufferedWriter(fileWriter);
    }

    public static FileWriterHandler getInstanceOutput() throws IOException {
        return new FileWriterHandler("src/data/Output.txt");
    }
    public static FileWriterHandler getInstanceBinaryOutput() throws IOException {
        return new FileWriterHandler("src/data/OutputBinary.txt");
    }

    public void writeCompression(String text) throws IOException {
        bufferedWriter.write(text);
        bufferedWriter.newLine();
    }

    public void writeNewLine() throws IOException {
        bufferedWriter.newLine();
    }
    public void write(String text) throws IOException {
        bufferedWriter.write(text);
    }
    public void writeDecompression(String text) throws IOException {
        write(text);
    }
    public void closeFileWriter() throws IOException {
        bufferedWriter.close();
    }

}
