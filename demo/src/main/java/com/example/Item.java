package com.example;

import java.io.Serializable;
import java.util.DoubleSummaryStatistics;

/**
 * Created by natkanskiz on 08.02.2017.
 */
public class Item implements Serializable {

    private Long id;
    private String name;
    private Double prize;

    public Item(Long id, String name, Double prize) {
        this.id = id;
        this.name = name;
        this.prize = prize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrize() {
        return prize;
    }

    public void setPrize(Double prize) {
        this.prize = prize;
    }
}
