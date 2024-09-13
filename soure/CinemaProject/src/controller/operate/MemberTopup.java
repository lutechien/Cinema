package controller.operate;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.Member;
import service.impl.MemberServiceImpl;
import util.Cal;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MemberTopup extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int addCash=0;
	private static MemberServiceImpl msi=new MemberServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberTopup frame = new MemberTopup();
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
	public MemberTopup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(10, 10, 395, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel 卡內金_文字 = new JLabel("當前金額");
		卡內金_文字.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		卡內金_文字.setForeground(new Color(255, 255, 255));
		卡內金_文字.setBounds(10, 13, 93, 23);
		panel.add(卡內金_文字);
		
		JLabel 當前金額 = new JLabel("");
		當前金額.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		當前金額.setForeground(new Color(255, 255, 255));
		當前金額.setBounds(113, 17, 121, 15);
		Member m=(Member) Cal.ReadObject("Member.txt");	
		panel.add(當前金額);
		String CASH=m.getCash()+"";
		當前金額.setText(CASH);
			
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 204));
		panel_1.setBounds(10, 60, 395, 91);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 0));
		panel_2.setBounds(10, 69, 395, 42);
		contentPane.add(panel_2);		
		panel_2.setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("加值成功！");
		lblNewLabel_1.setBackground(new Color(255, 255, 0));
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 22));
		lblNewLabel_1.setBounds(142, 5, 110, 30);
		panel_2.add(lblNewLabel_1);
		panel_2.setVisible(false);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(50, 205, 50));
		panel_2_1.setBounds(10, 72, 395, 42);
		contentPane.add(panel_2_1);
		panel_2_1.setLayout(null);
		JLabel lblNewLabel_1_1 = new JLabel("點選下方按鈕加值");
		lblNewLabel_1_1.setBounds(105, 6, 212, 30);
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 22));
		lblNewLabel_1_1.setBackground(Color.YELLOW);
		panel_2_1.add(lblNewLabel_1_1);
		
		
		JLabel 儲值金_文字 = new JLabel("本次儲值金額");
		儲值金_文字.setBounds(10, 10, 129, 23);
		panel_1.add(儲值金_文字);
		儲值金_文字.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		儲值金_文字.setForeground(new Color(255, 0, 0));
		
		JLabel 本次儲值金 = new JLabel("New label");
		本次儲值金.setBounds(131, 14, 59, 15);
		panel_1.add(本次儲值金);
		本次儲值金.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		本次儲值金.setForeground(new Color(255, 0, 0));
		本次儲值金.setText(addCash+"");
		
		JLabel 儲後金_文字 = new JLabel("儲值後金額 ");
		儲後金_文字.setBounds(200, 10, 129, 23);
		panel_1.add(儲後金_文字);
		儲後金_文字.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		儲後金_文字.setForeground(new Color(255, 0, 0));
		
		JLabel 儲值後金額 = new JLabel("0");
		儲值後金額.setBounds(301, 14, 59, 15);
		panel_1.add(儲值後金額);
		儲值後金額.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		儲值後金額.setForeground(new Color(255, 0, 0));
		
		
		JButton 五百 = new JButton("");
		五百.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addCash=addCash+500;
				本次儲值金.setText(addCash+"");
				儲值後金額.setText((m.getCash()+addCash)+"");
				panel_1.setVisible(true);
				panel_2_1.setVisible(false);
			}
		});
		五百.setIcon(new ImageIcon(MemberTopup.class.getResource("/picture/加500.png")));
		五百.setBounds(85, 323, 100, 100);
		contentPane.add(五百);
		
		JButton 一千 = new JButton("");
		一千.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addCash=addCash+1000;
				本次儲值金.setText(addCash+"");
				儲值後金額.setText((m.getCash()+addCash)+"");
				panel_1.setVisible(true);
				panel_2_1.setVisible(false);
			}
		});
		一千.setIcon(new ImageIcon(MemberTopup.class.getResource("/picture/加1000.png")));
		一千.setBounds(234, 323, 100, 100);
		contentPane.add(一千);
		
		JButton 三千 = new JButton("");
		三千.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addCash=addCash+3000;
				本次儲值金.setText(addCash+"");
				儲值後金額.setText((m.getCash()+addCash)+"");
				panel_1.setVisible(true);
				panel_2_1.setVisible(false);
			}
		});
		三千.setIcon(new ImageIcon(MemberTopup.class.getResource("/picture/加3000.png")));
		三千.setBounds(234, 453, 100, 100);
		contentPane.add(三千);
		
		JButton 一百 = new JButton("");
		一百.addMouseListener(new MouseAdapter() {
	
			@Override
			public void mouseClicked(MouseEvent e) {
				addCash=addCash+100;
				本次儲值金.setText(addCash+"");
				儲值後金額.setText((m.getCash()+addCash)+"");
				panel_1.setVisible(true);
				panel_2_1.setVisible(false);
			}
		});
		一百.setIcon(new ImageIcon(MemberTopup.class.getResource("/picture/加100.png")));
		一百.setBounds(85, 189, 100, 100);
		contentPane.add(一百);
		
		JButton 兩千 = new JButton("");
		兩千.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addCash=addCash+2000;
				本次儲值金.setText(addCash+"");
				儲值後金額.setText((m.getCash()+addCash)+"");
				panel_1.setVisible(true);
				panel_2_1.setVisible(false);
			}
		});
		兩千.setIcon(new ImageIcon(MemberTopup.class.getResource("/picture/加2000.png")));
		兩千.setBounds(85, 453, 100, 100);
		contentPane.add(兩千);
		
		JButton 三百 = new JButton("");
		三百.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addCash=addCash+300;
				本次儲值金.setText(addCash+"");
				儲值後金額.setText((m.getCash()+addCash)+"");
				panel_1.setVisible(true);
				panel_2_1.setVisible(false);
			}
		});
		三百.setIcon(new ImageIcon(MemberTopup.class.getResource("/picture/加300.png")));
		三百.setBounds(234, 189, 100, 100);
		contentPane.add(三百);
		
		
		JButton btnNewButton = new JButton("確定加值");
		btnNewButton.setBackground(new Color(51, 204, 0));
		btnNewButton.setBounds(74, 51, 95, 30);
		panel_1.add(btnNewButton);
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Member m=(Member) Cal.ReadObject("Member.txt");	
				Integer id=m.getId();
				Integer cash=m.getCash()+addCash;
				msi.updateCash(id, cash);
				Member m1=msi.findId(id);
				Cal.SaveObject(m1, "Member.txt");
				Member m3=(Member) Cal.ReadObject("Member.txt");	
				當前金額.setText(m3.getCash()+"");
				addCash=0;
				panel_1.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		
		JButton btnNewButton_2 = new JButton("清除加值");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addCash=0;
				本次儲值金.setText(addCash+"");
				儲值後金額.setText((m.getCash()+addCash)+"");		
			}
		});
		btnNewButton_2.setBackground(new Color(255, 102, 0));
		btnNewButton_2.setBounds(233, 51, 95, 30);
		panel_1.add(btnNewButton_2);
		btnNewButton_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		
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
		btnNewButton_1.setBounds(300, 15, 100, 30);
		panel.add(btnNewButton_1);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton_1.setBorder(new LineBorder(new Color(128, 0, 0), 2));	
		btnNewButton_1.setBackground(Color.BLACK);

		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBackground(new Color(255, 0, 0));
		lblNewLabel.setIcon(new ImageIcon(MemberTopup.class.getResource("/picture/小儲值頁.png")));
		lblNewLabel.setBounds(0, 0, 422, 600);
		contentPane.add(lblNewLabel);
	}

}
