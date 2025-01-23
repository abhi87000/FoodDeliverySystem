import Repository.RestaurantRepository;
import Repository.UserRepository;
import Service.OrderService;
import Service.RestaurantService;
import Service.UserService;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        RestaurantRepository restaurantRepository=new RestaurantRepository(new HashMap<>());
        UserRepository userRepository=new UserRepository(new HashMap<>());

        OrderService orderService=new OrderService();
        RestaurantService restaurantService=new RestaurantService();
        UserService userService=new UserService();
        Random random=new Random(10000);

        while(true)
        {
            try {
                String input = scanner.nextLine();
                input = input.trim();
                String[] inp = input.split(" ");
                switch (inp[0]) {
                    case "RESTAURANT_REGISTRATION":
                        restaurantService.registerRestaurant(inp[1], inp[2],inp[3],inp[4]);
                        break;
                    case "USER_REGISTRATION":
                        userService.registerUser(inp[1], inp[2],inp[3],inp[4]);
                        break;
                    case "ADD_ITEM_IN_CATALOG":
                        restaurantService.addItem(inp[1], inp[2],inp[3],inp[4]);
                        break;
                    case "SEARCH_ITEM":
                        restaurantService.searchItem(inp[1], inp[2]);
                        break;
                    case "GET_ORDERS":
                        userService.getOrders(inp[1]);
                        break;
                    case "PLACE_ORDER":
                        orderService.placeOrder(inp[1], inp[2],inp[3],inp[4]);
                        break;

                    case "CLOSE":
                        break;
                    default:
                        System.out.println("invalid input");
                }
            }
            catch (RuntimeException e)
            {
                System.out.println(e);
            }
        }

    }
}