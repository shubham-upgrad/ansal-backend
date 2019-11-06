package ansaltechblogapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// This annotation comprises of 3 annotations :

/***
 * 1. Configuration - That this class is a bean that specifies configuration
 * 2. EnableAutoConfiguration - Tell SpringBoot that I don't have configurations for Application
 *                      like DispatcherServlet, Context-based Config, Xml Configuration
 * 3. ComponentScan - Find all the components in the current package as well as in all the subpackages
 */

@SpringBootApplication
public class SpringBootStarterClass {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarterClass.class,args);
    }
}
