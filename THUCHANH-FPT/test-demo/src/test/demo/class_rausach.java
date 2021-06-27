/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.demo;

/**
 *
 * @author Dang Dinh Vu
 */
public class class_rausach {

    private String ten, diachi;
    private double gia, KhoangCach;

    public class_rausach() {
    }

    public class_rausach(String ten, String diachi, double gia, double KhoangCach) {
        this.ten = ten;
        this.diachi = diachi;
        this.gia = gia;
        this.KhoangCach = KhoangCach;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public double getKhoangCach() {
        return KhoangCach;
    }

    public void setKhoangCach(double KhoangCach) {
        this.KhoangCach = KhoangCach;
    }

    
}
