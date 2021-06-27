/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication23;

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 *
 * @author Dang Dinh Vu
 */
public class DataoutputStram {
    public static void main(String[] args) {
        try {
            // B1: Tao doi tuong luong lien ket du lieu
            FileInputStream fis = new FileInputStream("C:\\Users\\Dang Dinh Vu\\OneDrive\\Máy tính\\laptrinh-java2\\THUCHANH-FPT\\demofilefos.txt");
            DataInputStream dis = new DataInputStream(fis);
            
            // b2: Doc du lieu
            int n = dis.readInt();
            double m = dis.readDouble();
            
            // B3: Dong luong
            fis.close();
            dis.close();
            
            // Hien thi
            System.out.println("So nguyen: " + n);
            System.out.println("So thuc: " + m);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
