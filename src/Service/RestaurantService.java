package Service;

import Model.Catalog;
import Model.Item;
import Model.Restaurant;
import Repository.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RestaurantService {

    public void registerRestaurant(String restaurantName, String gstNumber, String email, String phoneNumber) {
        if(RestaurantRepository.restaurantMap.containsKey(restaurantName))
        {
            throw new RuntimeException("restaurant already exist"); //not handling duplicate name restaurant
        }
        // Validations can be performed on the field
        RestaurantRepository.restaurantMap.put(restaurantName,new Restaurant(restaurantName,gstNumber,email,phoneNumber,new Catalog(new ArrayList<>())));
        System.out.println("Registered restaurant");
    }

    public void addItem(String restaurantName, String item, String price, String quantity) {
        if(!RestaurantRepository.restaurantMap.containsKey(restaurantName))
        {
            throw new RuntimeException("restaurant doesn't exist");
        }
        Restaurant restaurant=RestaurantRepository.restaurantMap.get(restaurantName);
        Double pricei= Double.valueOf(price);
        restaurant.getCatalog().getItemList().add(new Item(item,pricei,Integer.parseInt(quantity)));
        RestaurantRepository.restaurantMap.put(restaurantName,restaurant);

        System.out.println("Added Item in catalog");
    }

    public void searchItem(String restaurantName, String item) {
        if(!RestaurantRepository.restaurantMap.containsKey(restaurantName))
        {
            throw new RuntimeException("restaurant doesn't exist");
        }
        Restaurant restaurant=RestaurantRepository.restaurantMap.get(restaurantName);
        List<Item> itemList=restaurant.getCatalog().getItemList();
        Item result = null;

        for(Item item1:itemList)
        {
            if(item1.getName().equals(item))
            {
                result=item1;
                break;
            }
        }
        if(result==null)
        {
            throw new RuntimeException("Item doesn't exist");
        }
        System.out.println(result.getName()+" "+result.getPrice()+" "+result.getQuantity());
    }
}
