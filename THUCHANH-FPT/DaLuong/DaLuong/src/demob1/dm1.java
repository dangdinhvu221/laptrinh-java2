/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demob1;

/**
 *
 * @author Đức DEV
 */
public class dm1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Threa is running ... " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        dm1 t1 = new dm1();
        t1.start();
        dm1 t2 = new dm1();
        t2.start();
    }
}
