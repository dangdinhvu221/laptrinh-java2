/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package From_main;

import javax.swing.table.DefaultTableModel;
import Class_main.HoSo;
import Validate_IO.Validate;
import Class_main.managerHoSo;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Đức DEV
 */
public class HoSo_From extends javax.swing.JFrame {

    DefaultTableModel tblModel = null;
    managerHoSo hsList = new managerHoSo();

    /**
     * Creates new form HoSo_From
     */
    public HoSo_From() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        addTitlerCol();
        addMajor();
        rdiMale.setSelected(true);
//        addListData();
    }

    public void loadHosoFile() {
        try {
            hsList.laodFiletoTable();
            hsList.renderFile(tblModel);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR: " + e.getMessage());
        }
    }

    public void addTitlerCol() {
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(new Object[]{
            "Tên", "Giới Tính", "Ngàng", "Kỹ Năng"
        });

        tableShowData.setModel(tblModel);
    }

    public void addMajor() {
        String[] data = {
            "Ứng Dụng", "Kinh Tế", "Xây Dựng", "AI", "IOT", "Mobile"
        };
        cbbMajor.setModel(new DefaultComboBoxModel(data));

    }

//    public void addListData() {
//        hsList.add(new HoSo("g", "Nam", "Ngủ", "Mõm"));
//        hsList.add(new HoSo("f", "Nữ", "Code", "Mõm2"));
//        hsList.add(new HoSo("a", "Nữ", "Hack", "Mõm3"));
//        hsList.add(new HoSo("h", "Nam", "Ngủ", "Mõm4"));
//        hsList.add(new HoSo("f", "Nữ", "Code", "Mõm5"));
//        
//        hsList.showTable(tblModel);
//
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableShowData = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        rdiMale = new javax.swing.JRadioButton();
        rdiFmale = new javax.swing.JRadioButton();
        cbbMajor = new javax.swing.JComboBox<>();
        txtSkills = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnOpenFile = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSaveFile = new javax.swing.JButton();
        btnSortName = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Hồ Sơ Cá Nhân");

        tableShowData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableShowData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableShowDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableShowData);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Họ Tên: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Giới Tính: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Ngành Học: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Kỹ Năng: ");

        buttonGroup1.add(rdiMale);
        rdiMale.setText("Nam");

        buttonGroup1.add(rdiFmale);
        rdiFmale.setText("Nữ");

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Xoá");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnOpenFile.setText("OpenFile");
        btnOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenFileActionPerformed(evt);
            }
        });

        btnReset.setText("Làm Mới");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnSaveFile.setText("SaveFile");
        btnSaveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveFileActionPerformed(evt);
            }
        });

        btnSortName.setText("SX Theo Tên");
        btnSortName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtName)
                    .addComponent(cbbMajor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(rdiMale)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdiFmale))
                    .addComponent(txtSkills, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd)
                            .addComponent(btnDelete)
                            .addComponent(btnOpenFile))
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSaveFile)
                            .addComponent(btnUpdate)
                            .addComponent(btnReset)))
                    .addComponent(btnSortName))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAdd)
                        .addComponent(btnReset)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(rdiMale)
                            .addComponent(rdiFmale)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete)
                            .addComponent(btnUpdate))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbbMajor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnOpenFile)
                            .addComponent(btnSaveFile))))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSkills, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSortName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(342, 342, 342)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddHoSo() {
        StringBuilder builder = new StringBuilder();
        Validate.checkEmpty(txtName, builder, "Tên Không Để Trống");
        Validate.checkEmpty(txtSkills, builder, "Kỹ Năng Không để trống");
        Validate.checkNumber(txtName, builder);

        if (builder.length() > 0) {
            JOptionPane.showMessageDialog(this, builder.toString(), "Invalid Data", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String gender = rdiMale.isSelected() ? "Nam" : "Nữ";
        HoSo hs = new HoSo();
        if (hsList.checkTrung(txtName.getText()) == true) {
            JOptionPane.showMessageDialog(this, "Trùng");
            return;
        }
        hs.setName(txtName.getText());
        hs.setSkills(txtSkills.getText());
        hs.setMajor(cbbMajor.getSelectedItem().toString());
        hs.setGender(gender);
        hsList.add(hs);
        hsList.showTable(tblModel);
        JOptionPane.showMessageDialog(this, "Thêm Thành Công");

    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        btnAddHoSo();
    }//GEN-LAST:event_btnAddActionPerformed

    public void deleteFrom() {
        try {
            boolean isDelete = hsList.deleteHs(txtName.getText());
            if (isDelete) {
                hsList.showTable(tblModel);
                JOptionPane.showMessageDialog(this, "Xoá Thành Công");
                Reset();
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy để xoá");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());

        }

    }
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        deleteFrom();
    }//GEN-LAST:event_btnDeleteActionPerformed

    public void Reset() {
        txtName.setText("");
        txtSkills.setText("");
        cbbMajor.setSelectedIndex(0);

    }
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        Reset();
    }//GEN-LAST:event_btnResetActionPerformed

    public void updateFrom() {
        try {
            int index = tableShowData.getSelectedRow();
            if (index == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn...");
            } else {
                HoSo hs = hsList.listHs.get(index);
                hs.setName(txtName.getText());
                String gender = rdiMale.isSelected() ? "Nam" : "Nữ";
                hs.setGender(gender);
                hs.setMajor(cbbMajor.getSelectedItem().toString());
                hs.setSkills(txtSkills.getText());
                hsList.showTable(tblModel);
                JOptionPane.showMessageDialog(this, "Update thành công");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn...");

        }

    }
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        updateFrom();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tableShowDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableShowDataMouseClicked
        // TODO add your handling code here:
        DefaultTableModel tblModel = (DefaultTableModel) tableShowData.getModel();
        int index = tableShowData.getSelectedRow();
        txtName.setText(tblModel.getValueAt(index, 0).toString());
        String indexGender = tableShowData.getValueAt(index, 1) + "";
        if (indexGender.equals("Nam")) {
            rdiMale.setSelected(true);
        } else {
            rdiFmale.setSelected(true);
        }
        cbbMajor.setSelectedItem(tblModel.getValueAt(index, 2));
        txtSkills.setText(tblModel.getValueAt(index, 3).toString());
    }//GEN-LAST:event_tableShowDataMouseClicked

    private void btnSortNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortNameActionPerformed
        // TODO add your handling code here:
        hsList.sortName();
        hsList.showTable(tblModel);
    }//GEN-LAST:event_btnSortNameActionPerformed

    private void btnOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenFileActionPerformed
        // TODO add your handling code here:
        try {
//            hsList.laodFiletoTable();
            loadHosoFile();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR: " + e.getMessage());
        }
    }//GEN-LAST:event_btnOpenFileActionPerformed

    private void btnSaveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveFileActionPerformed
        // TODO add your handling code here:
        try {
            hsList.saveFileToTable();
            JOptionPane.showMessageDialog(this, "Lưu File Thành Công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR" + e.getMessage());
        }
    }//GEN-LAST:event_btnSaveFileActionPerformed

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
            java.util.logging.Logger.getLogger(HoSo_From.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoSo_From.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoSo_From.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoSo_From.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoSo_From().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnOpenFile;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSaveFile;
    private javax.swing.JButton btnSortName;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbMajor;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdiFmale;
    private javax.swing.JRadioButton rdiMale;
    private javax.swing.JTable tableShowData;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSkills;
    // End of variables declaration//GEN-END:variables
}
