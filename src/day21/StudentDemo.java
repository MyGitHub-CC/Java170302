package day21;

public class StudentDemo {
	String name;
	String sex;
	int age;

	public StudentDemo(String n, String s, int a) {
		name = n;
		sex = s;
		age = a;
	}

	public void study() {
		System.out.println("我会学习！");
	}
	
	public void show() {
		System.out.println(name);
		System.out.println(sex);
		System.out.println(age);
	}
}
