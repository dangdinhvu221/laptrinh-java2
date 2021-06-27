/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dang Dinh Vu
 */
public class manageStaffff {

    ArrayList<Staff> listNv = new ArrayList<>();

    public void add(Staff nv) {
        listNv.add(nv);
    }

    public void showTable(DefaultTableModel tblModel) {
        tblModel.setRowCount(0);
        listNv.stream().map(nhanVien -> new Object[]{
            nhanVien.getCodeStaff(), nhanVien.getFullnameStaff(), nhanVien.getAgeStaff(),
            nhanVien.getGenDer(), nhanVien.getEmailStaff(), nhanVien.getSalaryStaff()
        }).forEachOrdered(row -> {
            tblModel.addRow(row);
        });
        tblModel.fireTableDataChanged();
    }

    public Staff findId(String codeId) {
        for (Staff nhanVien : listNv) {
            if (nhanVien.getCodeStaff().equals(codeId)) {
                return nhanVien;
            }
        }
        return null;
    }

    public boolean deleteById(String codeDeleteId) {
        for (Staff nhanVien : listNv) {
            if (nhanVien.getCodeStaff().equals(codeDeleteId)) {
                listNv.remove(codeDeleteId);
                return true;
            }
        }
        return false;
    }

}
