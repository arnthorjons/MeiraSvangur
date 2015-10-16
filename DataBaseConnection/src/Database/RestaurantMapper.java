package Database;

/**
 * Created by Arnthor on 6.10.2015.
 */
import org.springframework.jdbc.core.RowMapper;
import Database.Model.Restaurant;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantMapper implements RowMapper<Restaurant> {
    public Restaurant mapRow(ResultSet rs, int rowNum) throws SQLException {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(rs.getString("Name"));
        restaurant.setAddress(rs.getString("Address"));
        restaurant.setZip(rs.getInt("Zip"));
        restaurant.setCity(rs.getString("City"));
        restaurant.setHorizontal(rs.getDouble("Horizontal"));
        restaurant.setVertical(rs.getDouble("Vertical"));
        restaurant.setId(rs.getInt("Restaurant_Id"));
        return restaurant;
    }
}
