package projectshopping;

/*
 * This is for viewing the sales summary graph for the admin.
 */
import java.awt.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import projectshopping.CustomerRelatedLogic;
import projectshopping.CustomerRelatedLogic;

public class BaseVariable extends JPanel {

    CustomerRelatedLogic cl;
    int first = 0;
    int second = 0;
    int third = 0;
    Date date;
    int month;

    void graph() {
        try {
            cl=new CustomerRelatedLogic();
           
                cl.rs = cl.stmt.executeQuery("SELECT date_time FROM `order_table` WHERE 1");
                while (cl.rs.next()) {
                    date = cl.rs.getDate(1);
                    month = date.getMonth();
                    System.out.println(month);
                    if (month == 00) {
                        first++;
                    }
                    if (month == 01) {
                        second++;
                    }
                    if (month == 02) {
                        third++;
                    }
                    
                }
                
        } catch (SQLException ex) {
                Logger.getLogger(BaseVariable.class.getName()).log(Level.SEVERE, null, ex);
            }
         catch (Throwable ex) {
            Logger.getLogger(BaseVariable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void paintComponent(Graphics g) {
        Font f = new Font("Stencil Std", Font.BOLD, 16);
        
        g.setFont(f);
        // g.drawLine(640, 400 ,1280, 400);    
        g.fill3DRect(640, 600, 640, 10, false);
        g.fill3DRect(630, 100, 10, 510, false);
        g.drawString("January", 746, 630);
        g.drawString("February", 958, 630);
        g.drawString("March", 1170, 630);
        for (int i = 10; i <=100; i+=10) {
            g.drawString(i+"", 570,610-(i*5));
        }
        g.setColor(Color.red);
        g.drawString("MONTHS", 958, 690);
        g.drawString("S", 490, 295);
        g.drawString("O", 490, 310);
        g.drawString("L", 490, 325);
        g.drawString("D", 490, 340);
        g.drawString("",  490, 355);
        g.drawString("S", 490, 370);
        g.drawString("T", 490, 385);
        g.drawString("O", 490, 400);
        g.drawString("C", 490, 415);
        g.drawString("K", 490, 430);
        graph();
        first=100;
        
       second=13;
       third=75;
        g.setColor(Color.BLUE);
        g.fill3DRect(746, 600 -(( first * 5)), 106, first*5, true);
        g.fill3DRect(958, 600 - ((second * 5)), 106, second*5, true);
        g.fill3DRect(1170, 600 - ((third * 5)), 106, third*5, true);

    }

    public static void main(String[] args) {

//        JFrame frame = new JFrame("Draw Points");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        frame.setBackground(Color.white);
//        frame.setSize(1920, 1080);

        BaseVariable panel = new BaseVariable();
//        frame.add(panel);
//        frame.setVisible(true);
    }
}
