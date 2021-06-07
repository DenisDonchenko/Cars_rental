package com.car.rental.model;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class Auto {
    private int id;

    @NotEmpty(message = "Пусту ")
    @Pattern(regexp = "^[A-Za-zА-Яа-я0-9]+$",message = "Некоректный ввод данных")
    private String marka; // марка авто

    @Pattern(regexp = "^[A-Za-zА-Яа-я0-9]+$",message = "Некоректный ввод данных")
    @NotEmpty(message = "Вводимое поле пустое")
    private String model; // модель авто

    private int tip;   // тип авто

    @NotEmpty(message = "Вводимое поле пустое")
    @Pattern(regexp = "^\\d{4}$",message = "Некоректный ввод данных")
    private String age;

    @Min(value = 0, message = "Age should be greater than 0")
/*    @Pattern(regexp = "^\\d+$",message = "Некоректный ввод данных")*/
    private int price_rental; // цена проката

    @NotEmpty(message = "Вводимое поле пустое")
    private String fuel_tupe; // тип топлива

   // @Pattern(regexp = "^[0-9]*$",message = "Некоректный ввод данных")
   @Min(0)
   @Max(9999)
    private int count_passenger; // количество пасажиров

    @NotEmpty(message = "Вводимое поле пустое")
    @Pattern(regexp = "^[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*$", message = "Некоректный ввод данных")
    private String engine_volume; // объем двигателя

    @NotEmpty(message = "Вводимое поле пустое")
    private String tip_transmission; // тип коробки передач

    @Min(value = 0, message = "Age should be greater than 0")
  //  @Pattern(regexp = "^[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*$",message = "Некоректный ввод данных")
    private double percent; // процент снижения цены

    @NotEmpty(message = "Вводимое поле пустое")
    private String tip_unit; // тип привода

    @NotEmpty(message = "Вводимое поле пустое")
    private String photo_auto; // фото авто

    private boolean  availability; // возможность проката ( 1 || 0 )

    private int price1;
    private int price2;
    private int price3;
    private int price4;
    private int price5;
    public Auto() {

    }

    public Auto(int id, String marka, String model, int tip, String age,
                int price_rental, String fuel_tupe, int count_passenger,
                String engine_volume, String tip_transmission,double percent,
                String tip_unit, String photo_auto, boolean availability, int price1,
                int price2, int price3, int price4, int price5) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.tip = tip;
        this.age = age;
        this.price_rental = price_rental;
        this.fuel_tupe = fuel_tupe;
        this.count_passenger = count_passenger;
        this.engine_volume = engine_volume;
        this.tip_transmission = tip_transmission;
        this.percent = percent;
        this.tip_unit = tip_unit;
        this.photo_auto = photo_auto;
        this.availability = availability;
        this.price1 = price1;
        this.price2 = price2;
        this.price3 = price3;
        this.price4 = price4;
        this.price5 = price5;
    }

    public int getPrice1() {
        return price1;
    }

    public void setPrice1(int price1) {
        this.price1 = price1;
    }

    public int getPrice2() {
        return price2;
    }

    public void setPrice2(int price2) {
        this.price2 = price2;
    }

    public int getPrice3() {
        return price3;
    }

    public void setPrice3(int price3) {
        this.price3 = price3;
    }

    public int getPrice4() {
        return price4;
    }

    public void setPrice4(int price4) {
        this.price4 = price4;
    }

    public int getPrice5() {
        return price5;
    }

    public void setPrice5(int price5) {
        this.price5 = price5;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

    public int getPrice_rental() {
        return price_rental;
    }

    public void setPrice_rental(int price_rental) {
        this.price_rental = price_rental;
    }

    public String getFuel_tupe() {
        return fuel_tupe;
    }

    public void setFuel_tupe(String fuel_tupe) {
        this.fuel_tupe = fuel_tupe;
    }

    public int getCount_passenger() {
        return count_passenger;
    }

    public void setCount_passenger(int count_passenger) {
        this.count_passenger = count_passenger;
    }

    public String getEngine_volume() {
        return engine_volume;
    }

    public void setEngine_volume(String engine_volume) {
        this.engine_volume = engine_volume;
    }

    public String getTip_transmission() {
        return tip_transmission;
    }

    public void setTip_transmission(String tip_transmission) {
        this.tip_transmission = tip_transmission;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public String getTip_unit() {
        return tip_unit;
    }

    public void setTip_unit(String tip_unit) {
        this.tip_unit = tip_unit;
    }

    public String getPhoto_auto() {
        return photo_auto;
    }

    public void setPhoto_auto(String photo_auto) {
        this.photo_auto = photo_auto;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

}
