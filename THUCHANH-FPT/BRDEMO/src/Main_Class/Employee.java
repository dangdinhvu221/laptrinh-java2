/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_Class;

import java.io.Serializable;

/**
 *
 * @author Dang Dinh Vu
 */
public class Employee implements Serializable{
    private String codeEmployee, fullname, Language;
    private int Age;

    public Employee() {
    }

    public Employee(String codeEmployee, String fullname, int Age , String Language) {
        this.codeEmployee = codeEmployee;
        this.fullname = fullname;
        this.Language = Language;
        this.Age = Age;
    }

    public String getCodeEmployee() {
        return codeEmployee;
    }

    public void setCodeEmployee(String codeEmployee) {
        this.codeEmployee = codeEmployee;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }
    
    public String getAgeLabor(){
        if(Age < 18){
            return "Chưa trưởng thành!!";
        }else if(Age < 40){
            return "Tuổi trẻ";
        }else if(Age < 60){
            return "Tuổi sắp về hưu";
        }else{
            return "Tuổi già";
        }
    }
    
}
