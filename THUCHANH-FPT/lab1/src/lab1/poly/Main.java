package lab1.poly;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QLProduct ql = new QLProduct();
        ql.khoiTao5sp();
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("1 Nhập SP");
            System.out.println("2 Xuất SP");
            System.out.println("3 Xoa sản phẩm");
            System.out.println("0 Thoát");
            System.out.println("Mời chọn: ");
            int chosse;
            chosse = Integer.parseInt(sc.nextLine());
            switch (chosse) {
                case 1:
                    ql.inputProduct();
                    break;
                case 2:
                    ql.outputProduct();
                    Product pl = new Product();
                    pl.insert();
                    pl.update();
                    pl.delete();
                    pl.select();
                    System.out.println("\n");
                    break;
                case 3:
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Bye!!");
                    break;
            }
        }while(true);
    }
}
