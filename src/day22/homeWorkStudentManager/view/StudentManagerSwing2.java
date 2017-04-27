package day22.homeWorkStudentManager.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import day22.homeWorkStudentManager.biz.StudentManagerIO;
import day22.homeWorkStudentManager.entity.Student;
import day22.homeWorkStudentManager.model.StudentTableModel;

public class StudentManagerSwing2 {
	StudentManagerIO  studentManagerIO = new StudentManagerIO();
	List<Student> list = new ArrayList<Student>();
	JPanel mainPanel;
	JTextField nameJTextField;
	JTextField sexJTextField;
	JTextField ageJTextField;
	JPanel panel2;
	JTable table;
	JScrollPane scrollPane;
	StudentTableModel studentTableModel;
	
	public void init() {
		// 创建窗口
		JFrame frame = new JFrame("---欢迎进入学生管理系统---");
		frame.setSize(600, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 新建主窗口的主面板
		mainPanel = (JPanel) frame.getContentPane();
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		BoxLayout boxLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(boxLayout);
		
		// 主窗口的最上部的panel1（共3层）
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		// 主窗口中新增3个标签及3个文本框
		JLabel nameJLabel = new JLabel("姓名：");
		panel1.add(nameJLabel);
		nameJTextField = new JTextField();
		nameJTextField.setPreferredSize(new Dimension(80, 30));
		panel1.add(nameJTextField);
		JLabel sexJLabel = new JLabel("性别：");
		panel1.add(sexJLabel);
		sexJTextField = new JTextField();
		sexJTextField.setPreferredSize(new Dimension(80, 30));
		panel1.add(sexJTextField);
		JLabel ageJLabel = new JLabel("年龄：");
		panel1.add(ageJLabel);
		ageJTextField = new JTextField();
		ageJTextField.setPreferredSize(new Dimension(80, 30));
		panel1.add(ageJTextField);
		// 主窗口中查找按钮
		JButton searchButton = new JButton("查找");
		searchButton.setPreferredSize(new Dimension(60, 30));
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!(nameJTextField.getText().equals("") && sexJTextField.getText().equals(""))) {
					boolean isSearchByNameFound = true;
					String name = nameJTextField.getText();
					for (int i = 0; i < list.size(); i++) {
						if (name.equals(list.get(i).getName())) {
							// JOptionPane.showMessageDialog(null, list.get(i));
							List<Student> listStu = new ArrayList<Student>();
							listStu.add(list.get(i));
							studentTableModel.setData(listStu);
							listStu = studentManagerIO.load();
							panel2.add(scrollPane);
							isSearchByNameFound = false;
						}
					}
					if (isSearchByNameFound) {
						JOptionPane.showMessageDialog(null, "没有找到该学生！");
					}
				}
				if (!(sexJTextField.getText().equals(""))) {
					String sex = sexJTextField.getText();
					boolean isSearchBySexFound = true;
					for (int i = 0; i < list.size(); i++) {
						if (sex.equals(list.get(i).getSex())) {
//							JOptionPane.showMessageDialog(null, list.get(i));
							List<Student> listStu = new ArrayList<Student>();
							listStu.add(list.get(i));
							studentTableModel.setData(listStu);
							listStu = studentManagerIO.load();
							panel2.add(scrollPane);
							isSearchBySexFound = false;
						}
					}
					if (isSearchBySexFound) {
						JOptionPane.showMessageDialog(null, "没有找到该学生！");
					}
				}
				if (!(ageJTextField.getText().equals(""))) {
					int age = Integer.parseInt(ageJTextField.getText());
					boolean isSearchByAgeFound = true;
					for (int i = 0; i < list.size(); i++) {
						if (age == (list.get(i).getAge())) {
//							JOptionPane.showMessageDialog(null, list.get(i));
							List<Student> listStu = new ArrayList<Student>();
							listStu.add(list.get(i));
							studentTableModel.setData(listStu);
							listStu = studentManagerIO.load();
							panel2.add(scrollPane);
							isSearchByAgeFound = false;
						}
					}
					if (isSearchByAgeFound) {
						JOptionPane.showMessageDialog(null, "没有找到该学生！");
					}
				}
			}
		});
		panel1.add(searchButton);
		mainPanel.add(panel1);
		
		// 主窗口的中间部的panel2
		panel2 = new JPanel();
		list = studentManagerIO.load();
		studentTableModel = new StudentTableModel(list);
		table = new JTable(studentTableModel);
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(500, 300));
		panel2.add(scrollPane);
		mainPanel.add(panel2);
		
		// 主窗口的最底部的panel3
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER,80,0));
		JButton addButton = new JButton("新增");
		addButton.setPreferredSize(new Dimension(60, 30));
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 新建新增弹出窗口及主面板，并设置上下流布局
				JFrame frame = new JFrame("---请输入学生信息---");
				frame.setSize(300, 200);
				frame.setLocationRelativeTo(null);
				mainPanel = (JPanel) frame.getContentPane();
				mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
				BoxLayout boxLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
				mainPanel.setLayout(boxLayout);
				
				// 新增弹出窗口的最上部的panel1（共4层）
				JPanel panel1 = new JPanel();
				panel1.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
				JLabel nameJLabel = new JLabel("姓名：");
				panel1.add(nameJLabel);
				nameJTextField = new JTextField();
				nameJTextField.setPreferredSize(new Dimension(150, 30));
				panel1.add(nameJTextField);
				mainPanel.add(panel1);
				// 新增弹出窗口的第二层的panel2（共4层）
				JPanel addpanel2 = new JPanel();
				addpanel2.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
				JLabel sexJLabel = new JLabel("性别：");
				addpanel2.add(sexJLabel);
				sexJTextField = new JTextField();
				sexJTextField.setPreferredSize(new Dimension(150, 30));
				addpanel2.add(sexJTextField);
				mainPanel.add(addpanel2);
				// 新增弹出窗口的第三层的panel3（共4层）
				JPanel panel3 = new JPanel();
				panel3.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
				JLabel ageJLabel = new JLabel("年龄：");
				panel3.add(ageJLabel);
				ageJTextField = new JTextField();
				ageJTextField.setPreferredSize(new Dimension(150, 30));
				panel3.add(ageJTextField);
				mainPanel.add(panel3);
				// 新增弹出窗口的最下部的panel4（共4层）
				JPanel panel4 = new JPanel();
				panel4.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
				JButton saveButton = new JButton("保存");
				saveButton.setPreferredSize(new Dimension(100, 30));
				saveButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (nameJTextField.getText() != null &&	sexJTextField.getText() != null 
								&& ageJTextField.getText() != null) {
							Student student = new Student(nameJTextField.getText(),
									sexJTextField.getText(), Integer.parseInt(ageJTextField.getText()));
							list.add(student);
							studentManagerIO.save(list);
							studentTableModel.setData(list);
							list = studentManagerIO.load();
//							panel2.add(scrollPane);
							JOptionPane.showMessageDialog(null, "新增成功");
						}
					}
				});
				panel4.add(saveButton);
				mainPanel.add(panel4);
				frame.setVisible(true);
			}
		});
		mainPanel.add(panel2);
		panel3.add(addButton);
		
		JButton modifyButton = new JButton("修改");
		modifyButton.setPreferredSize(new Dimension(60, 30));
		modifyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!(nameJTextField.getText().equals(""))) {
					boolean isSearchByNameFound = true;
					String name = nameJTextField.getText();
					for (int i = 0; i < list.size(); i++) {
						if (name.equals(list.get(i).getName())) {
							list.get(i).setName(name);
							JOptionPane.showMessageDialog(null, "修改成功！");
							isSearchByNameFound = false;
							studentManagerIO.save(list);
							list = studentManagerIO.load();
							panel2.add(scrollPane);
						}
					}
					if (isSearchByNameFound) {
						JOptionPane.showMessageDialog(null, "没有找到该学生！");
					}
				}
				if (!(sexJTextField.getText().equals(""))) {
					String sex = sexJTextField.getText();
					boolean isSearchBySexFound = true;
					for (int i = 0; i < list.size(); i++) {
						if (sex.equals(list.get(i).getSex())) {
							list.get(i).setSex(sex);
							JOptionPane.showMessageDialog(null, "修改成功！");
							isSearchBySexFound = false;
							studentManagerIO.save(list);
							list = studentManagerIO.load();
							panel2.add(scrollPane);
						}
					}
					if (isSearchBySexFound) {
						JOptionPane.showMessageDialog(null, "没有找到该学生！");
					}
				}
				
				if (!(ageJTextField.getText().equals(""))) {
					int age = Integer.parseInt(ageJTextField.getText());
					boolean isSearchByAgeFound = true;
					for (int i = 0; i < list.size(); i++) {
						if (age == (list.get(i).getAge())) {
							list.get(i).setAge(age);
							JOptionPane.showMessageDialog(null, "修改成功！");
							isSearchByAgeFound = false;
							studentManagerIO.save(list);
							list = studentManagerIO.load();
							panel2.add(scrollPane);
						}
					}
					if (isSearchByAgeFound) {
						JOptionPane.showMessageDialog(null, "没有找到该学生！");
					}
				}
				studentManagerIO.save(list);
				studentManagerIO.load();
			}
		});
		panel3.add(modifyButton);
		
		JButton deleteButton = new JButton("删除");
		deleteButton.setPreferredSize(new Dimension(60, 30));
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!(nameJTextField.getText().equals(""))) {
					boolean isSearchByNameFound = true;
					String name = nameJTextField.getText();
					for (int i = 0; i < list.size(); i++) {
						if (name.equals(list.get(i).getName())) {
							list.remove(list.get(i));
							isSearchByNameFound = false;
							studentManagerIO.save(list);
							studentTableModel.setData(list);
							list = studentManagerIO.load();
							panel2.add(scrollPane);
							JOptionPane.showMessageDialog(null, "删除成功！");
						}
					}
					if (isSearchByNameFound) {
						JOptionPane.showMessageDialog(null, "没有找到该学生！");
					}
				}
				if (!(sexJTextField.getText().equals(""))) {
					String sex = sexJTextField.getText();
					boolean isSearchBySexFound = true;
					for (int i = 0; i < list.size(); i++) {
						if (sex.equals(list.get(i).getSex())) {
							list.remove(list.get(i));
							isSearchBySexFound = false;
							studentManagerIO.save(list);
							studentTableModel.setData(list);
							list = studentManagerIO.load();
							panel2.add(scrollPane);
							JOptionPane.showMessageDialog(null, "删除成功！");
						}
					}
					if (isSearchBySexFound) {
						JOptionPane.showMessageDialog(null, "没有找到该学生！");
					}
				}
				
				if (!(ageJTextField.getText().equals(""))) {
					int age = Integer.parseInt(ageJTextField.getText());
					boolean isSearchByAgeFound = true;
					for (int i = 0; i < list.size(); i++) {
						if (age == (list.get(i).getAge())) {
							list.remove(list.get(i));
							isSearchByAgeFound = false;
							studentManagerIO.save(list);
							studentTableModel.setData(list);
							list = studentManagerIO.load();
							panel2.add(scrollPane);
							JOptionPane.showMessageDialog(null, "删除成功！");
						}
					}
					if (isSearchByAgeFound) {
						JOptionPane.showMessageDialog(null, "没有找到该学生！");
					}
				}
				studentManagerIO.save(list);
				studentManagerIO.load();
			}
		});
		panel3.add(deleteButton);
		mainPanel.add(panel3);
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		StudentManagerSwing2 studentManagerIO = new StudentManagerSwing2();
		
		studentManagerIO.init();
	}
}
