package xml_based_DI_with_bean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class XmlBean 
{
    public static void main( String[] args )
    {
        
    	  ApplicationContext context = new ClassPathXmlApplicationContext("beansConfig.xml");
          // Retrieve the Student bean from ApplicationContext
    	  
    	  
          Student student = (Student) context.getBean("student");
          // Access the dependencies and call their methods
          student.address.printName();
          student.family.printName();
          student.health.printName();  
          
          
          
    }
}


 class Student {
    public Address address;
    public Family family;
    public Health health;

    // Constructor injection
    public Student(Address address) {
        this.address = address;
    }

    // Setter injection
    public void setFamily(Family family) {
        this.family = family;
    }
    // field injection works in a way 
    public void setHealth(Health health)// it has to be setHealth only .. it tries to inject it through the getters and setters of a simple POJO
    {
    	this.health=health;
    }

    // No setter method for health; using property injection directly
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