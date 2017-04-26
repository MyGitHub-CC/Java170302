package day20;

import org.junit.Test;

public class PrimeNumber {
	public static void main(String[] args) {
		int num = 27;
		for (int i = 2; i < (num / 2 + 1); i++) {
			if (num  % i == 0) {
				System.out.println("num:" + num + "不是质数");
				return;
			} 
		}
		System.out.println("num:" + num + "是质数");
	}
	
	@Test
	public void test1() {
		int num = 97;
		boolean flag = true;
		for (int i = 2; i < Math.sqrt(num); i++) {
			if (num % i == 0) {
				flag = false;
			}
		}
		if (flag) {
			System.out.println(num + "是素数");
		} else {
			System.out.println(num + "不是素数");
		}
	}
	
	@Test
	public void test2() {
		for (int i = 3; i < 1000; i++) {
			boolean flag = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					flag = false;
				}
			}
			if (flag) {
				System.out.println(i + "是素数");
			}
		}
	}
}
