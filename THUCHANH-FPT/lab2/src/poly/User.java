/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly;

/**
 *
 * @author Dang Dinh Vu
 */
public class User {
    private String Fullname;
    private String Password;
    private String Role;

    public User(String Fullname, String Password, String Role) {
        this.Fullname = Fullname;
        this.Password = Password;
        this.Role = Role;
    }

    public User() {
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }
    
    
}
