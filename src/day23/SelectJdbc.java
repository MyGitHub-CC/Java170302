package day23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectJdbc {
	// 1、导入jar包，这是编码之外的事情
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		// 2、加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 3、建立连接
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/studentdemo", "root", "root");
			// 4、创建SQL执行对象
			statement = connection.createStatement();
			// 5、执行sql语句
			String sql = "select * from student";
			resultSet = statement.executeQuery(sql);
			// 6、处理执行结果
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String sex = resultSet.getString("sex");
				int age = resultSet.getInt("age");
				System.out.println("id:" + id + " name:" + name + " sex:" + sex
						+ " age:" + age);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 7、关闭流
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
