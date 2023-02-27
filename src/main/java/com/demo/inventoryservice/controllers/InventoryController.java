package com.demo.inventoryservice.controllers;

import com.demo.inventoryservice.entities.Item;
import com.demo.inventoryservice.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class InventoryController {
    @Autowired
    private ItemService itemService;
    @GetMapping("/")
    public String greetings() {
        return "Welcome to Inventory Service";
    }

    @GetMapping("/app/item")
    public ResponseEntity<List<Item>> getItems() {
        ResponseEntity<List<Item>> resp;
        try{
            List<Item> items = itemService.getItemList();
            resp = new ResponseEntity<>(items, HttpStatusCode.valueOf(200));

        } catch (NoSuchElementException e) {
            resp = new ResponseEntity<>(null,HttpStatusCode.valueOf(404));
        }
        return resp;
    }

    @GetMapping("/app/item/{id}")
    public ResponseEntity<Item> getItem(@PathVariable("id") int id) {
        ResponseEntity<Item> resp;
        try{
            Item items = itemService.getItemById(id);
            resp = new ResponseEntity<>(items, HttpStatusCode.valueOf(200));

        } catch (NoSuchElementException e) {
            resp = new ResponseEntity<>(null,HttpStatusCode.valueOf(404));
        }
        return resp;
    }

    @PostMapping(value = "/app/item",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        ResponseEntity<Item> resp = null;
        try {
            itemService.addItem(item);
            resp = new ResponseEntity<>(item, HttpStatusCode.valueOf(201));
        } catch (Exception e) {
            resp = new ResponseEntity<>(null, HttpStatusCode.valueOf(400));
        }
        return resp;
    }

    @PutMapping(value = "/app/item/{id}",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<Item> updateItem(@PathVariable("id") int id,@RequestBody Item item){
        System.out.println("put id: "+id);
        System.out.println("put body: "+item.toString());
        boolean b = itemService.updateItemIfExists(item);
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
