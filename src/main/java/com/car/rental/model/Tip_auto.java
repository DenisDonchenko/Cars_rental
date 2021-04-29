package com.car.rental.model;


public class Tip_auto {

    private int id;
    private String name;

    public Tip_auto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public  Tip_auto(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

