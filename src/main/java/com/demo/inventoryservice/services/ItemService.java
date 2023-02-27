package com.demo.inventoryservice.services;

import com.demo.inventoryservice.entities.Item;
import com.demo.inventoryservice.repositories.ItemRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ItemService {
    private List<Item> itemList;
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getItemList () throws NoSuchElementException {
        return itemRepository.findAll();
    }

    public Item getItemById(int id) throws NoSuchElementException {
        return itemRepository.findById(id).get();
    }

    public void addItem(Item item) throws Exception{
        itemRepository.save(item);
    }

    public boolean updateItemIfExists(Item item) {
        if(itemRepository.existsById(item.getItemId())) {
            itemRepository.save(item);
            return true;
        }
        return false;
    }

    public void deleteAll() {
        itemRepository.deleteAll();
    }

    public boolean deleteById(int id) {
        try {
            itemRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
