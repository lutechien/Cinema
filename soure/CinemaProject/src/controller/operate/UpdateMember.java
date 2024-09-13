package controller.operate;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.login.AddMemberError;
import controller.login.AddMemberSuccess;
import controller.login.AddMemberUI;
import model.Member;
import service.impl.MemberServiceImpl;
import util.Cal;

import javax.swing.JLabel;

public class UpdateMember extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private static MemberServiceImpl msi=new MemberServiceImpl();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateMember frame = new UpdateMember();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateMember() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(59, 57, 341, 438);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("會員資料修改");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_1.setBounds(117, 41, 138, 28);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_2_1 = new JLabel("姓名");
		lblNewLabel_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(57, 101, 50, 30);
		panel.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_2_2 = new JLabel("帳號");
		lblNewLabel_2_2.setFont(new Font("微軟正黑體", Font.BOLD, 18)); 
		lblNewLabel_2_2.setBounds(57, 181, 50, 30);
		panel.add(lblNewLabel_2_2);
		lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_2_3 = new JLabel("密碼");
		lblNewLabel_2_3.setFont(new Font("微軟正黑體", Font.BOLD, 18)); 
		lblNewLabel_2_3.setBounds(57, 261, 50, 30);
		panel.add(lblNewLabel_2_3);
		lblNewLabel_2_3.setForeground(new Color(255, 255, 255));
		
		JLabel 修改成功_文字 = new JLabel("修改成功");
		修改成功_文字.setFont(new Font("微軟正黑體", Font.BOLD, 13));
		修改成功_文字.setForeground(new Color(0, 255, 0));
		修改成功_文字.setBounds(68, 343, 83, 15);
		panel.add(修改成功_文字);
		修改成功_文字.setVisible(false);
		
		name = new JTextField();
		name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				修改成功_文字.setVisible(false);
			}
		});
		name.setBounds(132, 106, 145, 25);
		panel.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				修改成功_文字.setVisible(false);
			}
		});
		username.setBounds(132, 186, 145, 25);
		panel.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				修改成功_文字.setVisible(false);
			}
		});
		password.setBounds(132, 266, 145, 25);
		panel.add(password);
		password.setColumns(10);
		
		JButton btnNewButton = new JButton("修改資料");
		btnNewButton.setBounds(41, 362, 103, 30);
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorder(new LineBorder(new Color(128, 0, 0), 2));
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		panel.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Member m=(Member) Cal.ReadObject("Member.txt");	
				Integer id=m.getId();
				String Name=name.getText();
				String Username=username.getText();
				String Password=password.getText();
				msi.udateMember(id, Name, Username, Password);
				Member m1=msi.findId(id);
				Cal.SaveObject(m1, "Member.txt");
				name.setText("");
				username.setText("");
				password.setText("");
				修改成功_文字.setVisible(true);
			}
			@Override
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnNewButton.setBackground(Color.DARK_GRAY); // 懸停時背景顏色變暗
		    }

		    @Override
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnNewButton.setBackground(Color.BLACK); // 懸停結束時恢復背景顏色
		    }
		});
		
		JButton btnNewButton_1 = new JButton("回上一頁");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginSuccess l=new LoginSuccess();
				l.setVisible(true);
				dispose();
			}
			@Override
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnNewButton_1.setBackground(Color.DARK_GRAY); // 懸停時背景顏色變暗
		    }

		    @Override
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnNewButton_1.setBackground(Color.BLACK); // 懸停結束時恢復背景顏色
		    }
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton_1.setBorder(new LineBorder(new Color(128, 0, 0), 2));
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setBounds(196, 362, 103, 30);
		panel.add(btnNewButton_1);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 450, 555);
		lblNewLabel.setIcon(new ImageIcon(AddMemberUI.class.getResource("/picture/小會員背景.png")));
		contentPane.add(lblNewLabel);
	}

}
