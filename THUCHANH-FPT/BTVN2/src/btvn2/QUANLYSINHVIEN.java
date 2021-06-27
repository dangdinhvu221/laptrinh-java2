/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btvn2;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dang Dinh Vu
 */
public class QUANLYSINHVIEN extends javax.swing.JFrame {

    int index = 0;

    ArrayList<QLSV> list = new ArrayList<>();

    /**
     * Creates new form QUANLYSINHVIEN
     */
    public QUANLYSINHVIEN() {
        initComponents();
        setResizable(false);
        setTitle("Đặng Đình Vũ");
        cboBox();
        loadData();
        setSize(670, 600);
        setLocationRelativeTo(null);

    }

    public void loadData() {
        list.add(new QLSV("Đặng Đình Vũ", 10, "Ứng dụng phần mềm"));
        list.add(new QLSV("Nguyễn Văn Đức", 10, "Ứng dụng phần mềm"));
        list.add(new QLSV("Nguyễn Xuân Quang", 10, "Thiết kế website"));
        list.add(new QLSV("Nguyễn Đức Nam", 7, "Lập trình Mobile"));
        list.add(new QLSV("Nguyễn Thị Lan", 8, "Ứng dụng phần mềm"));
        filltable();
    }

    public void cboBox() {
        String[] data = new String[]{"Ứng dụng phần mềm", "Thiết kế trang website", "Thiết kế đồ hoạ", "Lập trình Mobile"};
        cboNganh.setModel(new DefaultComboBoxModel(data));
    }

    public boolean checkTrung(String name) {
        boolean check = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equalsIgnoreCase(name)) {
                check = true;
            }
        }
        return check;
    }

    public void filltable() {
        DefaultTableModel model = (DefaultTableModel) tblQLSV.getModel();
        model.setRowCount(0);
        for (QLSV x : list) {
            model.addRow(new Object[]{x.getName(), x.getMarks(), x.getMajor(), x.getGrade(), x.isBonus()});
        }
    }

    public void Them() {
        try {
            if (txtHoVaTen.getText().isEmpty() || txtDiem.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Không được để rỗng!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                txtHoVaTen.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.red, Color.red));
                txtDiem.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.red, Color.red));
                txtHocLuc.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.red, Color.red));
            } else if (checkTrung(txtHoVaTen.getText()) == true) {
                JOptionPane.showMessageDialog(rootPane, "Bị trùng tên!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                txtHoVaTen.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.red, Color.red));
            } else {
                QLSV ql = new QLSV();
                ql.setName(txtHoVaTen.getText());
                ql.setMarks(Double.parseDouble(txtDiem.getText()));
                ql.setMajor(cboNganh.getSelectedItem() + "");
                txtHocLuc.setText(ql.getGrade());
                chkPhanThuong.setSelected(ql.isBonus());
                list.add(ql);
                filltable();
            }
        } catch (Exception e) {
        }
    }

    public void Xoa() {
        index = tblQLSV.getSelectedRow();
        try {

            if (list.size() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Không có dữ liệu để xoá !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else if (index == -1) {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                QLSV ql = list.get(index);
                list.remove(ql);
                filltable();
                JOptionPane.showMessageDialog(rootPane, "Đã xoá thành công!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
        }
    }

    public void capNhat() {
        index = tblQLSV.getSelectedRow();
        QLSV ql = list.get(index);
        ql.setName(txtHoVaTen.getText());
        ql.setMarks(Double.parseDouble(txtDiem.getText()));
        ql.setMajor(cboNganh.getSelectedItem() + "");
        filltable();
    }

    public void nhapMoi() {
        txtHoVaTen.setText("");
        txtDiem.setText("");
        cboNganh.setSelectedItem("Ứng dụng phần mềm");
        txtHocLuc.setText("");
        chkPhanThuong.setSelected(false);
    }

    public void mouseClick() {
        index = tblQLSV.getSelectedRow();
        QLSV ql = list.get(index);
        txtHoVaTen.setText(ql.getName());
        txtDiem.setText(ql.getMarks() + "");
        cboNganh.setSelectedItem(ql.getMajor());
        txtHocLuc.setText(ql.getGrade());
        chkPhanThuong.setSelected(ql.isBonus());
    }

    public void showw() {
        QLSV ql = list.get(index);
        txtHoVaTen.setText(ql.getName());
        txtDiem.setText(ql.getMarks() + "");
        txtHocLuc.setText(ql.getGrade());
        cboNganh.setSelectedItem(ql.getMajor());
        chkPhanThuong.setSelected(ql.isBonus());
    }

    public void sapXepTen() {
        Collections.sort(list, (QLSV o1, QLSV o2) -> {
            String name1 = o1.getName().split("")[o1.getName().split("").length - 1];
            String name2 = o2.getName().split("")[o2.getName().split("").length - 1];
            return name1.compareToIgnoreCase(name2);
        });
        filltable();
    }

    public void sapXepDiem() {
        Collections.sort(list, (QLSV o1, QLSV o2) -> {
            Double d1 = o1.getMarks();
            Double d2 = o2.getMarks();
            return d2.compareTo(d1);
        });
        filltable();
    }

    public void timKiem() {
        String name = JOptionPane.showInputDialog("Nhập tên cần tìm: ");

        for (QLSV x : list) {
            if (name.equalsIgnoreCase(x.getName())) {
                JOptionPane.showMessageDialog(rootPane, "Đã tìm thấy!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return;
            } else {
                JOptionPane.showMessageDialog(rootPane, "Không tìm thấy!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtHoVaTen = new javax.swing.JTextField();
        txtDiem = new javax.swing.JTextField();
        cboNganh = new javax.swing.JComboBox<>();
        txtHocLuc = new javax.swing.JTextField();
        chkPhanThuong = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblQLSV = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("QUẢN LÝ SINH VIÊN");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(221, 20, 238, 29);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("HỌ VÀ TÊN");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(69, 76, 74, 31);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("ĐIỂM");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(69, 118, 36, 31);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("NGÀNH");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(69, 160, 48, 31);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setText("HỌC LỰC");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(69, 202, 65, 31);

        txtHoVaTen.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel1.add(txtHoVaTen);
        txtHoVaTen.setBounds(199, 76, 328, 26);

        txtDiem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel1.add(txtDiem);
        txtDiem.setBounds(199, 118, 328, 29);

        cboNganh.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel1.add(cboNganh);
        cboNganh.setBounds(199, 160, 194, 31);

        txtHocLuc.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel1.add(txtHocLuc);
        txtHocLuc.setBounds(199, 203, 328, 29);

        chkPhanThuong.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        chkPhanThuong.setForeground(new java.awt.Color(204, 0, 0));
        chkPhanThuong.setText("Có phần thưởng?");
        jPanel1.add(chkPhanThuong);
        chkPhanThuong.setBounds(199, 251, 117, 23);

        jButton1.setBackground(new java.awt.Color(255, 255, 153));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 0, 0));
        jButton1.setText("THÊM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(125, 292, 67, 23);

        jButton2.setBackground(new java.awt.Color(255, 255, 153));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 0, 0));
        jButton2.setText("XOÁ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(202, 292, 59, 23);

        jButton3.setBackground(new java.awt.Color(255, 255, 153));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(204, 0, 0));
        jButton3.setText("CẬP NHẬT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(271, 292, 93, 23);

        jButton4.setBackground(new java.awt.Color(255, 255, 153));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(204, 0, 0));
        jButton4.setText("NHẬP MỚI");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(374, 292, 93, 23);

        tblQLSV.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tblQLSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "HỌ VÀ TÊN", "ĐIỂM", "NGÀNH", "HỌC LỰC", "THƯỞNG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblQLSV.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblQLSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLSVMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblQLSVMouseEntered(evt);
            }
        });
        jScrollPane3.setViewportView(tblQLSV);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(69, 333, 522, 128);

        jButton5.setBackground(new java.awt.Color(255, 255, 153));
        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(204, 0, 0));
        jButton5.setText("SẮP XẾP THEO TÊN");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(69, 492, 145, 23);

        jButton6.setBackground(new java.awt.Color(255, 255, 153));
        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(204, 0, 0));
        jButton6.setText("SẮP XẾP THEO ĐIỂM");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6);
        jButton6.setBounds(440, 492, 151, 23);

        jButton7.setBackground(new java.awt.Color(255, 255, 51));
        jButton7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 0, 0));
        jButton7.setText("<|");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7);
        jButton7.setBounds(220, 513, 43, 23);

        jButton8.setBackground(new java.awt.Color(255, 255, 51));
        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 0, 0));
        jButton8.setText("<<");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8);
        jButton8.setBounds(269, 513, 47, 23);

        jButton9.setBackground(new java.awt.Color(255, 255, 51));
        jButton9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 0, 0));
        jButton9.setText(">>");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(334, 513, 47, 23);

        jButton10.setBackground(new java.awt.Color(255, 255, 51));
        jButton10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 0, 0));
        jButton10.setText("|>");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10);
        jButton10.setBounds(391, 513, 43, 23);

        jButton11.setBackground(new java.awt.Color(255, 255, 153));
        jButton11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton11.setForeground(new java.awt.Color(204, 0, 0));
        jButton11.setText("TÌM KIẾM");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11);
        jButton11.setBounds(477, 292, 89, 23);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btvn2/1.jpg"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, -240, 660, 800);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here
        Them();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Xoa();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        capNhat();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        nhapMoi();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tblQLSVMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLSVMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblQLSVMouseEntered

    private void tblQLSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLSVMouseClicked
        // TODO add your handling code here:
        mouseClick();
    }//GEN-LAST:event_tblQLSVMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        try {
            index = 0;
            showw();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        try {
            if (index > 0) {
                index--;
                showw();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        try {
            if (index < list.size()) {
                index++;
                showw();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        try {
            index = list.size() - 1;
            showw();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        sapXepTen();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        sapXepDiem();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        timKiem();
    }//GEN-LAST:event_jButton11ActionPerformed

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
            java.util.logging.Logger.getLogger(QUANLYSINHVIEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QUANLYSINHVIEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QUANLYSINHVIEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QUANLYSINHVIEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QUANLYSINHVIEN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboNganh;
    private javax.swing.JCheckBox chkPhanThuong;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tblQLSV;
    private javax.swing.JTextField txtDiem;
    private javax.swing.JTextField txtHoVaTen;
    private javax.swing.JTextField txtHocLuc;
    // End of variables declaration//GEN-END:variables
}
