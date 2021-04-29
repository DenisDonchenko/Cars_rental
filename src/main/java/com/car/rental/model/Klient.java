package com.car.rental.model;

public class Klient {
    private int id;
    private String first_name;
    private String last_name;
    private String patronymic;
    private String phone_number;

    public Klient(){    }
    public Klient(int id, String first_name, String last_name,
                  String patronymic, String phone_number) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.patronymic = patronymic;
        this.phone_number = phone_number;
    }
    public Klient( String first_name, String last_name,
                   String patronymic, String phone_number) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.patronymic = patronymic;
        this.phone_number = phone_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}

