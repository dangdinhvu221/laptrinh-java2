package lab1.poly;

import java.util.ArrayList;
import java.util.Scanner;

public class QLProduct {
    ArrayList<Product> arrayList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public void khoiTao5sp() {
        arrayList.add(new Product("labtop", 340));
        arrayList.add(new Product("dien thoai", 400));
        arrayList.add(new Product("loa", 500));
        arrayList.add(new Product("ban phim", 600));
        arrayList.add(new Product("chuot", 700));
        arrayList.add(new NoTaxProduct("Kinh", 800));
        System.out.println("\n");
    }

    public void inputProduct(){
        Product pr = new Product();
        pr.input();
        arrayList.add(pr);
    }

    public void outputProduct() {
        for (Product x : arrayList) {
            x.output();
        }
    }


}
