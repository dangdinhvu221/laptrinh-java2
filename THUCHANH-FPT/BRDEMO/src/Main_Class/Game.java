/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_Class;

/**
 *
 * @author Dang Dinh Vu
 */
public class Game {

    private String ten, chedo;
    private int giochoi;

    public Game() {
    }

    public Game(String ten, int giochoi, String chedo) {
        this.ten = ten;
        this.giochoi = giochoi;
        this.chedo = chedo;
    }

   
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGiochoi() {
        return giochoi;
    }

    public void setGiochoi(int giochoi) {
        this.giochoi = giochoi;
    }

    public String getChedo() {
        return chedo;
    }

    public void setChedo(String chedo) {
        this.chedo = chedo;
    }

}
