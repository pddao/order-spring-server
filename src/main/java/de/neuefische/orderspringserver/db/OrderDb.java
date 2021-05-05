package de.neuefische.orderspringserver.db;

import de.neuefische.orderspringserver.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderDb {

    private final List<Order> orderDb = new ArrayList<>();

    public List<Order> list() {
        return orderDb;
    }

    public Order addOrder(Order order) {
        orderDb.add(order);
        return order;
    }

    public Order removeOrder(Order order) {
        orderDb.remove(order);
    }

    public Order updateOrder(Order orderInDb, Order newOrder) {
        orderInDb.setProductList(newOrder.getProductList());
        return orderInDb;
    }

    public Optional<Order> findOrderById(String id) {
        for (Order order : orderDb) {
            if (order.getId().equals(id)) {
                return Optional.of(order);
            }
        }

        return Optional.empty();
    }

}
