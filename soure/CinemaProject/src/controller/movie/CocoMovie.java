package controller.movie;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.operate.ChooseMovie;
import controller.operate.LoginSuccess;
import controller.movie.MovieSeat;

import javax.swing.JLabel;
import javax.swing.JCheckBox;

public class CocoMovie extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static int twoTicket;
	private static int oneTicket;
	private static int coke;
	private static int popcorn;
	private static JComboBox twoPerson;
	private static JComboBox onePerson;
	private static AbstractButton cokeCheckBox;
	private static AbstractButton popcornCheckBox;
	private static CocoMovie instance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CocoMovie frame = new CocoMovie();
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
	public CocoMovie() {
		 instance = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 682);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setForeground(new Color(64, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(CocoMovie.class.getResource("/picture/可可.png")));
		lblNewLabel_3.setBounds(24, 0, 205, 311);
		contentPane.add(lblNewLabel_3);
		
		
		
		JLabel lblNewLabel = new JLabel("可可夜總會");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(261, 52, 296, 62);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 46));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(CocoMovie.class.getResource("/picture/小普遍級.png")));
		lblNewLabel_4.setBounds(240, 124, 39, 42);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_8 = new JLabel("禁止劇透所以我不劇透....但這邊好空看著好乾");
		lblNewLabel_8.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setBounds(285, 150, 272, 16);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel("在哪裡跌倒，就在哪裡躺好。");
		lblNewLabel_8_1.setForeground(Color.WHITE);
		lblNewLabel_8_1.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		lblNewLabel_8_1.setBounds(239, 178, 272, 16);
		contentPane.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_8_1_1 = new JLabel("好好活下去，每天都有新的打擊。");
		lblNewLabel_8_1_1.setForeground(Color.WHITE);
		lblNewLabel_8_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		lblNewLabel_8_1_1.setBounds(240, 204, 272, 16);
		contentPane.add(lblNewLabel_8_1_1);
		
		JLabel lblNewLabel_8_1_1_1 = new JLabel("我不罵人，因為我動手能力比較強。");
		lblNewLabel_8_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_8_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		lblNewLabel_8_1_1_1.setBounds(239, 230, 272, 16);
		contentPane.add(lblNewLabel_8_1_1_1);
		
		JLabel lblNewLabel_8_1_1_1_1 = new JLabel("買房子好像太不切實際，還不如死後給我燒一間。");
		lblNewLabel_8_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_8_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		lblNewLabel_8_1_1_1_1.setBounds(239, 256, 296, 16);
		contentPane.add(lblNewLabel_8_1_1_1_1);
		
		JLabel lblNewLabel_8_1_1_1_1_1 = new JLabel("事已至此，先吃飯吧( º﹃º )");
		lblNewLabel_8_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_8_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
		lblNewLabel_8_1_1_1_1_1.setBounds(239, 279, 272, 16);
		contentPane.add(lblNewLabel_8_1_1_1_1_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255, 0));
		panel.setBounds(24, 321, 527, 312);
		panel.setBorder(new LineBorder(Color.GRAY, 2));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("雙人電影票券  580/份");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 23));
		lblNewLabel_1.setBounds(83, 60, 225, 31);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("單人電影票券  300/張");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 23));
		lblNewLabel_1_1.setBounds(83, 117, 225, 31);
		panel.add(lblNewLabel_1_1);
		
		twoPerson = new JComboBox<>();
		twoPerson.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		twoPerson.setBounds(365, 66, 52, 23);
		panel.add(twoPerson);
		twoPerson.addItem(0);
		twoPerson.addItem(1);
		twoPerson.addItem(2);
		twoPerson.addItem(3);
		twoPerson.show();
		
		onePerson = new JComboBox<>();
		onePerson.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		onePerson.setBounds(365, 123, 52, 23);
		panel.add(onePerson);
		onePerson.addItem(0);
		onePerson.addItem(1);
		onePerson.addItem(2);
		onePerson.addItem(3);
		onePerson.show();
		
		
		cokeCheckBox = new JCheckBox("可樂");
		cokeCheckBox.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		cokeCheckBox.setBounds(165, 184, 95, 31);
		panel.add(cokeCheckBox);
			
			/*@Override
			public void mouseClicked(MouseEvent e) {
				if (chckbxNewCheckBox.isSelected()) {
			        output.setText("他要可樂");
			    } else {
			        output.setText("");*/

		cokeCheckBox.setForeground(new Color(255, 255, 255));
		cokeCheckBox.setBackground(new Color(39,39,39));
		
		popcornCheckBox = new JCheckBox("爆米花");
		popcornCheckBox.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		popcornCheckBox.setBounds(295, 184, 112, 31);
		panel.add(popcornCheckBox);
		popcornCheckBox.setForeground(new Color(255, 255, 255));
		popcornCheckBox.setBackground(new Color(39,39,39));
	
		JLabel lblNewLabel_5 = new JLabel("購票區");
		lblNewLabel_5.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(235, 0, 112, 31);
		panel.add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("回上一頁");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChooseMovie c=new ChooseMovie();
				c.setVisible(true);
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
		btnNewButton_1.setBounds(457, 10, 100, 30);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton_1.setBorder(new LineBorder(new Color(128, 0, 0), 2));	
		btnNewButton_1.setBackground(Color.BLACK);
		
		JButton btnNewButton = new JButton("電影劃位");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				twoTicket =(Integer) twoPerson.getSelectedItem();
				oneTicket =(Integer) onePerson.getSelectedItem();
				if(cokeCheckBox.isSelected()) {coke=1;}
				if(popcornCheckBox.isSelected()) {popcorn=1;}			
				MovieSeat m=new MovieSeat();
				m.setVisible(true);
				
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
		btnNewButton.setBounds(185, 238, 162, 44);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 31));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton.setBorder(new LineBorder(new Color(128, 0, 0), 2));	
		btnNewButton.setBackground(Color.BLACK);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(CocoMovie.class.getResource("/picture/小買票.jpg")));
		lblNewLabel_2.setBounds(-10, 0, 591, 649);
		contentPane.add(lblNewLabel_2);
	}
	
	public static void resetSettings() {
        twoTicket = 0;
        oneTicket = 0;
        coke = 0;
        popcorn = 0;
        twoPerson.setSelectedIndex(0);
        onePerson.setSelectedIndex(0);
        cokeCheckBox.setSelected(false);
        popcornCheckBox.setSelected(false);
    }
	
public static int getTwoTicket() {
	return twoTicket;
}

public static int getOneTicket() {
	return oneTicket;
}

public static int getCoke() {
	return coke;
}

public static int getPopcorn() {
	return popcorn;
}
public static CocoMovie getInstance() {
    if (instance == null) {
        instance = new CocoMovie(); 
    }
    return instance;
}

public static void closeInstance() {
    if (instance != null) {
        instance.dispose(); 
        instance = null; 
    }
}



}
