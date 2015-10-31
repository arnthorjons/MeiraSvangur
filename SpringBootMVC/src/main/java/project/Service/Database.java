package project.Service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import project.RestaurantMapper;
import project.Service.Interface.IDatabase;
import project.model.Restaurant;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Service
public class Database implements IDatabase {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
}

    public  void insertIntoTable(String name, String address, Integer zip, String city, Integer id, Double horizontal, Double vertical) {
        String SQL = "insert into Restaurants (Restaurant_id, name, address, city, zip, horizontal, vertical) values (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplateObject.update( SQL, id, name, address, city, zip, horizontal, vertical);
        System.out.println("Created Record Name = " + name + " Address = " + address + " ZipCode = " + zip + " City = " + city + " Id = " + id + " Horizontal = " + horizontal + " Vertical = " + vertical);
        return;
    }

    public Restaurant getRestaurant(Integer id) {
        String SQL = "select * from Restaurants where Restaurant_Id = ?";
        Restaurant restaurant = jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new RestaurantMapper());
        return restaurant;
    }

    public List<Restaurant> listRestaurants() {
        String SQL = "select * from Restaurants";
        List <Restaurant>   restaurants = jdbcTemplateObject.query(SQL, new RestaurantMapper());
        return restaurants;
    }

    public void delete(Integer id){
        String SQL = "delete from Restaurants where Restaurant_Id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id );
        return;
    }

    public void update(String name, String address, Integer zip, String city, Integer id, Double horizontal, Double vertical){
        String SQL = "update Restaurants set address = ? where Restaurant_Id = ?";
        jdbcTemplateObject.update(SQL, address, id);
        System.out.println("Updated Record with ID = " + id );
        return;
    }
    public List<Restaurant> listRestaurantsInRadius(Integer distance, Double horizontal, Double vertical, Double altitude)
    {
        List<Restaurant> restaurants = listRestaurants();

        List<Restaurant> restaurantsInRadius = new ArrayList<Restaurant>();

        for(int i = 0; i < restaurants.size(); ++i)
        {
            Restaurant restaurant = restaurants.get(i);

            Double calcDistance = calcDistance(horizontal, restaurant.getHorizontal(), vertical, restaurant.getVertical(), altitude, 0.0);

            if(calcDistance <= distance)
            {
                Double d = calcDistance(horizontal, restaurant.getHorizontal(), vertical, restaurant.getVertical(), altitude, 0.0);
                System.out.println(d.toString());
                restaurantsInRadius.add(restaurants.get(i));
            }
        }

        return restaurantsInRadius;
    }

    /*
    * Calculate distance between two points in latitude and longitude taking
    * into account height difference. If you are not interested in height
    * difference pass 0.0. Uses Haversine method as its base.
    *
    * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
    * el2 End altitude in meters
    * @returns Distance in Meters
    */
    public static double calcDistance(Double startHor, Double endHor, Double startVer,
                                      Double endVer, Double el1, Double el2)
    {
        // Radius of the earth in km
        final int R = 6371;

        Double horDistance = Math.toRadians(endHor - startHor);
        Double verDistance = Math.toRadians(endVer - startVer);
        Double a = Math.sin(horDistance / 2) * Math.sin(horDistance / 2)
                + Math.cos(Math.toRadians(startHor)) * Math.cos(Math.toRadians(endHor))
                * Math.sin(verDistance / 2) * Math.sin(verDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // convert to meters
        double distance = R * c * 1000;

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }

    public static float distFrom(Double lat1, Double lng1, Double lat2, Double lng2) {
        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lng2-lng1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        float dist = (float) (earthRadius * c);

        return dist;
    }
}
