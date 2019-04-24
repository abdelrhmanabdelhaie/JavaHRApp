package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import com.model.Employee;

import com.util.EmpDBUtil;

import java.util.Date;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;

@WebService
@XmlSeeAlso({ EmpDBUtil.class })
public class EmpDao {
    
    private String result="";


    // --------------------------------------  getAllEmployees-------------------------------

    @WebMethod
    public List<Employee> getAllEmployees() {
        Connection conn = null;
        List<Employee> emplyeeList = new ArrayList<Employee>();
        try {
            conn = EmpDBUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rSet = stmt.executeQuery("select * from EMPLOYEES");
            while (rSet.next()) {
                Employee emp = new Employee();
                emp.setEmployee_id(rSet.getInt("EMPLOYEE_ID"));
                emp.setFirst_name(rSet.getString("FIRST_NAME"));
                emp.setLast_name(rSet.getString("LAST_NAME"));
                emp.setEmail(rSet.getString("EMAIL"));
                emp.setPhone_number(rSet.getString("PHONE_NUMBER"));
                emp.setHire_date(rSet.getDate("HIRE_DATE"));
                emp.setJop_id(rSet.getString("JOB_ID"));
                emp.setSalary(rSet.getInt("SALARY"));
                emp.setCommission_pct(rSet.getDouble("COMMISSION_PCT"));
                emp.setManager_id(rSet.getInt("MANAGER_ID"));
                emp.setDepartment_id(rSet.getInt("DEPARTMENT_ID"));

                emplyeeList.add(emp);
            }
            
            System.out.println("done");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            EmpDBUtil.closeConnection(conn);
        }

        return emplyeeList;
    }


    //---------------------------------   Get all employees in a specific department ------------------

    @WebMethod
    public List<Employee> getEmployeesInSpecificDepartment(@WebParam(name = "arg0") int dep_id) {
        Connection conn = null;
        List<Employee> emplyeeList = new ArrayList<Employee>();
        try {
            conn = EmpDBUtil.getConnection();
            PreparedStatement pStmt = conn.prepareStatement("select * from EMPLOYEES  where DEPARTMENT_ID = ?");
            pStmt.setInt(1, dep_id);
            ResultSet rSet = pStmt.executeQuery();
            while (rSet.next()) {
                Employee emp = new Employee();
                emp.setEmployee_id(rSet.getInt("EMPLOYEE_ID"));
                emp.setFirst_name(rSet.getString("FIRST_NAME"));
                emp.setLast_name(rSet.getString("LAST_NAME"));
                emp.setEmail(rSet.getString("EMAIL"));
                emp.setPhone_number(rSet.getString("PHONE_NUMBER"));
                emp.setHire_date(rSet.getDate("HIRE_DATE"));
                emp.setJop_id(rSet.getString("JOB_ID"));
                emp.setSalary(rSet.getInt("SALARY"));
                emp.setCommission_pct(rSet.getDouble("COMMISSION_PCT"));
                emp.setManager_id(rSet.getInt("MANAGER_ID"));
                emp.setDepartment_id(rSet.getInt("DEPARTMENT_ID"));

                emplyeeList.add(emp);
                
            }
            
            System.out.println("done");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            EmpDBUtil.closeConnection(conn);
        }

        return emplyeeList;
    }

    //---------------------------------------- get Employees by id --------------------------------------------


    @WebMethod
    public Employee getEmployeeById(@WebParam(name = "arg0") int empId) {
        Connection conn = null;
        Employee emp = null;
        try {
            conn = EmpDBUtil.getConnection();
            PreparedStatement pStmt = conn.prepareStatement("select * from EMPLOYEES  where EMPLOYEE_ID = ?");
            pStmt.setInt(1, empId);
            ResultSet rSet = pStmt.executeQuery();
            while (rSet.next()) {
                emp = new Employee();
                emp.setEmployee_id(rSet.getInt("EMPLOYEE_ID"));
                emp.setFirst_name(rSet.getString("FIRST_NAME"));
                emp.setLast_name(rSet.getString("LAST_NAME"));
                emp.setEmail(rSet.getString("EMAIL"));
                emp.setPhone_number(rSet.getString("PHONE_NUMBER"));
                emp.setHire_date(rSet.getDate("HIRE_DATE"));
                emp.setJop_id(rSet.getString("JOB_ID"));
                emp.setSalary(rSet.getInt("SALARY"));
                emp.setCommission_pct(rSet.getDouble("COMMISSION_PCT"));
                emp.setManager_id(rSet.getInt("MANAGER_ID"));
                emp.setDepartment_id(rSet.getInt("DEPARTMENT_ID"));
            }
            
            System.out.println("done");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            EmpDBUtil.closeConnection(conn);
        }

        return emp;
    }

    // ----------------------------------------- insert new Employee ------------------------------


    @WebMethod
    public String addEmployee(@WebParam(name = "arg0") Employee emp) {
        Connection conn = null;
        try {

            conn = EmpDBUtil.getConnection();
            PreparedStatement pStmt =
                conn.prepareStatement("insert into EMPLOYEES " +
                                      "(EMPLOYEE_ID,FIRST_NAME,LAST_NAME , EMAIL , PHONE_NUMBER , HIRE_DATE  , JOB_ID , SALARY ,COMMISSION_PCT ,MANAGER_ID  , DEPARTMENT_ID) " +
                                      "values (?, ?, ? ,?, ?, ?,?, ?, ?,?, ?)");

            pStmt.setInt(1, emp.getEmployee_id());
            pStmt.setString(2, emp.getFirst_name());
            pStmt.setString(3, emp.getLast_name());
            pStmt.setString(4, emp.getEmail());
            pStmt.setString(5, emp.getPhone_number());
            pStmt.setDate(6, new java.sql.Date(emp.getHire_date().getTime()));
            pStmt.setString(7, emp.getJop_id());
            pStmt.setInt(8, emp.getSalary());
            pStmt.setDouble(9, emp.getCommission_pct());
            pStmt.setInt(10, emp.getManager_id());
            pStmt.setInt(11, emp.getDepartment_id());

            pStmt.executeUpdate();
            
            if(pStmt.executeUpdate()  != Statement.EXECUTE_FAILED){
                result = "Emplyee inserted succefully";
            }else
            result = "Emplyee insert  faild";
            
            
            
            System.out.println("Inserted");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            EmpDBUtil.closeConnection(conn);
        }
        return result;
    }


    // -------------------------------------  Update employee  ----------------------------


    @WebMethod
    @Oneway
    public void updateEmplyee(@WebParam(name = "arg0") Employee emp) {
        Connection conn = null;
        try {
            conn = EmpDBUtil.getConnection();
            PreparedStatement pStmt =
                conn.prepareStatement("update EMPLOYEES set FIRST_NAME=?, LAST_NAME=? , EMAIL=? ,PHONE_NUMBER=? , HIRE_DATE=? , JOB_ID=? , SALARY=? , COMMISSION_PCT =? ,MANAGER_ID=?  ,DEPARTMENT_ID =? " +
                                      "where EMPLOYEE_ID=?");

            pStmt.setString(1, emp.getFirst_name());
            pStmt.setString(2, emp.getLast_name());
            pStmt.setString(3, emp.getEmail());
            pStmt.setString(4, emp.getPhone_number());
            pStmt.setDate(5, new java.sql.Date(emp.getHire_date().getTime()));
            pStmt.setString(6, emp.getJop_id());
            pStmt.setInt(7, emp.getSalary());
            pStmt.setDouble(8, emp.getCommission_pct());
            pStmt.setInt(9, emp.getManager_id());
            pStmt.setInt(10, emp.getDepartment_id());
           
            pStmt.setInt(11, emp.getEmployee_id());
            pStmt.executeUpdate();
            
            System.out.println("Updated");


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            EmpDBUtil.closeConnection(conn);
        }
    }


  // ------------------------------------------  Delete employee -------------------------


    @WebMethod
    @Oneway
    public void deleteEmployee(@WebParam(name = "arg0") int empId) {
        Connection conn = null;
        try {
            conn = EmpDBUtil.getConnection();
            PreparedStatement pStmt = conn.prepareStatement("delete from EMPLOYEES where EMPLOYEE_ID =? ");

            pStmt.setInt(1, empId);
            pStmt.executeUpdate();
            
            System.out.println("Deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            EmpDBUtil.closeConnection(conn);
        }
    }
 
  // -----------------------  Get employees with salary  >   Paramater ----------------------


    @WebMethod
    public List<Employee> getEmployeesBySalary(@WebParam(name = "arg0") int emp_sal) {
      Connection conn = null;
      List<Employee> emplyeeList = new ArrayList<Employee>();
      try {
          conn = EmpDBUtil.getConnection();
          PreparedStatement pStmt = conn.prepareStatement("select * from EMPLOYEES  where  SALARY > ?");
          pStmt.setInt(1, emp_sal);
          ResultSet rSet = pStmt.executeQuery();
          while (rSet.next()) {
              Employee emp = new Employee();
              emp.setEmployee_id(rSet.getInt("EMPLOYEE_ID"));
              emp.setFirst_name(rSet.getString("FIRST_NAME"));
              emp.setLast_name(rSet.getString("LAST_NAME"));
              emp.setEmail(rSet.getString("EMAIL"));
              emp.setPhone_number(rSet.getString("PHONE_NUMBER"));
              emp.setHire_date(rSet.getDate("HIRE_DATE"));
              emp.setJop_id(rSet.getString("JOB_ID"));
              emp.setSalary(rSet.getInt("SALARY"));
              emp.setCommission_pct(rSet.getDouble("COMMISSION_PCT"));
              emp.setManager_id(rSet.getInt("MANAGER_ID"));
              emp.setDepartment_id(rSet.getInt("DEPARTMENT_ID"));

              emplyeeList.add(emp);
              
          }
          
          System.out.println("done");
      } catch (SQLException e) {
          e.printStackTrace();
      } finally {
          EmpDBUtil.closeConnection(conn);
      }

      return emplyeeList;
  }

// ------------------------------ Get employees with hire date more than 6 months --------------


    @WebMethod
    public List<Employee> getAllEmployeesByHireDate() {
        Connection conn = null;
        List<Employee> emplyeeList = new ArrayList<Employee>();
        try {
            conn = EmpDBUtil.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rSet = stmt.executeQuery("  select *   from employees \n" + 
            "  where months_between(sysdate,HIRE_DATE) > 200 ");
            while (rSet.next()) {
                Employee emp = new Employee();
                emp.setEmployee_id(rSet.getInt("EMPLOYEE_ID"));
                emp.setFirst_name(rSet.getString("FIRST_NAME"));
                emp.setLast_name(rSet.getString("LAST_NAME"));
                emp.setEmail(rSet.getString("EMAIL"));
                emp.setPhone_number(rSet.getString("PHONE_NUMBER"));
                emp.setHire_date(rSet.getDate("HIRE_DATE"));
                emp.setJop_id(rSet.getString("JOB_ID"));
                emp.setSalary(rSet.getInt("SALARY"));
                emp.setCommission_pct(rSet.getDouble("COMMISSION_PCT"));
                emp.setManager_id(rSet.getInt("MANAGER_ID"));
                emp.setDepartment_id(rSet.getInt("DEPARTMENT_ID"));

                emplyeeList.add(emp);
            }
            
            System.out.println("done");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            EmpDBUtil.closeConnection(conn);
        }

        return emplyeeList;
    }



}
