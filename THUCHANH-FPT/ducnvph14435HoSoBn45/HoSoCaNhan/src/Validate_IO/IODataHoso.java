/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validate_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Đức DEV
 */
public class IODataHoso {

    public static Object readObject(String path) throws Exception{
        FileInputStream fii = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fii);
        Object obj = ois.readObject();
        return obj;
    }
    
    public static void writeObject(String path, Object obj) throws IOException{
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
    }
}
