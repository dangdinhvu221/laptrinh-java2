/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Controller.QLD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khai2
 */
public class QLDSV extends javax.swing.JInternalFrame {

    /**
     * Creates new form QLDSV
     */
    int i = 0;
    String user = "sa";
    String pass = "123456";
    String url = "jdbc:sqlserver://localhost: 1433; database = QLSV1";
    Connection conn;
    List<QLD> ListDSV = new ArrayList<>();
    DefaultTableModel model;
    int index = -1;

    public QLDSV() {
        initComponents();

        conn = getConnection();
        ListDSV = fetchList();
        renderList(ListDSV);
    }

    protected void renderList(List<QLD> list) {
        model = (DefaultTableModel) tblListDSV.getModel();
        model.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            QLD x = list.get(i);
            DecimalFormat dcf = new DecimalFormat("#.##");
            model.addRow(new Object[]{x.getMaSV(), x.getTenSV(), x.getTiengAnh(),
                x.getTinHoc(), x.getGDTC(), dcf.format(x.getDTB())});
        }
    }

    protected List<QLD> fetcListDB() {
        List<QLD> list = new ArrayList<>();
        String query = "SELECT ID, GRADE.MaSV, HoTen, TiengAnh, TinHoc, GDTC FROM GRADE INNER JOIN STUDENTS ON STUDENTS.MaSV = GRADE.MaSV\n"
                + "GROUP BY ID, GRADE.MaSV, HoTen, TiengAnh, TinHoc, GDTC \n"
                + "ORDER BY AVG(TiengAnh + TinHoc + GDTC) DESC";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt(1);
                String MaSV = rs.getString(2);
                String TenSV = rs.getNString(3);
                double TiengAnh = rs.getDouble(4);
                double TinHoc = rs.getDouble(5);
                double GDTC = rs.getDouble(6);
                double DTB = (TiengAnh + TinHoc + GDTC) / 3;
//                DecimalFormat dcf = new DecimalFormat("#.##");
                list.add(new QLD(ID, MaSV, TenSV, TiengAnh, TinHoc, GDTC, DTB));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    protected List<QLD> fetchList() {
        List<QLD> list = new ArrayList<QLD>();
        String query = "SELECT TOP 3 ID, GRADE.MaSV, HoTen, TiengAnh, TinHoc, GDTC FROM GRADE INNER JOIN STUDENTS ON STUDENTS.MaSV = GRADE.MaSV\n"
                + "GROUP BY ID, GRADE.MaSV, HoTen, TiengAnh, TinHoc, GDTC \n"
                + "ORDER BY AVG(TiengAnh + TinHoc + GDTC) DESC";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt(1);
                String MaSV = rs.getString(2);
                String TenSV = rs.getNString(3);
                double TiengAnh = rs.getDouble(4);
                double TinHoc = rs.getDouble(5);
                double GDTC = rs.getDouble(6);
                double DTB = (TiengAnh + TinHoc + GDTC) / 3;
//                DecimalFormat dcf = new DecimalFormat("#.##");
                list.add(new QLD(ID, MaSV, TenSV, TiengAnh, TinHoc, GDTC, DTB));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

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

    protected boolean checkTK() {
        if (txtTKMaSV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã sinh viên chưa được nhập");
            txtTKMaSV.requestFocus();
            return false;
        }
        return true;
    }

    protected void FindSV(List<QLD> list) {
        for (int i = 0; i < list.size(); i++) {
            QLD x = list.get(i);
            if (txtTKMaSV.getText().equalsIgnoreCase(x.getMaSV())) {
                index = i;
                ShowDetails();
                tblListDSV.setRowSelectionInterval(index, index);
                return;
            }

        }
    }

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (checkTK()) {
            try {
                String query = "SELECT GRADE.MaSV, HoTen, TiengAnh,"
                        + "TinHoc, GDTC FROM GRADE INNER JOIN STUDENTS"
                        + " ON STUDENTS.MaSV = GRADE.MaSV WHERE GRADE.MaSV = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, txtTKMaSV.getText());

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
//                    String MaSV = rs.getString("MaSv");
                    btnSave.setEnabled(true);
                    btnDelete.setEnabled(true);
                    btnUpdate.setEnabled(true);
                    txtTiengAnh.setEditable(true);
                    txtTinHoc.setEditable(true);
                    txtGDTC.setEditable(true);

                    txtMaSV.setText(rs.getString(1));
                    lblHoTen.setText(rs.getNString(2));
                    txtTiengAnh.setText(rs.getDouble(3) + "");
                    txtTinHoc.setText(rs.getDouble(4) + "");
                    txtGDTC.setText(rs.getDouble(5) + "");
                    double DTB = (Double.parseDouble(txtTiengAnh.getText())
                            + Double.parseDouble(txtTinHoc.getText())
                            + Double.parseDouble(txtGDTC.getText())) / 3;
                    DecimalFormat dcf = new DecimalFormat("#.##");
                    lblTB.setText(dcf.format(DTB));
//                    FindSV(ListDSV);
                } else {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy kết quả ");
                    txtTKMaSV.requestFocus();
                }
            } catch (Exception e) {
                e.printStackTrace();
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTKMaSV = new javax.swing.JTextField();
        btntK = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTiengAnh = new javax.swing.JTextField();
        txtTinHoc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtGDTC = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblTB = new javax.swing.JLabel();
        lblHoTen = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListDSV = new javax.swing.JTable();
        btnExit = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lí Điểm Sinh Viên");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20), new java.awt.Color(51, 0, 51))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Mã SV");

        txtTKMaSV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btntK.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btntK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search1.png"))); // NOI18N
        btntK.setText("Search");
        btntK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(txtTKMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btntK)
                .addGap(47, 47, 47))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTKMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btntK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, txtTKMaSV});

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Họ Tên SV");

        txtMaSV.setEditable(false);
        txtMaSV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Mã SV");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Tiếng Anh");

        txtTiengAnh.setEditable(false);
        txtTiengAnh.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtTinHoc.setEditable(false);
        txtTinHoc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Tin Học");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("GDTC");

        txtGDTC.setEditable(false);
        txtGDTC.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("Điểm TB");

        lblTB.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lblTB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblHoTen.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblHoTen.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtTinHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblTB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtTiengAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtGDTC, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTiengAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTinHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addComponent(lblTB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGDTC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        btnNew.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/plus (2).png"))); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/save.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/refresh (2).png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fr.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/backward.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/nextwa.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/next.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("*3 sinh viên có điểm cao nhất*");

        tblListDSV.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblListDSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SV", "Họ Tên", "Tiếng Anh", "Tin Học", "GDTC", "Điểm TB"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListDSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListDSVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListDSV);

        btnExit.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logout.png"))); // NOI18N
        btnExit.setText("Logout");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnFirst)
                                        .addGap(53, 53, 53)
                                        .addComponent(btnBack)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnNext)
                                        .addGap(47, 47, 47)
                                        .addComponent(btnLast))
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDelete, btnNew, btnSave, btnUpdate});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        unLock();
        ClearForm();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (checkNull() && checkDiem()) {
            if (checkMaSV1()) {
                String query = "INSERT INTO GRADE(MaSV, TiengAnh, TinHoc, GDTC)"
                        + " VALUES(?, ?, ?, ?)";
                try {
                    PreparedStatement ps = conn.prepareStatement(query);
//                    ps.setNString(1, lblHoTen.getText());
                    ps.setString(1, txtMaSV.getText());
                    ps.setDouble(2, Double.parseDouble(txtTiengAnh.getText()));
                    ps.setDouble(3, Double.parseDouble(txtTinHoc.getText()));
                    ps.setDouble(4, Double.parseDouble(txtGDTC.getText()));

                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                    ListDSV = fetchList();
                    renderList(ListDSV);
                    ClearForm();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
            //index = tblListDSV.getSelectedRow();
            int select = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa:" + lblHoTen.getText());
            if (select == JOptionPane.YES_OPTION) {
                String MaSV = txtMaSV.getText();
                String query = "DELETE FROM GRADE WHERE MaSV = ?";

                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, MaSV);
                ps.execute();

//                Delete();
                ListDSV = fetchList();
                renderList(ListDSV);
                ClearForm();
            }
//            else if (ListDSV.size() == 0) {
//                JOptionPane.showMessageDialog(this, "Không còn dữ liệu để xóa");
//                return;
//            }
        } catch (Exception e) {
            //            JOptionPane.showMessageDialog(this, "Vui lòng chọn dữ liệu để xóa");
            e.printStackTrace();
            return;
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        //        index = tblListDSV.getSelectedRow();
        String MaSV = txtMaSV.getText();
        String query = "UPDATE GRADE SET TiengAnh = ?, TinHoc = ?, GDTC = ? WHERE GRADE.MaSV = ?";
//        if (index >= 0) {
        if (checkNull() && checkDiem()) {
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setDouble(1, Double.parseDouble(txtTiengAnh.getText()));
                ps.setDouble(2, Double.parseDouble(txtTinHoc.getText()));
                ps.setDouble(3, Double.parseDouble(txtGDTC.getText()));
                ps.setString(4, MaSV);
                ps.execute();

                //                    Update();
                JOptionPane.showMessageDialog(this, "Update thành công");
                ListDSV = fetchList();
                renderList(ListDSV);
                ClearForm();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }

        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        txtTiengAnh.setEditable(true);
        txtTinHoc.setEditable(true);
        txtGDTC.setEditable(true);
        index = 0;
        ShowDetails();
        tblListDSV.setRowSelectionInterval(index, index);
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        txtTiengAnh.setEditable(true);
        txtTinHoc.setEditable(true);
        txtGDTC.setEditable(true);
        index--;
        if (index < 0) {
            index = ListDSV.size() - 1;
        }
        ShowDetails();
        tblListDSV.setRowSelectionInterval(index, index);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        txtTiengAnh.setEditable(true);
        txtTinHoc.setEditable(true);
        txtGDTC.setEditable(true);
        index++;
        if (index >= ListDSV.size()) {
            index = 0;
        }
        ShowDetails();
        tblListDSV.setRowSelectionInterval(index, index);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        txtTiengAnh.setEditable(true);
        txtTinHoc.setEditable(true);
        txtGDTC.setEditable(true);
        index = ListDSV.size() - 1;
        ShowDetails();
        tblListDSV.setRowSelectionInterval(index, index);
    }//GEN-LAST:event_btnLastActionPerformed

    private void tblListDSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListDSVMouseClicked
        // TODO add your handling code here:
        index = tblListDSV.getSelectedRow();
        txtTiengAnh.setEditable(true);
        txtTinHoc.setEditable(true);
        txtGDTC.setEditable(true);
        if (index >= 0) {
            ShowDetails();
        }
    }//GEN-LAST:event_tblListDSVMouseClicked

    private void btntKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntKActionPerformed
        // TODO add your handling code here:
        if (checkTK()) {
            try {
                String query = "SELECT GRADE.MaSV, HoTen, TiengAnh,"
                        + "TinHoc, GDTC FROM GRADE INNER JOIN STUDENTS"
                        + " ON STUDENTS.MaSV = GRADE.MaSV WHERE GRADE.MaSV = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, txtTKMaSV.getText());

                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    //                    String MaSV = rs.getString("MaSv");
                    btnSave.setEnabled(true);
                    btnDelete.setEnabled(true);
                    btnUpdate.setEnabled(true);
                    txtTiengAnh.setEditable(true);
                    txtTinHoc.setEditable(true);
                    txtGDTC.setEditable(true);

                    txtMaSV.setText(rs.getString(1));
                    lblHoTen.setText(rs.getNString(2));
                    txtTiengAnh.setText(rs.getDouble(3) + "");
                    txtTinHoc.setText(rs.getDouble(4) + "");
                    txtGDTC.setText(rs.getDouble(5) + "");
                    double DTB = (Double.parseDouble(txtTiengAnh.getText())
                            + Double.parseDouble(txtTinHoc.getText())
                            + Double.parseDouble(txtGDTC.getText())) / 3;
                    DecimalFormat dcf = new DecimalFormat("#.##");
                    lblTB.setText(dcf.format(DTB));
                    //                    FindSV(ListDSV);
                } else {
                    txtTiengAnh.setText("");
                    txtTinHoc.setText("");
                    txtGDTC.setText("");
                    lblTB.setText("");
                    String sql = "SELECT HoTen, MaSV FROM STUDENTS WHERE MaSV = ?";
                    ps = conn.prepareStatement(sql);

                    ps.setString(1, txtTKMaSV.getText());
                    ps.execute();

                    rs = ps.executeQuery();

                    if (rs.next()) {
                        txtMaSV.setText(rs.getNString(2));
                        lblHoTen.setText(rs.getNString(1));

                        btnSave.setEnabled(true);
                        txtTiengAnh.setEditable(true);
                        txtTinHoc.setEditable(true);
                        txtGDTC.setEditable(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "Không tìm thấy sinh viên");
                        return;
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }//GEN-LAST:event_btntKActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        login lg = new login();
        this.getDesktopPane().add(lg);
        lg.setVisible(true);
        lg.setLocation(this.getDesktopPane().getWidth() / 2 - lg.getWidth() / 2, (this.getDesktopPane().getHeight()) / 2 - lg.getHeight() / 2);
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed
//    protected void Delete() {
//        index = tblListDSV.getSelectedRow();
//        ListDSV.remove(index);
//    }

    protected void Update() {
        index = tblListDSV.getSelectedRow();
        String MaSV = tblListDSV.getValueAt(index, 0).toString();
        String query = "SELECT TOP 3 ID, STUDENTS.MaSV, HoTen, TiengAnh, TinHoc, GDTC FROM "
                + "GRADE INNER JOIN STUDENTS ON GRADE.MaSV = STUDENTS.MaSV WHERE GRADE.MaSV = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, MaSV);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt(1);
                MaSV = rs.getString(2);
                String TenSV = rs.getNString(3);
                double TA = rs.getDouble(4);
                double TH = rs.getDouble(5);
                double GDTC = rs.getDouble(6);

                double DTB = (TA + TH + GDTC) / 3;
                ListDSV.set(index, new QLD(ID, MaSV, TenSV, TA, TH, GDTC, DTB));
//                System.out.println(ID + "" + MaSV + "" + TH + "" + TA + "" + GDTC);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    protected boolean checkMaSV1() {
        String query = "SELECT * FROM GRADE WHERE MaSV = ?";
        boolean check = true;
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, txtMaSV.getText());
            ps.execute();

            ResultSet rs = ps.getResultSet();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Mã sinh viên đã tồn tại trong danh sách");
                txtMaSV.requestFocus();
                check = false;
            } else {
                check = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check;
    }

    protected boolean checkMaSV2() {
        String query = "SELECT * FROM STUDENTS WHERE STUDENTS.MaSV = ?";
        boolean check = true;
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, txtMaSV.getText());
            ps.execute();

            ResultSet rs = ps.getResultSet();

            if (rs.next()) {
                check = true;
            } else {
                JOptionPane.showMessageDialog(this, "Mã sinh viên chưa được khởi tạo trong bảng DSSV");
                txtMaSV.requestFocus();
                check = false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return check;
    }

    protected boolean checkNull() {
//        if (txtHoTen.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Họ tên sinh viên chưa được nhập");
//            txtHoTen.requestFocus();
//            return false;
//        } 
        if (txtMaSV.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã sinh viên chưa được nhập");
            txtMaSV.requestFocus();
            return false;
        } else if (txtTiengAnh.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Điểm tiếng anh chưa được nhập");
            txtTiengAnh.requestFocus();
            return false;
        } else if (txtTinHoc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Điểm tin học chưa được nhập");
            txtTinHoc.requestFocus();
            return false;
        } else if (txtGDTC.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Điểm GDTC chưa được nhập");
            txtGDTC.requestFocus();
            return false;
        }
        return true;
    }

    private boolean checkDiem() {
        String TA = txtTiengAnh.getText();
        String TH = txtTinHoc.getText();
        String GDTC = txtGDTC.getText();

        try {
            double checkTA = Double.parseDouble(TA);
            if (checkTA < 0) {
                JOptionPane.showMessageDialog(this, "Điểm Tiếng anh không thể âm");
                txtTiengAnh.requestFocus();
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Điểm Tiếng anh phải là số nguyên");
            txtTiengAnh.requestFocus();
            e.printStackTrace();
        }

        try {
            double checkTH = Double.parseDouble(TH);
            if (checkTH < 0) {
                JOptionPane.showMessageDialog(this, "Điểm Tin học không thể âm");
                txtTinHoc.requestFocus();
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Điểm Tin học phải là số nguyên");
            txtTinHoc.requestFocus();
            e.printStackTrace();
        }

        try {
            double checkGDTC = Double.parseDouble(GDTC);
            if (checkGDTC < 0) {
                JOptionPane.showMessageDialog(this, "Điểm GDTC không thể âm");
                txtGDTC.requestFocus();
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Điểm GDTC phải là số nguyên");
            txtGDTC.requestFocus();
            e.printStackTrace();
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btntK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblTB;
    private javax.swing.JTable tblListDSV;
    private javax.swing.JTextField txtGDTC;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtTKMaSV;
    private javax.swing.JTextField txtTiengAnh;
    private javax.swing.JTextField txtTinHoc;
    // End of variables declaration//GEN-END:variables
    private void ClearForm() {
        txtTKMaSV.setText("");
        lblHoTen.setText("");
        txtMaSV.setText("");
        txtTiengAnh.setText("");
        txtTinHoc.setText("");
        txtGDTC.setText("");
        lblTB.setText("");
    }

    private void unLock() {
        txtMaSV.setEditable(true);
//        txtHoTen.setE/ditable(true);
        txtTiengAnh.setEditable(true);
        txtTinHoc.setEditable(true);
        txtGDTC.setEditable(true);
    }

    private void ShowDetails() {
//        index = tblListDSV.getSelectedRow();
        QLD x = ListDSV.get(index);

        lblHoTen.setText(x.getTenSV());
        txtMaSV.setText(x.getMaSV());
        txtTiengAnh.setText(x.getTiengAnh() + "");
        txtTinHoc.setText(x.getTinHoc() + "");
        txtGDTC.setText(x.getGDTC() + "");
        btnSave.setEnabled(true);
        btnDelete.setEnabled(true);
        btnUpdate.setEnabled(true);

        double d1 = Double.parseDouble(txtTiengAnh.getText());
        double d2 = Double.parseDouble(txtTinHoc.getText());
        double d3 = Double.parseDouble(txtGDTC.getText());
        double tb = (d1 + d2 + d3) / 3;
        DecimalFormat dcf = new DecimalFormat("#.##");
        lblTB.setText(dcf.format(tb));
    }
}
