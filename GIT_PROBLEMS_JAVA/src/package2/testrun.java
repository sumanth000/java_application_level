package package2;
import java.util.*;

public class testrun {

    public static void main(String[] args) {
    	
    PriorityQueue<Integer> a=new PriorityQueue<>();
    int []arr= {1,22,2,44,66
    		};
    for(int i:arr)
    {
    	a.offer(i);
    }
    System.out.println(a);
    
     
    	
    
    }
}

class Threadtask extends Thread{
	
	public int sleepTime;
	public int threadNumber;
	public Threadtask(int time,int threadCount) {
		this.sleepTime=time;
		this.threadNumber=threadCount;
	}
	  
	 public void run(){
	   try{
	        Thread.sleep(sleepTime);
	      

	   }
	   catch(Exception e)
	   {
	     
	   }

	   System.out.println("thread task of number "+ " ---" +this.threadNumber+ " -- "+this.sleepTime);
	 }
	  
	}