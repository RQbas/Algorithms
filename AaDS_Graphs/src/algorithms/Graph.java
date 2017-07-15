package algorithms;

import file.FileReaderHandler;
import file.FileWriterHandler;

import java.io.IOException;
import java.util.*;

class Graph {
    private int verticesNumber;
    private LinkedList<Integer> adjacencyList[];
    private FileWriterHandler fW;

    Graph(int verticesNumber, FileWriterHandler fW){
        this.fW = fW;
        this.verticesNumber = verticesNumber;
        adjacencyList = new LinkedList[verticesNumber];
        for(int i=0; i<verticesNumber; i++){
            adjacencyList[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int w){
        adjacencyList[v].add(w);
    }

    public boolean isNeighbor(int v, int w){
       return adjacencyList[v].contains(w)?true:false;
    }

    public void BFS (int start, int end) throws IOException {
        int initialPosition = start;
        boolean visited[] = new boolean[verticesNumber];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        ArrayList<Integer> pred = new ArrayList<Integer>();

        for(int i=0; i<verticesNumber; i++)
            pred.add(-1);

        visited[start]=true;
        queue.add(start);

        while(queue.size()!=0){

            start = queue.poll();

            if(start == end)
                break;

            Iterator<Integer> i = adjacencyList[start].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                    pred.set(n, start);
                }
            }
        }
        retrieveBacktrace(pred, initialPosition, end);

    }

    public void retrieveBacktrace(ArrayList<Integer> pred, int start, int end) throws IOException {
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(end);

        while(end!=start){
            end = pred.get(end);
            path.add(end);
        }
        Collections.reverse(path);

        fW.write("PATH: ");
        for(int i : path)
            fW.write(i+" ");
        fW.writeNewLine();
    }

    public void printGraph() throws IOException {
        for(int i=0; i<verticesNumber; i++){
            fW.write("V"+i+": ");
            for(int j=0; j<adjacencyList[i].size(); j++){
                fW.write(adjacencyList[i].get(j)+" ");
            }
                fW.writeNewLine();
        }
    }




}