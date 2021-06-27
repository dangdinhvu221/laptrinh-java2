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
public class NGUOIYEUCU {
    private String name, address, skill, gender;
    private int Age;

    public NGUOIYEUCU() {
    }

    public NGUOIYEUCU(String name, String address,int Age, String skill, String gender) {
        this.name = name;
        this.address = address;
        this.skill = skill;
        this.gender = gender;
        this.Age = Age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }
    
    
}
