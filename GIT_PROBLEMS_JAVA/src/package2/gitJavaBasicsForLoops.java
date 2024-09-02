package package2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// if conditions
public class gitJavaBasicsForLoops {

	public static void main(String[] args) {
		
		//patterns 
		System.out.println("1 .square _________________________________________");
		
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
		
		System.out.println("2 .right angled triangle _________________________________________");
		
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<=i;j++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
		
		
		System.out.println("3. inverse right angled triangle  _________________________________________");
		
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5-i;j++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
		
		System.out.println("4. mirrored right angled triangle _________________________________________");
		
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5-i;j++)
			{
				System.out.print("* ");
			}
			
			System.out.println();
		}
		
		System.out.println("5  _________________________________________");
		
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5-i;j++)
			{
				System.out.print("* ");
			}
			
			System.out.println();
		}
		
		
	}
	

}
