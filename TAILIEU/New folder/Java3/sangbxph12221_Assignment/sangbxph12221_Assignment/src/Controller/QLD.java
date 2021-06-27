/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Khai2
 */
public class QLD {

    protected int ID;
    protected String TenSV;
    protected String MaSV;
    protected double TiengAnh;
    protected double TinHoc;
    protected double GDTC;
    protected double DTB;

    public QLD() {
    }

    public QLD(int ID, String MaSV, String TenSV, double TiengAnh, double TinHoc, double GDTC, double DTB) {
        this.ID = ID;
        this.MaSV = MaSV;
        this.TenSV = TenSV;
        this.TiengAnh = TiengAnh;
        this.TinHoc = TinHoc;
        this.GDTC = GDTC;
        this.DTB = DTB;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTenSV(String TenSV) {
        this.TenSV = TenSV;
    }

    public void setTiengAnh(double TiengAnh) {
        this.TiengAnh = TiengAnh;
    }

    public void setTinHoc(double TinHoc) {
        this.TinHoc = TinHoc;
    }

    public void setGDTC(double GDTC) {
        this.GDTC = GDTC;
    }

    public void setDTB(double DTB) {
        this.DTB = DTB;
    }

    public int getID() {
        return ID;
    }

    public String getTenSV() {
        return TenSV;
    }

    public String getMaSV() {
        return MaSV;
    }

    public double getTiengAnh() {
        return TiengAnh;
    }

    public double getTinHoc() {
        return TinHoc;
    }

    public double getGDTC() {
        return GDTC;
    }

    public double getDTB() {
        return DTB;
    }
}
