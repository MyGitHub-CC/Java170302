package day21.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StudentManagerIO {
	List<Student> list = new ArrayList<Student>();
	Scanner scanner = new Scanner(System.in);

	public void addStudent() {
		System.out.println("请输入要录入的学生人数：");
		int num = scanner.nextInt();
		// 录入学生的信息
		for (int i = 0; i < num; i++) {
			System.out.println("----请输入学生的信息----");
			Student student = new Student();
			System.out.println("请输入学生的姓名： ");
			String name = scanner.next();
			student.setName(name);
			System.out.println("请输入学生的性别： ");
			String sex = scanner.next();
			student.setSex(sex);
			System.out.println("请输入学生的年龄： ");
			int age = scanner.nextInt();
			student.setAge(age);
			list.add(student);
		}
		printAllStudent();
		// 录入后用输出流写入文件
		outPut();
	}

	public void printAllStudent() {
		// 打印所有学生的信息
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public void outPut() {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream("D:/sss.txt");
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(list);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (objectOutputStream != null) {
				try {
					objectOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void load() {
		File file = new File("D:/sss.txt");
		if (file.exists()) {
			FileInputStream fileInputStream = null;
			ObjectInputStream objectInputStream = null;
			try {
				fileInputStream = new FileInputStream("D:/sss.txt");
				objectInputStream = new ObjectInputStream(fileInputStream);
				list = (List<Student>) objectInputStream.readObject();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				if (objectInputStream != null) {
					try {
						objectInputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (fileInputStream != null) {
					try {
						fileInputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public void deleteStudent() {
		printAllStudent();
		// 删除指定的学生信息
		System.out.println("请输入要删除的学生的姓名：");
		String deleteName = scanner.next();
		for (int i = 0; i < list.size(); i++) {
			if ((list.get(i) != null)
					&& deleteName.equals(list.get(i).getName())) {
				list.remove(list.get(i));
			}
		}
//		Iterator<Student> iterator = list.iterator();
//		while (iterator.hasNext()) {
//			Student student = iterator.next();
//			if (deleteName.equals(student.getName())) {
//				iterator.remove();
//			}
//		}
		// 删除后打印所有学生的信息
		printAllStudent();
		// 删除后重新输出，覆盖原文件的内容
		outPut();
	}

	public void searchStudent() {
		// 查询指定的学生的信息
		System.out.println("请输入查询方式：1-按姓名，2-按性别，3-按年龄");
		int type = scanner.nextInt();
		if (type == 1) {
			System.out.println("请输入要查询的学生的姓名：");
			String isSearcheByNameFound = scanner.next();
			for (int i = 0; i < list.size(); i++) {
				if ((list.get(i) != null)
						&& isSearcheByNameFound.equals(list.get(i).getName())) {
					System.out.println(list.get(i));
				}
			}
		} else if (type == 2) {
			System.out.println("请输入要查询的学生的性别：");
			String isSearcheBySexFound = scanner.next();
			for (int i = 0; i < list.size(); i++) {
				if ((list.get(i) != null)
						&& isSearcheBySexFound.equals(list.get(i).getSex())) {
					System.out.println(list.get(i));
				}
			}
		} else if (type == 3) {
			System.out.println("请输入要查询的学生的年龄：");
			int isSearcheByAgeFound = scanner.nextInt();
			for (int i = 0; i < list.size(); i++) {
				if ((list.get(i) != null)
						&& isSearcheByAgeFound == (list.get(i).getAge())) {
					System.out.println(list.get(i));
				}
			}
		}
	}

	public static void main(String[] args) {
		StudentManagerIO studentManagerIO = new StudentManagerIO();
		studentManagerIO.load();

		while (true) {
			System.out.println("请输入：0-退出，1-删除，2-查询，3-录入，4-查询所有");
			int type = studentManagerIO.scanner.nextInt();
			if (type == 1) {
				studentManagerIO.deleteStudent();
			} else if (type == 2) {
				studentManagerIO.searchStudent();
			} else if (type == 3) {
				studentManagerIO.addStudent();
			} else if (type == 4) {
				studentManagerIO.printAllStudent();
			} else if (type == 0) {
				System.out.println("退出！");
				break;
			}
		}
	}
}
