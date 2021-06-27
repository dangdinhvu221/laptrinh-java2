/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication23;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Dang Dinh Vu
 */
public class FileReaderEX {

    public static void main(String[] args) {
        try {
            // B1 : tao doi tuong  
            File taoFile = new File("C:\\Users\\Dang Dinh Vu\\OneDrive\\Máy tính\\laptrinh-java2\\THUCHANH-FPT\\UDPM.txt");
            FileReader filedoc = new FileReader(taoFile);
            
            // doc du lieu
            BufferedReader br = new BufferedReader(filedoc);
            String s;
            int i = 0;
            while((s = br.readLine()) != null){
                i++;
                System.out.println(i+ "" + s);
            }
            
            // dong luong
            filedoc.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
