package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionManager {
	private Connection myConn;
	Properties p;

	public ConnectionManager() throws SQLException {
		setDataForConnection();
		myConn = DriverManager.getConnection((String) p.get("dbUrl"), p);
	}

	private void setDataForConnection() {
		p  = new Properties();
		p.put("user", "root");
		p.put("password", "135135aa");
		p.put("dbUrl", "jdbc:mysql://localhost:3306/mydb");
	}

	public void printDepartment(){
		try(Statement stmt = myConn.createStatement();
				ResultSet myRes = stmt.executeQuery("SELECT *FROM DEPARTMENT")){
			while(myRes.next()){
				System.out.println(myRes.getString("dept_no") + ", " +
						myRes.getString("dept_name") + ": " +  myRes.getString("location"));
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void printWorksOn() {
		try(Statement stmt = myConn.createStatement();
				ResultSet myRes = stmt.executeQuery("SELECT *FROM WORKS_ON")){
			while(myRes.next()){
				System.out.println(myRes.getInt("emp_no") + ", " + myRes.getString("project_no") + 
						", " +  myRes.getString("job") + ", " + myRes.getDate("enter_date"));
			}
		} catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public void printEmployeeEnh() {
		try(Statement stmt = myConn.createStatement();
				ResultSet myRes = stmt.executeQuery("SELECT *FROM EMPLOYEE_ENH")){
			while(myRes.next()){
				System.out.println(myRes.getInt("emp_no") + ", " + myRes.getString("emp_fname") + 
						", " +  myRes.getString("emp_lname") + ", " + myRes.getString("dept_no") + 
						", " + myRes.getString("domicile"));
			}
		} catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	public void printProject() {
		try(Statement stmt = myConn.createStatement();
				ResultSet myRes = stmt.executeQuery("SELECT *FROM PROJECT")){
			while(myRes.next()){
				System.out.println(myRes.getString("project_no") + ", " + myRes.getString("project_name") + 
						", " +  myRes.getInt("budget"));
			}
		} catch(Exception e){
			e.printStackTrace();
		}	
	}

	public static void main(String[] args) throws SQLException {
		ConnectionManager con = new ConnectionManager();
		con.printDepartment();
		System.out.println("****************************");
		con.printWorksOn();
		System.out.println("****************************");
		con.printEmployeeEnh();
		System.out.println("****************************");
		con.printProject();
	}
}
