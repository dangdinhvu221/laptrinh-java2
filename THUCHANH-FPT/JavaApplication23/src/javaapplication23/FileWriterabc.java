/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication23;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Dang Dinh Vu
 */
public class FileWriterabc {
    public static void main(String[] args) {
        
        try {
            //B1: Tạo đối tượng luồng.
            File taoFile = new File("C:\\Users\\Dang Dinh Vu\\OneDrive\\"
                    + "Máy tính\\laptrinh-java2\\THUCHANH-FPT\\UDPM.txt");
            FileWriter fileW = new FileWriter(taoFile);
            
            // B2: ghi dữ liệu
            fileW.write("Vu dep trai ");
            fileW.write("hoc gioi mai sau luong 1000$");
            
            fileW.close();
        } catch (IOException e) {
            System.out.println("Loi: " + e);
        }
    }
}
