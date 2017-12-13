
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employees {
    
    private Long employeesId;
    private String employeesName;
    private String phone;
    private String mail;
    private int salary;
    private int departmentsId;
    private int positionsId;

    public Employees() {
        
    }

    public Employees(Long employeesId, String employeesName, String phone, String mail, int salary, int departmentsId, int positionsId) {
        this.employeesId = employeesId;
        this.employeesName = employeesName;
        this.phone = phone;
        this.mail = mail;
        this.salary = salary;
        this.departmentsId = departmentsId;
        this.positionsId = positionsId;
    }

    @Id
    @Column(name = "employees_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(Long employeesId) {
        this.employeesId = employeesId;
    }

    @Column(name = "employees_name")
    public String getEmployeesName() {
        return employeesName;
    }

    public void setEmployeesName(String employeesName) {
        this.employeesName = employeesName;
    }

    @Column
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Column
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Column(name = "departments_id")
    public int getDepartmentsId() {
        return departmentsId;
    }

    public void setDepartmentsId(int departmentsId) {
        this.departmentsId = departmentsId;
    }

    @Column(name = "positions_id")
    public int getPositionsId() {
        return positionsId;
    }

    public void setPositionsId(int positionsId) {
        this.positionsId = positionsId;
    }
}
