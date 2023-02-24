package com.demo.inventoryservice.controllers;

import com.demo.inventoryservice.entities.Item;
import com.demo.inventoryservice.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

    @PutMapping(value = "/app/item/{id}",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<Item> updateItem(@PathVariable("id") int id,@RequestBody Item item){
        System.out.println("put id: "+id);
        System.out.println("put body: "+item.toString());
        boolean b = itemService.updateItem(item);
        ResponseEntity<Item> resp;
        if(b) {
           resp = new ResponseEntity<>(item, HttpStatusCode.valueOf(200));
        }else {
            resp = new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
        return resp;
    }

    @DeleteMapping("/app/item")
    public void removeAll() {
        itemService.deleteAll();
    }

    @DeleteMapping("/app/item/{id}")
    public ResponseEntity<Item> removeById(@PathVariable int id) {
        ResponseEntity<Item> resp;
        if(itemService.deleteById(id)) {
            resp = new ResponseEntity<>(HttpStatusCode.valueOf(200));
        } else {
            resp = new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
        return resp;
    }

}
