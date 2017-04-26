package day22;

public class StudentTest {
	int num = 4;

	public static void main(String[] args) {
		int sum = 3;
		sum = new StudentTest().num + 4;
		System.out.println(sum);
		
		Student student = new Student();
		student.name = "小明";
		student.sex = "男";
		student.age = 23;
		
		Student student1 = new Student();
		student1.name = "小红";
		student1.sex = "女";
		student1.age = 25;
		
	}
}
