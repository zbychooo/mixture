package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by natkanskiz on 08.02.2017.
 */

@org.springframework.stereotype.Controller
public class HelloCtrl {


    @RequestMapping("/hello")
    public @ResponseBody String getHello() {
        return "Hello";
    }

    @RequestMapping("/basket")
    public @ResponseBody Basket getBasket() {

        Basket basket = new Basket();
        basket.setBasketId(2015L);
        basket.addItem(new Item(111L, "item1", 493.21d));
        basket.addItem(new Item(101L, "item2", 93.1d));
        basket.addItem(new Item(110L, "item3", 3.21d));

        return basket;
    }

}
