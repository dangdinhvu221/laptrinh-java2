package lab3;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dang Dinh Vu
 */
public class QLSV extends javax.swing.JFrame {

    int index = 0;
    StudentList svL = new StudentList();
    String[] data = new String[]{"HỌ VÀ TÊN", "ĐIỂM", "NGÀNH", "HỌC LỰC", "THƯỞNG"};
    DefaultTableModel model = new DefaultTableModel(data, 0);

    public QLSV() {
        initComponents();
        this.setLocationRelativeTo(null);
        cboBox();
        tblDssv.setModel(model);
    }

    public void cboBox() {
        String[] data = new String[]{"Thiết kế trang web", "Ứng dụng phần mềm", "Thiết kế đồ hoạ", "Lập trình Mobile"};
        cboNganh.setModel(new DefaultComboBoxModel(data));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblFullname = new javax.swing.JLabel();
        lblDiem = new javax.swing.JLabel();
        lblNganh = new javax.swing.JLabel();
        lblHocLuc = new javax.swing.JLabel();
        txtFullname = new javax.swing.JTextField();
        txtDiem = new javax.swing.JTextField();
        cboNganh = new javax.swing.JComboBox<>();
        txtHocLuc = new javax.swing.JTextField();
        chkPhanThuong = new javax.swing.JCheckBox();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnNhapMoi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDssv = new javax.swing.JTable();
        lblSortname = new javax.swing.JButton();
        lblSortMark = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 102));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("QUẢN LÝ SINH VIÊN");

        lblFullname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblFullname.setText("HỌ VÀ TÊN");

        lblDiem.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblDiem.setText("ĐIỂM");

        lblNganh.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblNganh.setText("NGÀNH");

        lblHocLuc.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblHocLuc.setText("HỌC LỰC");

        cboNganh.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        cboNganh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        chkPhanThuong.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        chkPhanThuong.setText("Có phần thưởng?");

        btnThem.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnXoa.setText("XOÁ");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnCapNhat.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnCapNhat.setText("CẬP NHẬT");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnNhapMoi.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnNhapMoi.setText("NHẬP MỚI");
        btnNhapMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapMoiActionPerformed(evt);
            }
        });

        tblDssv.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDssv.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                tblDssvAncestorRemoved(evt);
            }
        });
        tblDssv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDssvMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDssv);

        lblSortname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblSortname.setText("Sắp xếp theo tên");
        lblSortname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblSortnameActionPerformed(evt);
            }
        });

        lblSortMark.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblSortMark.setText("Sắp xếp theo điểm");
        lblSortMark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblSortMarkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFullname)
                    .addComponent(lblDiem, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNganh, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHocLuc, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSortname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSortMark))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboNganh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHocLuc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(chkPhanThuong, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnThem)
                            .addGap(18, 18, 18)
                            .addComponent(btnXoa)
                            .addGap(18, 18, 18)
                            .addComponent(btnCapNhat)
                            .addGap(18, 18, 18)
                            .addComponent(btnNhapMoi))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(106, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(220, 220, 220))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFullname)
                    .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiem)
                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNganh, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHocLuc)
                    .addComponent(txtHocLuc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(chkPhanThuong)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnCapNhat)
                    .addComponent(btnNhapMoi))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSortMark)
                    .addComponent(lblSortname))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // button event THem
        Student st = new Student();
        st.name = txtFullname.getText();
        st.marks = Double.parseDouble(txtDiem.getText());
        st.major = cboNganh.getSelectedItem().toString();
        txtHocLuc.setText(st.getGrade());
        chkPhanThuong.setSelected(st.isBonus());

        add(st);
        loadTable();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int r = tblDssv.getSelectedRow();
        svL.list.remove(r);
        loadTable();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblDssvAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblDssvAncestorRemoved
        // TODO add your handling code here:.
        int r = tblDssv.getSelectedRow();
        txtFullname.setText(tblDssv.getValueAt(r, 1).toString());
        txtDiem.setText(tblDssv.getValueAt(r, 2).toString());
        cboNganh.setSelectedItem(tblDssv.getValueAt(r, 2).toString());
        txtHocLuc.setText(tblDssv.getValueAt(r, 3).toString());

        String thuong = (tblDssv.getValueAt(r, 4).toString());
        if (thuong.equalsIgnoreCase("true")) {
            chkPhanThuong.setSelected(true);
        } else {
            chkPhanThuong.setSelected(false);
        }
    }//GEN-LAST:event_tblDssvAncestorRemoved

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        int r = tblDssv.getSelectedRow();
        Student sv = svL.list.get(r);
        sv.name = txtFullname.getText();
        sv.marks = Double.parseDouble(txtDiem.getText());
        sv.major = (String) cboNganh.getSelectedItem();
        txtHocLuc.setText(sv.getGrade());
        chkPhanThuong.setSelected(sv.isBonus());
        loadTable();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnNhapMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapMoiActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btnNhapMoiActionPerformed

    private void lblSortnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblSortnameActionPerformed
        // TODO add your handling code here:
        Collections.sort(svL.list, sxname);
        loadTable();
    }//GEN-LAST:event_lblSortnameActionPerformed

    private void lblSortMarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblSortMarkActionPerformed
        // TODO add your handling code here:
        Collections.sort(svL.list, sxmark);
        loadTable();
    }//GEN-LAST:event_lblSortMarkActionPerformed

    private void tblDssvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDssvMouseClicked
        // TODO add your handling code here:
        index = tblDssv.getSelectedRow();
        Student x = svL.list.get(index);
        txtFullname.setText(x.name);
        txtDiem.setText(x.marks + "");
        txtHocLuc.setText(x.getGrade());
        chkPhanThuong.setSelected(x.isBonus());
    }//GEN-LAST:event_tblDssvMouseClicked
    public void add(Student st) {
        svL.them(st);
    }

    public void loadTable() {
        model.setRowCount(0);
        Object rowData[] = new Object[5];
        for (int i = 0; i < svL.list.size(); i++) {
            rowData[0] = svL.list.get(i).name;
            rowData[1] = svL.list.get(i).marks;
            rowData[2] = svL.list.get(i).major;
            rowData[3] = svL.list.get(i).getGrade();
            rowData[4] = svL.list.get(i).isBonus();
            model.addRow(rowData);
        }
    }

    public void reset() {
        txtFullname.setText("");
        txtDiem.setText("");
        cboNganh.setSelectedItem("Thiết kế trang web");
        txtHocLuc.setText("");
        chkPhanThuong.setSelected(false);
    }

    Comparator<Student> sxname = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            String name1 = o1.name.split(" ")[o1.name.split(" ").length - 1];
            String name2 = o2.name.split(" ")[o2.name.split(" ").length - 1];
            return name1.compareToIgnoreCase(name2);
        }
    };

    Comparator<Student> sxmark = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            Double d1 = o1.marks;
            Double d2 = o2.marks;
            return d2.compareTo(d1);
        }
    };

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
            java.util.logging.Logger.getLogger(QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLSV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLSV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnNhapMoi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboNganh;
    private javax.swing.JCheckBox chkPhanThuong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDiem;
    private javax.swing.JLabel lblFullname;
    private javax.swing.JLabel lblHocLuc;
    private javax.swing.JLabel lblNganh;
    private javax.swing.JButton lblSortMark;
    private javax.swing.JButton lblSortname;
    private javax.swing.JTable tblDssv;
    private javax.swing.JTextField txtDiem;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JTextField txtHocLuc;
    // End of variables declaration//GEN-END:variables
}
