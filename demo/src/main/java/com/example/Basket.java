package com.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by natkanskiz on 08.02.2017.
 */
public class Basket implements Serializable {

    private Long basketId;
    private List<Item> items;

    public Basket(Long basketId, List<Item> items) {
        this.basketId = basketId;
        this.items = items;
    }

    public Basket() {
        this.items = new ArrayList<>();
    }

    public Long getBasketId() {
        return basketId;
    }

    public void setBasketId(Long basketId) {
        this.basketId = basketId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        if(this.items == null) {
            this.items = new ArrayList<>();
        }

        this.items.add(item);
    }
}
