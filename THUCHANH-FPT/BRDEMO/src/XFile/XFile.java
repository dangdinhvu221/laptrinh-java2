/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Dang Dinh Vu
 */
public class XFile {

    public static void writeOb(String path, Object object) {
        try (FileOutputStream fos = new FileOutputStream(path);
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {

            oos.writeObject(object);
        } catch (Exception e) {
        }
    }

    public static Object readOb(String path) {
        try (FileInputStream fis = new FileInputStream(path);
                ObjectInputStream ois = new ObjectInputStream(fis)) {

            Object object = ois.readObject();
            return object;
        } catch (Exception e) {
        }
        return null;
    }
}
