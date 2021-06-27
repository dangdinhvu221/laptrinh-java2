
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dang Dinh Vu
 */
public class Xfile {

    public static void writeOb(String path, Object object) {
        // tạo luồng dữ liệu
        try (FileOutputStream fos = new FileOutputStream(path);
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            // ghi dữ liệu vào file
            oos.writeObject(object);
            oos.close();
        } catch (Exception e) {
        }
    }

    public static Object readOb(String path) {
        // tạo luồng dữ liệu
        try (FileInputStream fis = new FileInputStream(path);
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            // đọc dữ liệu từ file
            Object object = ois.readObject();
            return object;
        } catch (Exception e) {
        }
        return null;
    }

    static ArrayList<KhachHang> ReadOb(String qlkHdat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
