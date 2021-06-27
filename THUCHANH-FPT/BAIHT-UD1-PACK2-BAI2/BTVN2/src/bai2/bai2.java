/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dang Dinh Vu
 */
public class bai2 extends javax.swing.JFrame {

    private String path = "";

    ArrayList<QLSV> list = new ArrayList<QLSV>();
    int index = 0;

    public bai2() {
        initComponents();
        setResizable(false);
        duLieu();
        setSize(670, 660);
        setLocationRelativeTo(null);
        btnDauActionPerformed(null);

    }

    public void duLieu() {
        list.add(new QLSV("sv01", "Đặng Đình Vũ", 10, "Nam", "code", "Thiếu tiền"));
        list.add(new QLSV("sv02", "Nguyễn Thị lan", 9, "Nữ", "mobile", "Thiếu tiền"));
        list.add(new QLSV("sv03", "Nguyễn Văn Đức", 8, "Nam", "website", "Thiếu tình"));
        list.add(new QLSV("sv04", "Trịnh Thu Thảo", 7, "Nữ", "thiết kế", "Thiếu tình"));
        list.add(new QLSV("sv05", "Nguyễn Đức Thịnh", 6, "Nam", "code", "Thiếu tiền"));
        list.add(new QLSV("sv06", "Đặng lan Anh", 10, "Nữ", "code", "Thiếu tiền" + "  Thiếu tình"));
        fillTable();
    }

    public boolean checkTrung(String name) {
        boolean check = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(index).getMaMeo().equals(name)) {
                check = true;
            }
        }
        return check;
    }

    public void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblQLSV.getModel();
        model.setRowCount(0);

        for (QLSV x : list) {
            model.addRow(new String[]{x.getMaMeo(), x.getHoVaTen(), x.getDiemGia() + "", x.getGioTinh(), x.getKyNang(), x.getGhiChu()});
        }
    }

    public void ADD() {
        String gioiTinh = rdoNam.isSelected() ? "Nam" : "Nữ";
        QLSV ql = new QLSV();
        ql.setMaMeo(txtMaMeo.getText());
        ql.setHoVaTen(txtHoTen.getText());
        ql.setDiemGia(Double.parseDouble(txtDiem.getText()));
        ql.setKyNang(cboKyNang.getSelectedItem() + "");
        ql.setGioTinh(gioiTinh);
        if (chkThieuTien.isSelected() && chkThieuTinh.isSelected()) {
            ql.setGhiChu("Thiếu tiền" + "  Thiếu tình");
        } else if (chkThieuTien.isSelected()) {
            ql.setGhiChu("Thiếu tiền");
        } else if (chkThieuTinh.isSelected()) {
            ql.setGhiChu("Thiếu tình");
        }
        list.add(ql);
        fillTable();
        lamMoi();
        JOptionPane.showMessageDialog(rootPane, "Đã thêm thành công <3....");
    }

    public void Them() {
        String text = txtMaMeo.getText();
        String ht = txtHoTen.getText();
        try {
            if (checkTrung(txtMaMeo.getText()) == true) {
                JOptionPane.showMessageDialog(rootPane, "Đã bị trùng mã !!!!");
                return;
            } else if (txtMaMeo.getText().isEmpty() || txtHoTen.getText().isEmpty() || txtDiem.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Không được để rỗng !!!!");
                return;
            } else if (text.length() < 7 || text.length() > 7) {
                JOptionPane.showMessageDialog(this, "Mã sinh viên phải đúng 7 kí tự");
                return;
            } else if (ht.length() > 40) {
                JOptionPane.showMessageDialog(this, "Họ tên tối đa 40 ký tự");
                return;
            } else if (Double.parseDouble(txtDiem.getText()) < 0 || Double.parseDouble(txtDiem.getText()) > 10) {
                JOptionPane.showMessageDialog(this, "Điểm chỉ được nhập 0 -> 10");
            } else {
                ADD();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "VUI LÒNG KIỂM TRA LẠI!!!", "THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void Xoa() {
        try {
            index = tblQLSV.getSelectedRow();
            if (list.size() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Không có Dữ liệu!!");
                return;
            } else if (index == -1) {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn !!!");
            } else {
                list.remove(index);
                fillTable();
                JOptionPane.showMessageDialog(rootPane, "Xoá thành công <3...");
                lamMoi();
            }
        } catch (Exception e) {

        }
    }

    public void capNhat() {
        try {
            index = tblQLSV.getSelectedRow();
            if (checkTrung(txtMaMeo.getText()) == true) {
                JOptionPane.showMessageDialog(this, "Trùng mÃ!!!!");
            } else if (txtMaMeo.getText().length() < 7 || txtMaMeo.getText().length() > 7) {
                JOptionPane.showMessageDialog(this, "Mã sinh viên phải đúng 7 kí tự");
                return;
            } else if (list.size() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Không có Dữ liệu!!");
            } else if (index == -1) {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn !!!");
            } else {
                String gioiTinh1 = rdoNam.isSelected() ? "Nam" : "Nữ";
                QLSV ql = list.get(index);
                ql.setMaMeo(txtMaMeo.getText());
                ql.setHoVaTen(txtHoTen.getText());
                ql.setDiemGia(Double.parseDouble(txtDiem.getText()));
                ql.setKyNang(cboKyNang.getSelectedItem() + "");
                ql.setGioTinh(gioiTinh1);
                if (chkThieuTien.isSelected() && chkThieuTinh.isSelected()) {
                    ql.setGhiChu("Thiếu tiền" + "  Thiếu tình");
                } else if (chkThieuTien.isSelected()) {
                    ql.setGhiChu("Thiếu tiền");
                } else if (chkThieuTinh.isSelected()) {
                    ql.setGhiChu("Thiếu tình");
                } else {
                    ql.setGhiChu("");
                }

                fillTable();
                JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công <3...");
                lamMoi();
            }
        } catch (Exception e) {
        }
    }

    public void lamMoi() {
        txtMaMeo.setText("");
        txtHoTen.setText("");
        txtDiem.setText("");
        rdoNam.setSelected(true);
        chkThieuTien.setSelected(false);
        chkThieuTinh.setSelected(false);
    }

    public void SapXepTen() {
        Collections.sort(list, (QLSV o1, QLSV o2) -> {
            String name1 = o1.getHoVaTen().split("")[o1.getHoVaTen().split("").length - 1];
            String name2 = o2.getHoVaTen().split("")[o2.getHoVaTen().split("").length - 1];
            return name1.compareToIgnoreCase(name2);
        });
        fillTable();
    }

    public void sapXepDiem() {
        Collections.sort(list, (QLSV o1, QLSV o2) -> {
            Double d1 = o1.getDiemGia();
            Double d2 = o2.getDiemGia();
            return d2.compareTo(d1);
        });
        fillTable();
    }

    public void sxd2() {
        Collections.sort(list, (a, b) -> (int) (a.getDiemGia() - b.getDiemGia()));
        fillTable();
    }

    public void mouseClick() {
        try {
            index = tblQLSV.getSelectedRow();
            QLSV ql = list.get(index);
            txtMaMeo.setText(ql.getMaMeo());
            txtHoTen.setText(ql.getHoVaTen());
            txtDiem.setText(ql.getDiemGia() + "");
            cboKyNang.setSelectedItem(ql.getKyNang());
            String role1 = tblQLSV.getValueAt(index, 5).toString();
            if (role1.equalsIgnoreCase("")) {
                chkThieuTinh.setSelected(false);
                chkThieuTien.setSelected(false);
            } else if (role1.equalsIgnoreCase("Thiếu tiền")) {
                chkThieuTien.setSelected(true);
                chkThieuTinh.setSelected(false);
            } else if (role1.equalsIgnoreCase("Thiếu tình")) {
                chkThieuTinh.setSelected(true);
                chkThieuTien.setSelected(false);
            } else {
                chkThieuTinh.setSelected(true);
                chkThieuTien.setSelected(true);
            }
            String role = tblQLSV.getValueAt(index, 3).toString();
            if (role.equalsIgnoreCase("Nam")) {
                rdoNam.setSelected(true);
            } else {
                rdoNu.setSelected(true);
            }
        } catch (Exception e) {
        }

    }

    public void showw() {
        QLSV ql = list.get(index);
        txtMaMeo.setText(ql.getMaMeo());
        txtHoTen.setText(ql.getHoVaTen());
        txtDiem.setText(ql.getDiemGia() + "");
        cboKyNang.setSelectedItem(ql.getKyNang());
        String role = tblQLSV.getValueAt(index, 4).toString();
        String role1 = tblQLSV.getValueAt(index, 5).toString();
        if (role1.equalsIgnoreCase("")) {
            chkThieuTinh.setSelected(false);
            chkThieuTien.setSelected(false);
        } else if (role1.equalsIgnoreCase("Thiếu tiền")) {
            chkThieuTien.setSelected(true);
            chkThieuTinh.setSelected(false);
        } else if (role1.equalsIgnoreCase("Thiếu tình")) {
            chkThieuTinh.setSelected(true);
            chkThieuTien.setSelected(false);
        } else {
            chkThieuTinh.setSelected(true);
            chkThieuTien.setSelected(true);
        }

        if (role.equalsIgnoreCase("Nam")) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
    }

    public void saveTOFile() {
//        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\Dang Dinh Vu\\OneDrive\\Máy tính\\laptrinh-java2\\THUCHANH-FPT\\QLSV.dat");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);){
//            oos.writeObject(list);
//        } catch (Exception e) {
//            System.out.println("Error: " + e);
//        }
        XFile.writeOb("C:\\Users\\Dang Dinh Vu\\OneDrive\\Máy tính\\"
                + "laptrinh-java2\\THUCHANH-FPT\\QLSV.dat", list);
    }

    public void OpenFile() {
//        FileInputStream fis = null;
//        ObjectInputStream ois = null;
//        try {
//            fis = new FileInputStream("C:\\Users\\Dang Dinh Vu\\OneDrive\\Máy tính\\laptrinh-java2\\THUCHANH-FPT\\QLSV.dat");
//            ois = new ObjectInputStream(fis);
//            list = (ArrayList<QLSV>) ois.readObject();
//            ois.close();
//            fis.close();
//        } catch (Exception e) {
//            System.out.println("ERROR: " + e);
//        }

        File file = new File("C:\\Users\\Dang Dinh Vu\\OneDrive\\Máy tính\\laptrinh-java2\\THUCHANH-FPT\\QLSV.dat");
        list = (ArrayList<QLSV>) XFile.readOb("C:\\Users\\Dang Dinh Vu\\OneDrive\\Máy tính\\laptrinh-java2\\THUCHANH-FPT\\QLSV.dat");
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
        lblmaMeo = new javax.swing.JLabel();
        rdoNu = new javax.swing.JRadioButton();
        lblDiem = new javax.swing.JLabel();
        lblKyNang = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        lblHovaTen = new javax.swing.JLabel();
        txtDiem = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtMaMeo = new javax.swing.JTextField();
        cboKyNang = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        btnLamMoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnOpenfil = new javax.swing.JButton();
        btnLuuFile = new javax.swing.JButton();
        btnSapXepTen = new javax.swing.JButton();
        btnSapXepDiem = new javax.swing.JButton();
        chkThieuTien = new javax.swing.JCheckBox();
        chkThieuTinh = new javax.swing.JCheckBox();
        btnDau = new javax.swing.JButton();
        btnLui = new javax.swing.JButton();
        btnTien = new javax.swing.JButton();
        btnCuoi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQLSV = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnSieuThoat = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        lblmaMeo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblmaMeo.setForeground(new java.awt.Color(255, 0, 0));
        lblmaMeo.setText("MÃ NV:");
        jPanel1.add(lblmaMeo);
        lblmaMeo.setBounds(56, 77, 79, 32);

        buttonGroup1.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rdoNu.setForeground(new java.awt.Color(255, 0, 0));
        rdoNu.setText("Nữ");
        jPanel1.add(rdoNu);
        rdoNu.setBounds(244, 296, 43, 25);

        lblDiem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblDiem.setForeground(new java.awt.Color(255, 0, 0));
        lblDiem.setText("ĐIỂM GIẢ:");
        jPanel1.add(lblDiem);
        lblDiem.setBounds(56, 177, 79, 31);

        lblKyNang.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblKyNang.setForeground(new java.awt.Color(255, 0, 0));
        lblKyNang.setText("KÝ NĂNG:");
        jPanel1.add(lblKyNang);
        lblKyNang.setBounds(56, 246, 79, 31);

        lblGioiTinh.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblGioiTinh.setForeground(new java.awt.Color(255, 0, 0));
        lblGioiTinh.setText("GIỚI TÍNH:");
        jPanel1.add(lblGioiTinh);
        lblGioiTinh.setBounds(56, 300, 79, 17);

        lblHovaTen.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblHovaTen.setForeground(new java.awt.Color(255, 0, 0));
        lblHovaTen.setText("HỌ VÀ TÊN:");
        jPanel1.add(lblHovaTen);
        lblHovaTen.setBounds(56, 127, 79, 32);

        txtDiem.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jPanel1.add(txtDiem);
        txtDiem.setBounds(173, 178, 165, 31);

        txtHoTen.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jPanel1.add(txtHoTen);
        txtHoTen.setBounds(173, 128, 165, 31);

        txtMaMeo.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jPanel1.add(txtMaMeo);
        txtMaMeo.setBounds(173, 78, 165, 31);

        cboKyNang.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cboKyNang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "code", "mobile", "website", "thiết kế" }));
        jPanel1.add(cboKyNang);
        cboKyNang.setBounds(173, 247, 165, 31);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ SINH VIÊN");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(191, 19, 238, 29);

        buttonGroup1.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        rdoNam.setForeground(new java.awt.Color(255, 0, 0));
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");
        jPanel1.add(rdoNam);
        rdoNam.setBounds(173, 296, 53, 25);

        btnLamMoi.setBackground(new java.awt.Color(255, 255, 51));
        btnLamMoi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(204, 0, 0));
        btnLamMoi.setText("Làm mời");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        jPanel1.add(btnLamMoi);
        btnLamMoi.setBounds(397, 77, 89, 31);

        btnThem.setBackground(new java.awt.Color(255, 255, 51));
        btnThem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(204, 0, 0));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel1.add(btnThem);
        btnThem.setBounds(397, 127, 89, 31);

        btnXoa.setBackground(new java.awt.Color(255, 255, 51));
        btnXoa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(204, 0, 0));
        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoa);
        btnXoa.setBounds(397, 177, 89, 31);

        btnCapNhat.setBackground(new java.awt.Color(255, 255, 51));
        btnCapNhat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnCapNhat.setForeground(new java.awt.Color(204, 0, 0));
        btnCapNhat.setText("Cập Nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });
        jPanel1.add(btnCapNhat);
        btnCapNhat.setBounds(397, 246, 89, 31);

        btnOpenfil.setBackground(new java.awt.Color(255, 255, 51));
        btnOpenfil.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnOpenfil.setForeground(new java.awt.Color(204, 0, 0));
        btnOpenfil.setText("Open file");
        btnOpenfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenfilActionPerformed(evt);
            }
        });
        jPanel1.add(btnOpenfil);
        btnOpenfil.setBounds(516, 77, 113, 31);

        btnLuuFile.setBackground(new java.awt.Color(255, 255, 51));
        btnLuuFile.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnLuuFile.setForeground(new java.awt.Color(204, 0, 0));
        btnLuuFile.setText("Lưu file");
        btnLuuFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuFileActionPerformed(evt);
            }
        });
        jPanel1.add(btnLuuFile);
        btnLuuFile.setBounds(516, 127, 113, 31);

        btnSapXepTen.setBackground(new java.awt.Color(255, 255, 51));
        btnSapXepTen.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSapXepTen.setForeground(new java.awt.Color(204, 0, 0));
        btnSapXepTen.setText("Sắp xếp tên");
        btnSapXepTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepTenActionPerformed(evt);
            }
        });
        jPanel1.add(btnSapXepTen);
        btnSapXepTen.setBounds(516, 177, 113, 31);

        btnSapXepDiem.setBackground(new java.awt.Color(255, 255, 51));
        btnSapXepDiem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSapXepDiem.setForeground(new java.awt.Color(204, 0, 0));
        btnSapXepDiem.setText("Sắp xếp điểm");
        btnSapXepDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepDiemActionPerformed(evt);
            }
        });
        jPanel1.add(btnSapXepDiem);
        btnSapXepDiem.setBounds(516, 246, 113, 31);

        chkThieuTien.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        chkThieuTien.setForeground(new java.awt.Color(255, 0, 0));
        chkThieuTien.setText("Thiếu tiền");
        jPanel1.add(chkThieuTien);
        chkThieuTien.setBounds(397, 296, 89, 25);

        chkThieuTinh.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        chkThieuTinh.setForeground(new java.awt.Color(255, 0, 0));
        chkThieuTinh.setText("Thiếu tình");
        jPanel1.add(chkThieuTinh);
        chkThieuTinh.setBounds(516, 296, 89, 25);

        btnDau.setBackground(new java.awt.Color(255, 255, 51));
        btnDau.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDau.setForeground(new java.awt.Color(255, 51, 51));
        btnDau.setText("<|");
        btnDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDauActionPerformed(evt);
            }
        });
        jPanel1.add(btnDau);
        btnDau.setBounds(201, 339, 43, 25);

        btnLui.setBackground(new java.awt.Color(255, 255, 51));
        btnLui.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnLui.setForeground(new java.awt.Color(255, 51, 51));
        btnLui.setText("<<");
        btnLui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuiActionPerformed(evt);
            }
        });
        jPanel1.add(btnLui);
        btnLui.setBounds(254, 339, 49, 25);

        btnTien.setBackground(new java.awt.Color(255, 255, 51));
        btnTien.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnTien.setForeground(new java.awt.Color(255, 51, 51));
        btnTien.setText(">>");
        btnTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTienActionPerformed(evt);
            }
        });
        jPanel1.add(btnTien);
        btnTien.setBounds(351, 339, 49, 25);

        btnCuoi.setBackground(new java.awt.Color(255, 255, 51));
        btnCuoi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnCuoi.setForeground(new java.awt.Color(255, 51, 51));
        btnCuoi.setText("|>");
        btnCuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuoiActionPerformed(evt);
            }
        });
        jPanel1.add(btnCuoi);
        btnCuoi.setBounds(410, 339, 43, 25);

        tblQLSV.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tblQLSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MSSV", "Họ Và Tên", "Điểm", "Giới tính", "Kỹ năng", "Ghi chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblQLSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLSVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblQLSV);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 392, 652, 164);

        jLabel2.setBackground(new java.awt.Color(255, 0, 0));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("...");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(321, 343, 12, 17);

        btnSieuThoat.setBackground(new java.awt.Color(255, 255, 0));
        btnSieuThoat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSieuThoat.setForeground(new java.awt.Color(255, 0, 0));
        btnSieuThoat.setText("Siêu thoát");
        btnSieuThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSieuThoatActionPerformed(evt);
            }
        });
        jPanel1.add(btnSieuThoat);
        btnSieuThoat.setBounds(530, 570, 100, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bai2/1.jpg"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 0, 670, 620);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblQLSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLSVMouseClicked
        // TODO add your handling code here:
        mouseClick();
    }//GEN-LAST:event_tblQLSVMouseClicked

    private void btnCuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuoiActionPerformed
        // TODO add your handling code here:
        try {
            index = list.size() - 1;
            showw();
            tblQLSV.setRowSelectionInterval(index, index);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnCuoiActionPerformed

    private void btnTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTienActionPerformed
        // TODO add your handling code here:
        try {
            if (index < list.size()) {
                index++;
                showw();
                tblQLSV.setRowSelectionInterval(index, index);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnTienActionPerformed

    private void btnLuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuiActionPerformed
        // TODO add your handling code here:
        try {
            if (index > 0) {
                index--;
                showw();
                tblQLSV.setRowSelectionInterval(index, index);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnLuiActionPerformed

    private void btnDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDauActionPerformed
        // TODO add your handling code here:
        try {
            index = 0;
            showw();
            tblQLSV.setRowSelectionInterval(index, index);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnDauActionPerformed

    private void btnSapXepDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepDiemActionPerformed
        // TODO add your handling code here:
        sapXepDiem();
    }//GEN-LAST:event_btnSapXepDiemActionPerformed

    private void btnSapXepTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepTenActionPerformed
        // TODO add your handling code here:
        SapXepTen();
    }//GEN-LAST:event_btnSapXepTenActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        capNhat();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        Xoa();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        Them();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        lamMoi();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnOpenfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenfilActionPerformed
        try {
            OpenFile();
            if (list.size() > 0) {
                index = 0;
                showw();
                fillTable();
                tblQLSV.setRowSelectionInterval(index, index);
            } else {
                index = -1;
                lamMoi();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnOpenfilActionPerformed

    private void btnLuuFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuFileActionPerformed
        int luaChon = JOptionPane.showConfirmDialog(this, "bạn muốn lưu không",
                "Hỏi đáp lưu file", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.YES_OPTION);
        try {
            if (luaChon == JOptionPane.YES_OPTION) {
                this.saveTOFile();
            } else {
                return;
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnLuuFileActionPerformed

    private void btnSieuThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSieuThoatActionPerformed
        // TODO add your handling code here:
        saveTOFile();
        System.exit(0);
    }//GEN-LAST:event_btnSieuThoatActionPerformed

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
            java.util.logging.Logger.getLogger(bai2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bai2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bai2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bai2.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bai2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnCuoi;
    private javax.swing.JButton btnDau;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLui;
    private javax.swing.JButton btnLuuFile;
    private javax.swing.JButton btnOpenfil;
    private javax.swing.JButton btnSapXepDiem;
    private javax.swing.JButton btnSapXepTen;
    private javax.swing.JButton btnSieuThoat;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTien;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboKyNang;
    private javax.swing.JCheckBox chkThieuTien;
    private javax.swing.JCheckBox chkThieuTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDiem;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblHovaTen;
    private javax.swing.JLabel lblKyNang;
    private javax.swing.JLabel lblmaMeo;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblQLSV;
    private javax.swing.JTextField txtDiem;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaMeo;
    // End of variables declaration//GEN-END:variables
}
