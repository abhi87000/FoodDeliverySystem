package Model;

public class Order {
    String orderId;
    String userId;

    public String getOrderId() {
        return orderId;
    }

    String restaurantName;
    String itemName;

    public Order(String userId, String restaurantName, String itemName, int quantity) {
        this.userId = userId;
        this.restaurantName = restaurantName;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    int quantity;
}
