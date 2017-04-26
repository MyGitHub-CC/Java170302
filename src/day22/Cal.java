package day22;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cal {
	JTextField textField1;
	JTextField textField2;
	JTextField textField3;
	public void init() {
		JFrame frame = new JFrame();
		frame.setSize(400, 200);
//		frame.setLocation(400, 300);
		frame.setLocationRelativeTo(null); // 使窗口居中
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		// final JTextField textField1 = new JTextField();
		textField1 = new JTextField();
		textField1.setPreferredSize(new Dimension(80, 20));
		panel.add(textField1);
		
		JLabel label = new JLabel();
		label.setText("+");
		panel.add(label);
		
		textField2 = new JTextField();
		textField2.setPreferredSize(new Dimension(80, 20));
		panel.add(textField2);
		
		JButton button = new JButton();
		button.setText("=");
		button.setPreferredSize(new Dimension(50, 20));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println("hello");
				int a = Integer.parseInt(textField1.getText());
				int b = Integer.parseInt(textField2.getText());
				int c = a + b;
				textField3.setText(String.valueOf(c));
			}
		});
		
		panel.add(button);
		
		
		textField3 = new JTextField();
		textField3.setPreferredSize(new Dimension(80, 20));
		panel.add(textField3);
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Cal().init();
		
	}
}
