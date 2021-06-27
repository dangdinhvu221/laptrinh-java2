/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class_main;

import java.io.Serializable;

/**
 *
 * @author Đức DEV
 */
public class HoSo implements Serializable{
    private String name, gender, major, skills;

    public HoSo() {
    }

    
    public HoSo(String name, String gender, String major, String skills) {
        this.name = name;
        this.gender = gender;
        this.major = major;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
    
    
}
