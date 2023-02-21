package com.demo.inventoryservice.controllers;

import com.demo.inventoryservice.entities.Item;
import com.demo.inventoryservice.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {
    @Autowired
    private ItemService itemService;
    @GetMapping("/")
    public String greetings() {
        return "Welcome to Inventory Service";
    }

    @GetMapping("/app/item")
    public List<Item> getItems() {
        return itemService.getItemList();
    }

    @GetMapping("/app/item/{id}")
    public Item getItem(@PathVariable("id") int id) {
        return itemService.getItemById(id);
    }

    @PostMapping(value = "/app/item",
            consumes = {"application/json"},
            produces = {"application/json"})
    public void addItem(@RequestBody Item item) {
        itemService.addItem(item);
    }

}
