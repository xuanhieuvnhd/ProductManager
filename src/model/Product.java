package model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public class Product implements  Serializable {
    private int id;
    private String name;
    private double price;

    public Product() {
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        Locale locale = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getInstance(locale);
        return "San pham{" +
                "Ma san pham: " + id +
                ", Ten san pham: " + name + '\'' +
                ", Gia san pham: " + numberFormat.format(price)+" VND" +
                '}';
    }
}
