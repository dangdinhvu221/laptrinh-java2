/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threadd;

import static java.lang.Thread.sleep;

/**
 *
 * @author Dang Dinh Vu
 */
public class NewClass {
    
    public void chuyenDong() {
        new Thread() {
            @Override
            public void run() {
                String line = lblSTCT.getText();
                while (true) {
                    line = line.substring(1, line.length()) + line.charAt(0);
                    lblSTCT.setText(line);
                    try {
                        sleep(100);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        }.start();
    }

    public void dongHo() {
        new Thread() {
            @Override
            public void run() {
                int hh = 0, mm = 0, aa = 0, i = 0;
                while (true) {
                    try {
                        i++;
                        if (mm == 60) {
                            hh += 1;
                            mm = 0;
                        }
                        if (aa == 60) {
                            mm += 1;
                            aa = 0;
                        }
                        aa += 1;
                        lblTime.setText(hh + ": " + mm + ": " + aa);
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
