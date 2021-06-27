/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication23;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 *
 * @author Dang Dinh Vu
 */
public class JavaApplication23 {

    static  Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            //B1: Tao doi tuong lien ket nguon du lieu
            FileOutputStream fos = new FileOutputStream("C:\\Users\\Dang Dinh Vu\\OneDrive\\Máy tính\\laptrinh-java2\\THUCHANH-FPT\\demofilefos.txt");
            DataOutputStream dos = new DataOutputStream(fos);
            
            //B2: ghi du lieu vao file
            System.out.println("Nhap: ");
            int a = Integer.parseInt(sc.nextLine());
            dos.writeInt(a);
            dos.writeDouble(9.5);
            dos.writeDouble(9.5);
            dos.writeDouble(9.5);
            
            //B3: dong luong:
            fos.flush();
            fos.close();
            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
