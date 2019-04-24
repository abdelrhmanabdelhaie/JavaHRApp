package main;

import com.dao.EmpDao;

import com.model.Employee;

import java.util.Date;
import java.util.List;

public class Run {

    @SuppressWarnings("deprecation")
    public static void main(String [] args){
        /*
        EmpDao ed=new EmpDao();
        Employee emp;
      //  emp = new Employee(989, "ro7oby", "mazen", "df", "515.124.429", new Date("17-AUG-02"), "FI_MGR", 124, 0.2, 101, 100);
        ed.deleteEmployee(2222);
    */
     
        EmpDao ed=new EmpDao();
        List<Employee> empList= ed.getAllEmployeesByHireDate();
       
       for (Employee emp : empList) {
          System.out.println(emp.getSalary());
       }
         
        
        
        
        
        
        
        
    }
  
}
