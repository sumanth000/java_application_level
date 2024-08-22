package package2;

import java.util.*;

//collection framework
public class gitJavaCollection {
	
	public static void main(String []args)
	{
		
		ArrayList<Integer>arrayList=new ArrayList<>();
		Set<Integer> hashSet=new HashSet<>();
		Set<Integer> treeSet=new TreeSet<>();
		Set<Integer> linkedHashSet=new LinkedHashSet<>();
		Map<Integer,String> hashMap=new HashMap<>();
		
		//create ++++++++++++++++++++++++++
		
		arrayList.add(1);
		arrayList.add(2);
				
		
		hashSet.add(1);
		hashSet.add(1);
		hashSet.add(2);
		
		treeSet.add(2);
		treeSet.add(1);
		
		
		linkedHashSet.add(1);
		linkedHashSet.add(1);
		linkedHashSet.add(3);
		linkedHashSet.add(2);
		
		
		hashMap.put(1, "sumanth");
		hashMap.put(2, "sumathi");
		hashMap.put(3, "ss");



		
		
		//reading through the iterations ++++++++++++++++++++++++++
		
		//arraylist
		//method 1
		for(int i=0;i<arrayList.size();i++)
		{
			System.out.print(arrayList.get(i)+" ");
		}
		System.out.println();
		
		
		//method2
		for(Integer a:arrayList)
		{
		    System.out.print(a+" ");	
		}
		System.out.println();

		//method3
		arrayList.stream().forEach((e)->{
		System.out.print(e+" ");
		});
		System.out.println();
		
		//set
		
		

		
		for(Map.Entry<Integer,String> e: hashMap.entrySet())
		{
			System.out.println(e.getKey() +" "+e.getValue());
		}
		System.out.println();

		
		//update ++++++++++++++++++++++++++
		
		
		//delete ++++++++++++++++++++++++++
		
		
		
		
		//sort
		
		
	}

}
