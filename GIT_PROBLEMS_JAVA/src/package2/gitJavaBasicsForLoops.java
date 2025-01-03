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
		
		System.out.println("5 inverse right angled triangle _________________________________________");
		
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5-i;j++)
			{
				System.out.print("* ");
			}
			
			System.out.println();
		}
				System.out.println("6 square with diagonal _________________________________________");
		
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(i==0|| j==0 || i==8-1 || j==8-1)
					System.out.print("* ");
				else if(i==j)
					System.out.print("* ");	//left diagonal
				else if(i==8-1-j)
					System.out.print("* ");	//right diagonal
				else
					System.out.print("  ");
			}
			System.out.println("");
		}
		
	}
	

}
