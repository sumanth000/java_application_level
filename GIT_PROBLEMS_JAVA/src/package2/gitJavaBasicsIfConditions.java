package package2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// if conditions
public class gitJavaBasicsIfConditions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num=12;
		
		List<Integer>factors=new ArrayList<>();
		List<Integer>primeFactors=new ArrayList<>(); 
		List<Integer>factorization=new ArrayList<>(); 

		for(int i=1;i<=10;i++)
		{
			if(num%i==0)
			{	
				factors.add(i);
			}
		}
		
		System.out.println("#factors "+factors);
//		######################################################3
        System.out.println();//--------------------------

		for(int i=1;i<=10;i++)
		{
			if(num%i==0)
			{
				
				boolean isPrime=true;
				for(int j=2;j<i;j++)
				{
					if(i%j==0 || i==1)
					{
					  isPrime=false; 	
					}
				}
				if(isPrime)primeFactors.add(i);
			}
		}
		System.out.println("#prime factors "+primeFactors);
//		######################################################3

        System.out.println();//--------------------------


		


       int numF=num;
		for(int i=2;i<=numF;i++)
		{
		    
			while(numF%i==0)
			{
				numF=numF/i;
				factorization.add(i);	
			}
		}
		
		System.out.println("#factorization "+factorization);
//		######################################################3

        
        
		System.out.println("#amicable numbers ---- sum of factors of one number == other number");
		System.out.println(amicableNumbers(220,284));

//		######################################################3
		System.out.println();
		System.out.println("#no  of zeros present in factorial of 7");
		System.out.println(findZeroesInFactorial(7));
		
		
//		######################################################3
		System.out.println();
		System.out.println("#given sum is palindrome or not");
		System.out.println(digitsSumIsPalindrome(92));
		
		
		

	}
	
	 static boolean amicableNumbers(int x,int y) {
		 
		 boolean result=false;
		 int sumOfXfactors=0;
		 int sumOfYfactors=0;
		 for(int i=1;i<x;i++)
		 {
			 if(x%i==0)
			 {
				 sumOfXfactors+=i; 
			 }
		 }
		 
		 for(int i=1;i<y;i++)
		 {
			 if(y%i==0)
			 {
				 sumOfYfactors+=i;
			 }
		 }
		 
		 if(sumOfXfactors==y && sumOfYfactors==x)result=true;
		 
		 return result;
		 
		
	}
	 
	 static int findZeroesInFactorial( int n) {
		 int zeroes=0;
		 int factorialValue=n;
		 
		 while(n!=1){
			 

			 factorialValue*=--n; 
//			 System.out.println(factorialValue+" "+n);
			 
		 }
		 
		 while(factorialValue!=0)
		 {
			
			 if(factorialValue%10==0)zeroes++;
			
			 
			 factorialValue=factorialValue/10;
		 }
//		 System.out.println(factorialValue);
		 return zeroes;
	 }
	
	 
	 static boolean digitsSumIsPalindrome(int x) {
		boolean result=true;
		int sum=0;
		
		while(x!=0)
		{
			sum+=x%10;
			x=x/10;
		}
		System.out.println(sum);
		boolean isPalindrome=true;
		for(int i=0,j=String.valueOf(sum).length()-1;i<=j;i++,j--)
		{
			System.out.println(String.valueOf(sum).charAt(i)==String.valueOf(sum).charAt(j));
		  if(String.valueOf(sum).charAt(i)!=String.valueOf(sum).charAt(j)) {
			  isPalindrome=false;
			
		  }
		}
		return isPalindrome;
		 
	 }
	

}
