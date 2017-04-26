package day20.homework;

import org.junit.Test;

/**
 * 红球：1-33中随机生成6个不重复的整数 
 * 篮球：1-16中随机生成1个不重复的整数
 * @author Administrator
 */
public class DoubleChromosphere {
	public static void main(String[] args) {
		int[] nums = new int[33];

		int count = 1;
		for (int k = 0; k < count; k++) {
			System.out.println("-------第" + (k + 1) + "场------");
			for (int i = 0; i < nums.length; i++) {
				 // 生成1-34之间的一个随机数
				nums[i] = (int) (Math.random() * 33+ 1);

				for (int j = 0; j < i; j++) { //
					while (nums[i] == nums[j]) {
						nums[i] = (int) (Math.random() * 33 + 1);
						j = 0;
					}
				}
			}

			// 冒泡排序：将数组中的元素从小到大排列
			System.out.print("红球：");
			for (int i = 0; i < nums.length - 1; i++) { 
				for (int j = 0; j < nums.length - i - 1; j++) {
					if (nums[j] > nums[j + 1]) {
						int temp = nums[j];
						nums[j] = nums[j + 1];
						nums[j + 1] = temp;
					}
				}
			}
			
			// 打印红球这个数组中的数
			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i] + " ");
			}

			System.out.println();
			int lan = (int) (Math.random() * 33 + 1);
			System.out.println("篮球：" + lan);
		}
	}
	
	
	@Test
	public void test1() {
		int[] hong = new int[6]; // 定义一个数组，用于存放6个红球的数
		// 生成随机数
		// 外层循环控制生成随机数的个数
		for (int i = 0; i < hong.length; i++) {
			// 定义一个临时变量，随机生成一个[1-33]的随机数并赋值给这个临时变量
			int qiu = (int)(Math.random() * 33 + 1);
			// 定义一个标记，记录新生成的随机数是否个数组中的元素重复，默认为不重复
			boolean flag = true;
			// 将新生成的随机数（临时变量）和之前的每个数据进行比较
			for (int j = 0; j < i; j++) {
				// 如果出现重复，则将标记变为false，并直接跳出本层循环
				if (hong[j] == qiu) {
					flag = false;
					//i--;
					break;
				}
			}
			// 如果没有出现重复，flag依然为true，则将该随机数（临时变量）赋值给数组中的元素
			// 否则i--，再i++，重新生成一个随机数，直到flag=true（即不重复）再赋值
			if (flag) {
				hong[i] = qiu;
			} else {
				i--;
			}
		}
		
		// 冒泡排序：将数组中的元素从小到大排列
		System.out.print("红球：");
		for (int i = 0; i < hong.length - 1; i++) { 
			for (int j = 0; j < hong.length - i - 1; j++) {
				if (hong[j] > hong[j + 1]) {
					int temp = hong[j];
					hong[j] = hong[j + 1];
					hong[j + 1] = temp;
				}
			}
		}
		
		 // 打印红球这个数组中的数
		for (int i = 0; i < hong.length; i++) {
			System.out.print(hong[i] + " ");
		}

		// 随机生成一个蓝色球的随机数
		System.out.println();
		int lan = (int) (Math.random() * 33 + 1);
		System.out.println("篮球：" + lan);
	}
	
}
