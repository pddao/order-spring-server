package de.neuefische.orderspringserver.controller;

import de.neuefische.orderspringserver.model.Order;
import de.neuefische.orderspringserver.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> listOfOrders() {
        return orderService.list();
    }

    @PutMapping("{id}")
    public Order addOrder(@RequestBody Order newOrder, @PathVariable String id) {
        if (id.equals(newOrder.getId())) {
            if (orderService.findOrderById(id).isPresent()) {
                return orderService.updateOrder(orderService.findOrderById(id).get(), newOrder);
            }
            return orderService.addOrder(newOrder);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID not matching");
    }

}
