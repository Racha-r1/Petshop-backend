package com.example.petshop.repositories;

import com.example.petshop.models.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemsRepository extends CrudRepository<Item, Long> {

    @Query(value = "SELECT * FROM items  WHERE order_id= :id", nativeQuery = true)
    List<Item> findAllOrderItemsByOrderId(long id);
}
