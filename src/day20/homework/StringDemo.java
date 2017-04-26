package day20.homework;

import java.util.Scanner;

import org.junit.Test;

/**
 * String:从控制台输入姓名，输出姓和名 
 * @author Administrator
 */
public class StringDemo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入姓名：");
		String name = scanner.next();
		String[] nameArr = {"欧阳", "太史", "端木", "上官", "司马", "东方", "独孤",
				"南宫", "万俟", "闻人", "夏侯", "诸葛", "尉迟", "公羊", "赫连", "澹台", "皇甫", "宗政", "濮阳",
				"公冶", "太叔", "申屠", "公孙", "慕容", "仲孙", "钟离", "长孙", "宇文", "司徒", "鲜于", "司空",
				"闾丘", "子车", "亓官", "司寇", "巫马", "公西", "颛孙", "壤驷", "公良", "漆雕", "乐正"};
		for (int i = 0; i < nameArr.length; i++) {
			if (name.substring(0, 2).equals(nameArr[i])) {
				System.out.println("姓：" + nameArr[i]);
				String fuming = name.substring(2);
				System.out.println("名：" + fuming);
				return;
			}
		}

		System.out.println("姓：" + name.charAt(0));
		String ming = name.substring(1);
		System.out.println("名：" + ming);

	}
	
	// 优化
	@Test
	public void test1() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入姓名：");
		String name = scanner.next();
		String[] nameArr = {"欧阳", "太史", "端木", "上官", "司马", "东方", "独孤"};
		// 
		boolean flag = true;
		for (int i = 0; i < nameArr.length; i++) {
			if (name.substring(0, 2).equals(nameArr[i])) {
				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println("姓：" + name.charAt(0));
			String ming = name.substring(1);
			System.out.println("名：" + ming);
		} else {
			System.out.println("姓：" + name.substring(0, 2));
			String fuming = name.substring(2);
			System.out.println("名：" + fuming);
		}
	}
}
