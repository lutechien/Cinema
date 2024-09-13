package controller.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.operate.LoginSuccess;
import model.Member;
import service.impl.MemberServiceImpl;
import util.Cal;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 366);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("帳號");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_1.setBounds(194, 61, 46, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼");
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(194, 114, 46, 22);
		contentPane.add(lblNewLabel_1_1);
		
		username = new JTextField();
		username.setBounds(267, 61, 178, 22);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(267, 114, 178, 22);
		contentPane.add(password);
		
		JButton btnNewButton = new JButton("註冊帳號");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() 
		{
			@Override
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnNewButton.setBackground(Color.DARK_GRAY); // 懸停時背景顏色變暗
		    }

		    @Override
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnNewButton.setBackground(Color.BLACK); // 懸停結束時恢復背景顏色
		    }
		    
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Cal.gotoAddMemberUI();
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton.setBounds(149, 240, 120, 37);
		btnNewButton.setBorder(new LineBorder(new Color(128, 0, 0), 2));
		contentPane.add(btnNewButton);
		
		JButton btnBj = new JButton("登入帳號");
		btnBj.addMouseListener(new MouseAdapter() 
		{
			@Override
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        btnBj.setBackground(Color.DARK_GRAY); // 懸停時背景顏色變暗
		    }
		    @Override
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        btnBj.setBackground(Color.BLACK); // 懸停結束時恢復背景顏色
		    }
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username=username.getText();
				String Password=password.getText();
				Member m=msi.Login(Username, Password);
				if(m!=null)
				{
					Cal.SaveObject(m, "Member.txt");
					LoginSuccess l=new LoginSuccess();
					l.setVisible(true);
					dispose();
				}
				else
				{
					LoginError l=new LoginError();
					l.setVisible(true);
					dispose();
				}
			}
		});
		btnBj.setForeground(Color.WHITE);
		btnBj.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnBj.setBackground(Color.BLACK);
		btnBj.setBounds(377, 240, 120, 37);
		btnBj.setBorder(new LineBorder(new Color(128, 0, 0), 2));
		contentPane.add(btnBj);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginUI.class.getResource("/picture/電影.jpg")));
		lblNewLabel.setBounds(10, 10, 610, 307);
		contentPane.add(lblNewLabel);
	}
}
