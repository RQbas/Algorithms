package tools;

import src.HashingInterface;

/**
 * Created by Rafał on 2017-05-23.
 */
public class TestingClassInt implements HashingInterface
{
    private long operationCount;


    public TestingClassInt(){

    }

    public void cleanOperationCount(){
        setOperationCount(0);
    }
    public void setOperationCount(int operationCount){
        this.operationCount = operationCount;
    }

    public void increaseOperationCount(){
        this.operationCount++;
    }

    public long getOperationCount(){
        return this.operationCount;
    }


}
