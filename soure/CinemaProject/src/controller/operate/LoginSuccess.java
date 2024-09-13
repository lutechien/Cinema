package controller.operate;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.login.LoginUI;
import model.Member;
import util.Cal;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginSuccess extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSuccess frame = new LoginSuccess();
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
	public LoginSuccess() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 641);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("點擊前往修改會員資料");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(156, 173, 142, 28);
		contentPane.add(lblNewLabel_1_1);
					
		JLabel 會員名字 = new JLabel("");
		會員名字.setForeground(Color.WHITE);
		會員名字.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		會員名字.setBounds(21, 10, 109, 28);
		Member m=(Member) Cal.ReadObject("Member.txt");	
		contentPane.add(會員名字);
		會員名字.setText(m.getName());
		
		JLabel 先生女士 = new JLabel("先生/女士");
		先生女士.setForeground(Color.WHITE);
		先生女士.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		先生女士.setBounds(127, 10, 109, 28);
		contentPane.add(先生女士);
		
		JLabel lblNewLabel_1_2 = new JLabel("剩餘儲值金");
		lblNewLabel_1_2.setForeground(new Color(247, 223, 9));
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(252, 45, 75, 28);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel 儲值金顯示 = new JLabel("剩餘儲值金");
		儲值金顯示.setForeground(new Color(247, 223, 9));
		儲值金顯示.setFont(new Font("微軟正黑體", Font.BOLD, 13));
		儲值金顯示.setBounds(326, 46, 69, 28);
		contentPane.add(儲值金顯示);
		String CASH=m.getCash()+"";
		儲值金顯示.setText(CASH);
		
		JButton btnNewButton_2 = new JButton("登出");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI l = new LoginUI();
				l.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setBorder(new LineBorder(new Color(128, 0, 0), 2));
		btnNewButton_2.setBounds(21, 45, 50, 28);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("修改資料");
		btnNewButton.setBackground(new Color(203,3,40));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBorder(new LineBorder(Color.GRAY, 2));
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateMember u=new UpdateMember();
				u.setVisible(true);
				dispose();
			}
			@Override
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnNewButton.setBackground(Color.DARK_GRAY); // 懸停時背景顏色變暗
		    }
		    @Override
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnNewButton.setBackground(new Color(203,3,40)); // 懸停結束時恢復背景顏色
		    }
		});
		btnNewButton.setBounds(135, 135, 165, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("會員儲值");
		btnNewButton_1.setBackground(new Color(203,3,40));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBorder(new LineBorder(Color.GRAY, 2));
		btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MemberTopup m=new MemberTopup();
				m.setVisible(true);
				dispose();
			}
			@Override
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnNewButton_1.setBackground(Color.DARK_GRAY); // 懸停時背景顏色變暗
		    }
		    @Override
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnNewButton_1.setBackground(new Color(203,3,40)); // 懸停結束時恢復背景顏色
		    }
		});
		btnNewButton_1.setBounds(135, 271, 165, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("前往購票");
		btnNewButton_1_1.setBackground(new Color(203,3,40));
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setBorder(new LineBorder(Color.GRAY, 2));
		btnNewButton_1_1.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChooseMovie c=new ChooseMovie();
				c.setVisible(true);
				dispose();
			}
			@Override
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnNewButton_1_1.setBackground(Color.DARK_GRAY); // 懸停時背景顏色變暗
		    }
		    @Override
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnNewButton_1_1.setBackground(new Color(203,3,40)); // 懸停結束時恢復背景顏色
		    }
		});
		btnNewButton_1_1.setBounds(135, 409, 165, 40);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("點擊前往會員儲值頁面");
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_1_1_2.setBounds(156, 308, 142, 28);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("點擊前往影院購票系統");
		lblNewLabel_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_3.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_1_1_3.setBounds(156, 445, 142, 28);
		contentPane.add(lblNewLabel_1_1_3);
		
			JLabel lblNewLabel = new JLabel("登入成功");
			lblNewLabel.setBackground(new Color(204, 51, 0));
			lblNewLabel.setBounds(0, 0, 414, 610);
			lblNewLabel.setIcon(new ImageIcon(LoginSuccess.class.getResource("/picture/小會員操作.jpg")));
			contentPane.add(lblNewLabel);
	}

}
