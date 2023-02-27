package com.demo.inventoryservice.repositories;

import com.demo.inventoryservice.entities.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item,Integer> {
    public List<Item> findAll();


}
