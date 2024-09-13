package controller.movie;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import model.Member;
import service.impl.MemberServiceImpl;
import util.Cal;
import util.TicketPrinter;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Arrays;
import java.util.Collections;

public class MoviePay extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
	private Integer total;
	protected Window 顧客現金;
	private static MemberServiceImpl msi=new MemberServiceImpl();
	private static  JLabel MembercashShow; 
	protected static Integer Membercash;
	private String[] selectedSeats;
   


	public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MoviePay frame = new MoviePay();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MoviePay() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 673); // 设置窗口大小
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("付款介面");
        lblTitle.setForeground(new Color(255, 255, 255));
        lblTitle.setFont(new Font("微軟正黑體", Font.BOLD, 26));
        lblTitle.setBounds(170, 10, 130, 30);
        contentPane.add(lblTitle);

        JPanel paymentPanel = new JPanel();
        paymentPanel.setBackground(new Color(39,39,39));
        paymentPanel.setBounds(10, 246, 416, 157);
        paymentPanel.setBorder(new LineBorder(Color.GRAY, 2));
        
        paymentPanel.setLayout(null);
        contentPane.add(paymentPanel);

        JLabel lblPaymentMethod = new JLabel("請選擇付款方式");
        lblPaymentMethod.setForeground(new Color(255, 255, 255));
        lblPaymentMethod.setFont(new Font("微軟正黑體", Font.BOLD, 16));
        lblPaymentMethod.setBounds(140, 10, 130, 20);
        paymentPanel.add(lblPaymentMethod);

        JCheckBox cbCash = new JCheckBox("現金付款"); 
        cbCash.setFont(new Font("微軟正黑體", Font.BOLD, 13));
        cbCash.setBackground(new Color(39,39,39));
        cbCash.setForeground(new Color(255, 255, 255));
        cbCash.setBounds(20, 50, 95, 23);
        paymentPanel.add(cbCash);

        JCheckBox cbMemberPoints = new JCheckBox("會員扣款");
        cbMemberPoints.setFont(new Font("微軟正黑體", Font.BOLD, 13));
        cbMemberPoints.setBackground(new Color(39,39,39));
        cbMemberPoints.setForeground(new Color(255, 255, 255));
        cbMemberPoints.setBounds(20, 80, 95, 23);
        paymentPanel.add(cbMemberPoints);
        
        ButtonGroup group = new ButtonGroup();
        group.add(cbCash);
        group.add(cbMemberPoints);

        JTextField 顧客現金 = new JTextField();
        顧客現金.setBounds(120, 50, 100, 25);
        paymentPanel.add(顧客現金);
        顧客現金.setColumns(10);
     
        JLabel lblCurrentPoints = new JLabel("目前會員金");
        lblCurrentPoints.setFont(new Font("微軟正黑體", Font.BOLD, 12));
        lblCurrentPoints.setForeground(new Color(255, 255, 0));
        lblCurrentPoints.setBounds(127, 125, 100, 20);
        paymentPanel.add(lblCurrentPoints);

        MembercashShow = new JLabel("");
        MembercashShow.setFont(new Font("微軟正黑體", Font.BOLD, 12));
        MembercashShow.setForeground(new Color(255, 255, 0));
        MembercashShow.setBounds(208, 125, 100, 20);
        paymentPanel.add(MembercashShow);
        Member m=(Member) Cal.ReadObject("Member.txt");	
        String CASH=m.getCash()+"";
        Integer id=m.getId();
        MembercashShow.setText(CASH);
        
        JButton btnPrint = new JButton("列印票券與明細");
        btnPrint.setBounds(150, 570, 150, 25);
        contentPane.add(btnPrint);
        btnPrint.setVisible(false);

        JPanel itemsPanel = new JPanel();
        itemsPanel.setBackground(new Color(0, 0, 0,0));
        itemsPanel.setBounds(10, 50, 416, 186);
        itemsPanel.setLayout(null);
        itemsPanel.setBorder(new LineBorder(Color.GRAY, 2));
        contentPane.add(itemsPanel);

        JLabel lblItems = new JLabel("您購買的項目如下");
        lblItems.setForeground(new Color(255, 255, 255));
        lblItems.setFont(new Font("微軟正黑體", Font.BOLD, 16));
        lblItems.setBounds(10, 10, 150, 25);
        itemsPanel.add(lblItems);

        JButton btnRechoose = new JButton("重新選購");
        btnRechoose.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		CocoMovie c=new CocoMovie();
        		c.setVisible(true);
        		dispose();
        	}
        });
        btnRechoose.setBounds(300, 10, 100, 25);
        itemsPanel.add(btnRechoose);

     // 创建表格模型并设置列名
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[] {"品項", "數量", "金額"});

        // 创建表格并设置模型
        table = new JTable(model);

        // 使用 JScrollPane 包装表格
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 46, 396, 104);

        // 将 JScrollPane 添加到面板1
        itemsPanel.add(scrollPane);
        
        JLabel lblNewLabel = new JLabel("商品總價");
        lblNewLabel.setForeground(new Color(255, 0, 0));
        lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 157, 66, 23);
        itemsPanel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setForeground(new Color(255, 0, 0));
        lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(90, 157, 70, 23);
        itemsPanel.add(lblNewLabel_1);

        // 初始化数据
        if(CocoMovie.getTwoTicket()>0) {model.addRow(new Object[] {"雙人電影票券", CocoMovie.getTwoTicket(), CocoMovie.getTwoTicket() * 580});}
        if(CocoMovie.getOneTicket()>0) {model.addRow(new Object[] {"單人電影票券", CocoMovie.getOneTicket(), CocoMovie.getOneTicket() * 300});}
        if(CocoMovie.getCoke()>0) {model.addRow(new Object[] {"可樂", CocoMovie.getCoke(), CocoMovie.getCoke() * 50});}
        if(CocoMovie.getPopcorn()>0) {model.addRow(new Object[] {"爆米花", CocoMovie.getPopcorn(), CocoMovie.getPopcorn() * 80});}
        total=CocoMovie.getTwoTicket() * 580+CocoMovie.getOneTicket() * 300+CocoMovie.getCoke() * 50+CocoMovie.getPopcorn() * 80;
        lblNewLabel_1.setText(total+"");
        
        JTextArea 交易成功 = new JTextArea();
        交易成功.setForeground(new Color(255, 255, 255));
        交易成功.setFont(new Font("微軟正黑體", Font.PLAIN, 13));
        交易成功.setBackground(new Color(60, 60, 60));
        交易成功.setBorder(new LineBorder(Color.GRAY, 2));
        交易成功.setBounds(10, 416, 414, 144);
        contentPane.add(交易成功);
        交易成功.setVisible(false);
        
        JButton btnCashPayment = new JButton("現金付款");
        btnCashPayment.setFont(new Font("微軟正黑體", Font.BOLD, 13));
        btnCashPayment.setBackground(new Color(0, 255, 255));
        btnCashPayment.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		String Cashpay=顧客現金.getText();
        		Integer CP=new Integer(Cashpay);
        		if (CP>=total) 
        		{   
        			交易成功.setVisible(true);
        			交易成功.setText(Cal.Cashpayshow(total,CP,Cal.CashPay(total,CP)));
        			顧客現金.setText(null);
        			btnPrint.setVisible(true);
        		}
        		else 
        		{
        			 JOptionPane.showMessageDialog(contentPane, "您的付款金額不足", "金額不足", JOptionPane.WARNING_MESSAGE);
        			 顧客現金.setText(null);
        		};
  		
        	}
        });
        btnCashPayment.setBounds(250, 50, 120, 25);
        paymentPanel.add(btnCashPayment);

        JButton btnMemberPayment = new JButton("會員付款");
        btnMemberPayment.setFont(new Font("微軟正黑體", Font.BOLD, 13));
        btnMemberPayment.setBackground(new Color(0, 255, 0));
        btnMemberPayment.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Member m3=(Member) Cal.ReadObject("Member.txt");	
        		Membercash=m3.getCash();
        		if(Membercash>=total) 
        		{   
        			交易成功.setVisible(true);
        			交易成功.setText(Cal.Memberpayshow(total,Membercash,Cal.MemberPay(total,Membercash)));
        			Integer cash=Cal.MemberPay(total,Membercash);
        			msi.updateCash(id, cash);
        			Member m1=msi.findId(id);					
    				Cal.SaveObject(m1, "Member.txt");
    				Member m2=(Member) Cal.ReadObject("Member.txt");
    		        String CASH=m2.getCash()+"";
    		        MembercashShow.setText(CASH);  
    		        btnPrint.setVisible(true);
        		}
        		else {
        			JOptionPane.showMessageDialog(contentPane, "您的會員金不足,請儲值或改用現金付款", "會員金不足", JOptionPane.WARNING_MESSAGE);
        		};
        		
        	}
        });
        btnMemberPayment.setBounds(250, 80, 120, 25);
        paymentPanel.add(btnMemberPayment);

        JButton btnMemberTopUp = new JButton("會員儲值");
        btnMemberTopUp.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		PayTpoup p=new PayTpoup();
				p.setVisible(true);
        	}
        	@Override
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
        		btnMemberTopUp.setBackground(Color.DARK_GRAY); // 懸停時背景顏色變暗
		    }

		    @Override
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	btnMemberTopUp.setBackground(Color.BLACK); // 懸停結束時恢復背景顏色
		    } 
        });
        btnMemberTopUp.setBounds(20, 120, 100, 25);
        btnMemberTopUp.setForeground(Color.WHITE);
        btnMemberTopUp.setFont(new Font("微軟正黑體", Font.BOLD, 14));
        btnMemberTopUp.setBorder(new LineBorder(new Color(128, 0, 0), 2));	
        btnMemberTopUp.setBackground(Color.BLACK);
        paymentPanel.add(btnMemberTopUp);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setIcon(new ImageIcon(MoviePay.class.getResource("/picture/儲值頁.png")));
        lblNewLabel_2.setBounds(0, 0, 434, 634);
        contentPane.add(lblNewLabel_2);
        
        btnPrint.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String movieName = "可可夜總會";  
                String hallNumber = "票廳 A廳";  
                String showTime = "2060-09-12 18:00:00";  

                PrinterJob printerJob = PrinterJob.getPrinterJob();               
                TicketPrinter TP = new TicketPrinter(model, total, movieName, hallNumber, showTime, selectedSeats);          
                try {
                    printerJob.setPrintable(TP);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                boolean doPrint = printerJob.printDialog(); 
                if (doPrint) {
                    try {
                        printerJob.print(); 
                    } catch (PrinterException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        
    }

	public static void setMembercashShow(Integer membercash) {
		MembercashShow.setText(membercash+"");;
	}

	 public void setSelectedSeats(String[] seatsArray) {
		    this.selectedSeats = seatsArray;
		}
    
}
