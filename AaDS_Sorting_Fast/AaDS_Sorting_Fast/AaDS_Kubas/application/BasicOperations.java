/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.security.SecureRandom;
import java.util.List;

public class BasicOperations implements BasicOperationsInt{
    private String type;

    public BasicOperations(String type){
     this.type = type;
    }

    public String getType(){
        return type;
    }

    @Override
    public  void showList(List list){
		for(int i=0; i<list.size(); i++)
			System.out.print(list.get(i)+"  ");
			System.out.println("");
	 }
    @Override
    public void fillWithRandomData(List list, int dataSize){
		for(int i=0; i<dataSize; i++)
		    list.add(i, generateValue());
	}
    Object generateValue(){
        if(type.compareTo("string")==0)
            return randomString();
        else
            return randomInt();
    }

    int randomInt(){return (int) (Math.random()* Integer.MAX_VALUE);}

    String randomString(){
        final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        int sizeOfString = (int)(Math.random()*50);
        StringBuilder sb = new StringBuilder( sizeOfString );
            for( int i = 0; i < sizeOfString; i++ )
                    sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
            }

      @Override
      public void checkSortingCorrectness(List list){
            boolean isSorted = true;
            int i = 1;
            while(i <list.size() && isSorted){
                if(compareValue(list.get(i-1), list.get(i)))
                    isSorted = false;
                i++;
            }
            System.out.println("Sorted: "+isSorted);
        }

   public boolean compareValue(Object obj1, Object obj2){
        if(type.compareTo("string")==0)
            return compareString(obj1, obj2);
        else
            return compareInt(obj1, obj2);

    }

   public boolean compareInt(Object obj1, Object obj2){return (int) obj1 > (int) obj2? true: false;}

    public boolean compareString(Object obj1, Object obj2){
        String string1 = (String) obj1;
        String string2 = (String) obj2;
            return string1.compareTo(string2)<0? true: false;}



    public boolean isEqual(Object obj1, Object obj2){
        if(type.compareTo("string")==0)
            return isEqualString(obj1, obj2);
        else
            return isEqualInt(obj1, obj2);
    }
    public boolean isEqualInt(Object obj1, Object obj2){return (int) obj1 == (int) obj2? true: false;}

    public boolean isEqualString(Object obj1, Object obj2){
        String string1 = (String) obj1;
        String string2 = (String) obj2;
        return string1.compareTo(string2)==0? true: false;}

}
