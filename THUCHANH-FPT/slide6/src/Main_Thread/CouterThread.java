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
public class CouterThread extends Thread{
    @Override
    public synchronized void run(){
        for (int i = 0; i <= 10; i++) {
            System.out.println("thread is running: " +i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
    
    public static void main(String[] args) {
        CouterThread th1 = new CouterThread();
        Thread t1 = new Thread(th1);
        Thread t2 = new Thread(th1);
        t1.start();
        t2.start();
        System.out.println("Succesfully!!!");
    }
}
