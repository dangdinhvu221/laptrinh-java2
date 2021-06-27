/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_Thread;

/**
 *
 * @author Dang Dinh Vu
 */
public class MyRunnable implements Runnable {

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(" " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
        System.out.println("Thread is running....");
    }

    public static void main(String[] args) {
        MyRunnable m1 = new MyRunnable();
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m1);

        t1.start();
        t2.start();
    }
}
