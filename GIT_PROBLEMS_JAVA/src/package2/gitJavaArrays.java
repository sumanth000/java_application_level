package package2;

import java.util.*;
public class gitJavaArrays {

	public static void main(String[] args) {
		//declaring arrays
		//swapping numbers		
		//find the largest Number of arrays
		//finding the second largest Number in the array
		//sum of the elements
		//replace with sum of the right side elements
		//sorting techniques
		
	
		int []array1=new int[1];
		array1[0]=1;
		int []array2=new int[] {1,3,4};
	
		
		swapNumbers(1,2);
		
		
		int maxNumber=findLargestNumber(new int[] {1,3,4});
		System.out.println("finding Largest Number "+maxNumber);
		
		int secondLargest=findingSecondLargest(new int[] {1,2,3,4});
		System.out.println("finding Second Largest Number "+secondLargest);
		
		int sumOfArray=sumOfElements(new int[] {1,2});
		System.out.println("sum Of Array  "+sumOfArray);
		
		int []replace_with_sum_of_right_elements=replaceWithSumOfRightSideElements(new int[] {1,2,3,4,5});
		System.out.println("Replaced with sum of Right Side Elements  "+Arrays.toString(replace_with_sum_of_right_elements));
		
		

		int [] sortedNumbers=sortingNumbers(new int[] {1,3,4,2});
		System.out.println("sorting Numbers "+Arrays.toString(sortedNumbers));


	}
	
	public static int findLargestNumber(int []a) {
		int result=Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++)
		{
		  if(result<a[i]) {
			  result=a[i];
		  }
			
		}
		
		return result;
	}
	
	public static int findingSecondLargest(int []a) {
		int result=-1;
		int largest=Integer.MIN_VALUE;
		int secondLargest=Integer.MIN_VALUE;
		for(int i=0;i<a.length;i++)
		{
			int current=a[i];
			
			if(largest<current) {
				secondLargest=largest;
				largest=current;
			}
			
			
		}
		result=secondLargest;
		return result;
	}
	
	public static void swapNumbers (int a,int b) {

		System.out.print("before swap "+a+" "+b + " ------ ");

		int c=a;
		a=b;
		b=c;
		System.out.print("after swap "+a+" "+b);
		System.out.println();
		
	}
	
	public static int [] sortingNumbers(int []a)
	{
		int []result=a;
		for(int i=0;i<a.length;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]>a[j])
				{
					swapNumbersInArray(a,i,j);
				}
			}
		}
		
		
		return result;
	}
	
	public static void swapNumbersInArray(int []a,int i,int j)
	{
		int [] result=a;
		int k=result[i];
		result[i]=result[j];
		result[j]=k;
//		return result;
	}
	
    public static int sumOfElements(int []a) {

    	int sum=0;
    	for(int i:a) {
    		sum+=i;
    	}
    	return sum;
    }
    
    public static int [] replaceWithSumOfRightSideElements(int []a) {
    	
    	//method1
    	int []result=new int[a.length];
    	for(int i=0;i<a.length;i++)
    	{
    		int sumOfRight=0;
    		for(int j=i+1;j<a.length;j++)
    			sumOfRight+=a[j];
    		result[i]=sumOfRight;
    	}
    	//method2
    	int sumOfArray=sumOfElements(a);
    	for(int i=0;i<a.length;i++)
    	{
    		
    		a[i]=sumOfArray-a[i];
    		sumOfArray=a[i];
    	}
    	return a;
    	
//    	return result;
    }
 }
		


