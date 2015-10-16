package Database.Service.Interface;

import Database.Model.Restaurant;
import javax.sql.DataSource;
import java.util.List;


public interface IRestaurantJDBCTemplate {
    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    void setDataSource(DataSource ds);
    /**
     * This is the method to be used to create
     * a record in the Restaurant table.
     */
    void insertIntoTable(String name, String address, Integer zip, String city, Integer id, Double horizontal, Double vertical);
    /**
     * This is the method to be used to list down
     * a record from the Restaurant table corresponding
     * to a passed restaurant id.
     */
    Restaurant getRestaurant(Integer id);
    /**
     * This is the method to be used to list down
     * all the records from the Restaurant table.
     */
    List<Restaurant> listRestaurants();
    /**
     * This is the method to be used to delete
     * a record from the Restaurant table corresponding
     * to a passed restaurant id.
     */
    void delete(Integer id);
    /**
     * This is the method to be used to update
     * a record into the Restaurant table.
     */
    void update(String name, String address, Integer zip, String city, Integer id, Double horizontal, Double vertical);
}
