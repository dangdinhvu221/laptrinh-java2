/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;
import java.io.Serializable;
/**
 *
 * @author Dang Dinh Vu
 */
public class QLSV implements Serializable{

    private String maMeo, hoVaTen, kyNang, gioTinh, ghiChu;
    private double diemGia;

    public QLSV() {
    }

    public QLSV(String maMeo, String hoVaTen, double diemGia, String gioTinh, String kyNang, String ghiChu) {
        this.maMeo = maMeo;
        this.hoVaTen = hoVaTen;
        this.kyNang = kyNang;
        this.gioTinh = gioTinh;
        this.ghiChu = ghiChu;
        this.diemGia = diemGia;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaMeo() {
        return maMeo;
    }

    public void setMaMeo(String maMeo) {
        this.maMeo = maMeo;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getKyNang() {
        return kyNang;
    }

    public void setKyNang(String kyNang) {
        this.kyNang = kyNang;
    }

    public String getGioTinh() {
        return gioTinh;
    }

    public void setGioTinh(String gioTinh) {
        this.gioTinh = gioTinh;
    }

    public double getDiemGia() {
        return diemGia;
    }

    public void setDiemGia(double diemGia) {
        this.diemGia = diemGia;
    }
}
