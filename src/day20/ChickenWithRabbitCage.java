package day20;
/**
 * 穷举法：
 * 鸡兔同笼问题：35个头；94只脚
 * @author Administrator
 */
public class ChickenWithRabbitCage {
	public static void main(String[] args) {
		int a; // 鸡的数量
		int sum ; // 鸡和兔子的脚的总数
		for (int i = 0; i <= 35; i++) { // 兔子的数量从0-35递增
			a = 35 - i;
			sum = 2*a + 4*i;
			if (sum == 94) {
				System.out.println("鸡的数量是：" + a);
				System.out.println("兔子的数量是：" + i);
			}
		}
		
		
		for (int i = 0; i <= 35; i++) {
			for (int j = 0; j < 35 - i; j++) {
				
			}
		}
	}
}
