package LEVEL1_ARRAYS;

import java.util.*;

public class MaxAndSecondMax {
    public static void main(String[] args) {
      System.out.println("Hello, World!");
       Solution1 obj = new Solution1();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		    res = obj.largestAndSecondLargest(3, new int[]{2,1,2});
		    System.out.println(res.get(0) + " " + res.get(1) );
  }
}

class Solution1{
    
    // Function to find largest and second largest element in the array
    public static ArrayList<Integer> largestAndSecondLargest(int sizeOfArray, int arr[])
    {
        //code here.
        ArrayList<Integer> result=new ArrayList<>();
        
        int n=sizeOfArray;
        int []a=arr;
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        
        int i=0;
        while(i<n)
        {
           if(a[i]>max1)
            {
             max2=max1;
             max1=a[i];
             
            }
            else if (a[i]>max2 && a[i]<max1)
            {
              max2=a[i];
            }
            
           
            i++;
        }
        
        result.add(max1);result.add(max2);
        
        
        return result;
        
    }
}