package day20;

import org.junit.Test;

/**
 * 选择排序：用一个数（第一个数）和其余的数进行比较，选出一个最小（或最大）值，
 * 再从剩余的数中选出一个最小（或最大）值，
 * 反复进行操作，直到倒数第二个数和最后一个数比较完成。
 * @author Administrator
 */

public class SelectSort {
	public static void main(String[] args) {
		int[] array = {5, 4, 3, 2, 1};
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	@Test
	public void test1() {
		
	}
}
