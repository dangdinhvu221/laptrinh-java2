/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class_main;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.DefaultTableModel;
import Validate_IO.IODataHoso;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Đức DEV
 */
public class managerHoSo {

    public ArrayList<HoSo> listHs = new ArrayList<>();
    private String path = "Hoso.dat";

    public void saveFileToTable() throws IOException {
        IODataHoso.writeObject(path, listHs);
    }

    public void laodFiletoTable() throws Exception {
        File file = new File(path);
        if (file.exists()) {
            listHs = (ArrayList<HoSo>) IODataHoso.readObject(path);
        } else {
            addListData();
        }

    }

    public void addListData() {
        listHs.add(new HoSo("Đỗ Thị Lương", "Nữ", "Kinh Tế", "Smart"));
        listHs.add(new HoSo("Nguyễn Văn Đức", "Nam", "Ứng Dụng", "Vip"));
        listHs.add(new HoSo("Trịnh Viết Lượng", "Nữ", "IOT", "OK"));
        listHs.add(new HoSo("Đặng Đình Vũ", "Nam", "AI", "Tạm Đước"));
        listHs.add(new HoSo("Nguyễn Hà Trang", "Nữ", "Kinh Tế", "MõmVIP"));
        listHs.add(new HoSo("Nguyễn Minh Duy", "Nam", "Xây Dựng", "MõmGà"));
    }

    public void showTable(DefaultTableModel tblMode) {
        tblMode.setRowCount(0);

        listHs.stream().map(listH -> new Object[]{
            listH.getName(), listH.getGender(), listH.getMajor(), listH.getSkills()
        }).forEachOrdered(row -> {
            tblMode.addRow(row);
        });
        tblMode.fireTableDataChanged();
    }

    public void add(HoSo hs) {
        listHs.add(hs);
    }

    public boolean checkTrung(String acc) {
        boolean check = false;
        for (int i = 0; i < listHs.size(); i++) {
            if (listHs.get(i).getName().equals(acc)) {
                check = true;
            }
        }
        return check;
    }

    public boolean deleteHs(String dltHs) {
        for (HoSo listH : listHs) {
            if (listH.getName().equals(dltHs)) {
                listHs.remove(listH);
                return true;
            }
        }
        return false;
    }

    public void sortName() {
        Collections.sort(listHs, (o1, o2) -> {
            return o1.getName().compareTo(o2.getName()); //To change body of generated lambdas, choose Tools | Templates.
        });
    }

    public void renderFile(DefaultTableModel tblModel) {
        showTable(tblModel);
    }
//    public void 
}
