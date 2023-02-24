package com.demo.inventoryservice.repositories;

import com.demo.inventoryservice.entities.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item,Integer> {
    
}
