package lab1.poly;

import java.util.Scanner;

public class Product implements DAO {
    private String name;
    private double price;
    static Scanner sc = new Scanner(System.in);

    public Product() {

    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
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

    public double getImportTax() {
        return getPrice() * 0.1;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                "thue NK: " + getImportTax() +
                '}';
    }

    public String khoitao(String name) {
        System.out.println(name);
        return sc.nextLine();
    }

    public double sothuc(String name) {
        System.out.println(name);
        return Double.parseDouble(sc.nextLine());
    }

    public void input() {
        khoitao("Nhập name: ");
        sothuc("Nhập price: ");
    }

    public void output() {
        System.out.println(toString());
    }

    @Override
    public void insert() {
        System.out.println("insert ok!!");
    }

    @Override
    public void update() {
        System.out.println("update ok!!");
    }

    @Override
    public void delete() {
        System.out.println("delete ok!!");
    }

    @Override
    public void select() {
        System.out.println("select ok!!");
    }
}
