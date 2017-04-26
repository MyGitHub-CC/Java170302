package day20;
/**
 * 交换两个整数类型变量的值
 * @author Administrator
 */
public class SwapTwoVariable {
	public static void main(String[] args) {
		int num1 = 5;
		int num2 = 6;
		System.out.println("Before:num1=" + num1);
		System.out.println("Before:num2=" + num2);
		
		System.out.println("-------------");
		int temp = num1;
		num1 = num2;
		num2 = temp;
		System.out.println("After:num1=" + num1);
		System.out.println("After:num2=" + num2);
	}
}
