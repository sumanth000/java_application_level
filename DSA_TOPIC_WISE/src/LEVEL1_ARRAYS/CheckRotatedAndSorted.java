package LEVEL1_ARRAYS;

import java.util.*;

public class CheckRotatedAndSorted {
    public static void main(String[] args) {
       Solution obj = new Solution();
		
		    boolean res = obj.checkRotatedAndSorted(new int[]{3,1,2},3);
		    System.out.println(res);
		    
		    // 1 2 3
		    // 2 3 1 
		   
  }
}

class Solution{
    
    // Function to find largest and second largest element in the array
     // num: size of array
    // Function to check if array is sorted and rotated
    public static boolean checkRotatedAndSorted(int arr[], int num){
        
        // Your code here
        
        System.out.println(nonIncreasingOrNonDecreasing(arr));
        
        for(int i=0;i<arr.length;i++)
        {
           
          if(nonIncreasingOrNonDecreasing(arr))return true;
          else
          {
            shiftElementsToLeft(arr);
            System.out.println(Arrays.toString(arr));
          }
            
        }
        
        return false;
        
    }
    
    public static void shiftElementsToLeft(int []arr)
    {
      int temp=arr[arr.length-1];
      
      for(int i=arr.length-1;i>0;i--)
      {
        arr[i]=arr[i-1];
      }
      
      arr[0]=temp;
      
    }
    public static boolean nonIncreasingOrNonDecreasing(int arr[])
    {
        boolean result=true;
        boolean decreasing=true;
         boolean increasing=true;
        if(!(arr[0]>arr[1]))decreasing=false;
        for(int i=0;i<arr.length-1;i++)
        {
            
            if(decreasing)
            if(!(arr[i]>arr[i+1]))
             result=false;
            
            if(!decreasing)
            if(!(arr[i]<arr[i+1]))
             result=false;
                
            
            
            
        }
        
        return result;
    }
    
}