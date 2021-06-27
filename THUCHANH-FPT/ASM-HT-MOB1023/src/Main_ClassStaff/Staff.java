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
public class Staff implements Serializable {

    private String codeStaff, fullnameStaff, Email, Gender;
    private int Age;
    private double Salary;

    public Staff(String codeStaff, String fullnameStaff, int Age, String Gender, String Email, double Salary) {
        this.codeStaff = codeStaff;
        this.fullnameStaff = fullnameStaff;
        this.Email = Email;
        this.Age = Age;
        this.Salary = Salary;
        this.Gender = Gender;
    }

    public Staff() {
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getCodeStaff() {
        return codeStaff;
    }

    public void setCodeStaff(String codeStaff) {
        this.codeStaff = codeStaff;
    }

    public String getFullnameStaff() {
        return fullnameStaff;
    }

    public void setFullnameStaff(String fullnameStaff) {
        this.fullnameStaff = fullnameStaff;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }
}
