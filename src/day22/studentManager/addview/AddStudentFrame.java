package day22.studentManager.addview;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import day22.studentManager.biz.StudentManager;
import day22.studentManager.entity.Student;
import day22.studentManager.util.CallBack;

public class AddStudentFrame{
	JTextField nameJTextField;
	JTextField sexJTextField;
	JTextField ageJTextField;
	StudentManager studentManager = new StudentManager();
	
	CallBack callBack;
	public AddStudentFrame (CallBack callBack) {
		this.callBack = callBack;
	}
	
	public void init() {
		// 创建窗口
		JFrame frame = new JFrame();
		frame.setSize(260, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// 新建主面板
		JPanel mainPanel = (JPanel) frame.getContentPane();
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		BoxLayout boxLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(boxLayout);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		
		JLabel nameJLabel = new JLabel("姓名：");
		panel1.add(nameJLabel);
		nameJTextField = new JTextField();
		nameJTextField.setPreferredSize(new Dimension(90, 30));
		panel1.add(nameJTextField);
		
		JLabel sexJLabel = new JLabel("性别：");
		panel2.add(sexJLabel);
		sexJTextField = new JTextField();
		sexJTextField.setPreferredSize(new Dimension(90, 30));
		panel2.add(sexJTextField);
		
		JLabel ageJLabel = new JLabel("年龄：");
		panel3.add(ageJLabel);
		ageJTextField = new JTextField();
		ageJTextField.setPreferredSize(new Dimension(90, 30));
		panel3.add(ageJTextField);
		
		JButton button = new JButton("保存");
		button.setPreferredSize(new Dimension(60, 30));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Student student = new Student();
				student.setName(nameJTextField.getText());
				student.setSex(sexJTextField.getText());
				student.setAge(Integer.parseInt(ageJTextField.getText()));
				List<Student> list = studentManager.load();
				list.add(student);
				studentManager.save(list);
				callBack.callBack();
			}
		});
		panel4.add(button);
		
		frame.setVisible(true);
	}
	
}
