/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btvn;

/**
 *
 * @author Dang Dinh Vus
 */
public class DanhSachTuong {
    private String tenTuong, kyNang, LoaiTuong, gioiTinh;

    public DanhSachTuong(String tenTuong, String kyNang, String LoaiTuong, String gioiTinh) {
        this.tenTuong = tenTuong;
        this.kyNang = kyNang;
        this.LoaiTuong = LoaiTuong;
        this.gioiTinh = gioiTinh;
    }
    

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public DanhSachTuong() {
    }
    
    public String getTenTuong() {
        return tenTuong;
    }

    public void setTenTuong(String tenTuong) {
        this.tenTuong = tenTuong;
    }

    public String getKyNang() {
        return kyNang;
    }

    public void setKyNang(String kyNang) {
        this.kyNang = kyNang;
    }

    public String getLoaiTuong() {
        return LoaiTuong;
    }

    public void setLoaiTuong(String LoaiTuong) {
        this.LoaiTuong = LoaiTuong;
    }

    
}
