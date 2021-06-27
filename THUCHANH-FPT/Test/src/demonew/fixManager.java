/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demonew;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dang Dinh Vu
 */
public class fixManager {

    private ArrayList<fix> listF = new ArrayList<>();

    public void add(fix f) {
        listF.add(f);
    }

    public void showTable(DefaultTableModel tblModel) {
        tblModel.setRowCount(0);
        for (fix object : listF) {
            Object[] row = new Object[]{
                object.getName(), object.getAge(), object.getSalary()
            };
            tblModel.addRow(row);
        }
        tblModel.fireTableDataChanged();
    }
}
