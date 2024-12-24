package java_applicatoin_run;

import java.util.*;

public class java {
    public static void main(String[] args) {
    
    	
    	
  }
  
 
  
  
}


class Solution{
	public int solution(int n) {
        int leftSum = 0, rightSum = n * (n + 1) / 2; // Pre-calculate the sum from 1 to n

        for (int x = 1; x <= n; x++) {
            leftSum += x;
            rightSum -= x;

            if (leftSum == rightSum) {
                return x;
            }
        }

        return -1;
    }
  
  
}



