package Database;

import Database.Model.Restaurant;
import Database.Service.RestaurantJDBCTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");

        RestaurantJDBCTemplate restaurantJDBCTemplate = (RestaurantJDBCTemplate)context.getBean("restaurantJDBCTemplate");

//        System.out.println("------Records Creation--------");
//        restaurantJDBCTemplate.insertIntoTable("Dominos", "Hjarðarhagi 51", 107, "Reykjavík", 1, 64.138254, -21.956093);
//        restaurantJDBCTemplate.insertIntoTable("Dominos", "Skúlagata 26", 101, "Reykjavík", 2, 64.145549, -21.918857);
//        restaurantJDBCTemplate.insertIntoTable("Íslenska Hamborgarafabrikkan", "Katrínartún 2", 105, "Reykjavík", 4, 64.145026, -21.906703);
//        restaurantJDBCTemplate.insertIntoTable("Dominos", "Skeifan 17", 999, "Reykjavík", 5, 64.130202, -21.869628);
//        restaurantJDBCTemplate.insertIntoTable("Subway", "Bankastræti 14", 101, "Reykjavík", 6, 64.146481, -21.933038);
//        restaurantJDBCTemplate.insertIntoTable("Subway", "Ártúnshöfði", 999, "Reykjavík", 7, 64.123549, -21.825998);
//        restaurantJDBCTemplate.insertIntoTable("Subway", "Fjarðargata 19", 999, "Reykjavík", 8, 64.067877, -21.957042);
//        restaurantJDBCTemplate.insertIntoTable("Serrano", "Höfðatorg", 999, "Reykjavík", 9, 64.144997, -21.907951);
//        restaurantJDBCTemplate.insertIntoTable("Serrano", "Kringlan", 999, "Reykjavík", 10, 64.129367, -21.893657);
//        restaurantJDBCTemplate.insertIntoTable("Serrano", "Bíldshöfði 2", 999, "Reykjavík", 11, 64.124554, -21.831819);
//
//        System.out.println("------Listing Multiple Records--------");
//        List<Restaurant> restaurants = restaurantJDBCTemplate.listRestaurants();
//        for (Restaurant record : restaurants) {
//            System.out.print("ID : " + record.getId());
//            System.out.print(", Name : " + record.getName());
//            System.out.println(", ZipCode : " + record.getZip());
//            System.out.println(", City : " + record.getCity());
//            System.out.println(", Horizontal : " + record.getHorizontal());
//            System.out.println(", Vertical : " + record.getVertical());
//        }
//
//        System.out.println("----Updating Record with ID = 3 -----");
//        restaurantJDBCTemplate.update("Dominos", "Skeifan 17", 999, "Reykjavík", 3, 11.111, 99.999);
//
//        System.out.println("----Listing Record with ID = 2 -----");
//        Restaurant restaurant = restaurantJDBCTemplate.getRestaurant(2);
//        System.out.print("ID : " + restaurant.getId());
//        System.out.print(", Name : " + restaurant.getName());
//        System.out.println(", ZipCode : " + restaurant.getZip());
//        System.out.println(", City : " + restaurant.getCity());
//        System.out.println(", Horizontal : " + restaurant.getHorizontal());
//        System.out.println(", Vertical : " + restaurant.getVertical());

        System.out.println("----Listing Record with Distance = 2000m -----");
        List<Restaurant> restaurants = restaurantJDBCTemplate.listRestaurantsInRadius(5000, 64.146995, -21.982398, 0.0);
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