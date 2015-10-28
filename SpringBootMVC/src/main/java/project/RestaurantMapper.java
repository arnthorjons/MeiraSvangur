package project;

import project.model.Restaurant;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class RestaurantMapper implements RowMapper<Restaurant> {
    public RestaurantMapper() {
    }

    public Restaurant mapRow(ResultSet rs, int rowNum) throws SQLException {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(rs.getString("Name"));
        restaurant.setAddress(rs.getString("Address"));
        restaurant.setZip(Integer.valueOf(rs.getInt("Zip")));
        restaurant.setCity(rs.getString("City"));
        restaurant.setHorizontal(Double.valueOf(rs.getDouble("Horizontal")));
        restaurant.setVertical(Double.valueOf(rs.getDouble("Vertical")));
        restaurant.setId(Integer.valueOf(rs.getInt("Restaurant_Id")));
        return restaurant;
    }
}
