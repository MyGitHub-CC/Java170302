package day21;

import java.util.Scanner;

public class TestStudentInfos {
	public static void main(String[] args) {
		Student[] students = new Student[2];
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < students.length; i++) {
			System.out.println("请输入第" + (i+1) + "个学生的姓名：");
			String name = scanner.next();
			System.out.println("请输入第" + (i+1) + "个学生的性别：");
			String sex = scanner.next();
			System.out.println("请输入第" + (i+1) + "个学生的年龄：");
			int age = scanner.nextInt();
			Student student = new Student(name, sex, age);
			students[i] = student;
		}
		
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i].getName() + " "
					+ students[i].getSex() + " " + students[i].getAge());
		}
		
		System.out.println("请输入要删除的学生的姓名：");
		String deleteName = scanner.next();
		for (int i = 0; i < students.length; i++) {
			if (deleteName.equals(students[i].getName())) {
				students[i] = null;
			}
		}

		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				System.out.println(students[i].getName() + " "
						+ students[i].getSex() + " " + students[i].getAge());
			}
		}
		
		System.out.println("请输入要查询的学生的姓名：");
		String searchName = scanner.next();
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && searchName.equals(students[i].getName())) {
				System.out.println(students[i].getName() + " "
						+ students[i].getSex() + " " + students[i].getAge());
			}
		}
	}
}
