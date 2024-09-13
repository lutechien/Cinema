package controller.operate;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.login.LoginUI;
import controller.movie.CocoMovie;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChooseMovie extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final int ICON_WIDTH = 150; // 電影寬
    private static final int ICON_HEIGHT = 250; // 電影高
    private JButton prevButton;
    private JButton nextButton;
    private JScrollPane scrollPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ChooseMovie frame = new ChooseMovie();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ChooseMovie() {
        setTitle("Choose Movie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(889, 487);
        setLocationRelativeTo(null); // Center the window

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel titleLabel = new JLabel("選擇電影", SwingConstants.CENTER);
        titleLabel.setForeground(new Color(255, 255, 255));
        titleLabel.setBounds(162, 40, 532, 41);
        titleLabel.setFont(new Font("微軟正黑體", Font.BOLD | Font.ITALIC, 40));
        contentPane.add(titleLabel);
        
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
    	btnNewButton_1.setBounds(746, 40, 100, 30);
    	contentPane.add(btnNewButton_1);
    	btnNewButton_1.setForeground(Color.WHITE);
    	btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
    	btnNewButton_1.setBorder(new LineBorder(new Color(128, 0, 0), 2));	
    	btnNewButton_1.setBackground(Color.BLACK);

        // Create panel for icons
        JPanel iconPanel = new JPanel();
        iconPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));


        // Create scroll pane
        scrollPane = new JScrollPane(iconPanel, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        JButton button = new JButton();
        button.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		CocoMovie c=new CocoMovie();
				c.setVisible(true);
				dispose();
        	}
        });
        button.setIcon(new ImageIcon(ChooseMovie.class.getResource("/picture/可可.png")));
        button.setPreferredSize(new Dimension(150, 250));
        iconPanel.add(button);
        
        JButton button_1 = new JButton();
        button_1.setIcon(new ImageIcon(ChooseMovie.class.getResource("/picture/動物未上.png")));
        button_1.setPreferredSize(new Dimension(150, 250));
        iconPanel.add(button_1);
        
        JButton button_2 = new JButton();
        button_2.setIcon(new ImageIcon(ChooseMovie.class.getResource("/picture/腦筋未上.png")));
        button_2.setPreferredSize(new Dimension(150, 250));
        iconPanel.add(button_2);
        
        JButton button_3 = new JButton();
        button_3.setIcon(new ImageIcon(ChooseMovie.class.getResource("/picture/貓貓未上.png")));
        button_3.setPreferredSize(new Dimension(150, 250));
        iconPanel.add(button_3);
        
        JButton button_4 = new JButton();
        button_4.setIcon(new ImageIcon(ChooseMovie.class.getResource("/picture/魔法未上.png")));
        button_4.setPreferredSize(new Dimension(150, 250));
        iconPanel.add(button_4);
        
        JButton button_5 = new JButton();
        button_5.setIcon(new ImageIcon(ChooseMovie.class.getResource("/picture/海洋未上.png")));
        button_5.setPreferredSize(new Dimension(150, 250));
        iconPanel.add(button_5);

            
        scrollPane.setBounds(104, 127, 654, 263);
        scrollPane.getHorizontalScrollBar().setUnitIncrement(ICON_WIDTH);
        contentPane.add(scrollPane);
        prevButton = new JButton("");
        prevButton.setIcon(new ImageIcon(ChooseMovie.class.getResource("/picture/左按鈕.png")));
        prevButton.setBounds(34, 249, 45, 61);
        prevButton.setForeground(Color.WHITE);
        prevButton.setFont(new Font("微軟正黑體", Font.BOLD, 39));
        prevButton.setBorder(new LineBorder(new Color(128, 0, 0), 2));	
        prevButton.setBackground(new Color(68, 68, 68));
        
        contentPane.add(prevButton);
        nextButton = new JButton("");
        nextButton.setIcon(new ImageIcon(ChooseMovie.class.getResource("/picture/右按鈕.png")));
        nextButton.setForeground(Color.WHITE);
        nextButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        nextButton.setBorder(new LineBorder(new Color(128, 0, 0), 2));	
        nextButton.setBackground(Color.BLACK);
        nextButton.setBounds(787, 249, 45, 61);
        contentPane.add(nextButton);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(ChooseMovie.class.getResource("/picture/小選片.png")));
        lblNewLabel.setBounds(0, 0, 876, 454);
        contentPane.add(lblNewLabel);
        nextButton.addActionListener(e -> scroll(1));
        
                prevButton.addActionListener(e -> scroll(-1));
    }
    

    private void scroll(int direction) {
        JScrollBar horizontalScrollBar = scrollPane.getHorizontalScrollBar();
        int max = horizontalScrollBar.getMaximum();
        int value = horizontalScrollBar.getValue();
        int extent = horizontalScrollBar.getModel().getExtent();

       
        int newValue = Math.max(0, Math.min(max, value + direction * ICON_WIDTH));
        horizontalScrollBar.setValue(newValue);
        
        
    }
}