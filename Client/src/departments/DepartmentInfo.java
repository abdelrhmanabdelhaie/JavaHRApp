package departments;

public class DepartmentInfo {
    
    private int departmentID;
    private String depratmentName;
    private int managerID;
    private int locationID;
    public DepartmentInfo(){}
    public DepartmentInfo(int departmentID, String depratmentName, int managerID, int locationID) {
        super();
        this.departmentID = departmentID;
        this.depratmentName = depratmentName;
        this.managerID = managerID;
        this.locationID = locationID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepratmentName(String depratmentName) {
        this.depratmentName = depratmentName;
    }

    public String getDepratmentName() {
        return depratmentName;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public int getLocationID() {
        return locationID;
    }
}
