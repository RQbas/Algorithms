package algorithms;

import file.FileReaderHandler;
import file.FileWriterHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Rafał on 2017-06-10.
 */
public class BFS {
    FileReaderHandler fR;
    FileWriterHandler fW;
    Graph graph;
    int edgeNumber;
    int verticesNumber;

    public BFS(int v1, int v2) throws IOException {
        setFileHandlers();
        readInputParameters();
        fillGraph();
        runBFS(v1, v2);
        closeFileHandlers();
    }


    public void setFileHandlers() throws IOException {
        this.fR = FileReaderHandler.getInstanceInputBFS();
        this.fW = FileWriterHandler.getInstanceOutput();
    }
    private void readInputParameters() throws IOException {
        String[] splitFirstLine;
        splitFirstLine = fR.getLine().split("\\s+");

        verticesNumber = Integer.valueOf(splitFirstLine[0]);
        edgeNumber = Integer.valueOf(splitFirstLine[1]);
    }

    private void fillGraph() throws IOException {
        String[] splitLine;
        graph = new Graph(verticesNumber, fW);
        for(int i= 0 ; i<edgeNumber; i++){
            splitLine = fR.getLine().split("\\s+");
            graph.addEdge(Integer.valueOf(splitLine[0]),Integer.valueOf(splitLine[1]));
        }
    }
    private void runBFS(int v1, int v2) throws IOException {
        graph.BFS(v1, v2);
        graph.printGraph();
        }












    private void closeFileHandlers() throws IOException {
        this.fR.closeFileReader();
        this.fW.closeFileWriter();
    }
}
