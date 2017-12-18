package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DepartmentDao {
	private Connection myConn;
	Properties p;

	public DepartmentDao() throws SQLException {
		setDataForConnection();
		myConn = DriverManager.getConnection((String) p.get("dbUrl"), p);
	}

	private void setDataForConnection() {
		p  = new Properties();
		p.put("user", "root");
		p.put("password", "135135aa");
		p.put("dbUrl", "jdbc:mysql://localhost:3306/mydb");
	}

	public List<Department> getAllDepartments(){
		List<Department> departments = new ArrayList<>();
		try(Statement myStmt = myConn.createStatement();
				ResultSet 	myRs = myStmt.executeQuery("select *from department;")){
			while(myRs.next()){
				Department tempGoods = convertRowToUser(myRs);
				departments.add(tempGoods);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return departments;
	}

	private Department convertRowToUser(ResultSet myRs) {
		Department tempDepartment = new Department();
		try{
			String deptNo = myRs.getString("dept_no");
			String deptName = myRs.getString("dept_name");
			String location = myRs.getString("location");
			tempDepartment = new Department(deptNo, deptName, location);
		} catch (SQLException e){
			e.printStackTrace();
		}
		return tempDepartment;
	}

	public static void main(String[] args) throws SQLException {
		DepartmentDao daoDep = new DepartmentDao();
		List<Department> departments = daoDep.getAllDepartments();
		departments.forEach(e -> System.out.println(e));
	}
	
}
