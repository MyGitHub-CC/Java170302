package day23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertJdbc {
	// 1、导入jar包，这是编码之外的事情
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		// 2、加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 3、建立连接
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studentdemo?characterEncoding=utf-8", "root", "root");
			// 4、创建SQL执行对象
			statement = connection.createStatement();
			// 5、执行sql语句
			String sql = "insert into student(name,sex,age) values ('张三','男',24);";
			int result = statement.executeUpdate(sql);
			// 6、处理执行结果
			if (result > 0) {
				System.out.println("添加成功！");
			} else {
				System.out.println("添加失败！");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 7、关闭流
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
