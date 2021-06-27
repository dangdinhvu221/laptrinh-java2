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
public class dm2 implements Runnable{

    @Override
    public void run() {
        System.out.println("thread is runniing....");
    }
    
    public static void main(String[] args) {
        dm2 t1 = new dm2();
        Thread tt1 = new Thread(t1);
        tt1.start();
    }
    
}
