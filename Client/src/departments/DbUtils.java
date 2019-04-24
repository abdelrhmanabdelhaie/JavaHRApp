package departments;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleDriver;

public class DbUtils {

    
    private static final String INSERT_DEPARTMENT = "CALL insertDepartment (?,?,?,?)";
    private static final String UPDATE_DEPARTMENT = "CALL updateDepartment (?,?,?,?)";
    private static final String DELETE_DEPARTMENT = "CALL deleteDepartment (?)";
    private static final String ALL_DEPARTMENT_QUERY = "SELECT * FROM DEPARTMENTS";
    private static final String DEPARTMENT_BY_ID = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";
    public static Connection getConnection() throws SQLException {
        String username = "hr";
        String password = "hr";
        String thinConn = "jdbc:oracle:thin:@localhost:1521:xe";
        DriverManager.registerDriver(new OracleDriver());
        Connection conn = DriverManager.getConnection(thinConn, username, password);
        conn.setAutoCommit(false);
        return conn;
    }


    public static List<DepartmentInfo> getAllDepartments() {
        Connection conn = null;
        List<DepartmentInfo> departments = new ArrayList<>();
        try {
            conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(ALL_DEPARTMENT_QUERY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                departments.add(new DepartmentInfo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (conn != null)
                try {
                    conn.close();
                } catch (SQLException e) {
                }
        }
        return departments;
    }


    public static DepartmentInfo getDepartmentByID(int departmentID) throws SQLException {
        Connection conn = null;
        DepartmentInfo department = null;
        try {
            conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(DEPARTMENT_BY_ID);
            ps.setInt(1, departmentID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            department = new DepartmentInfo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (conn != null)
                try {
                    conn.close();
                } catch (SQLException e) {
                }
        }
        return department;

    }

    public static String insertDepartment(int departmentID, String departmentName, int managerID, int locationID) {
        Connection conn = null;
        String result = "";
        try {
            conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(INSERT_DEPARTMENT);
            ps.setInt(1, departmentID);
            ps.setString(2, departmentName);
            ps.setInt(3, managerID);
            ps.setInt(4, locationID);

            if (ps.executeUpdate() != Statement.EXECUTE_FAILED) {
                result = "Department inserted succefully";
            } else
                result = "faild to insert department";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (conn != null)
                try {
                    conn.close();
                } catch (SQLException e) {
                }
        }
        return result;
    }


    public static String deleteDepartment(int departmentID) {
        Connection conn = null;
        String result = "";
        try {
            conn = getConnection();

            PreparedStatement ps = conn.prepareStatement(DELETE_DEPARTMENT);
            ps.setInt(1, departmentID);
            System.out.println(ps.executeUpdate());


            if (ps.executeUpdate() != Statement.EXECUTE_FAILED) {
                result = "Department deleted succefully";
            } else
                result = "faild to delete department";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (conn != null)
                try {
                    conn.close();
                } catch (SQLException e) {
                }
        }
        return result;
    }


    public static String updateDepartment(int departmentID, String departmentName, int managerID, int locationID) {
        Connection conn = null;
        String result = "";
        try {
            conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_DEPARTMENT);
            ps.setInt(1, departmentID);
            ps.setString(2, departmentName);
            ps.setInt(3, managerID);
            ps.setInt(4, locationID);
            
            if (ps.executeUpdate() != Statement.EXECUTE_FAILED) {
                result = "Department updated succefully";
            } else
                result = "faild to updated department";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (conn != null)
                try {
                    conn.close();
                } catch (SQLException e) {
                }
        }
        return result;
    }

}
