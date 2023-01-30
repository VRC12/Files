package Technologies.Java;

import java.util.ArrayList;
import java.util.List;

class Order {
    private List<Item> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public List<Item> getItems() {
        return this.items;
    }
}

class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }
}

class Customer {
    private List<Order> orders;

    public Customer() {
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        this.orders.add(order);
    }

    public double getTotalSpent() {
        double total = 0;
        for (Order order : this.orders) {
            for (Item item : order.getItems()) {
                total += item.getPrice() * item.getQuantity();
            }
        }
        return total;
    }

    public double getDiscount() {
        int numOrders = this.orders.size();
        if (numOrders >= 10) {
            return 0.1;
        } else if (numOrders >= 5) {
            return 0.05;
        } else {
            return 0;
        }
    }
}

class assesment {
    public static void main(String[] args) {
        Customer customer = new Customer();

        Order order1 = new Order();
        order1.addItem(new Item("item1", 10, 2));
        order1.addItem(new Item("item2", 20, 1));
        customer.placeOrder(order1);

        Order order2 = new Order();
        order2.addItem(new Item("item3", 5, 5));
        customer.placeOrder(order2);

        double totalSpent = customer.getTotalSpent();
        double discount = customer.getDiscount();
        double finalAmount = totalSpent - (totalSpent * discount);

        System.out.println("Total spent: " + totalSpent);
        System.out.println("Discount: " + (discount * 100) + "%");
        System.out.println("Final amount: " + finalAmount);
    }
}
