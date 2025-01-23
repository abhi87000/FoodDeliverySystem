package Util;

import Model.Item;
import Model.Order;
import Model.Restaurant;
import Repository.RestaurantRepository;

import java.util.List;

public class RestaurantUtil {
    public static void addOrder(Order order) {
        Restaurant restaurant = RestaurantRepository.restaurantMap.get(order.getRestaurantName());
        List<Order> orderList = restaurant.getOrderList();
        List<Item> itemList = restaurant.getCatalog().getItemList();
        for(Item item:itemList)
        {
            if(order.getItemName().equals(item.getName()))
            {
                item.setQuantity(item.getQuantity()- order.getQuantity());
            }
        }
        orderList.add(order);
        RestaurantRepository.restaurantMap.put(restaurant.getName(),restaurant);
    }
}
