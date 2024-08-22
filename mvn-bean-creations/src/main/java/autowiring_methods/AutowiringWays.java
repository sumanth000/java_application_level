package autowiring_methods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@ComponentScan("autowiring_methods")  // Ensures that Spring scans the correct package
public class AutowiringWays {

    @Autowired
    private MyBean myBeanFromBeans; // Should inject `myAnotherBean1` due to @Primary
    
    @Autowired
    private MyBean myBeanFromAnotherBeans;  // Should inject the same bean due to @Primary

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AutowiringWays.class);
        AutowiringWays app = context.getBean(AutowiringWays.class);
        app.run();
    }

    public void run() {
        System.out.println("From Beans class: " + myBeanFromBeans.name);       
        System.out.println("From AnotherBeans class: " + myBeanFromAnotherBeans.name);
    }
}

@Configuration
class Beans {

    @Bean
    @Primary 
    public MyBean myBean1() {
        return new MyBean("myBean from Beans class");
    }

    @Bean
    public MyBean myBean2() {
        return new MyBean("myBean2 from Beans class");
    }
}

@Configuration
class AnotherBeans {

    @Bean
     // This bean is marked as primary
    public MyBean myAnotherBean1() {
        return new MyBean("myAnotherBean1 from AnotherBeans class");
    }

    @Bean
    public MyBean myAnotherBean2() {
        return new MyBean("myAnotherBean2 from AnotherBeans class");
    }
}


class MyBean {
	
    public String name;
    public MyBean(String name) {
        this.name = name;
    }
}

// usually when used the autowiring, it catches the same 'TYPE' (datatype or classType) and injects it
// if used the primary to it, then will spefically choses that bean for injection of those multiple same type beans
// if needed to use the name, then have to use the qualifier
