package day22.homeWorkStudentManager.biz;

import java.util.List;

import day22.homeWorkStudentManager.dao.StudentDao;
import day22.homeWorkStudentManager.entity.Student;

public class StudentManagerIO {
	StudentDao studentDao = new StudentDao();
	
	public List<Student> load() {
		return studentDao.load();
	}
	
	public void save(List<Student> list) {
		studentDao.save(list);
		return;
	}

}
