/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btvn;

/**
 *
 * @author Dang Dinh Vu
 */
public class QLTK {
    private String Username, passWorld, rePassWorld, sdt;

    public QLTK(String Username, String passWorld, String rePassWorld, String sdt) {
        this.Username = Username;
        this.passWorld = passWorld;
        this.rePassWorld = rePassWorld;
        this.sdt = sdt;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassWorld() {
        return passWorld;
    }

    public void setPassWorld(String passWorld) {
        this.passWorld = passWorld;
    }

    public String getRePassWorld() {
        return rePassWorld;
    }

    public void setRePassWorld(String rePassWorld) {
        this.rePassWorld = rePassWorld;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
    
}
