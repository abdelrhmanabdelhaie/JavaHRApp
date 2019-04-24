package departments;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({ DbUtils.class })
@WebService
public class Main {

    @WebMethod
    public List<DepartmentInfo> getAllDepartments() throws SQLException {
    return DbUtils.getAllDepartments();  
    }

    @WebMethod
    public DepartmentInfo getDepartmentByID(@WebParam(name = "id") int id) throws SQLException {
      return DbUtils.getDepartmentByID(id);
    }

    @WebMethod
    public String insertDepartment(@WebParam(name = "departmentID") int departmentID,
                                   @WebParam(name = "departmentName") String departmentName,
                                   @WebParam(name = "locationID") int locationID, @WebParam(name = "managerID") int managerID)  {
      return DbUtils.insertDepartment(departmentID, departmentName, locationID, managerID);
  }

    @WebMethod
    public String deleteDepartment(@WebParam(name = "departmentId") int departmentId)  {
      return DbUtils.deleteDepartment(departmentId);
    }

    @WebMethod
    public String updateDepartment(@WebParam(name = "departmentID") int departmentID,
                                   @WebParam(name = "departmentName") String departmentName,
                                   @WebParam(name = "managerID") int managerID, @WebParam(name = "locationID") int locationID)  {
      return DbUtils.updateDepartment(departmentID, departmentName, managerID, locationID);
    }
  
}
