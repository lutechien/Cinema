package controller.login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class AddMemberError extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMemberError frame = new AddMemberError();
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
	public AddMemberError() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("註冊失敗");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(184, 99, 115, 28);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(244,197,3));
		panel.setBounds(0, 0, 434, 76);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(LoginError.class.getResource("/picture/小小驚嘆號.jpg")));
		lblNewLabel_2.setBounds(188, 10, 65, 66);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("重新登入");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI l=new LoginUI();
				l.setVisible(true);
				dispose();
			}
			@Override
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnNewButton.setBackground(new Color(0, 255, 0)); // 懸停時背景顏色變暗
		    }
		    @Override
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnNewButton.setBackground(new Color(0, 149, 0)); // 懸停結束時恢復背景顏色
		    }
		});
		btnNewButton.setBackground(new Color(0, 149, 0));
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton.setBounds(62, 179, 115, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("重新註冊");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddMemberUI a=new AddMemberUI();
				a.setVisible(true);
				dispose();
			}
			@Override
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnNewButton_1.setBackground(new Color(254, 185, 129)); // 懸停時背景顏色變暗
		    }
		    @Override
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnNewButton_1.setBackground(new Color(255, 128, 64)); // 懸停結束時恢復背景顏色
		    }
		});
		btnNewButton_1.setBackground(new Color(255, 128, 64));
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton_1.setBounds(270, 179, 115, 34);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("您可能已有會員帳號");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel_1.setBounds(62, 159, 115, 17);
		contentPane.add(lblNewLabel_1);
	}

}
