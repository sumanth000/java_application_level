package dependency_injection_without_bean;



public class DI_without_bean {
	
	public static void main(String []args)
	{
		
		//manual contructor dependencyinjection
		
		Address address=new Address();
		Family family=new Family();
		Health health=new Health();
		
		
		
		Student student=new Student(address);//constructor injection
	    student.setFamily(family);//setter injection
		student.health=health;//property injection
		
		
		
		student.address.printName();
		student.health.printName();
		student.family.printName();
		
		
	}

}


class Student{
	public Address address;
	
	public Family family;
	
	public Health health;
	
	public Student(Address address)
	{
		this.address=address;
	}
	
	public void setFamily(Family family)
	{
		this.family=family;
	}
	
	
}


class Address{
	public String name;
	
	public void printName() {
		System.out.println("printName() and class Address");
	}
}


class Family{
	public void printName() {
		System.out.println("printName() and Family Address");
	}
}

class Health{
	public void printName() {
		System.out.println("printName() and Health Address");
	}
}
