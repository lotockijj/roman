package lab.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lab.dao.StudentDao;
import lab.model.Student;
import lab.persistent.ConnectorManager;
import lab.transforment.StudentTransformer;

public class StudentDaoImpl implements StudentDao {
	private static final String CREATE = "INSERT INTO student (kod, firstName, lastName, birthDay, sex) "
			+ "values(?, ?, ?, ?, ?)";
	private static final String GETALL = "SELECT *FROM student";
	private static final String DELETE = "DELETE FROM student WHERE kod = ?";
	//private static final String UPDATE = "update student set (new values where where id = ?";
	
	@Override
	public void create(Student student) throws SQLException {
		try(Connection conn = ConnectorManager.getConnection();
				PreparedStatement ps = conn.prepareStatement(CREATE)){
			ps.setInt(1, student.getKod());
			ps.setString(2, student.getFirstName());
			ps.setString(3, student.getLastName());
			ps.setDate(4, student.getbDay());
			ps.setString(5, student.getSex().name());
			ps.executeUpdate();
		}
	}

	@Override
	public void deleteByKod(Integer kod) throws SQLException {
		try(Connection conn = ConnectorManager.getConnection();
				PreparedStatement ps = conn.prepareStatement(DELETE)){
			ps.setInt(1, kod);
			ps.executeUpdate();
		}
		
	}

	@Override
	public List<Student> getAllStudent() throws SQLException {
		List<Student> students = new ArrayList<>();
		try(Connection conn = ConnectorManager.getConnection();
				Statement st = conn.createStatement(); 
				ResultSet myRs = st.executeQuery(GETALL)){
			while(myRs.next()) {
				students.add(new StudentTransformer().fromResultSetToStudent(myRs));
			}
		}
		return students;
	}

}
