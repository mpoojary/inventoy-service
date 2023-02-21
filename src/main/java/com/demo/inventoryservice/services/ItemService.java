package com.demo.inventoryservice.services;

import com.demo.inventoryservice.entities.Item;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    private List<Item> itemList;

    @PostConstruct
    private void addIniItems() {
        itemList = new ArrayList<>();
        LocalDateTime localDateTime = LocalDateTime.now();
        itemList.add(new Item(100,"Gear box",localDateTime));
        itemList.add(new Item(200,"Tyre",localDateTime.minusHours(2)));
        itemList.add(new Item(300,"Break pads",localDateTime.minusHours(3)));
    }

    public List<Item> getItemList () {
        return itemList;
    }

    public Item getItemById(int id) {
        return itemList
                .stream()
                .filter(s->s.getItemId()==id)
                .findAny()
                .orElse(null);
    }

    public boolean addItem(Item item) {
        if(itemList.stream().anyMatch(s->s.getItemId()==item.getItemId())) {
            return false;
        } else {
            itemList.add(item);
            return true;
        }
    }
}
