package Util;

import Model.Order;
import Model.User;
import Repository.UserRepository;

import java.util.List;

public class UserUtil {
    public static void addOrder(Order order) {
        User user=UserRepository.userMap.get(order.getUserId());
        List<Order> orders = user.getOrders();
        orders.add(order);
    }
}
