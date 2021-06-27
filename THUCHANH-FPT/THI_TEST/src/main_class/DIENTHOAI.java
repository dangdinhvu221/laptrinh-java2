/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_class;

import java.io.Serializable;

/**
 *
 * @author Dang Dinh Vu
 */
public class DIENTHOAI implements Serializable{
    private String ten, hang, trangThai;
    private double gia;

    public DIENTHOAI() {
    }

    public DIENTHOAI(String ten, String hang, double gia) {
        this.ten = ten;
        this.hang = hang;
        this.gia = gia;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
    
    public String getStatus(double gia){
        if(gia >= 1000){
            return "Tốt";
        }else{
            return "Bình Thuong";
        }
    }
    
    public String getTTHD(){
        return "Đang hoạt động";
    }
}
