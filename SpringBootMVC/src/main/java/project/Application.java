package project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import project.dao.CustomerDAO;
import project.dao.impl.Database;
import project.model.Customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import project.model.Restaurant;

import java.util.List;

/**
 * The main class of the project.
 * By running the main class of {@link Application} then you start the Spring Boot system
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder){
        return applicationBuilder.sources(Application.class);
    }

    public static void main(String[] args) {

        SpringApplication.run(Application.class,args);
/*
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
        Customer customer = new Customer(2, "Ivan",24);
        customerDAO.insert(customer);

        Customer customer1 = customerDAO.findByCustomerId(2);
        System.out.println(customer1);
*/
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Spring-Module.xml");

        Database database = (Database)context.getBean("database");

        System.out.println("----Listing Record with Distance = 2000m -----");
        List<Restaurant> restaurants = database.listRestaurantsInRadius(5000, 64.146995, -21.982398, 0.0);
        for (Restaurant restaurant : restaurants)
        {
            System.out.println();
            System.out.println("ID : " + restaurant.getId() + ",");
            System.out.println("Name : " + restaurant.getName() + ",");
            System.out.println("Address : " + restaurant.getAddress() + ",");
            System.out.println("ZipCode : " + restaurant.getZip() + ",");
            System.out.println("City : " + restaurant.getCity() + ",");
            System.out.println("Horizontal : " + restaurant.getHorizontal() + ",");
            System.out.println("Vertical : " + restaurant.getVertical() + ",");
        }

    }

}
