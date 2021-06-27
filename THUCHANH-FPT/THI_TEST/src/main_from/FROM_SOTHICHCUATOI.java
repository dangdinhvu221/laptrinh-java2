/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_from;

import static java.lang.Thread.sleep;
import main_File.XFlie;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import main_class.SOTHICHCUATOI;

/**
 *
 * @author Dang Dinh Vu
 */
public class FROM_SOTHICHCUATOI extends javax.swing.JFrame {

    private ArrayList<SOTHICHCUATOI> list = new ArrayList<>();
    private int index = 0;

    /**
     * Creates new form FROM_SOTHICHCUATOI
     */
    public FROM_SOTHICHCUATOI() {
        initComponents();
        setLocationRelativeTo(null);
        addTitelTable();
        addListCBB();
        duLieu();
        htptt2();
        chuyenDong();
        dongHo();
    }

    public void chuyenDong() {
        new Thread() {
            @Override
            public void run() {
                String line = lblSTCT.getText();
                while (true) {
//                    line = line.substring(1, line.length()) + line.charAt(0);
                    line = line.charAt(line.length() - 1) + line.substring(0, line.length() - 1);
                    lblSTCT.setText(line);
                    try {
                        sleep(1000);
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
                int hh = 0, mm = 0, ss = 0, i = 0;
                while (true) {
                    try {
                        i++;
                        if (mm == 60) {
                            hh += 1;
                            mm = 0;
                        }
                        if (ss == 60) {
                            mm += 1;
                            ss = 0;
                        }
                        ss += 1;
                        lblTime.setText(hh + ": " + mm + ": " + ss);
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public void duLieu() {
        list.add(new SOTHICHCUATOI("đặng đình vũ", "0965528854", "NƯỚC NGỌT", "CƠM RANG"));
        list.add(new SOTHICHCUATOI("ĐỨC", "0123456789", "BIA", "CƠM LAM"));
        list.add(new SOTHICHCUATOI("LAN", "0123456789", "RƯỢU", "XÔI"));
        list.add(new SOTHICHCUATOI("MẪN", "0123456789", "RƯỢU", "CƠM RANG"));
        fillTable();
    }

    public void addTitelTable() {
        String[] data = {"HỌ TÊN", "SỐ ĐIỆN THOẠI", "ĐỒ UỐNG", "CƠM", "KẾT LUẬN"};
        tblShowSTCT.setModel(new DefaultTableModel(data, 0));
    }

    public void addListCBB() {
        String[] data = {"CƠM RANG", "CƠM LAM", "XÔI", "CƠM NẾP"};
        cboCom.setModel(new DefaultComboBoxModel<>(data));
    }

    public void clear() {
        txtHoTen.setText("");
        txtSoDT.setText("");
        chkNuocNgot.setSelected(true);
        cboCom.setSelectedIndex(index);
    }

    public void htptt2() {
        index = 1;
        showw();
        tblShowSTCT.setRowSelectionInterval(index, index);
    }

    public void showw() {
        SOTHICHCUATOI st = list.get(index);
        txtHoTen.setText(st.getHoTen());
        txtSoDT.setText(st.getSoDT());
        String role = tblShowSTCT.getValueAt(index, 2).toString();
        if (role.equalsIgnoreCase("RƯỢU")) {
            chkRuou.setSelected(true);
        } else if (role.equalsIgnoreCase("BIA")) {
            chkBia.setSelected(true);
        } else {
            chkNuocNgot.setSelected(true);
        }
        cboCom.setSelectedItem(st.getCom());
    }

    public void mouseClick(int i) {
        try {
            showw();
        } catch (Exception e) {
        }
    }

    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblShowSTCT.getModel();
        String check = chkBia.isSelected() ? "BIA" : chkRuou.isSelected() ? "RƯỢU" : "NƯỚC NGỌT";
        model.setRowCount(0);
        list.forEach(st -> {
            model.addRow(new Object[]{st.getHoTen(), st.getSoDT(), st.getUong(), st.getCom(), st.getKetLuan(check)});
        });
        model.fireTableDataChanged();
    }

    public void addDataSTCT() {
        String hoTen = txtHoTen.getText(), soDT = txtSoDT.getText();
        String pattern = "0\\d{9,10}";
        Pattern pt = Pattern.compile(pattern);
        Matcher m = pt.matcher(soDT);
        boolean lag = false;
        String doUong = chkBia.isSelected() ? "BIA" : chkRuou.isSelected() ? "RƯỢU" : "NƯỚC NGỌT";
        if (hoTen.isEmpty() || soDT.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ko rỗng");
        } else if (!m.find()) {
            JOptionPane.showMessageDialog(this, "sai sdt");
            lag = false;
        } else {
            lag = true;
            SOTHICHCUATOI st = new SOTHICHCUATOI();
            st.setHoTen(hoTen);
            st.setSoDT(soDT);
            st.setUong(doUong);
            st.setCom(cboCom.getSelectedItem().toString());
            list.add(st);
            fillTable();
            JOptionPane.showMessageDialog(this, "thêm thành công!!");
            clear();
        }
    }

    public boolean checkTrung(String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getHoTen().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void ghiFile() {
        XFlie.writeOb("listSTCT.dat", list);
    }

    public void docFile() {
        list = (ArrayList<SOTHICHCUATOI>) XFlie.readOb("listSTCT.dat");
    }

    public void Xoa() {
        index = tblShowSTCT.getSelectedRow();
        SOTHICHCUATOI st = list.get(index);
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Rỗng");
        } else if (index == -1) {
            JOptionPane.showMessageDialog(this, "Chọn!!");
        } else {
            list.remove(st);
            fillTable();
        }
    }

    public void capNhat() {
        String hoTen = txtHoTen.getText(), soDT = txtSoDT.getText();
        String doUong = chkBia.isSelected() ? "BIA" : chkRuou.isSelected() ? "RƯỢU" : "NƯỚC NGỌT";
        index = tblShowSTCT.getSelectedRow();
        SOTHICHCUATOI st = list.get(index);
        if (checkTrung(txtHoTen.getText()) == false) {
            JOptionPane.showMessageDialog(this, "ERROR");
        } else if (list.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Rỗng");
        } else if (index == -1) {
            JOptionPane.showMessageDialog(this, "Chọn!!");
        } else {
            st.setHoTen(hoTen);
            st.setSoDT(soDT);
            st.setUong(doUong);
            st.setCom(cboCom.getSelectedItem().toString());
            fillTable();
            JOptionPane.showMessageDialog(this, "CN thành công!!");
            clear();
        }
    }

    public void timKiem() {
        int i;
        String tim = JOptionPane.showInputDialog(this, "nhập thứ mà muốn tìm!!!");
        for (i = 0; i < list.size(); i++) {
            SOTHICHCUATOI st = list.get(i);
            if (list.get(i).getHoTen().contains(tim)) {
                index = i;
                showw();
                tblShowSTCT.setRowSelectionInterval(i, i);
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblSTCT = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtSoDT = new javax.swing.JTextField();
        chkRuou = new javax.swing.JRadioButton();
        chkBia = new javax.swing.JRadioButton();
        chkNuocNgot = new javax.swing.JRadioButton();
        cboCom = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblShowSTCT = new javax.swing.JTable();
        lblTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSTCT.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblSTCT.setText("SỞ THÍCH CỦA TÔI ");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("HỌ TÊN: ");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("SỐ ĐT");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("UỐNG");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("CƠM");

        txtHoTen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHoTenKeyReleased(evt);
            }
        });

        buttonGroup1.add(chkRuou);
        chkRuou.setText("RƯỢU");

        buttonGroup1.add(chkBia);
        chkBia.setText("BIA");

        buttonGroup1.add(chkNuocNgot);
        chkNuocNgot.setSelected(true);
        chkNuocNgot.setText("NƯỚC NGỌT");

        cboCom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("THÊM MỚI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("GHI");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("MỞ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("XOÁ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("CẬP NHẬT");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("TÌM");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jButton6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton6KeyReleased(evt);
            }
        });

        tblShowSTCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "null", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblShowSTCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblShowSTCTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblShowSTCT);

        lblTime.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cboCom, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chkRuou)
                        .addGap(18, 18, 18)
                        .addComponent(chkBia)
                        .addGap(18, 18, 18)
                        .addComponent(chkNuocNgot)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSTCT)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTime)
                                .addGap(43, 43, 43)))))
                .addGap(37, 37, 37))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSTCT)
                    .addComponent(lblTime))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chkRuou)
                        .addComponent(chkBia)
                        .addComponent(chkNuocNgot)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboCom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            addDataSTCT();
            ghiFile();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        docFile();
        fillTable();
//        try {
//            if (list.size() > 0) {
//                index = 0;
//                fillTable();
//            } else {
//                index = -1;
//                clear();
//            }
//        } catch (Exception e) {
//        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Xoa();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            capNhat();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        timKiem();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tblShowSTCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblShowSTCTMouseClicked
        // TODO add your handling code here:
        index = tblShowSTCT.getSelectedRow();
        mouseClick(index);
    }//GEN-LAST:event_tblShowSTCTMouseClicked

    private void jButton6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton6KeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton6KeyReleased

    private void txtHoTenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoTenKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenKeyReleased

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
            java.util.logging.Logger.getLogger(FROM_SOTHICHCUATOI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FROM_SOTHICHCUATOI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FROM_SOTHICHCUATOI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FROM_SOTHICHCUATOI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FROM_SOTHICHCUATOI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboCom;
    private javax.swing.JRadioButton chkBia;
    private javax.swing.JRadioButton chkNuocNgot;
    private javax.swing.JRadioButton chkRuou;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSTCT;
    private javax.swing.JLabel lblTime;
    private javax.swing.JTable tblShowSTCT;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtSoDT;
    // End of variables declaration//GEN-END:variables
}
