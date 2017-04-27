package day22.studentManager.biz;

import java.util.List;

import day22.studentManager.dao.StudentDao;
import day22.studentManager.entity.Student;


public class StudentManager {
	StudentDao studentDao = new StudentDao();
	
	public List<Student> load() {
		return studentDao.load();
	}

	public void save(List<Student> list) {
		studentDao.save(list);
	}
}
