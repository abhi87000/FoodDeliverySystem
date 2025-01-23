package Service;

import Model.Order;
import Model.User;
import Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserService {
    Random random=new Random(10000);
    public void registerUser(String userName, String email, String phoneNumber) {
        String userId= String.valueOf(random.nextInt());
        UserRepository.userMap.put(userId,new User(userId,userName,email,phoneNumber,new ArrayList<>()));
        System.out.println("User Registered");

    }

    public void getOrders(String s) {
        if(!UserRepository.userMap.containsKey(s))
        {
            throw new RuntimeException("User doesn't exist");
        }
        User user=UserRepository.userMap.get(s);
        List<Order>orderList=user.getOrders();

        for (Order order:orderList)
        {
            System.out.println(order.getOrderId()+" "+order.getItemName()+" "+order.getQuantity());
        }
    }
}
