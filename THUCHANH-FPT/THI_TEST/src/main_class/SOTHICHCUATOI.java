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
public class SOTHICHCUATOI implements Serializable {

    private String hoTen, soDT, Uong, Com;

    public SOTHICHCUATOI() {
    }

    public SOTHICHCUATOI(String hoTen, String soDT, String Uong, String Com) {
        this.hoTen = hoTen;
        this.soDT = soDT;
        this.Uong = Uong;
        this.Com = Com;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getUong() {
        return Uong;
    }

    public void setUong(String Uong) {
        this.Uong = Uong;
    }

    public String getCom() {
        return Com;
    }

    public void setCom(String Com) {
        this.Com = Com;
    }

    public String getKetLuan(String doUong) {
        if (Uong.equalsIgnoreCase("rượu")) {
            return "Nhiện nặng";
        } else if (Uong.equalsIgnoreCase("bia")) {
            return "Nghiện vừa";
        } else {
            return "Không tốt";
        }
    }
}
