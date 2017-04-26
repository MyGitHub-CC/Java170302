package day21;

import java.util.Scanner;

public class Swicth {
	public static void main(String[] args) {
		Scanner scanner = new  Scanner(System.in);
		int score = scanner.nextInt();
		if (score > 100 || score < 0 ) {
			System.out.println("不合法的输入");
		}
		int grade = score / 10;
		switch (grade) {
		case 10:
	   	case 9:
			System.out.println("优秀");
			break;
		case 8:
			System.out.println("良好");
			break;
		case 7:
			System.out.println("一般");
			break;
		case 6:
			System.out.println("及格");
			break;
		default:
			System.out.println("不及格");
			break;
		}
	}
}
