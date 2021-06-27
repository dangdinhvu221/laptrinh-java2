/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Khai2
 */
public class User {
    protected String Username;
    protected String Password;
    protected String ChucVu;
    public User() {
    }

    public User(String Username, String Password, String ChucVu) {
        this.Username = Username;
        this.Password = Password;
        this.ChucVu = ChucVu;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }
    
    
}
