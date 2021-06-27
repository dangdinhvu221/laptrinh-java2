/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btvn;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dang Dinh Vu
 */
public class NewJFrame extends javax.swing.JFrame {

    int index = 0;

    private ArrayList<DanhSachTuong> listDS = new ArrayList<>();

    String[] data = new String[]{"Tên Tướng", "Ký Năng", "Loại tướng", "Giới tính"};
    DefaultTableModel model = new DefaultTableModel(data, 0);

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
        setResizable(false);
        cbo();
        tblDsTuong.setModel(model);
        setSize(530, 620);
        img();
        img1();
        setLocationRelativeTo(null);

        listDS.add(new DanhSachTuong("ngộ không", "ngu dốt", "Trợ thủ", "Nam"));
        listDS.add(new DanhSachTuong("natalya", "ngu dốt", "Đấu sĩ", "Nữ"));
        listDS.add(new DanhSachTuong("zill", "ngu dốt", "Pháp sư", "Nam"));
        listDS.add(new DanhSachTuong("caphely", "ngu dốt", "Xạ thủ", "Nữ"));
        listDS.add(new DanhSachTuong("Vionet", "ngu dốt", "Xạ thủ", "Nữ"));
        listDS.add(new DanhSachTuong("Lữ bố", "ngu dốt", "Đấu sĩ", "Nam"));
        listDS.add(new DanhSachTuong("Zuka", "ngu dốt", "Sát thủ", "Nam"));
        fillTable();
    }

    public void img() {
        try {
            BufferedImage img = ImageIO.read(new File("1.jpg"));
            ImageIcon icon = new ImageIcon(img.getScaledInstance(120, 60, img.SCALE_SMOOTH));
            lblAnh.setIcon(icon);
        } catch (Exception e) {
        }
    }

    public void img1() {
        try {
            BufferedImage img = ImageIO.read(new File("4.jpg"));
            ImageIcon icon = new ImageIcon(img.getScaledInstance(530, 620, img.SCALE_SMOOTH));
            lblAnhnen.setIcon(icon);
        } catch (Exception e) {
        }
    }

    public boolean checkTRung(String name) {
        boolean flag = false;
        for (int i = 0; i < listDS.size(); i++) {
            if (listDS.get(i).getTenTuong().equals(name)) {
                flag = true;
            }
        }
        return flag;
    }

    public void lamMoi() {
        txtTenTuong.setText("");
        txtKyNang.setText("");
        cboLoaiTuong.setSelectedIndex(0);
        chkLuu.setSelected(false);
        rdoNam.setSelected(true);
    }

    public void cbo() {
        String[] data = {"Đấu sĩ", "Pháp sư", "Trợ thủ", "Đỡ đòn", "Sát thủ", "Xạ thủ"};
        cboLoaiTuong.setModel(new DefaultComboBoxModel(data));
        cboLoaiTuong.setBackground(Color.pink);
    }

    public void themTuong() {
        try {
            if (checkTRung(txtTenTuong.getText()) == true) {
                JOptionPane.showMessageDialog(rootPane, "Đã bị trùng tên tướng !!!", "Thông Báo!", JOptionPane.INFORMATION_MESSAGE);
                txtTenTuong.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.red, Color.red));
                txtKyNang.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.red, Color.red));
                return;
            } else if (txtTenTuong.getText().isEmpty() || txtKyNang.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Không được để rỗng !!!", "Thông Báo!", JOptionPane.INFORMATION_MESSAGE);
                txtTenTuong.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.red, Color.red));
                txtKyNang.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.red, Color.red));
            } else if (chkLuu.isSelected()) {
                String aa = rdoNam.isSelected() ? "Nam" : "Nữ";
                DanhSachTuong ds = (new DanhSachTuong(txtTenTuong.getText(), txtKyNang.getText(), cboLoaiTuong.getSelectedItem() + "", aa));
                listDS.add(ds);
                fillTable();
                JOptionPane.showMessageDialog(rootPane, "Đã thêm thành con nhà bà công <3...");
                lamMoi();
                txtTenTuong.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GREEN, Color.GREEN));
                txtKyNang.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GREEN, Color.GREEN));
            } else {
                JOptionPane.showMessageDialog(rootPane, "Bạn phải tích nút Lưu!!!!", "Thông Báo!", JOptionPane.INFORMATION_MESSAGE);
                txtTenTuong.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.red, Color.red));
                txtKyNang.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.red, Color.red));
                return;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Bạn phải tích nút Lưu!!!!");
        }

    }

    public void fillTable() {
        model.setRowCount(0);
        for (DanhSachTuong x : listDS) {
            model.addRow(new Object[]{x.getTenTuong(), x.getKyNang(), x.getLoaiTuong(), x.getGioiTinh()});
        }
    }

    public void mouClick() {
        index = tblDsTuong.getSelectedRow();
        DanhSachTuong x = listDS.get(index);
        txtTenTuong.setText(x.getTenTuong());
        txtKyNang.setText(x.getKyNang());
        cboLoaiTuong.setSelectedItem(x.getLoaiTuong());
        String role = tblDsTuong.getValueAt(index, 3) + "";
        if (role.equalsIgnoreCase("Nam")) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
    }

    public void showw() {
        DanhSachTuong ds = listDS.get(index);
        txtTenTuong.setText(ds.getTenTuong());
        txtKyNang.setText(ds.getKyNang());
        cboLoaiTuong.setSelectedItem(ds.getLoaiTuong());
        String role = tblDsTuong.getValueAt(index, 3) + "";
        if (role.equalsIgnoreCase("Nam")) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
    }

    public void Delete() {
        try {
            index = tblDsTuong.getSelectedRow();
            if (listDS.size() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Không có dữ liệu!!");
            } else if (index == -1) {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn!!");
            } else {
                listDS.remove(index);
                lamMoi();
                fillTable();
                JOptionPane.showMessageDialog(rootPane, "Xoá thành công!!!");
            }
        } catch (Exception e) {
        }
    }

    public void Update() {
        try {
            index = tblDsTuong.getSelectedRow();
            DanhSachTuong ds = listDS.get(index);
            ds.setTenTuong(txtTenTuong.getText());
            ds.setKyNang(txtKyNang.getText());
            ds.setLoaiTuong(cboLoaiTuong.getSelectedItem() + "");
            ds.setGioiTinh(rdoNam.isSelected() ? "Nam" : "Nữ");
            fillTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn!!!");
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTenTuong = new javax.swing.JTextField();
        txtKyNang = new javax.swing.JTextField();
        cboLoaiTuong = new javax.swing.JComboBox<>();
        btnThemTuong = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        chkLuu = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDsTuong = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        btnDau = new javax.swing.JButton();
        btnTien = new javax.swing.JButton();
        btnLui = new javax.swing.JButton();
        btbnCuoi = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        lblAnh = new javax.swing.JLabel();
        lblAnhnen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MinhQD8_FPolyHL");

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 102));
        jLabel2.setText("Tên tướng:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 170, 80, 17);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 102));
        jLabel3.setText("Kỹ năng:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 210, 60, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 102));
        jLabel4.setText("Loại tướng:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 260, 72, 30);
        jPanel1.add(txtTenTuong);
        txtTenTuong.setBounds(140, 170, 219, 28);
        jPanel1.add(txtKyNang);
        txtKyNang.setBounds(140, 210, 219, 28);

        cboLoaiTuong.setBackground(new java.awt.Color(204, 255, 255));
        cboLoaiTuong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cboLoaiTuong.setForeground(new java.awt.Color(255, 255, 255));
        cboLoaiTuong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cboLoaiTuong);
        cboLoaiTuong.setBounds(140, 260, 135, 25);

        btnThemTuong.setBackground(new java.awt.Color(255, 51, 51));
        btnThemTuong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnThemTuong.setForeground(new java.awt.Color(255, 255, 51));
        btnThemTuong.setText("Thêm tướng");
        btnThemTuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTuongActionPerformed(evt);
            }
        });
        jPanel1.add(btnThemTuong);
        btnThemTuong.setBounds(380, 170, 110, 28);

        btnLamMoi.setBackground(new java.awt.Color(255, 51, 51));
        btnLamMoi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 51));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        jPanel1.add(btnLamMoi);
        btnLamMoi.setBounds(380, 210, 110, 28);

        chkLuu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        chkLuu.setForeground(new java.awt.Color(255, 255, 0));
        chkLuu.setSelected(true);
        chkLuu.setText("Lưu");
        jPanel1.add(chkLuu);
        chkLuu.setBounds(310, 260, 51, 25);

        tblDsTuong.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tblDsTuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDsTuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDsTuongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDsTuong);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 390, 470, 124);

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 51));
        jButton1.setText("Siêu Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(350, 540, 99, 25);

        btnDelete.setBackground(new java.awt.Color(255, 51, 51));
        btnDelete.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 51));
        btnDelete.setText("Xoá Dữ Liệu");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete);
        btnDelete.setBounds(380, 260, 110, 28);

        buttonGroup1.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rdoNam.setForeground(new java.awt.Color(255, 255, 0));
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");
        jPanel1.add(rdoNam);
        rdoNam.setBounds(140, 300, 53, 25);

        buttonGroup1.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rdoNu.setForeground(new java.awt.Color(255, 255, 0));
        rdoNu.setText("Nữ");
        jPanel1.add(rdoNu);
        rdoNu.setBounds(210, 300, 43, 25);

        btnDau.setBackground(new java.awt.Color(255, 51, 51));
        btnDau.setForeground(new java.awt.Color(255, 255, 51));
        btnDau.setText("<|");
        btnDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDauActionPerformed(evt);
            }
        });
        jPanel1.add(btnDau);
        btnDau.setBounds(140, 350, 45, 23);

        btnTien.setBackground(new java.awt.Color(255, 51, 51));
        btnTien.setForeground(new java.awt.Color(255, 255, 51));
        btnTien.setText("<<");
        btnTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTienActionPerformed(evt);
            }
        });
        jPanel1.add(btnTien);
        btnTien.setBounds(200, 350, 49, 23);

        btnLui.setBackground(new java.awt.Color(255, 51, 51));
        btnLui.setForeground(new java.awt.Color(255, 255, 51));
        btnLui.setText(">>");
        btnLui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuiActionPerformed(evt);
            }
        });
        jPanel1.add(btnLui);
        btnLui.setBounds(270, 350, 49, 23);

        btbnCuoi.setBackground(new java.awt.Color(255, 51, 51));
        btbnCuoi.setForeground(new java.awt.Color(255, 255, 51));
        btbnCuoi.setText("|>");
        btbnCuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbnCuoiActionPerformed(evt);
            }
        });
        jPanel1.add(btbnCuoi);
        btbnCuoi.setBounds(330, 350, 45, 23);

        btnUpdate.setBackground(new java.awt.Color(255, 51, 51));
        btnUpdate.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 51));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate);
        btnUpdate.setBounds(380, 310, 110, 25);
        jPanel1.add(lblAnh);
        lblAnh.setBounds(390, 10, 120, 50);
        jPanel1.add(lblAnhnen);
        lblAnhnen.setBounds(0, 0, 520, 580);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        lamMoi();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnThemTuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTuongActionPerformed
        // TODO add your handling code here:
        themTuong();
    }//GEN-LAST:event_btnThemTuongActionPerformed

    private void tblDsTuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDsTuongMouseClicked
        // TODO add your handling code here:
        mouClick();
    }//GEN-LAST:event_tblDsTuongMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        Delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDauActionPerformed
        // TODO add your handling code here:

        try {
            index = 0;
            showw();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnDauActionPerformed

    private void btnTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTienActionPerformed
        // TODO add your handling code here:
        try {
            if (index > 0) {
                index--;
                showw();
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnTienActionPerformed

    private void btnLuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuiActionPerformed
        // TODO add your handling code here:
        try {
            if (index < listDS.size()) {
                index++;
                showw();
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnLuiActionPerformed

    private void btbnCuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbnCuoiActionPerformed
        // TODO add your handling code here:

        try {
            index = listDS.size() - 1;
            showw();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btbnCuoiActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        Update();
    }//GEN-LAST:event_btnUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbnCuoi;
    private javax.swing.JButton btnDau;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLui;
    private javax.swing.JButton btnThemTuong;
    private javax.swing.JButton btnTien;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboLoaiTuong;
    private javax.swing.JCheckBox chkLuu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblAnhnen;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblDsTuong;
    private javax.swing.JTextField txtKyNang;
    private javax.swing.JTextField txtTenTuong;
    // End of variables declaration//GEN-END:variables
}
