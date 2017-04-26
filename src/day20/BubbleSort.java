package day20;

import org.junit.Test;

/**
 * 冒泡排序:相邻两个数之间进行比较
 * @author Administrator
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] array = {5, 4, 3, 2, 1};
		
		System.out.println("交换前：-----------");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
		
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		
		System.out.println();
		System.out.println("交换后：----------");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
	}
	
	@Test
	public void test1() {
		int[] array = {55, 44, 33 , 22, 11};
		
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
