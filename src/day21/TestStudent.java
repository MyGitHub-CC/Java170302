package day21;

public class TestStudent {
	public static void main(String[] args) {
		StudentDemo student = new StudentDemo("小明", "男", 20);
		student.show();
		student.study();
		
		StudentDemo student1 = new StudentDemo( "小红", "女", 21);
		student1.show();
		student1.study();
	}
}
