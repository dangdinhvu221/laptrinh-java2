package lab1.poly;

import java.util.Scanner;

public class NoTaxProduct extends Product{
    boolean tt;

    public NoTaxProduct(){
        super();
    }

    public NoTaxProduct(String name, double price) {
        super(name, price);
    }

    @Override
    public double getImportTax() {
        return 0;
    }

    @Override
    public void input() {
        super.input();
        System.out.println("Sản phẩm tính thuế hay không?");
        Scanner sc = new Scanner(System.in);
        tt = sc.nextBoolean();
    }

    @Override
    public void output() {
        super.output();
        if (tt == true) {
            System.out.println("Thuế NK: " + this.getImportTax());
        }else {
            System.out.println("Thuế NK: " + super.getImportTax());
        }
    }
}
