package com.demo.inventoryservice.repositories;

import com.demo.inventoryservice.entities.Item;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemPagingRepository extends PagingAndSortingRepository<Item,Integer> {
}
