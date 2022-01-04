package com.example.petshop.controllers;

import com.example.petshop.models.Item;
import com.example.petshop.models.Order;
import com.example.petshop.repositories.ItemsRepository;
import com.example.petshop.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemsRepository itemRepository;

    @PostMapping
    public Order addOrder(@RequestBody Order order){
        order.setOrder_date(new Date());
        Order newOrder = orderRepository.save(order);
        for (Item i : order.getItems()){
            i.setOrder(newOrder);
            itemRepository.save(i);
        }
        return newOrder;
    }

    @GetMapping("{id}")
    public Optional<Order> getOrderById(@PathVariable long id) {
        return orderRepository.findById(id);
    }

    @GetMapping
    public List<Order> getOrdersByUserEmail(@RequestParam(name = "user_email") String user_email){
        return orderRepository.findOrdersByUserEmail(user_email);
    }
}
