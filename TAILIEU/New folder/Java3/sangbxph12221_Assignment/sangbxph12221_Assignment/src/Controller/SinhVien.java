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
public class SinhVien {

    protected String MaSV;
    protected String HoTen;
    protected String Email;
    protected String SoDT;
    protected String GT;
    protected String DiaChi;
    protected String Images;

    public SinhVien() {
    }

    public SinhVien(String MaSV, String HoTen, String Email, String SoDT, String GT, String DiaChi, String Images) {
        this.MaSV = MaSV;
        this.HoTen = HoTen;
        this.Email = Email;
        this.SoDT = SoDT;
        this.GT = GT;
        this.DiaChi = DiaChi;
        this.Images = Images;
    }

    public String getMaSV() {
        return MaSV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public String getEmail() {
        return Email;
    }

    public String getSoDT() {
        return SoDT;
    }

    public String getGT() {
        return GT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getImages() {
        return Images;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public void setGT(String GT) {
        this.GT = GT;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setImages(String Images) {
        this.Images = Images;
    }
}
