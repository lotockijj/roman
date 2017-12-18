package lab.dao;

import java.sql.SQLException;
import java.util.List;

import lab.model.Student;

public interface StudentDao {
	void create(Student student) throws SQLException;
	void deleteByKod(Integer kod)throws SQLException;
	List<Student> getAllStudent()throws SQLException;
}
