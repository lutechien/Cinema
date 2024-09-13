package util;

import java.awt.*;
import java.awt.print.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TicketPrinter implements Printable {
    private String[] seats; 
    private DefaultTableModel model;
    private int total;
    private String movieName;
    private String hallNumber;
    private String showTime;

    public TicketPrinter(DefaultTableModel model, int total, String movieName, String hallNumber, String showTime, String[] seats) {
        this.model = model;
        this.total = total;
        this.movieName = movieName;
        this.hallNumber = hallNumber;
        this.showTime = showTime;
        this.seats = seats;

        if (seats == null) {
            System.out.println("Warning: seats array is null");
        }
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        g2d.setFont(new Font("微軟正黑體", Font.PLAIN, 12));

        int PAGE_WIDTH = (int) pageFormat.getImageableWidth();
        int PAGE_HEIGHT = (int) pageFormat.getImageableHeight();
        int MARGIN = 20;
        int LINE_HEIGHT = 15;

        
        int maxLinesPerPage = (PAGE_HEIGHT - 2 * MARGIN) / LINE_HEIGHT;
        
        if (pageIndex * maxLinesPerPage >= seats.length) {
            return NO_SUCH_PAGE;
        }

        int y = MARGIN;
        int startIndex = pageIndex * maxLinesPerPage;
        int endIndex = Math.min(startIndex + maxLinesPerPage, seats.length);


        g2d.setFont(new Font("微軟正黑體", Font.BOLD, 14));
        g2d.drawString("電影票券", MARGIN, y);
        y += 20;
        g2d.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
        g2d.drawString("電影名稱: " + movieName, MARGIN, y);
        y += LINE_HEIGHT;
        g2d.drawString("票廳: " + hallNumber, MARGIN, y);
        y += LINE_HEIGHT;

     
        g2d.drawString("座位: ", MARGIN, y);
        y += LINE_HEIGHT;

        for (int i = startIndex; i < endIndex; i++) {
            g2d.drawString(seats[i], MARGIN, y);
            y += LINE_HEIGHT;
        }

        // Print the show time
        g2d.drawString("放映時間: " + showTime, MARGIN, y);
        y += LINE_HEIGHT;

        // Print the current date and time
        String printDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        g2d.drawString("列印時間: " + printDate, MARGIN, y);
        y += LINE_HEIGHT;

        // Print purchase details
        int lineCount = 0;
        g2d.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
        y += LINE_HEIGHT;
        g2d.drawString("購買明細:", MARGIN, y);
        y += LINE_HEIGHT;

        for (int i = 0; i < model.getRowCount(); i++) {
            if (lineCount >= maxLinesPerPage) {
                return PAGE_EXISTS; // Return PAGE_EXISTS to indicate that there are more pages
            }
            String item = (String) model.getValueAt(i, 0);
            int quantity = (int) model.getValueAt(i, 1);
            int amount = (int) model.getValueAt(i, 2);
            g2d.drawString(item + " - 數量: " + quantity + " - 金額: " + amount, MARGIN, y);
            y += LINE_HEIGHT;
            lineCount++;
        }

        g2d.drawString("總金額: " + total, MARGIN, y);

        return PAGE_EXISTS;
    }
}
