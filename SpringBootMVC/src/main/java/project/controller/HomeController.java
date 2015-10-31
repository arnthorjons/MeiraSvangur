package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import project.Service.Database;
import project.model.Restaurant;

import java.util.List;

@Controller
public class HomeController {

    // Instance Variables
    Database database;

    // Dependency Injection
    @Autowired
    public HomeController(Database database) {
        this.database = database;
    }

    // Request mapping is the path that you want to map this method to
    // In this case, the mapping is the root "/", so when the project
    // is running and you enter "localhost:8080" into a browser, this
    // method is called
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){

        // The string "Index" that is returned here is the name of the view
        // (the Index.jsp file) that is in the path /main/webapp/WEB-INF/jsp/
        // If you change "Index" to something else, be sure you have a .jsp
        // file that has the same name
        return "Index";
    }

    // To call this method, enter "localhost:8080/user" into a browser
    @RequestMapping(value = "/svangur", method = RequestMethod.GET)
    public String svangur(Model model){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Spring-Module.xml");

        Database database = (Database)context.getBean("database");

        List<Restaurant> restaurants = database.listRestaurants();

//        System.out.println("----Listing Record with Distance = 2000m -----");
//        List<Restaurant> restaurants = database.listRestaurantsInRadius(5000, 64.146995, -21.982398, 0.0);
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

        return "Svangur";
    }

    @RequestMapping(value = "/getRestaurants", method = RequestMethod.GET)
    public @ResponseBody List<Restaurant> getRestaurants() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Spring-Module.xml");

        Database database = (Database)context.getBean("database");

        List<Restaurant> restaurants = database.listRestaurants();

        return restaurants;
    }
}
