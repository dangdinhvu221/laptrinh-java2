/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.JFrame;
import view.QLDSV;
import view.QLSV;
import view.login;

/**
 *
 * @author Khai2
 */
public class main extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    QLSV qlsv;
    QLDSV qldsv;
    login lg;
    public main() {
        initComponents();
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        QLSV = new javax.swing.JMenuItem();
        QLDSV = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Login = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop)
        );

        jMenu1.setText("Qu???n L??");

        QLSV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        QLSV.setText("Qu???n L?? Sinh Vi??n");
        QLSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QLSVActionPerformed(evt);
            }
        });
        jMenu1.add(QLSV);

        QLDSV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        QLDSV.setText("Qu???n L?? ??i???m Sinh Vi??n");
        QLDSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QLDSVActionPerformed(evt);
            }
        });
        jMenu1.add(QLDSV);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("T??i Kho???n");

        Login.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Login.setText("????ng nh???p");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        jMenu2.add(Login);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void QLSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLSVActionPerformed
        // TODO add your handling code here:
        if (qlsv == null || qlsv.isClosed()) {
            qlsv = new QLSV();
            Desktop.add(qlsv);
            qlsv.setLocation(this.getWidth() / 2 - qlsv.getWidth() / 2, (this.getHeight() - 20) / 2 - qlsv.getHeight() / 2 - 20);
            qlsv.setVisible(true);
        } else {
            qlsv.setLocation(this.getWidth() / 2 - qlsv.getWidth() / 2, (this.getHeight() - 20) / 2 - qlsv.getHeight() / 2 - 20);
            qlsv.setVisible(true);
        }
    }//GEN-LAST:event_QLSVActionPerformed

    private void QLDSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLDSVActionPerformed
        // TODO add your handling code here:
        if (qldsv == null || qldsv.isClosed()) {
            qldsv = new QLDSV();
            Desktop.add(qldsv);
            qldsv.setLocation(this.getWidth() / 2 - qldsv.getWidth() / 2, (this.getHeight() - 20) / 2 - qldsv.getHeight() / 2 - 20);
            qldsv.setVisible(true);
        } else {
            qldsv.setLocation(this.getWidth() / 2 - qlsv.getWidth() / 2, (this.getHeight() - 20) / 2 - qlsv.getHeight() / 2 - 20);
            qldsv.setVisible(true);
        }
    }//GEN-LAST:event_QLDSVActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        // TODO add your handling code here:
        if (lg == null || lg.isClosed()) {
            lg = new login();
            Desktop.add(lg);
            lg.setLocation(this.getWidth() / 2 - lg.getWidth() / 2, (this.getHeight() - 20) / 2 - lg.getHeight() / 2 - 20);
            lg.setVisible(true);
        } else {
            lg.setLocation(this.getWidth() / 2 - lg.getWidth() / 2, (this.getHeight() - 20) / 2 - lg.getHeight() / 2 - 20);
            lg.setVisible(true);
        }
    }//GEN-LAST:event_LoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenuItem Login;
    private javax.swing.JMenuItem QLDSV;
    private javax.swing.JMenuItem QLSV;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
