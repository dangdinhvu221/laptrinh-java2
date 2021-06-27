/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_ClassStaff;

import java.io.Serializable;

/**
 *
 * @author Dang Dinh Vu
 */
public class Singup implements Serializable{
    private String User, pass, rePass, email, numberPhone;

    public Singup() {
    }

    public Singup(String User, String pass, String rePass, String email, String numberPhone) {
        this.User = User;
        this.pass = pass;
        this.rePass = rePass;
        this.email = email;
        this.numberPhone = numberPhone;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRePass() {
        return rePass;
    }

    public void setRePass(String rePass) {
        this.rePass = rePass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
}
