/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.security.SecureRandom;

public class BasicOperations {
    public int[] numberArray;
    public String[] stringArray;

    public void showArrayInt(int[] NumberArray){
		for(int i=0; i<NumberArray.length; i++)
			System.out.print(NumberArray[i]+"  ");
			System.out.println("");
	 }
     public void showArrayString(String[] stringArray){
		for(int i=0; i<stringArray.length; i++)
			System.out.print(stringArray[i]+"  ");
			System.out.println("");
	 }
	
	 void fillWithRandomNumber(int[] numberArray){
		for(int i=0; i<numberArray.length; i++){
		numberArray[i]=(int) (Math.random()*Integer.MAX_VALUE);
                }
	}
        
        void fillWithRandomString(String[] stringArray){
                final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
                 SecureRandom rnd = new SecureRandom();
         for(int j=0; j<stringArray.length; j++ ){
            int sizeOfString = (int)(Math.random()*20);
            StringBuilder sb = new StringBuilder( sizeOfString );
            for( int i = 0; i < sizeOfString; i++ ) 
                sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
         stringArray[j] = sb.toString();
        }
        
        }
        
      public  void checkSortingCorrectionInt(int[] numberArray){
            boolean isSorted = true;
            int i = 1;
            while(i <numberArray.length && isSorted){
                if(numberArray[i-1]>numberArray[i])
                    isSorted = false;
                i++;
            }
            System.out.println("Sorted: "+isSorted);
        }
       public void checkSortingCorrectionString(String[] stringArray){
            int i = 1;
            boolean isSorted = true;
            while(i <stringArray.length && isSorted){
                if(stringArray[i].compareTo(stringArray[i-1]) < 0)
                    isSorted = false;
                i++;
            }
             System.out.println("Sorted: "+isSorted);
        }
        
        
	 public void ReturnFunctionValue(int value){
		System.out.println(value);
	}
	
}
