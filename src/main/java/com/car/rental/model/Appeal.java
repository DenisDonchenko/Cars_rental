package com.car.rental.model;

import java.time.LocalDate;

public class Appeal {
    private int id;
    private int id_auto;
    private int id_klient;
    private String date_return;
    private String place_return;
    private String date_issue;
    private String place_issue;
    private String klient_name;
    private String phone_number;
    private String name_car;
    private int count_day;
    private int price_day;
    private int all_price;
    public Appeal(){}
    public Appeal(int id, int id_auto,String name_car, int id_klient,String klient_name,String phone_number,
                  String date_return,String place_return, String date_issue,
                  String place_issue) {
        this.id = id;
        this.id_auto = id_auto;
        this.id_klient = id_klient;
        this.date_return = date_return;
        this.place_return = place_return;
        this.date_issue = date_issue;
        this.place_issue = place_issue;
        this.name_car =name_car;
        this.phone_number =phone_number;
        this.klient_name = klient_name;
    }
    public Appeal(int id_auto, int id_klient,
                  String date_return,
                  String place_return, String date_issue,
                  String place_issue,int count_day, int price_day, int all_price) {
        this.id_auto = id_auto;
        this.id_klient = id_klient;
        this.date_return = date_return;
        this.place_return = place_return;
        this.date_issue = date_issue;
        this.place_issue = place_issue;
        this.count_day = count_day;
        this.price_day = price_day;
        this.all_price = all_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_auto() {
        return id_auto;
    }

    public void setId_auto(int id_auto) {
        this.id_auto = id_auto;
    }

    public int getId_klient() {
        return id_klient;
    }

    public void setId_klient(int id_klient) {
        this.id_klient = id_klient;
    }

    public String getDate_return() {
        return date_return;
    }

    public void setDate_return(String date_return) {
        this.date_return = date_return;
    }

    public String getPlace_return() {
        return place_return;
    }

    public void setPlace_return(String place_return) {
        this.place_return = place_return;
    }

    public String getDate_issue() {
        return date_issue;
    }

    public void setDate_issue(String date_issue) {
        this.date_issue = date_issue;
    }

    public String getPlace_issue() {
        return place_issue;
    }

    public void setPlace_issue(String place_issue) {
        this.place_issue = place_issue;
    }

    public String getKlient_name() {
        return klient_name;
    }

    public void setKlient_name(String klient_name) {
        this.klient_name = klient_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getName_car() {
        return name_car;
    }

    public void setName_car(String name_car) {
        this.name_car = name_car;
    }

    public int getCount_day() {
        return count_day;
    }

    public void setCount_day(int count_day) {
        this.count_day = count_day;
    }

    public int getPrice_day() {
        return price_day;
    }

    public void setPrice_day(int price_day) {
        this.price_day = price_day;
    }

    public int getAll_price() {
        return all_price;
    }

    public void setAll_price(int all_price) {
        this.all_price = all_price;
    }
}
