package component_based_DI_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@ComponentScan("component_based_DI_injection") 
public class ComponentBean {
	
	public static void main(String []args)
	{
		ApplicationContext context = new AnnotationConfigApplicationContext(ComponentBean.class);
	    Student student = context.getBean(Student.class);
	    student.detail.printName();
	    student.health.pringName();
	    student.Gender.printName();
	}

    
	
    
}


@Component
class Student{
	
	@Autowired
	public Gender Gender;// field injection
	
	public Detail detail;

	public Health health;
	
	
	

	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}

	public Health getHealth() {
		return health;
	}
	@Autowired            //setter injection

	public void setHealth(Health health) {
		this.health = health;
	}
	
	@Autowired
	public Student(Detail detail)// constructor injection
	{
		this.detail=detail;
	}

	
	
	
}

@Component
 class Detail{
	public String name;
	public void printName() {
		System.out.println("printName");
	}
}


@Component
class Health{
	public void pringName() {
		System.out.println("printName");

	}
}

@Component
class Gender{
	public void printName() {
		System.out.println("printName");

	}
}