package com.example.petshop.controllers;

import com.example.petshop.models.Item;
import com.example.petshop.models.Order;
import com.example.petshop.repositories.ItemsRepository;
import com.example.petshop.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public Order addOrder(@RequestBody Order order){
        order.setOrder_date(new Date());
        return orderRepository.save(order);
    }

    @GetMapping
    public List<Order> getOrdersByUserEmail(@RequestParam(name = "user_email") String user_email){
        return orderRepository.findOrdersByUserEmail(user_email);
    }
}
