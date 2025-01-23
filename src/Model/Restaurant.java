package Model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    String id;
    String name;
    String gstNumber;
    String email;
    String phoneNumber;

    public String getId() {
        return id;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    List<Order> orderList;

    public Restaurant(String name, String gstNumber, String email, String phoneNumber, Catalog catalog) {
        this.name = name;
        this.gstNumber = gstNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.catalog = catalog;
        this.orderList=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    Catalog catalog;
}
