package de.neuefische.orderspringserver.service;

import de.neuefische.orderspringserver.db.OrderDb;
import de.neuefische.orderspringserver.db.ProductDb;
import de.neuefische.orderspringserver.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderDb orderDb;
    private final ProductDb productDb;

    @Autowired
    public OrderService(OrderDb orderDb, ProductDb productDb) {
        this.orderDb = orderDb;
        this.productDb = productDb;
    }

    public List<Order> list() {
        return orderDb.list();
    }

    public Order addOrder(Order order) {
        //productDb.findProductById(id
        return orderDb.addOrder(order);
    }

    public Order removeOrder(Order order) {
        return orderDb.removeOrder(order);
    }

    public Order updateOrder(Order orderInDb, Order newOrder) {
        return orderDb.updateOrder(orderInDb, newOrder);
    }

    public Optional<Order> findOrderById(String id) {
        return orderDb.findOrderById(id);
    }
}
