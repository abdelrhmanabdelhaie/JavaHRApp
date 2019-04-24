package com.model;

import java.util.Date;

public class Employee {
    
    private int employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private Date hire_date;
    private String jop_id;
    private int salary;
    private Double commission_pct;
    private int manager_id;
    private int department_id;
    
    public Employee(){
        
    }


    public Employee(int employee_id, String first_name, String last_name, String email, String phone_number,
                    Date hire_date, String jop_id, int salary, double commission_pct, int manager_id, int department_id) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.hire_date = hire_date;
        this.jop_id = jop_id;
        this.salary = salary;
        this.commission_pct = commission_pct;
        this.manager_id = manager_id;
        this.department_id = department_id;
    }


    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setJop_id(String jop_id) {
        this.jop_id = jop_id;
    }

    public String getJop_id() {
        return jop_id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setCommission_pct(Double commission_pct) {
        this.commission_pct = commission_pct;
    }

    public Double getCommission_pct() {
        return commission_pct;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getDepartment_id() {
        return department_id;
    }


}
