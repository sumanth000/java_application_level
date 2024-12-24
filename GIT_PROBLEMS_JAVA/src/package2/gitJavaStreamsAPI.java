package package2;

import java.util.*;
public class gitJavaStreamsAPI {

	public static void main(String[] args) {
		
	 List<Employee> empList=List.of(new Employee("ruchin",23,23000),new Employee("sraddha",30,30000),new Employee("sumanth",25,230000));
	 
	 System.out.println(empList);
	 
     
	}
	
	
 }
	
class Employee{
	
	public String name;
	public int age;
	public double salary;
	
	public Employee(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	
}


