package Main_FromStaff;

import javax.swing.table.DefaultTableModel;
import Main_ClassStaff.Staff;
import XFile.XFile;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class From_manageStaff extends javax.swing.JFrame {

    private ArrayList<Staff> list = new ArrayList<>();
    private int index = 0;

    public From_manageStaff() {
        initComponents();
        titleTable();
        setLocationRelativeTo(null);
        setResizable(false);
        titleTable();
        DataTableStaff();
        FristlyStaff();
        Time();
    }

    public final void Time() {
        new Thread() {
            SimpleDateFormat sdf = new SimpleDateFormat();

            @Override
            public void run() {
                while (true) {
                    Date now = new Date();

                    String st = sdf.format(now);
                    lblTime.setText(st);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }.start();
    }

    public void Record() {
        lblRecord.setText("Record: " + (index + 1) + "of" + list.size());
    }

    public void showw() {
        // gọi lớp Staff = lấy vị trí trong list
        Staff staff = list.get(index);
        // truyền dữ liệu từ lớp Staff vào các JTextField
        txtcodeStaff.setText(staff.getCodeStaff());
        txtFullname.setText(staff.getFullnameStaff());
        txtAge.setText(staff.getAge() + "");
        txtEmail.setText(staff.getEmail());
        txtSalary.setText(staff.getSalary() + "");
        String role = tblDataStaff.getValueAt(index, 3).toString();
        if (role.equalsIgnoreCase("nam")) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
    }

    public void fillTable() {
        // gọi phương thức con có sãn của Table và ép kiểu để lấy cả bảng số hàng số cột
        DefaultTableModel model = (DefaultTableModel) tblDataStaff.getModel();
        // xoá toàn bộ dữ liệu.
        model.setRowCount(0);
        // duyện list của Staff
        list.forEach(staff -> {
            // add vào hàng vào cột của bảng.
            model.addRow(new Object[]{staff.getCodeStaff(), staff.getFullnameStaff(),
                staff.getAge(), staff.getGender(), staff.getEmail(), staff.getSalary()});
        });
        model.fireTableDataChanged();
    }

    public void DataTableStaff() {
        // khởi toạ dữ liệu truyền vào
        list.add(new Staff("NV01", "ĐẶNG ĐÌNH VŨ", 19, "NAM", "vuddph14036@fpt.edu.vn", 100000));
        list.add(new Staff("NV02", "NGUYỄN THỊ NGỌC GIANG", 20, "NỮ", "giangntn123@fpt.edu.vn", 200000));
        list.add(new Staff("NV03", "NGUYỄN VĂN ĐỨC", 21, "NAM", "ducnv0000@fpt.edu.vn", 300000));
        list.add(new Staff("NV04", "NGUYỄN VĂN ĐỨC", 21, "NAM", "ducnv0000@fpt.edu.vn", 300000));
        list.add(new Staff("NV05", "NGUYỄN VĂN ĐỨC", 21, "NAM", "ducnv0000@fpt.edu.vn", 300000));
        list.add(new Staff("NV06", "NGUYỄN VĂN ĐỨC", 21, "NAM", "ducnv0000@fpt.edu.vn", 300000));
        list.add(new Staff("NV07", "NGUYỄN VĂN ĐỨC", 21, "NAM", "ducnv0000@fpt.edu.vn", 300000));
        list.add(new Staff("NV08", "NGUYỄN VĂN ĐỨC", 21, "NAM", "ducnv0000@fpt.edu.vn", 300000));
        list.add(new Staff("NV09", "NGUYỄN VĂN ĐỨC", 21, "NAM", "ducnv0000@fpt.edu.vn", 300000));
        list.add(new Staff("NV010", "NGUYỄN VĂN ĐỨC", 21, "NAM", "ducnv0000@fpt.edu.vn", 300000));
        fillTable();
    }

    public void titleTable() {
        // add titel vào bảng
        String[] data = {"MÃ NHÂN VIÊN", "HỌ VÀ TÊN", "TUỔI", "GIỚI TÍNH", "EMAIL", "LƯƠNG"};
        tblDataStaff.setModel(new DefaultTableModel(data, 0));
    }

    public void NewStaff() {
        // làm mới JTextField
        txtAge.setText("");
        txtEmail.setText("");
        txtFullname.setText("");
        txtSalary.setText("");
        txtcodeStaff.setText("");
        txtFind.setText("");
        rdoNam.setSelected(true);
        index = 0;
        tblDataStaff.setRowSelectionInterval(index, index);
    }

    public boolean checkCodeStaff(String codeID) { // tạo phương thức boolean và có tham số truyền vào là String
        // duyệt mảng..
        for (int i = 0; i < list.size(); i++) {
            // điều kiện mã nhân viên trong list so sánh với tên biến của tham số chuyền vào
            if (list.get(i).getCodeStaff().equalsIgnoreCase(codeID)) {
                // nếu trùng thì trả về true
                return true;
            }
        }
        // không trùng thì trả về false
        return false;
    }

    public void addDataStaff() {
        // tạo biến và gán giá trị
        String fullname = txtFullname.getText();
        String codeID = txtcodeStaff.getText();
        String Age = txtAge.getText();
        String email = txtEmail.getText();
        String salary = txtSalary.getText();
        Pattern pt = Pattern.compile("\\w+@\\w+(\\.\\w+){1,2}");
        Matcher matcher = pt.matcher(email);
        String gender = rdoNam.isSelected() ? "NAM" : "NỮ";
        boolean flag = true;
        // kiểm tra các điều kiện
        try {
            if (checkCodeStaff(codeID) == true) {
                JOptionPane.showMessageDialog(this, "Duplicate code!!!");
                return;
            } else if (codeID.isEmpty()) {
                JOptionPane.showMessageDialog(this, "You can't empty CodeStaff!!!");
                return;
            } else if (fullname.isEmpty()) {
                JOptionPane.showMessageDialog(this, "You can't empty first and last name Staff!!!");
                return;
            } else if (Age.isEmpty()) {
                JOptionPane.showMessageDialog(this, "You can't empty Age!!!");
                return;
            } else if (email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "You can't empty Email!!!");
                return;
            } else if (!matcher.find()) {
                JOptionPane.showMessageDialog(this, "Invalid email!!!");
                return;
            } else if (salary.isEmpty()) {
                JOptionPane.showMessageDialog(this, "You can't empty Salary!!!");
                return;
            }
            flag = false;
        } catch (HeadlessException e) {
        }

        try {
            if (Double.parseDouble(salary) < 5000000) {
                JOptionPane.showMessageDialog(this, "Salary must be > 5.000.000!!!");
                return;
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "salary must be number !!!");
        }

        try {
            if (Integer.parseInt(Age) < 18 || Integer.parseInt(Age) > 55) {
                JOptionPane.showMessageDialog(this, "Age must > 18 and Age < 55!!");
                return;
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Age must be number !!!");
        }

        // đúng thì thêm dữ liệu vào list
        if (flag == true) {
            Staff st = new Staff();
            st.setCodeStaff(codeID);
            st.setFullnameStaff(fullname);
            st.setAge(Integer.parseInt(Age));
            st.setEmail(email);
            st.setSalary(Double.parseDouble(salary));
            st.setGender(gender);
            list.add(st);
            fillTable();
            JOptionPane.showMessageDialog(this, "Add data Succesfully <3...");
            NewStaff();
        }
    }

    public void DeleteStaff() {
        // tên biến =chọn vị trí dòng  của table
        index = tblDataStaff.getSelectedRow();
        try {
            if (list.size() == 0) {
                JOptionPane.showMessageDialog(this, "No data Employee!!!");
            } else if (index == -1) {
                JOptionPane.showMessageDialog(this, "Please choose data to delete!!!");
            } else {
                list.remove(index);
                fillTable();
                JOptionPane.showMessageDialog(this, "Delete data Staff succesfully <3...");
            }
        } catch (HeadlessException e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }

    public void UpdateStaff() {
        String fullname = txtFullname.getText();
        String codeID = txtcodeStaff.getText();
        String Age = txtAge.getText();
        String email = txtEmail.getText();
        String salary = txtSalary.getText();
        String gender = rdoNam.isSelected() ? "NAM" : "NỮ";
        index = tblDataStaff.getSelectedRow();
        try {
            if (list.isEmpty()) {
                JOptionPane.showConfirmDialog(this, "No data Employee!!!");
            } else if (index == -1) {
                JOptionPane.showMessageDialog(this, "Please choose data to delete!!!");
            } else if (checkCodeStaff(codeID) == false) {
                JOptionPane.showMessageDialog(this, "can't edited codeIDStaff!!!");
            } else {
                Staff st = list.get(index);
                st.setCodeStaff(codeID);
                st.setFullnameStaff(fullname);
                st.setAge(Integer.parseInt(Age));
                st.setEmail(email);
                st.setSalary(Double.parseDouble(salary));
                st.setGender(gender);
                fillTable();
                JOptionPane.showMessageDialog(this, "Update data Succesfully <3...");
            }

        } catch (HeadlessException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void FindStaff() {
        boolean flag1 = false;
        int i;
        try {
            // tạo biến gán giá trị
            String find = txtFind.getText();
            // duyện list và điều kiện so sánh
            for (i = 0; i < list.size(); i++) {
                Staff staff = list.get(i);
                if (staff.getCodeStaff().equalsIgnoreCase(find)) {

                    // hiển thị dữ liệu lên các JTextField
                    txtcodeStaff.setText(staff.getCodeStaff());
                    txtFullname.setText(staff.getFullnameStaff());
                    txtAge.setText(staff.getAge() + "");
                    txtEmail.setText(staff.getEmail());
                    txtSalary.setText(staff.getSalary() + "");
                    if (staff.getGender().equalsIgnoreCase("nam")) {
                        rdoNam.setSelected(true);
                    } else {
                        rdoNu.setSelected(true);
                    }

                    tblDataStaff.setRowSelectionInterval(i, i);
                    // thông báo...
                    JOptionPane.showMessageDialog(this, "Search data Staff succesfully <3...");
                    flag1 = true;
                    break;
                }
            }
            if (flag1 == false) { // không tìm thấy thông báo
                JOptionPane.showMessageDialog(this, "No search data Staff ...");
            }
        } catch (HeadlessException e) {
        }
    }

    public void FristlyStaff() {
        try {
            index = 0;
            showw();
            Record();
            tblDataStaff.setRowSelectionInterval(index, index);
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    public void SortStaff() {
        try {
            if (list.size() > 0) {
                if (rdoSortAZ.isSelected()) {
                    Collections.sort(list, (Staff o1, Staff o2) -> {
                        String name1 = o1.getFullnameStaff().split("")[o1.getFullnameStaff().split("").length - 1];
                        String name2 = o2.getFullnameStaff().split("")[o2.getFullnameStaff().split("").length - 1];
                        return name1.compareToIgnoreCase(name2);
                    });
                    fillTable();
                    JOptionPane.showMessageDialog(this, "Sort Succesfully!!!!");
                } else if (rdoSortAZ.isSelected()) {
                    Collections.sort(list, (Staff o1, Staff o2) -> {
                        String name1 = o1.getFullnameStaff().split("")[o1.getFullnameStaff().split("").length - 1];
                        String name2 = o2.getFullnameStaff().split("")[o2.getFullnameStaff().split("").length - 1];
                        return name2.compareToIgnoreCase(name1);
                    });
                    fillTable();
                    JOptionPane.showMessageDialog(this, "Sort Succesfully!!!!");
                } else {
                    Collections.sort(list, (a, b) -> (int) (a.getAge() - b.getAge()));
                    fillTable();
                    JOptionPane.showMessageDialog(this, "Sort Succesfully!!!!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "ERROR");
            }
        } catch (HeadlessException e) {
        }
    }

    public void UpStaff() {
        try {
            if (index > 0) {
                index--;
                showw();
                Record();
                tblDataStaff.setRowSelectionInterval(index, index);
            }
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    public void BackStaff() {
        try {
            if (index < list.size()) {
                index++;
                showw();
                Record();
                tblDataStaff.setRowSelectionInterval(index, index);
            }
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    public void LastStaff() {
        DefaultTableModel model = (DefaultTableModel) tblDataStaff.getModel();
        for (int i = 0; i < 3; i++) {
            model.addRow(new Object[]{list.get(i).getCodeStaff(), list.get(i).getFullnameStaff(),
                list.get(i).getAge(), list.get(i).getGender(), list.get(i).getEmail(), list.get(i).getSalary()});
        }
    }

    public void mouseClickTable(int i) {
        showw();
    }

    public void saveFile() {
        try {
            XFile.writeOb("ASSM-JAVA2.dat", list);
        } catch (Exception e) {
        }
    }

    public void openFile() {
        try {
            // tạo đối tượng JFileChooser
            JFileChooser jfc = new JFileChooser();
            //lọc các file có đuôi ".dat", ".txt", ".doc"
            FileNameExtensionFilter text = new FileNameExtensionFilter("Select File", "dat", "txt", "doc");
            // set vào filefilter và truyền text vào
            jfc.setFileFilter(text);
            // set chọn chế độ một hoặc nhiều.
            jfc.setMultiSelectionEnabled(false);
            // tạo một biến gán giá trị cho người dùng chọn file
            int x = jfc.showDialog(this, "Select File");
            // so sánh người dùng chọn file hay chưa
            if (x == JFileChooser.APPROVE_OPTION) {
                // cho người dùng chọn 1 hay nhiều file
                File f = jfc.getSelectedFile();
                // ép kiểu và gọi tới readOb và có tham số là f.getAbsolutePath
                // f.getAbsolutePath là đường dẫn tới file
                list = (ArrayList<Staff>) XFile.readOb(f.getAbsolutePath());
                // file k có dữ liệu sẽ hiển thị thông báo
                if (list.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No data in File");
                }
                // hiển thị lên table
                fillTable();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtcodeStaff = new javax.swing.JTextField();
        txtFullname = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSalary = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnOpen = new javax.swing.JButton();
        btnFind1 = new javax.swing.JButton();
        btnSortname = new javax.swing.JButton();
        btnFirstly = new javax.swing.JButton();
        btnUp = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        lblRecord = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDataStaff = new javax.swing.JTable();
        lblTime = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        txtFind = new javax.swing.JTextField();
        rdoSortAZ = new javax.swing.JRadioButton();
        rdoSortZA = new javax.swing.JRadioButton();
        rdoSortAge = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        btnShow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ NHÂN VIÊN");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("MÃ NHÂN VIÊN:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("HỌ VÀ TÊN:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("TUỔI:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("EMAIL:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("LƯƠNG:");

        txtcodeStaff.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        txtFullname.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        txtAge.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        txtSalary.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnNew.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnNew.setText("NEW");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnOpen.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnOpen.setText("OPEN");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        btnFind1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnFind1.setText("UPDATE");
        btnFind1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFind1ActionPerformed(evt);
            }
        });

        btnSortname.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnSortname.setText("SORT");
        btnSortname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortnameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(btnOpen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnFind1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSortname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFind1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnSortname, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnFirstly.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnFirstly.setText("|<");
        btnFirstly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstlyActionPerformed(evt);
            }
        });

        btnUp.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnUp.setText("<<");
        btnUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnBack.setText(">>");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnLast.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        lblRecord.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblRecord.setForeground(new java.awt.Color(255, 0, 0));
        lblRecord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRecord.setText("Record: 1 of 10");

        tblDataStaff.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tblDataStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "null", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDataStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataStaffMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDataStaff);

        lblTime.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTime.setForeground(new java.awt.Color(204, 0, 0));
        lblTime.setText("dd/mm/yyyy 00:00:00");

        btnExit.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnFind.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnFind.setText("FIND");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoSortAZ);
        rdoSortAZ.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        rdoSortAZ.setText("Sort  A - Z");

        buttonGroup1.add(rdoSortZA);
        rdoSortZA.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        rdoSortZA.setText("Sort  Z - A");

        buttonGroup1.add(rdoSortAge);
        rdoSortAge.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        rdoSortAge.setSelected(true);
        rdoSortAge.setText("Sort  Age");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("GIỚI TÍNH:");

        buttonGroup2.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        rdoNam.setSelected(true);
        rdoNam.setText("NAM");

        buttonGroup2.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        rdoNu.setText("NỮ");

        btnShow.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnShow.setText("SHOW");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(rdoNam)
                                .addGap(18, 18, 18)
                                .addComponent(rdoNu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(399, 399, 399))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnFirstly)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnUp)
                                        .addGap(38, 38, 38)
                                        .addComponent(lblRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(42, 42, 42)
                                        .addComponent(btnBack)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnLast)
                                        .addGap(58, 58, 58)))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdoSortZA)
                                    .addComponent(rdoSortAZ)
                                    .addComponent(rdoSortAge))
                                .addGap(23, 23, 23)))
                        .addGap(38, 38, 38))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFullname)
                                    .addComponent(txtEmail)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtcodeStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 206, Short.MAX_VALUE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnShow)
                        .addGap(431, 431, 431)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(81, 81, 81)
                            .addComponent(lblTime)
                            .addGap(24, 24, 24))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lblTime))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcodeStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rdoSortAge)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoSortAZ)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoSortZA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 21, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFind, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFirstly)
                            .addComponent(btnUp)
                            .addComponent(btnBack)
                            .addComponent(btnLast)
                            .addComponent(lblRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(btnShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        addDataStaff();
        try {
            this.saveFile();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnFirstlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstlyActionPerformed
        FristlyStaff();
    }//GEN-LAST:event_btnFirstlyActionPerformed

    private void btnUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpActionPerformed
        UpStaff();
    }//GEN-LAST:event_btnUpActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        BackStaff();

    }//GEN-LAST:event_btnBackActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        LastStaff();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        NewStaff();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DeleteStaff();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        FindStaff();
    }//GEN-LAST:event_btnFindActionPerformed

    private void tblDataStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataStaffMouseClicked
        index = tblDataStaff.getSelectedRow();
        mouseClickTable(index);
    }//GEN-LAST:event_tblDataStaffMouseClicked

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        try {
            openFile();
            if (list.size() > 0) {
                index = 0;
                fillTable();
            } else {
                index = -1;
                NewStaff();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnOpenActionPerformed

    private void btnFind1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFind1ActionPerformed
        // TODO add your handling code here:
        UpdateStaff();
    }//GEN-LAST:event_btnFind1ActionPerformed

    private void btnSortnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortnameActionPerformed
        // TODO add your handling code here:
        SortStaff();
    }//GEN-LAST:event_btnSortnameActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        // TODO add your handling code here:
        LastStaff();
    }//GEN-LAST:event_btnShowActionPerformed
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
            java.util.logging.Logger.getLogger(From_manageStaff.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(From_manageStaff.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(From_manageStaff.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(From_manageStaff.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new From_manageStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnFind1;
    private javax.swing.JButton btnFirstly;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnShow;
    private javax.swing.JButton btnSortname;
    private javax.swing.JButton btnUp;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
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
    private javax.swing.JLabel lblRecord;
    private javax.swing.JLabel lblTime;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JRadioButton rdoSortAZ;
    private javax.swing.JRadioButton rdoSortAge;
    private javax.swing.JRadioButton rdoSortZA;
    private javax.swing.JTable tblDataStaff;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFind;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JTextField txtSalary;
    private javax.swing.JTextField txtcodeStaff;
    // End of variables declaration//GEN-END:variables
}
