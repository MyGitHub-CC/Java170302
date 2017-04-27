package day22;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalSuper {
	JTextField textField1;
	JTextField textField2;
	JTextField textField3;
	JComboBox comboBox;
	public void init() {
		JFrame frame = new JFrame();//创建一个窗口
		frame.setSize(400, 200);// 设置窗口大小
		frame.setLocationRelativeTo(null); // 使窗口居中
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置当关闭窗口时，程序结束
		JPanel panel = (JPanel) frame.getContentPane();// 在窗口中创建一个控制面板
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));// 设置流布局
		
		textField1 = new JTextField();// 创建一个文本框用于输入
		textField1.setPreferredSize(new Dimension(80, 20));// 设置文本框宽度和高度
		panel.add(textField1);//将文本框添加到面板中
		
//		JLabel label = new JLabel();
//		label.setText("+");
//		panel.add(label);
		
		// 第一种添加下拉列表的方式
//		comboBox=new JComboBox();
//		comboBox.setPreferredSize(new Dimension(50, 20));
//      comboBox.addItem("+");  
//      comboBox.addItem("-");  
//      comboBox.addItem("*");  
//      comboBox.addItem("/");  
//      panel.add(comboBox); 
		
		// 第二种添加下拉列表的方式
//		comboBox = new JComboBox();
//      comboBox.setModel(new DefaultComboBoxModel(new String[] {"+","-","*","/"}));
//      panel.add(comboBox);
		
		String[] str = {"+", "-", "*", "/"};
		comboBox=new JComboBox(str);
		panel.add(comboBox);
		
		textField2 = new JTextField();// 创建第二个文本框
		textField2.setPreferredSize(new Dimension(80, 20));// 设置文本框宽度和高度
		panel.add(textField2);//将文本框添加到面板中
		
		JButton button = new JButton();// 新建一个按钮
		button.setText("=");// 在按钮中添加内容
		button.setPreferredSize(new Dimension(50, 20));// 设置按钮宽度和高度
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int c = 0;
				int a = Integer.parseInt(textField1.getText());
				int b = Integer.parseInt(textField2.getText());
				String result = (String) comboBox.getSelectedItem();
				if (result.equals("+")) {
					c = a + b;
				} else if (result.equals("-")) {
					c = a - b;
				} else if (result.equals("*")) {
					c = a * b;
				} else if (result.equals("/")) {
					c = a / b;
				}
				textField3.setText(String.valueOf(c));
			}
		});
		
		panel.add(button);
		
		textField3 = new JTextField();
		textField3.setPreferredSize(new Dimension(80, 20));
		panel.add(textField3);
		
		frame.setVisible(true);// 设置窗口为可见
	}
	
	public static void main(String[] args) {
		new CalSuper().init();
		
	}
}
