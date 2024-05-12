package configuration_bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import org.springframework.context.*;




public class ConfigurationBean {

	
	public static void main(String []args)
	{
		 ApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class,ConfigClass2.class);

	        // Retrieve beans from the context using their names
	        Student student = context.getBean(Student.class);
	       

	        // Access methods or properties of the retrieved beans
	        
	        student.detail.printName();
	        student.health.pringName();
	        student.Gender.printName();
	        
	        
	        
	        Detail detail = (Detail) context.getBean("customDetailBean"); // Correct bean name
	        Health health = context.getBean(Health.class);
	        Gender gender = context.getBean(Gender.class);

	        // Access methods or properties of the retrieved beans
	        detail.printName();
	        health.pringName();
	        gender.printName();	
	        
	}

}



@Configuration
class ConfigClass {

   

    @Bean(name = "customDetailBean")
    public Detail detail() {
        return new Detail();
    }

    @Bean
    public Health health() {
        return new Health();
    }

    @Bean                  // bean has to be created to use them in the autowrired
    public Gender gender() {
        return new Gender();
    }
}


@Configuration
class ConfigClass2 {

    @Autowired
    public Detail detail;// this is to inject student bean 

    @Autowired
    public  Health health;

    @Autowired
    public  Gender gender;

    @Bean
    public Student student() {
        Student student = new Student();
        student.setDetail(detail);
        student.setHealth(health);
        student.setGender(gender);
        return student;
    }

}


class Student{
	
	public Gender Gender;
	
	public Detail detail;

	public Health health;

	public Gender getGender() {
		return Gender;
	}

	public void setGender(Gender gender) {
		Gender = gender;
	}

	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}

	public Health getHealth() {
		return health;
	}

	public void setHealth(Health health) {
		this.health = health;
	}
	
	
}

class Detail{
	public void printName() {
		System.out.println("printName");
	}
}



class Health{
	public void pringName() {
		System.out.println("printName");

	}
}


class Gender{
	public void printName() {
		System.out.println("printName");

	}
}
