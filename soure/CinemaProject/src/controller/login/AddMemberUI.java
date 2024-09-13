package controller.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.login.*;
import model.Member;
import service.impl.MemberServiceImpl;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class AddMemberUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField memberno;
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
					AddMemberUI frame = new AddMemberUI();
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
	public AddMemberUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 627);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(45, 63, 341, 473);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("會員註冊");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_1.setBounds(134, 10, 109, 28);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_2 = new JLabel("編號");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_2.setBounds(55, 80, 50, 30);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_2_1 = new JLabel("姓名");
		lblNewLabel_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(55, 160, 50, 30);
		panel.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_2_2 = new JLabel("帳號");
		lblNewLabel_2_2.setFont(new Font("微軟正黑體", Font.BOLD, 18)); 
		lblNewLabel_2_2.setBounds(55, 240, 50, 30);
		panel.add(lblNewLabel_2_2);
		lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_2_3 = new JLabel("密碼");
		lblNewLabel_2_3.setFont(new Font("微軟正黑體", Font.BOLD, 18)); 
		lblNewLabel_2_3.setBounds(55, 320, 50, 30);
		panel.add(lblNewLabel_2_3);
		lblNewLabel_2_3.setForeground(new Color(255, 255, 255));
		
		memberno = new JTextField();
		memberno.setBounds(130, 85, 145, 25);
		panel.add(memberno);
		memberno.setColumns(10);
		
		name = new JTextField();
		name.setBounds(130, 165, 145, 25);
		panel.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setBounds(130, 245, 145, 25);
		panel.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(130, 325, 145, 25);
		panel.add(password);
		password.setColumns(10);
		
		JButton btnNewButton = new JButton("註冊會員");
		btnNewButton.setBounds(117, 399, 103, 30);
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorder(new LineBorder(new Color(128, 0, 0), 2));
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		panel.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				String Username=username.getText();
				if(msi.findByUsername(Username)==true) 
				{
					AddMemberError a=new AddMemberError();
					a.setVisible(true);
					dispose();
				}
				else
				{
					String Memberno=memberno.getText();
					String Name=name.getText();
					String Password=password.getText();
					Integer Cash=0;
					Member m=new Member(Memberno,Name,Username,Password,Cash);
					msi.addMember(m);
					AddMemberSuccess a=new AddMemberSuccess();
					a.setVisible(true);
					dispose();		
				}
				
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 450, 595);
		lblNewLabel.setIcon(new ImageIcon(AddMemberUI.class.getResource("/picture/小會員背景.png")));
		contentPane.add(lblNewLabel);
	}
}
