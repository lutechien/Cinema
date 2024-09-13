package controller.movie;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import util.TicketPrinter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class MovieSeat extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton[][] seats;
    private final int ROWS = 5; // 行
    private final int COLS = 4; // 列
    private final int SEAT_WIDTH = 80; // 座位按钮的宽
    private final int SEAT_HEIGHT = 30; // 座位按钮的高
    private final int GAP_Y = 5; // 按钮之间的垂直间隔
    private final int GAP_X = 5; // 按钮之间的水平间隔
    private final Color SELECTED_COLOR = Color.GREEN;
    private final Color DEFAULT_COLOR = new Color(128, 128, 128);
    private final int MAX_SELECTION=CocoMovie.getOneTicket()+(CocoMovie.getTwoTicket()*2); // 最大可选择座位数
    private Point initialClick;
    private int selectedCount = 0; // 当前已选择的座位数
    private JLabel 顯示座位;
	private JComponent submitButton_1;
	private JComponent submitButton_1_1;
	protected String[] seatsArray;
	private static String[] SeatsArray;
	private static List<String> selectedSeatList;

	
	

    

	/**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MovieSeat frame = new MovieSeat();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public MovieSeat() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700, 100, 450, 657);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("選擇觀影位置");
        lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(147, 10, 186, 32);
        contentPane.add(lblNewLabel);

        JPanel seatPanel = new JPanel();
        seatPanel.setLayout(new GridLayout(ROWS, COLS, GAP_X, GAP_Y));
        seatPanel.setBounds(10, 390, (SEAT_WIDTH * COLS + GAP_X * (COLS - 1)) + 20, (SEAT_HEIGHT * ROWS + GAP_Y * (ROWS - 1)) + 20);

        JScrollPane scrollPane = new JScrollPane(seatPanel);
        scrollPane.setBounds(34, 273, (SEAT_WIDTH * COLS + GAP_X * (COLS - 1)) + 20, (SEAT_HEIGHT * ROWS + GAP_Y * (ROWS - 1)) + 20);
        contentPane.add(scrollPane);

        seats = new JButton[ROWS][COLS]; // 初始化 seats 陣列

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                JButton seatButton = new JButton("Seat " + (row * COLS + col + 1));
                seatButton.setPreferredSize(new Dimension(SEAT_WIDTH, SEAT_HEIGHT));
                seatButton.addActionListener(e -> toggleSeatSelection(seatButton));
                seatButton.setFont(new Font("Agency FB", Font.BOLD, 16));
                seatButton.setBackground(DEFAULT_COLOR);
                seatButton.setForeground(Color.WHITE);
                seatButton.setBorder(new EmptyBorder(5, 5, 5, 5)); 
                seats[row][col] = seatButton;
                seatPanel.add(seatButton);
            }
        }

        submitButton_1 = new JButton("前往付款");
        submitButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        submitButton_1.setBounds(239, 552, 137, 35);
        submitButton_1.setForeground(Color.WHITE);       
        submitButton_1.setBorder(new LineBorder(new Color(128, 0, 0), 2));	
        submitButton_1.setBackground(Color.BLACK);
        contentPane.add(submitButton_1);
        submitButton_1.setVisible(false);
                 
        submitButton_1_1 = new JButton("重新購票");
        submitButton_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        submitButton_1_1.setBounds(48, 552, 128, 35);
        submitButton_1_1.setForeground(Color.WHITE);       
        submitButton_1_1.setBorder(new LineBorder(new Color(128, 0, 0), 2));	
        submitButton_1_1.setBackground(Color.BLACK);
        contentPane.add(submitButton_1_1);
        submitButton_1_1.setVisible(false);
        
        JButton submitButton = new JButton("確定劃位");
        submitButton.setBounds(147, 473, 120, 35); // 设置提交按钮的位置    
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        submitButton.setBorder(new LineBorder(new Color(128, 0, 0), 2));	
        submitButton.setBackground(Color.BLACK);
        submitButton.addActionListener(e -> showSelectedSeats());
        submitButton.addMouseListener(new MouseAdapter() {
        		@Override
    		    public void mouseEntered(java.awt.event.MouseEvent evt) {
        			submitButton.setBackground(Color.DARK_GRAY); // 懸停時背景顏色變暗
    		    }

    		    @Override
    		    public void mouseExited(java.awt.event.MouseEvent evt) {
    		    	submitButton.setBackground(Color.BLACK); // 懸停結束時恢復背景顏色
    		    }        
    		});
        contentPane.add(submitButton);

        addDragListener(seatPanel);
        
        JLabel lblNewLabel_1 = new JLabel("您一共購買");
        lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(48, 63, 120, 26);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("雙人票券:");
        lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_1.setBounds(48, 100, 120, 31);
        contentPane.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("單人票券:");
        lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_1_1.setBounds(48, 140, 120, 25);
        contentPane.add(lblNewLabel_1_1_1);
        
        JLabel two = new JLabel("");
        two.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        two.setForeground(new Color(255, 255, 255));
        two.setBounds(157, 100, 120, 31);
        contentPane.add(two);
        two.setText(CocoMovie.getTwoTicket()+"");
        
        JLabel one = new JLabel("");
        one.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        one.setForeground(new Color(255, 255, 255));
        one.setBounds(157, 140, 120, 25);
        contentPane.add(one);
        one.setText(CocoMovie.getOneTicket()+"");              
              
        submitButton_1_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		CocoMovie.resetSettings();
				dispose();
        	}
        	@Override
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
    			submitButton_1_1.setBackground(Color.DARK_GRAY); // 懸停時背景顏色變暗
		    }

		    @Override
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	submitButton_1_1.setBackground(Color.BLACK); // 懸停結束時恢復背景顏色
		    }
        });
        
        
        JLabel lblNewLabel_1_2 = new JLabel("您選擇的位置為");
        lblNewLabel_1_2.setForeground(new Color(255, 255, 0));
        lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
        lblNewLabel_1_2.setBounds(34, 211, 156, 26);
        contentPane.add(lblNewLabel_1_2);
        
        顯示座位 = new JLabel("");
        顯示座位.setForeground(new Color(255, 255, 0));
        顯示座位.setFont(new Font("微軟正黑體", Font.BOLD, 16));
        顯示座位.setBounds(34, 237, 355, 26);
        contentPane.add(顯示座位);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("請選擇");
        lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        lblNewLabel_1_1_1_1.setBounds(48, 180, 87, 25);
        contentPane.add(lblNewLabel_1_1_1_1);
        
        JLabel lblNewLabel_1_1_1_1_1 = new JLabel("個座位");
        lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        lblNewLabel_1_1_1_1_1.setBounds(213, 180, 120, 25);
        contentPane.add(lblNewLabel_1_1_1_1_1);
        
        JLabel two_1 = new JLabel("0");
        two_1.setForeground(Color.WHITE);
        two_1.setFont(new Font("微軟正黑體", Font.BOLD, 28));
        two_1.setBounds(157, 175, 72, 36);
        contentPane.add(two_1);
        two_1.setText(MAX_SELECTION+"");
        
        submitButton_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {   
                    MoviePay m = new  MoviePay ();
                    m.setSelectedSeats(seatsArray);
                    m.setVisible(true);
                    dispose(); // 关闭当前窗口
                    CocoMovie.closeInstance();           
            }
        	@Override
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
    			submitButton_1.setBackground(Color.DARK_GRAY); // 懸停時背景顏色變暗
		    }

		    @Override
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	submitButton_1.setBackground(Color.BLACK); // 懸停結束時恢復背景顏色
		    }
        });
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(MovieSeat.class.getResource("/picture/小買票.jpg")));
        lblNewLabel_2.setBounds(0, 0, 434, 618);
        contentPane.add(lblNewLabel_2);
    }
    

    private void toggleSeatSelection(JButton button) {
        if (button.getBackground() == SELECTED_COLOR) {
            button.setBackground(DEFAULT_COLOR); // 取消选择
            button.setForeground(Color.WHITE);
            selectedCount--; // 减少已选择座位数
        } else {
            if (selectedCount < MAX_SELECTION) {
                button.setBackground(SELECTED_COLOR); // 选择
                button.setForeground(Color.BLACK);
                selectedCount++; // 增加已选择座位数
            } else {
                JOptionPane.showMessageDialog(contentPane, "劃位數達上限", "Selection Limit", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void showSelectedSeats() {
    	if (selectedCount < MAX_SELECTION) {
            JOptionPane.showMessageDialog(contentPane, "您尚未選擇足夠的座位", "選擇不足", JOptionPane.WARNING_MESSAGE);
            return; 
        };
        StringBuilder selectedSeats = new StringBuilder();
        selectedSeatList = new ArrayList<>(); // 初始化列表以存储选中的座位
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (seats[row][col].getBackground() == SELECTED_COLOR) {
                	 String seat = "Seat " + (row * COLS + col + 1);
                	 selectedSeats.append(seat).append(", ");                	 
                	 selectedSeatList.add(seat);
                	                  
                }
            }
        }
        if (selectedSeats.length() > 0) {
            顯示座位.setText(selectedSeats.toString());           
            submitButton_1.setVisible(true);
            submitButton_1_1.setVisible(true);
            seatsArray = selectedSeatList.toArray(new String[0]);          
        } else {
            顯示座位.setText("您尚未選擇任何座位。");
        }        
    }

    private void addDragListener(JComponent component) {
        component.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
            }
        });

        component.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                JComponent component = (JComponent) e.getSource();
                Point currentLocation = e.getLocationOnScreen();
                component.setLocation(currentLocation.x - initialClick.x, currentLocation.y - initialClick.y);
            }
        });
    }   
    
}
