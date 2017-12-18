package lab.main;

import java.sql.SQLException;
import java.util.List;

import lab.model.Student;
import lab.service.StudentService;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		StudentService service = new StudentService();
		List<Student> students = service.getAllStudent();
		students.forEach(System.out::println);
//		service.deleteByKod(4);
//		@SuppressWarnings("deprecation")
//		Date date = new Date(1981, 31, 8);
//		Student student = new Student(4, "Kolya", "Trenbach", date, Student.Sex.male);
//		service.create(student);
	}
}
