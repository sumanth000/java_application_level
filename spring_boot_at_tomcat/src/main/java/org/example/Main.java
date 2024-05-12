package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.bind.annotation.*;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

@Configuration
@ComponentScan(basePackages = "org.example")
 class AppConfig {

    // No additional configuration needed if beans are defined in the component classes using annotations
}



@SpringBootApplication
@RestController
@ComponentScan(basePackages = "org.example")
public class Main extends SpringBootServletInitializer {
    @Autowired
    private  service1 service1;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @GetMapping("/hello")
    public  String sayHello() {
        return "Hello, World! " + service1.printMethod();
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Main.class);
    }

}

@Component
class service{
    public String printMethod(){
        System.out.println("print method");
        return "pring method";
    }
}
@Component
class serviceClass{
    @Autowired
    public service ser;


}


@Component
class service1{

    @Autowired
    public serviceClass serviceClass;

    public String printMethod() {
        return serviceClass.ser.printMethod();
    }

}