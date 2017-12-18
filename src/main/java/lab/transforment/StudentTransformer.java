package lab.transforment;

import java.sql.ResultSet;
import java.sql.SQLException;

import lab.model.Student;
import lab.model.Student.Sex;

public class StudentTransformer {

	public Student fromResultSetToStudent(ResultSet rs) throws SQLException {
		Student student = new Student();
		student.setKod(rs.getInt("kod"));
		student.setFirstName(rs.getString("firstName"));
		student.setLastName(rs.getString("lastName"));
		student.setbDay(rs.getDate("birthDay"));
		student.setSex(Sex.valueOf(rs.getString("sex")));
		return student;
	}
}
