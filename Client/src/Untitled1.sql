

/*??????*/
/*procedur for select is not working leave it now  */


Create procedure deleteDepartment (DEPARTMENT_ID  NUMBER)
as
begin
DELETE FROM DEPARTMENTS WHERE DEPARTMENTS.DEPARTMENT_ID=deleteDepartment.DEPARTMENT_ID;
end;

Create procedure insertDepartment (DEPARTMENT_ID  NUMBER,DEPARTMENT_NAME VARCHAR ,MANAGER_ID NUMBER ,LOCATION_ID NUMBER)
as
begin
INSERT INTO DEPARTMENTS(Department_id,department_name,manager_id,location_id) VALUES (DEPARTMENT_ID,DEPARTMENT_NAME,MANAGER_ID,LOCATION_ID);
end;


Create procedure updateDepartment (DEPARTMENT_ID  NUMBER,DEPARTMENT_NAME VARCHAR ,MANAGER_ID NUMBER ,LOCATION_ID NUMBER)
as
begin
UPDATE DEPARTMENTS SET DEPARTMENTS.DEPARTMENT_NAME =updateDepartment.DEPARTMENT_NAME ,DEPARTMENTS.MANAGER_ID= updateDepartment.MANAGER_ID ,DEPARTMENTS.LOCATION_ID = updateDepartment.LOCATION_ID WHERE DEPARTMENTS.DEPARTMENT_ID = updateDepartment.DEPARTMENT_ID;
end;




variable dept refcursor;
CALL selectAllDepartments;
print dept;
