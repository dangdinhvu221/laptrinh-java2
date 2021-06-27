/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.SinhVien;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khai2
 */
public class QLSV extends javax.swing.JInternalFrame {

    /**
     * Creates new form QLSV
     */
    String user = "sa";
    String pass = "123456";
    String url = "jdbc:sqlserver://localhost: 1433; database = QLSV1";
    Connection conn;
    String link = "";
    List<SinhVien> ListSV = new ArrayList<>();
    DefaultTableModel model;
    int index;

    public QLSV() {
        initComponents();
        conn = getConnection();

        ListSV = fetchList();
        renderForm(ListSV);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        btnTaiLen = new javax.swing.JButton();
        lblLink = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListSV = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Quản Lí Sinh Viên");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lí Sinh Viên");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("MaSV");

        txtMaSV.setEditable(false);
        txtMaSV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("HoTen");

        txtHoTen.setEditable(false);
        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtEmail.setEditable(false);
        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Email");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("SoDT");

        txtSDT.setEditable(false);
        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("GioiTinh");

        buttonGroup1.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdoNam.setText("Nam");
        rdoNam.setEnabled(false);

        buttonGroup1.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rdoNu.setText("Nữ");
        rdoNu.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("DiaChi");

        txtDiaChi.setEditable(false);
        txtDiaChi.setColumns(20);
        txtDiaChi.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        txtDiaChi.setRows(5);
        jScrollPane1.setViewportView(txtDiaChi);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnTaiLen.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnTaiLen.setText("Tải lên");
        btnTaiLen.setEnabled(false);
        btnTaiLen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaiLenActionPerformed(evt);
            }
        });

        lblLink.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        btnNew.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/plus (2).png"))); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/close.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/save.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/refresh (2).png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        tblListSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SV", "Tên SV", "Email", "SDT", "Giới Tính", "Địa Chỉ", "Hình"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListSVMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblListSV);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logout.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(471, 471, 471)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSDT))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmail))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHoTen))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdoNam)
                                        .addGap(37, 37, 37)
                                        .addComponent(rdoNu))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMaSV))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTaiLen)
                            .addComponent(lblLink, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaSV, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rdoNam)
                                .addComponent(rdoNu)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTaiLen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLink, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(282, 282, 282))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel3, jLabel4, jLabel5, txtEmail, txtSDT});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel6, rdoNam, rdoNu});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    protected boolean checkNull() {
        if (txtMaSV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã sinh viên chưa được nhập");
            txtMaSV.requestFocus();
            return false;
        } else if (txtHoTen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Họ tên sinh viên chưa được nhập");
            txtHoTen.requestFocus();
            return false;
        } else if (txtEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email sinh viên chưa được nhập");
            txtEmail.requestFocus();
            return false;
        } else if (txtSDT.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại sinh viên chưa được nhập");
            txtSDT.requestFocus();
            return false;
        } else if (!rdoNam.isSelected() && !rdoNu.isSelected()) {
            JOptionPane.showMessageDialog(this, "Giới tính sinh viên chưa được chọn");
            return false;
        } else if (txtDiaChi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Địa chỉ sinh viên chưa được nhập");
            txtDiaChi.requestFocus();
            return false;
        } else if (lblLink.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ảnh sinh viên chưa được tải lên");
            btnTaiLen.requestFocus();
            return false;
        }
        return true;
    }

    private boolean checkEmail() {
        String Email = "\\w+@\\w+(\\.\\w+){1,2}";
        boolean check = false;
        if (!txtEmail.getText().matches(Email)) {
            JOptionPane.showMessageDialog(this, "Email không đúng định dạng");
            txtEmail.requestFocus();
            check = false;
        } else {
            check = true;
        }
        return check;
    }

    private boolean checkSDT() {
        String SDT = "0\\d{9}";
        boolean check = false;

        if (!txtSDT.getText().matches(SDT)) {
            JOptionPane.showMessageDialog(this, "Số điện không đúng định dạng");
            txtSDT.requestFocus();
            check = false;
        } else {
            check = true;
        }

        return check;
    }

    protected void renderForm(List<SinhVien> sv) {
        model = (DefaultTableModel) tblListSV.getModel();
        model.setRowCount(0);

        for (int i = 0; i < sv.size(); i++) {
            SinhVien x = sv.get(i);
            model.addRow(new Object[]{x.getMaSV(), x.getHoTen(), x.getEmail(),
                x.getSoDT(), x.getGT(), x.getDiaChi(), x.getImages()});
        }
    }

    protected void Delete() {
        index = tblListSV.getSelectedRow();
        ListSV.remove(index);
    }

    protected boolean checkMaSV() {
        boolean check = false;
        for (int i = 0; i < ListSV.size(); i++) {
            SinhVien x = ListSV.get(i);
            if (txtMaSV.getText().equalsIgnoreCase(x.getMaSV())) {
                JOptionPane.showMessageDialog(this, "Mã sinh viên đã tồn tại");
                txtMaSV.requestFocus();
                check = false;
            } else {
                check = true;
            }
        }
        return check;
    }

    protected List<SinhVien> fetchList() {
        List<SinhVien> list = new ArrayList<>();
        String query = "SELECT * FROM STUDENTS";

        try {
            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String MaSV = rs.getString("MaSV");
                String HoTen = rs.getNString("HoTen");
                String Email = rs.getString("Email");
                String SDT = rs.getString("SoDT");
                String GT = rs.getNString("GioiTinh");
                String DiaChi = rs.getString("DiaChi");
                String Images = rs.getString("Images");

                list.add(new SinhVien(MaSV, HoTen, Email, SDT, GT, DiaChi, Images));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    protected void unLock() {
        txtMaSV.setEditable(true);
        txtHoTen.setEditable(true);
        txtEmail.setEditable(true);
        txtSDT.setEditable(true);
        rdoNam.setEnabled(true);
        rdoNu.setEnabled(true);
        txtDiaChi.setEditable(true);

        btnTaiLen.setEnabled(true);
        btnSave.setEnabled(true);
        btnDelete.setEnabled(true);
        btnUpdate.setEnabled(true);
    }

    private void ClearForm() {
        txtMaSV.setText("");
        txtHoTen.setText("");
        txtEmail.setText("");
        txtSDT.setText("");
        buttonGroup1.clearSelection();
        txtDiaChi.setText("");
        lblImage.setIcon(null);
        lblLink.setText("");
    }
    private void btnTaiLenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiLenActionPerformed
        // TODO add your handling code here:
        JFileChooser jc = null;

        try {
            jc = new JFileChooser();
            jc.setCurrentDirectory(new File(System.getProperty("user.dir")));
            FileNameExtensionFilter extion = new FileNameExtensionFilter("*Images", "jpg", "png", "jpeg");
            jc.addChoosableFileFilter(extion);

            int select = jc.showOpenDialog(this);

            if (select == JFileChooser.APPROVE_OPTION) {
                link = jc.getSelectedFile().getAbsolutePath();
                ImageIcon icon = new ImageIcon(link);
                Image img = icon.getImage();
                Image new_img = img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon new_icon = new ImageIcon(new_img);
                lblImage.setIcon(new_icon);

                lblLink.setText(link);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnTaiLenActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        unLock();
        ClearForm();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        index = tblListSV.getSelectedRow();
        String query = "DELETE FROM STUDENTS WHERE MaSV = ?";
        String MaSV = tblListSV.getValueAt(index, 0).toString();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, MaSV);
            ps.execute();

            Delete();
            renderForm(ListSV);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (checkNull() && checkEmail() && checkSDT() && checkMaSV()) {
            try {
                String gt = "";
                String query = "INSERT INTO STUDENTS(MaSV, HoTen, Email, SoDT, GioiTinh,"
                        + "DiaChi, Images) OUTPUT INSERTED.MaSV VALUES(?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, txtMaSV.getText());
                ps.setNString(2, txtHoTen.getText());
                ps.setString(3, txtEmail.getText());
                ps.setString(4, txtSDT.getText());
                if (rdoNam.isSelected()) {
                    gt = "Nam";
                } else if (rdoNu.isSelected()) {
                    gt = "Nữ";
                }
                ps.setString(5, gt);
                ps.setNString(6, txtDiaChi.getText());
                ps.setString(7, lblLink.getText());

                ps.executeQuery();

                ListSV = fetchList();
                renderForm(ListSV);
                ClearForm();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String query = "UPDATE STUDENTS SET HoTen = ?, Email = ?, SoDT = ?, GioiTinh = ?,"
                + "DiaChi = ?, Images = ? WHERE MaSV = ?";
        index = tblListSV.getSelectedRow();
        String MaSV = tblListSV.getValueAt(index, 0).toString();
        String GT = "";
        if (checkNull() && checkEmail() & checkSDT()) {
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setNString(1, txtHoTen.getText());
                ps.setString(2, txtEmail.getText());
                ps.setString(3, txtSDT.getText());
                if (rdoNam.isSelected()) {
                    GT = "Nam";
                } else {
                    GT = "Nữ";
                }
                ps.setNString(4, GT);
                ps.setString(5, txtDiaChi.getText());
                ps.setString(6, lblLink.getText());
                ps.setString(7, MaSV);

                ps.execute();
                JOptionPane.showMessageDialog(this, "Update thành công");
                Update();
                renderForm(ListSV);
                tblListSV.setRowSelectionInterval(index, index);
                ClearForm();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblListSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListSVMouseClicked
        // TODO add your handling code here:
        index = tblListSV.getSelectedRow();
        if (index >= 0) {
            ShowDetails();
            unLock();
        }
    }//GEN-LAST:event_tblListSVMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        login lg = new login();
        this.getDesktopPane().add(lg);
        lg.setVisible(true);
        lg.setLocation(this.getDesktopPane().getWidth() / 2 - lg.getWidth() / 2, (this.getDesktopPane().getHeight()) / 2 - lg.getHeight() / 2);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTaiLen;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblLink;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblListSV;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtSDT;
    // End of variables declaration//GEN-END:variables
     protected void Update() {
        SinhVien sv = ListSV.get(index);
        String MaSV = txtMaSV.getText();
        String HoTen = txtHoTen.getText();
        String Email = txtEmail.getText();
        String SDT = txtSDT.getText();
        String GT = "";
        if (rdoNam.isSelected()) {
            GT = "Nam";
        } else {
            GT = "Nữ";
        }
        String DiaChi = txtDiaChi.getText();
        String Link = lblLink.getText();
        ListSV.set(index, new SinhVien(MaSV, HoTen, Email, SDT, GT, DiaChi, Link));
    }

    protected void ShowDetails() {
        SinhVien sv = ListSV.get(index);

        txtMaSV.setText(sv.getMaSV());
        txtHoTen.setText(sv.getHoTen());
        txtEmail.setText(sv.getEmail());
        txtSDT.setText(sv.getSoDT());
        if (sv.getGT().equalsIgnoreCase("Nam")) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        txtDiaChi.setText(sv.getDiaChi());
        lblImage.setIcon(new ImageIcon(new ImageIcon(sv.getImages()).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH)));
        lblLink.setText(sv.getImages());
    }
}