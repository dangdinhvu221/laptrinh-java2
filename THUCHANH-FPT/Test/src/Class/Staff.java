/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author Dang Dinh Vu
 */
public class Staff {
    private String codeStaff, FullnameStaff, EmailStaff, genDer;
    private int AgeStaff;
    private double SalaryStaff;

    public Staff() {
    }

    public Staff(String codeStaff, String FullnameStaff, int AgeStaff, String genDer, String EmailStaff, double SalaryStaff) {
        this.codeStaff = codeStaff;
        this.FullnameStaff = FullnameStaff;
        this.EmailStaff = EmailStaff;
        this.genDer = genDer;
        this.AgeStaff = AgeStaff;
        this.SalaryStaff = SalaryStaff;
    }

    public String getGenDer() {
        return genDer;
    }

    public void setGenDer(String genDer) {
        this.genDer = genDer;
    }

    

    public String getCodeStaff() {
        return codeStaff;
    }

    public void setCodeStaff(String codeStaff) {
        this.codeStaff = codeStaff;
    }

    public String getFullnameStaff() {
        return FullnameStaff;
    }

    public void setFullnameStaff(String FullnameStaff) {
        this.FullnameStaff = FullnameStaff;
    }

    public String getEmailStaff() {
        return EmailStaff;
    }

    public void setEmailStaff(String EmailStaff) {
        this.EmailStaff = EmailStaff;
    }

    public int getAgeStaff() {
        return AgeStaff;
    }

    public void setAgeStaff(int AgeStaff) {
        this.AgeStaff = AgeStaff;
    }

    public double getSalaryStaff() {
        return SalaryStaff;
    }

    public void setSalaryStaff(double SalaryStaff) {
        this.SalaryStaff = SalaryStaff;
    }
    
    
}
