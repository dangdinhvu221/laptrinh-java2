/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_xfile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.imageio.stream.FileImageInputStream;

/**
 *
 * @author Dang Dinh Vu
 */
public class Xfile {

    public static void WriteOb(String path, Object object) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(object);
            fos.flush();
            oos.close();
        } catch (Exception e) {
        }
    }

    public static Object ReadOb(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Object object = ois.readObject();
            fis.close();
            ois.close();
            return object;
        } catch (Exception e) {
        }
        return null;
    }
}
