package lab.service;

import java.sql.SQLException;
import java.util.List;

import lab.implementation.StudentDaoImpl;
import lab.model.Student;

public class StudentService {
	
	public void create(Student student) throws SQLException{
		new StudentDaoImpl().create(student);
	}
	
	public void deleteByKod(Integer kod)throws SQLException{
		new StudentDaoImpl().deleteByKod(kod);
	}
	
	public List<Student> getAllStudent()throws SQLException{
		return new StudentDaoImpl().getAllStudent();
	}
}
