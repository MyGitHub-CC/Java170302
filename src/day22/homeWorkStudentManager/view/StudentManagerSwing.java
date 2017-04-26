package day22.homeWorkStudentManager.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import day22.studentManager.biz.StudentManagerIO;
import day22.studentManager.entity.Student;
import day22.studentManager.model.StudentTableModel;

public class StudentManagerSwing {
	StudentManagerIO  studentManagerIO = new StudentManagerIO();
	
	public void init() {
		// 创建窗口
		JFrame frame = new JFrame();
		frame.setSize(600, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 新建主面板
		JPanel mainPanel = (JPanel) frame.getContentPane();
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		BoxLayout boxLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(boxLayout);
		
		// 最上部的panel1（共3层）
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		// 新增3个标签及3个文本框
		JLabel nameJLabel = new JLabel("姓名：");
		panel1.add(nameJLabel);
		JTextField nameJTextField = new JTextField();
		nameJTextField.setPreferredSize(new Dimension(80, 30));
		panel1.add(nameJTextField);
		
		JLabel sexJLabel = new JLabel("性别：");
		panel1.add(sexJLabel);
		JTextField sexJTextField = new JTextField();
		sexJTextField.setPreferredSize(new Dimension(80, 30));
		panel1.add(sexJTextField);
		
		JLabel ageJLabel = new JLabel("年龄：");
		panel1.add(ageJLabel);
		JTextField ageJTextField = new JTextField();
		ageJTextField.setPreferredSize(new Dimension(80, 30));
		panel1.add(ageJTextField);
		
		JButton searchButton = new JButton("查找");
		searchButton.setPreferredSize(new Dimension(60, 30));
		panel1.add(searchButton);
		// 添加到主面板
		mainPanel.add(panel1);
		
		// 中间部的panel2
		JPanel panel2 = new JPanel();
		List<Student> list = studentManagerIO.load();
		StudentTableModel studentTableModel = new StudentTableModel(list);
		JTable table = new JTable(studentTableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(500, 300));
		panel2.add(scrollPane);
		mainPanel.add(panel2);
		// 最底部的panel3
		JPanel panel3 = new JPanel();
		
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER,80,0));
		JButton addButton = new JButton("新增");
		addButton.setPreferredSize(new Dimension(60, 30));
		panel3.add(addButton);
		
		JButton modifyButton = new JButton("修改");
		modifyButton.setPreferredSize(new Dimension(60, 30));
		panel3.add(modifyButton);
		
		JButton deleteButton = new JButton("删除");
		deleteButton.setPreferredSize(new Dimension(60, 30));
		panel3.add(deleteButton);
		
		mainPanel.add(panel3);
		
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		StudentManagerSwing studentManagerIO = new StudentManagerSwing();
		
		studentManagerIO.init();
	}
}
