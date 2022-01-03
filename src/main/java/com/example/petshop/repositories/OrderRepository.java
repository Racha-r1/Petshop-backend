package com.example.petshop.repositories;

import com.example.petshop.models.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query(value = "SELECT * FROM orders WHERE user_email= :user_email", nativeQuery = true)
    List<Order> findOrdersByUserEmail(String user_email);
}
