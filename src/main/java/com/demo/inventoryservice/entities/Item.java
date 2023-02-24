package com.demo.inventoryservice.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;
    private String itemName;
    private String itemEnteredByUser;
    private LocalDateTime itemEnteredDate;
    private Double itemBuyingPrice;
    private Double itemSellingPrice;
    private LocalDateTime itemLastModifiedDate;
    private String itemLastModifiedUser;
    private String itemStatus;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemEnteredByUser() {
        return itemEnteredByUser;
    }

    public void setItemEnteredByUser(String itemEnteredByUser) {
        this.itemEnteredByUser = itemEnteredByUser;
    }

    public LocalDateTime getItemEnteredDate() {
        return itemEnteredDate;
    }

    public void setItemEnteredDate(LocalDateTime itemEnteredDate) {
        this.itemEnteredDate = itemEnteredDate;
    }

    public Double getItemBuyingPrice() {
        return itemBuyingPrice;
    }

    public void setItemBuyingPrice(Double itemBuyingPrice) {
        this.itemBuyingPrice = itemBuyingPrice;
    }

    public Double getItemSellingPrice() {
        return itemSellingPrice;
    }

    public void setItemSellingPrice(Double itemSellingPrice) {
        this.itemSellingPrice = itemSellingPrice;
    }

    public LocalDateTime getItemLastModifiedDate() {
        return itemLastModifiedDate;
    }

    public void setItemLastModifiedDate(LocalDateTime itemLastModifiedDate) {
        this.itemLastModifiedDate = itemLastModifiedDate;
    }

    public String getItemLastModifiedUser() {
        return itemLastModifiedUser;
    }

    public void setItemLastModifiedUser(String itemLastModifiedUser) {
        this.itemLastModifiedUser = itemLastModifiedUser;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemEnteredByUser='" + itemEnteredByUser + '\'' +
                ", itemEnteredDate=" + itemEnteredDate +
                ", itemBuyingPrice=" + itemBuyingPrice +
                ", itemSellingPrice=" + itemSellingPrice +
                ", itemLastModifiedDate=" + itemLastModifiedDate +
                ", itemLastModifiedUser='" + itemLastModifiedUser + '\'' +
                ", itemStatus='" + itemStatus + '\'' +
                '}';
    }

    public Item(int itemId, String itemName, LocalDateTime itemEnteredDate) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemEnteredDate = itemEnteredDate;
    }

    public Item() {
    }
}

