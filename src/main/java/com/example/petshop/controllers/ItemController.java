package com.example.petshop.controllers;

import com.example.petshop.models.Item;
import com.example.petshop.repositories.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController {

    @Autowired
    private ItemsRepository itemRepository;

    @PostMapping
    public Item addOrderItem(@RequestBody Item item){
        return itemRepository.save(item);
    }

    @GetMapping
    public List<Item> getOrderItemsByOrderId(@RequestParam(name = "order_id") long orderId){
        return itemRepository.findAllOrderItemsByOrderId(orderId);
    }
}
