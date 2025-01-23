package Repository;

import Model.Restaurant;

import java.util.Map;

public class RestaurantRepository {
    public static Map<String, Restaurant> restaurantMap;

    public RestaurantRepository(Map<String, Restaurant> restaurantMap) {
        RestaurantRepository.restaurantMap = restaurantMap;
    }

}
