package application;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.List;

public class BasicData {
    private List dataList;
    private int dataSize;

    BasicData(int size){
        createArray();
        setSize(size);
    }

    public BasicData(List list){
        dataList = cloneList(list); //MAKE CLONING
        dataSize = list.size();
    }

    public static List cloneList(List list) {
        List clone = new ArrayList(list.size());
        for(int i=0; i<list.size(); i++) clone.add(list.get(i));
        return clone;
    }

    void createArray(){
        dataList = new ArrayList();
    }
    void setSize(int size){
        dataSize = size;
    }
    public List getList(){
        return dataList;
    }
    public int getDataSize(){
        return dataSize;
    }

}
