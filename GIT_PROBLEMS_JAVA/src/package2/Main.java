package package2;
import java.util.*;
public class Main {
	
	public static void main(String []args)
	{


	      Collection<Integer> list=new ArrayList<>();
	      List<Integer> list1=new ArrayList<>();
	      list1.add(1);
	      list1.add(2);
	        list1.add(3);
	      List<Integer> list2=Arrays.asList(1,2,3);
	      List<Integer> list3=List.of(1,2,3);
	      List<Integer>list4=new ArrayList<>(list3);
	      List<Integer>list5=new ArrayList<>(new HashSet<Integer>(List.of(1,2,3)));
	      
	      
	      for(int i=0;i<list1.size();i++)
	      {
	        System.out.print(list1.get(i)+ " ");
	      }
	      
	      System.out.println("");
	      
	      for(Integer i:list2)
	      {
	        System.out.print(i+ " ");
	      }
	      
	      System.out.println("");

	      Iterator<Integer> it=list3.iterator();
	      while(it.hasNext()){
	        System.out.print(it.next()+" ");
	        
	      }
	}

}
