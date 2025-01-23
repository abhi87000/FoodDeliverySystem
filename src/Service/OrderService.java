package Service;

import Model.Item;
import Model.Order;
import Model.Restaurant;
import Repository.RestaurantRepository;
import Repository.UserRepository;
import Util.RestaurantUtil;
import Util.UserUtil;

import java.util.List;

public class OrderService {

    public void placeOrder(String userId, String restaurantName, String item, String quantity) {
        if(!RestaurantRepository.restaurantMap.containsKey(restaurantName))
        {
            throw new RuntimeException("Restaurant doesn't exist");
        }
        if(!UserRepository.userMap.containsKey(userId))
        {
            throw new RuntimeException("Invalid User");
        }
        Restaurant restaurant=RestaurantRepository.restaurantMap.get(restaurantName);
        List<Item> itemList=restaurant.getCatalog().getItemList();
        Item item1=null;

        for(Item item2:itemList)
        {
            if(item2.getName().equals(item))
            {
                item1=item2;
                break;
            }
        }
        if(item1==null)
        {
            throw new RuntimeException("Item doesn't exist in restaurant catalog");
        }
        if(item1.getQuantity()<Integer.parseInt(quantity))
        {
            throw new RuntimeException("Not enough quantity for item");
        }
        Order order=new Order(userId,restaurantName,item,Integer.parseInt(quantity));
        UserUtil.addOrder(order);
        RestaurantUtil.addOrder(order);
        System.out.println("order placed"+order.getOrderId());
    }
}
