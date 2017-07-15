package algorithms;

import file.FileReaderHandler;
import file.FileWriterHandler;

import java.io.IOException;

/**
 * Created by Rafał on 2017-06-10.
 */
public class FloydWarshall {
    FileReaderHandler fR;
    FileWriterHandler fW;
    int[][] costMatrix;
    int[][] predecessorMatrix;
    int edgeNumber;
    int verticesNumber;
    final int infinity = Integer.MAX_VALUE - 1;


    public FloydWarshall() throws Exception {
        setFileHandlers();
        readInputParameters();
        setGraphMatrix();
        performAlgorithm();
        reconstructPath();
        closeFileHandlers();
    }


    public void setFileHandlers() throws IOException {
        this.fR = FileReaderHandler.getInstanceInputFloyd();
        this.fW = FileWriterHandler.getInstanceOutput();
    }

    private void readInputParameters() throws IOException {
        String[] splitFirstLine;
        splitFirstLine = fR.getLine().split("\\s+");

        verticesNumber = Integer.valueOf(splitFirstLine[0]);
        edgeNumber = Integer.valueOf(splitFirstLine[1]);
    }

    private void setGraphMatrix() throws IOException {
        costMatrix = new int[verticesNumber][verticesNumber];
        predecessorMatrix = new int[verticesNumber][verticesNumber];
        fillInitial();
        fillWithData();
    }

    private void fillInitial() {
        for (int i = 0; i < verticesNumber; i++) {
            for (int j = 0; j < verticesNumber; j++) {
                predecessorMatrix[i][j] = -1;

                if (i == j)
                    costMatrix[i][j] = 0;
                else
                    costMatrix[i][j] = infinity;
            }
        }

    }

    private void fillWithData() throws IOException {
        String[] dataMatrix;
        int sourceIndex;
        int destinationIndex;
        int value;
        for (int k = 0; k < fR.getLineNumber() - 1; k++) {
            dataMatrix = fR.getLine().split("\\s+");
            sourceIndex = Integer.valueOf(dataMatrix[0]);
            destinationIndex = Integer.valueOf(dataMatrix[1]);
            value = Integer.valueOf(dataMatrix[2]);

            costMatrix[sourceIndex][destinationIndex] = value;
            predecessorMatrix[sourceIndex][destinationIndex] = sourceIndex;
        }
    }

    public void performAlgorithm() throws Exception {
        for (int k = 0; k < verticesNumber; k++)
            for (int i = 0; i < verticesNumber; i++)
                for (int j = 0; j < verticesNumber; j++) {
                    if ((costMatrix[i][k] == infinity) || (costMatrix[k][j] == infinity))
                        continue;
                    if (costMatrix[i][j] > costMatrix[i][k] + costMatrix[k][j]) {
                        costMatrix[i][j] = costMatrix[i][k] + costMatrix[k][j];
                        predecessorMatrix[i][j] = predecessorMatrix[k][j];
                    }
                }
    }

    public void reconstructPath() throws IOException {
        for (int i = 0; i < verticesNumber; i++)
            for (int j = 0; j < verticesNumber; j++) {
                if (i != j && predecessorMatrix[i][j] != -1) {
                    fW.write("d[" + i + ", " + j + "]  DIST: "+costMatrix[i][j]+" PATH:");
                    fW.write(i+" ");
                    FWPath(i, j);
                    fW.writeNewLine();
                }
            }
    }


    void FWPath(int i, int j) throws IOException {
        if (i != j && predecessorMatrix[i][j] != -1) {
            FWPath(i, predecessorMatrix[i][j]);
            fW.write(j+" ");
        }
    }


    private void closeFileHandlers() throws IOException {
        this.fR.closeFileReader();
        this.fW.closeFileWriter();
    }

    private void displayMatrix() {
        for (int i = 0; i < verticesNumber; i++) {
            for (int j = 0; j < verticesNumber; j++) {
                if (costMatrix[i][j] == infinity)
                    System.out.print("∞ ");
                else
                    System.out.print(costMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }


}
