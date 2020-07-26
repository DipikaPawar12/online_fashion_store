/*
 * This is the USER/CUSTOMER HOME PORTAL.
 * The customer can browse around and view different products.
 * There are also filter and search options in men,women and children category.
 * These filters and search options allow the user to view the variety of products based on their need.
 */
package projectshopping;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.Timer;


/*womens wear
jLabel   1,2,3,4,5,6,7,8,9 are for images
         10,11,12,13,14,15,16,17,18 are for product name
jButton  1,2,3,4,5,6,7,8,9 are the view buttons*/

/*mens wear
jLabel   31,32,33,34,35,36,37,38,39 are for images
         40,41,42,43,44,45,46,47,48 are for product names
jButton  11,12,13,14,15,16,17,18,19,20 are the view buttons*/

/*kids wear
jLabel   53,54,55,56,57,58,59,60,61 are for images
         62,63,64,65,66,67,68,69,70 are for product names
jButton  21,22,23,24,25,26,27,28,29 are the view buttons*/
public class CustomerShopScreen extends javax.swing.JFrame implements ItemListener{
     CustomerRelatedLogic cl;
       
    Container c;
    
    OrderSelection os;
    public static int id1;
    
    File photoFile;
    ArrayList<JLabel> label = new ArrayList<>();
    
    public int customer = UserScreen.customerId;
    
     Timer tm;
    int x =0;
    String[] list = {
                     "D:\\AANSHI PATWARI-2018\\Semester 2\\project OOP 2019\\image3.jpg",
                     "D:\\AANSHI PATWARI-2018\\Semester 2\\project OOP 2019\\image7.jpg",
                     "D:\\AANSHI PATWARI-2018\\Semester 2\\project OOP 2019\\image8.jpg" 
                    };
    
    String[] list1 = {
                     "D:\\AANSHI PATWARI-2018\\Semester 2\\project OOP 2019\\image4.jpg",
                     "D:\\AANSHI PATWARI-2018\\Semester 2\\project OOP 2019\\image5.jpg",
                     "D:\\AANSHI PATWARI-2018\\Semester 2\\project OOP 2019\\image9.jpg" 
                    };
    //for womens wear
     ButtonGroup group = new ButtonGroup();
    ButtonGroup group1 = new ButtonGroup();
    ButtonGroup group2 = new ButtonGroup();
    //for mens wear
    ButtonGroup group3 = new ButtonGroup();
    ButtonGroup group4 = new ButtonGroup();
    ButtonGroup group5 = new ButtonGroup();
    //for kids wear
    ButtonGroup group6 = new ButtonGroup();
    ButtonGroup group7 = new ButtonGroup();
    ButtonGroup group8 = new ButtonGroup();
    
    /**
     * Creates new form CustomerShopScreen
     */
    public CustomerShopScreen() throws Throwable {
        initComponents();

        this.setSize(1920, 1080);
        this.setTitle("MAD Creationzzz!!!");
        //src/img/
        Image icon = Toolkit.getDefaultToolkit().getImage("src/img/i1.jpg");
        this.setIconImage(icon);
        cl = new CustomerRelatedLogic();
        
        label.add(jLabel1);
        label.add(jLabel2);
        label.add(jLabel3);
        label.add(jLabel4);
        label.add(jLabel5);
        label.add(jLabel6);
       // label.add(jLabel7);
       // label.add(jLabel8);
       // label.add(jLabel9);
        label.add(jLabel24);
        label.add(jLabel26);
        label.add(jLabel31);
        label.add(jLabel32);
        label.add(jLabel33);
        label.add(jLabel34);
        label.add(jLabel35);
        label.add(jLabel36);
        label.add(jLabel37);
        label.add(jLabel38);
      //  label.add(jLabel39);
        label.add(jLabel53);
        label.add(jLabel54);
        label.add(jLabel55);
        label.add(jLabel56);
        label.add(jLabel57);
        label.add(jLabel58);
        label.add(jLabel59);
        label.add(jLabel60);
        label.add(jLabel61);
        label.add(jLabel62);
      //  label.add(jLabel63);
          label.add(jLabel79);      
         
         setImageSize(2);
         setImageSizes(2);
        tm = new Timer(3000,new ActionListener()
            
        {       @Override
    public void actionPerformed(ActionEvent e) {
       setImageSize(x);
       setImageSizes(x);
       x +=1;
       if(x>=list.length)
       {
           x=0;
       }
    }  
        });
        
        
        tm.start();
        setLayout(null);
       // setSize(1920,1080);
        //getContentPane().setBackground(Color.decode("#bdb67b"));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
         //make groups of button
       //for womens wear category
        group.add(jRadioButton1);
        group.add(jRadioButton2);
        //for womens wear price 
        group1.add(jRadioButton3);
        group1.add(jRadioButton4);
        //for womens wear sortby
        group2.add(jRadioButton5);
        group2.add(jRadioButton6);
        group2.add(jRadioButton7);
        
        //for mens wear category
        group3.add(jRadioButton8);
        group3.add(jRadioButton9);
        group3.add(jRadioButton10);
        //for mens wear price
        group4.add(jRadioButton11);
        group4.add(jRadioButton12);
        //for mens wear sortby
        group5.add(jRadioButton13);
        group5.add(jRadioButton14);
        group5.add(jRadioButton15);
        
        //for kids wear category
        group6.add(jRadioButton16);
        group6.add(jRadioButton17);
        //for kids wear price
        group7.add(jRadioButton18);
        group7.add(jRadioButton19);
        //for kids wear sort by
        group8.add(jRadioButton20);
        group8.add(jRadioButton21);
        group8.add(jRadioButton22);
        
        
        //Define their listener
        //womens wear
        jRadioButton1.addItemListener(this);
        jRadioButton2.addItemListener(this);
        jRadioButton3.addItemListener(this);
        jRadioButton4.addItemListener(this);
        jRadioButton5.addItemListener(this);
        jRadioButton6.addItemListener(this);
        jRadioButton7.addItemListener(this);
        //mens wear
        jRadioButton8.addItemListener(this);
        jRadioButton9.addItemListener(this);
        jRadioButton10.addItemListener(this);
        jRadioButton11.addItemListener(this);
        jRadioButton12.addItemListener(this);
        jRadioButton13.addItemListener(this);
        jRadioButton14.addItemListener(this);
        jRadioButton15.addItemListener(this);
        //kids wear
        jRadioButton16.addItemListener(this);
        jRadioButton17.addItemListener(this);
        jRadioButton18.addItemListener(this);
        jRadioButton19.addItemListener(this);
        jRadioButton20.addItemListener(this);
        jRadioButton21.addItemListener(this);
        jRadioButton22.addItemListener(this);
        
    }
    
     public int getId() {
        int id = 0;
        ArrayList<Integer> productId = this.priceCollection("SELECT product_id FROM `cloth` WHERE 1");
       
        return id;
    }
     
     public int checkMatch(JLabel label) throws SQLException, Throwable{
           int i=0;
            try{
            cl.rs=cl.stmt.executeQuery("SELECT * FROM `cloth` WHERE 1");
            while(cl.rs.next()){
               // System.out.println("button pressed");
                if(cl.rs.getString(2).compareTo(label.getText())==0){
                    i=cl.rs.getInt(1);                    
                         
                    break;
                }                       
             }           
            }catch(Exception e)
            {
                System.out.println(e);
            }                  
        return i;
    }
    
     public void setImageSize(int i){
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic.setIcon(newImc);
    } 
     
      public void setImageSizes(int i){
        ImageIcon icon = new ImageIcon(list1[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(pic1.getWidth(), pic1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        pic1.setIcon(newImc);
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        pic = new javax.swing.JLabel();
        pic1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel20 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel21 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel22 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel13 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jLabel81 = new javax.swing.JLabel();
        jButton34 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        jRadioButton15 = new javax.swing.JRadioButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jRadioButton16 = new javax.swing.JRadioButton();
        jRadioButton17 = new javax.swing.JRadioButton();
        jRadioButton18 = new javax.swing.JRadioButton();
        jRadioButton19 = new javax.swing.JRadioButton();
        jRadioButton20 = new javax.swing.JRadioButton();
        jRadioButton21 = new javax.swing.JRadioButton();
        jRadioButton22 = new javax.swing.JRadioButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel79 = new javax.swing.JLabel();
        jButton30 = new javax.swing.JButton();
        jLabel80 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton10.setText("Cart");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton20.setText("log out");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10)
                    .addComponent(jButton20))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseEntered(evt);
            }
        });

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/new arrivals.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(pic1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(104, 104, 104))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 1621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(749, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3147, 3147, 3147)
                .addComponent(pic1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel6);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 2384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Recent Arrivals", jPanel4);

        jPanel3.setBackground(new java.awt.Color(0, 0, 102));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Filter By:");

        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Traditional Wear");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Categories:");

        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Western Wear");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Price:");

        jRadioButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton3.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton3.setText("<500");

        jRadioButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton4.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton4.setText(">500");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Sort By:");

        jRadioButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton5.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton5.setText("Rating");

        jRadioButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton6.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton6.setText("High to Low Price");

        jRadioButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton7.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton7.setText("Low to High Price");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton7)
                    .addComponent(jRadioButton6)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel19)
                .addGap(39, 39, 39)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addGap(62, 62, 62)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton3)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton4)
                .addGap(96, 96, 96)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton5)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton6)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton7)
                .addContainerGap(1140, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel10.setText("jLabel10");

        jButton1.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton1.setText("View");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel11.setText("jLabel11");

        jButton2.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton2.setText("View");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel12.setText("jLabel12");

        jButton3.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton3.setText("View");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel15.setText("jLabel15");

        jButton6.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton6.setText("View");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel9.setText("label9");

        jLabel18.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel18.setText("jLabel18");

        jButton9.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton9.setText("View");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel14.setText("jLabel14");

        jButton5.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton5.setText("View");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton4.setText("View");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel13.setText("jLabel13");

        jLabel8.setText("label8");

        jLabel17.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel17.setText("jLabel17");

        jButton8.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton8.setText("view");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton7.setText("View");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel16.setText("jLabel16");

        jLabel7.setText("label7");

        jLabel25.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel25.setText("jLabel16");

        jButton32.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton32.setText("view");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton33.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton33.setText("View");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jLabel81.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel81.setText("jLabel17");

        jButton34.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton34.setText("View");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                        .addGap(533, 1753, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addGap(172, 172, 172))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                                .addGap(1024, 1024, 1024)
                                .addComponent(jButton8))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addGap(519, 519, 519)
                                        .addComponent(jButton7))
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addGap(338, 338, 338)
                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel13Layout.createSequentialGroup()
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton1))
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(145, 145, 145)
                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel13Layout.createSequentialGroup()
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton2))
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel13Layout.createSequentialGroup()
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton34))
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4)))
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addGap(289, 289, 289)
                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addGap(142, 142, 142)
                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel13Layout.createSequentialGroup()
                                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton33))
                                            .addGroup(jPanel13Layout.createSequentialGroup()
                                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel13Layout.createSequentialGroup()
                                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(jButton3)))
                                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(6, 6, 6)))
                                                .addGap(76, 76, 76)
                                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jButton32))
                                                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(jPanel13Layout.createSequentialGroup()
                                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jButton6)))
                                                        .addGroup(jPanel13Layout.createSequentialGroup()
                                                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(1, 1, 1))))))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton9)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(232, 232, 232))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jButton1))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jButton6))
                                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton3)
                                        .addComponent(jButton2))
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(46, 46, 46)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton4))
                    .addComponent(jLabel81, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton32)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton33)
                        .addComponent(jButton34)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 971, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(97, 97, 97)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addContainerGap())
        );

        jScrollPane4.setViewportView(jPanel13);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 2359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1846, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Womens wear", jPanel2);

        jPanel7.setBackground(new java.awt.Color(0, 0, 102));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Filter By:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Categories:");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Price:");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Sort By:");

        jRadioButton8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton8.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton8.setText("Formal Wear");

        jRadioButton9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton9.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton9.setText("Casual Wear");

        jRadioButton10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton10.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton10.setText("Festive Wear");

        jRadioButton11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton11.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton11.setText("<500");

        jRadioButton12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton12.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton12.setText(">500");

        jRadioButton13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton13.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton13.setText("Ratings");

        jRadioButton14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton14.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton14.setText("HIgh to Low price");

        jRadioButton15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton15.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton15.setText("Low to High price");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton14)
                    .addComponent(jRadioButton13)
                    .addComponent(jRadioButton12)
                    .addComponent(jRadioButton11)
                    .addComponent(jRadioButton9)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jRadioButton10)
                    .addComponent(jRadioButton15)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jRadioButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel27)
                .addGap(37, 37, 37)
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton8)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton9)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton10)
                .addGap(96, 96, 96)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton11)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton12)
                .addGap(81, 81, 81)
                .addComponent(jLabel30)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton13)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton14)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel39.setText("jLabel39");

        jLabel40.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel40.setText("jLabel40");

        jLabel41.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel41.setText("jLabel41");

        jLabel42.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel42.setText("jLabel42");

        jLabel43.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel43.setText("jLabel43");

        jLabel44.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel44.setText("jLabel44");

        jLabel45.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel45.setText("jLabel45");

        jLabel46.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel46.setText("jLabel46");

        jLabel47.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel47.setText("jLabel47");

        jLabel48.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel48.setText("jLabel48");

        jButton11.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton11.setText("View");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton12.setText("View");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton13.setText("View");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton14.setText("View");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton15.setText("View");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton16.setText("View");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton17.setText("View");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton18.setText("View");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton19.setText("View");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton11)))
                                .addGap(143, 143, 143)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton12))))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jButton14)
                                .addGap(92, 92, 92)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton15))
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton13))
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton17)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(661, 661, 661)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton19))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton16))
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton18)))
                .addGap(36, 36, 36))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton16)))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(jButton13)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton11)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton12))
                                .addGap(60, 60, 60)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton17)
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton18))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jButton15)))
                        .addGap(341, 341, 341))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton14)
                        .addGap(363, 363, 363)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton19)))
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Mens Wear", jPanel5);

        jPanel10.setBackground(new java.awt.Color(0, 0, 102));

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Filter By:");

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Categories:");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Price:");

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Sort By:");

        jRadioButton16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton16.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton16.setText("Boys Clothing");

        jRadioButton17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton17.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton17.setText("Girls Clothing");

        jRadioButton18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton18.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton18.setText("<500");

        jRadioButton19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton19.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton19.setText(">500");

        jRadioButton20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton20.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton20.setText("Ratings");
        jRadioButton20.setActionCommand("");

        jRadioButton21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton21.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton21.setText("High to low Price");

        jRadioButton22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jRadioButton22.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton22.setText("Low to High Price");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton22)
                    .addComponent(jRadioButton21)
                    .addComponent(jRadioButton20)
                    .addComponent(jRadioButton19)
                    .addComponent(jRadioButton18)
                    .addComponent(jRadioButton17)
                    .addComponent(jRadioButton16)
                    .addComponent(jLabel49)
                    .addComponent(jLabel50)
                    .addComponent(jLabel51)
                    .addComponent(jLabel52))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel49)
                .addGap(33, 33, 33)
                .addComponent(jLabel50)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton16)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton17)
                .addGap(51, 51, 51)
                .addComponent(jLabel51)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton18)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton19)
                .addGap(68, 68, 68)
                .addComponent(jLabel52)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton20)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton21)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton22)
                .addContainerGap(1198, Short.MAX_VALUE))
        );

        jLabel62.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel62.setText("jLabel62");

        jLabel63.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel63.setText("jLabel63");

        jLabel64.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel64.setText("jLabel64");

        jLabel65.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel65.setText("jLabel65");

        jLabel66.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel66.setText("jLabel66");

        jLabel67.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel67.setText("jLabel67");

        jLabel68.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel68.setText("jLabel68");

        jLabel69.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel69.setText("jLabel69");

        jLabel70.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel70.setText("jLabel70");

        jButton21.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton21.setText("View");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton22.setText("View");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton23.setText("View");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton24.setText("View");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton25.setText("View");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton26.setText("View");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton27.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton27.setText("View");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton28.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton28.setText("View");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton29.setFont(new java.awt.Font("Stencil Std", 1, 18)); // NOI18N
        jButton29.setText("View");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton21))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton24))
                    .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton29)))
                        .addGap(133, 133, 133))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(158, 158, 158)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton23))
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                            .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton27))
                                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton25)
                                    .addComponent(jButton22))))
                        .addGap(97, 97, 97)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton26))
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton28)))
                        .addContainerGap(813, Short.MAX_VALUE))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton21)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton26))
                .addGap(49, 49, 49)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton24)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton25)
                            .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton27)
                            .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton28))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButton29)))
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Kids Wear", jPanel9);

        jLabel71.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel71.setText("Last Name:");

        jLabel72.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel72.setText("Email:");

        jLabel73.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel73.setText("First Name:");

        jLabel74.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel74.setText("Postal Code:");

        jLabel75.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel75.setText("Address:");

        jLabel76.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel76.setText("City:");

        jLabel77.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel77.setText("Phone Number:");

        jLabel78.setFont(new java.awt.Font("Stencil Std", 1, 24)); // NOI18N
        jLabel78.setText("Profile Photo");

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField2.setBorder(null);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField3.setBorder(null);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField4.setBorder(null);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField5.setBorder(null);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField6.setBorder(null);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jLabel79.setText("jLabel79");

        jButton30.setText("UPDATE");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jLabel80.setFont(new java.awt.Font("Stencil Std", 1, 36)); // NOI18N
        jLabel80.setText("My Profile");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(352, 352, 352)
                .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField2)
                                .addComponent(jTextField3)
                                .addComponent(jTextField1)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(158, 158, 158))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(340, 340, 340)
                                .addComponent(jLabel80))
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addGap(56, 56, 56)
                                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(433, 433, 433))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel77)
                                    .addGap(421, 421, 421))))
                        .addGap(123, 162, Short.MAX_VALUE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1511, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel80)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(153, 153, 153)
                        .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1014, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Profile", jPanel12);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1876, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
         ArrayList<ImageIcon> image = this.imageCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '60%'");
        ArrayList<String> name = this.nameCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '60%'");
        ArrayList<Integer> price = this.priceCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '60%'");
        //These are image label
        
        jLabel1.setIcon(image.get(0));
        jLabel2.setIcon(image.get(1));
        jLabel3.setIcon(image.get(2));
        jLabel4.setIcon(image.get(3));
        jLabel5.setIcon(image.get(4));
        jLabel6.setIcon(image.get(5));
        jLabel24.setIcon(image.get(6));
        jLabel26.setIcon(image.get(7));
      //  jLabel9.setIcon(image.get(8));
        //These are name label
        jLabel10.setText(name.get(0));
        jLabel11.setText(name.get(1));
        jLabel12.setText(name.get(2));
        jLabel13.setText(name.get(3));
        jLabel14.setText(name.get(4));
        jLabel15.setText(name.get(5));
        jLabel25.setText(name.get(6));
        jLabel81.setText(name.get(7));
      //  jLabel18.setText(name.get(8));
        int record;
        record = image.size();
        temporaryConnection(record, image, name);
        
         group.clearSelection();
        group1.clearSelection();
        group2.clearSelection();
        
         ArrayList<ImageIcon> image1 = this.imageCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '50%'");
        ArrayList<String> name1 = this.nameCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '50%'");
        ArrayList<Integer> price1 = this.priceCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '50%'");
        
        jLabel31.setIcon(image1.get(0));
        jLabel32.setIcon(image1.get(1));
        jLabel33.setIcon(image1.get(2));
        jLabel34.setIcon(image1.get(3));
        jLabel35.setIcon(image1.get(4));
        jLabel36.setIcon(image1.get(5));
        jLabel37.setIcon(image1.get(6));
        jLabel38.setIcon(image1.get(7));
     //   jLabel39.setIcon(image1.get(8));
        //These are name label
        jLabel40.setText(name1.get(0));
        jLabel41.setText(name1.get(1));
        jLabel42.setText(name1.get(2));
        jLabel43.setText(name1.get(3));
        jLabel44.setText(name1.get(4));
        jLabel45.setText(name1.get(5));
        jLabel46.setText(name1.get(6));
        jLabel47.setText(name1.get(7));
      //  jLabel48.setText(name1.get(8));
        int record1;
        record1 = image1.size();
        temporaryConnection1(record1, image1, name1);
        
        group3.clearSelection();
        group4.clearSelection();
        group5.clearSelection();
        
         ArrayList<ImageIcon> image2 = this.imageCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '70%'");
        ArrayList<String> name2 = this.nameCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '70%'");
        ArrayList<Integer> price2 = this.priceCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '70%'");
        jLabel53.setIcon(image2.get(0));
        jLabel54.setIcon(image2.get(1));
        jLabel55.setIcon(image2.get(2));
        jLabel56.setIcon(image2.get(3));
        jLabel57.setIcon(image2.get(4));
        jLabel58.setIcon(image2.get(5));
        jLabel59.setIcon(image2.get(6));
        jLabel60.setIcon(image2.get(7));
    //    jLabel61.setIcon(image2.get(8));
        //These are name label
        jLabel62.setText(name2.get(0));
        jLabel63.setText(name2.get(1));
        jLabel64.setText(name2.get(2));
        jLabel65.setText(name2.get(3));
        jLabel66.setText(name2.get(4));
        jLabel67.setText(name2.get(5));
        jLabel68.setText(name2.get(6));
        jLabel69.setText(name2.get(7));
    //    jLabel70.setText(name2.get(8));
        int record2;
        record2 = image2.size();
        temporaryConnection2(record2, image2, name2);
        
        group6.clearSelection();
        group7.clearSelection();
        group8.clearSelection();
        
        try {
             // TODO add your handling code here:
             cl.rs=cl.stmt.executeQuery("SELECT * FROM `sign_up` WHERE customer_id="+customer);
             if(cl.rs.next()){
                 jTextField1.setText(cl.rs.getString(1));
                 jTextField2.setText(cl.rs.getString(2));
                 jTextField3.setText(cl.rs.getString(8));
                 jTextArea1.setText(cl.rs.getString(9));
                 jTextField4.setText(cl.rs.getString(10));
                 jTextField5.setText(cl.rs.getInt(11)+"");
                 jTextField6.setText(cl.rs.getLong(12)+"");
                 jLabel79.setIcon(new ImageIcon(cl.rs.getBytes(13)));
               //  jTextField7.setText(cl.rs.getString(2)+"");
                  
             }
         } catch (SQLException ex) {
             Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }//GEN-LAST:event_jTabbedPane1MouseClicked
 
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
         try {
             // TODO add your handling code here:
             ViewCart vc = new ViewCart();
             vc.setVisible(true);
             this.setVisible(false);
         } catch (Throwable ex) {
             Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
         try {
             // TODO add your handling code here:
             UserScreen us2 = new UserScreen();
             us2.setVisible(true);
             this.setVisible(false);
         } catch (Throwable ex) {
             Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jTabbedPane1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseEntered

    }//GEN-LAST:event_jTabbedPane1MouseEntered

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
             id1=checkMatch(jLabel40);
            System.out.println(id1);
            
            os = new OrderSelection(); 
            os.setVisible(true); 
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
             id1=checkMatch(jLabel41);
            System.out.println(id1);
            
            os = new OrderSelection(); 
            os.setVisible(true); 
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
             id1=checkMatch(jLabel42);
            System.out.println(id1);
            
            os = new OrderSelection(); 
            os.setVisible(true); 
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
             id1=checkMatch(jLabel44);
            System.out.println(id1);
            
            os = new OrderSelection(); 
            os.setVisible(true); 
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
             id1=checkMatch(jLabel45);
            System.out.println(id1);
            
            os = new OrderSelection(); 
            os.setVisible(true); 
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
             id1=checkMatch(jLabel43);
            System.out.println(id1);
            
            os = new OrderSelection(); 
            os.setVisible(true); 
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
             id1=checkMatch(jLabel46);
            System.out.println(id1);
            
            os = new OrderSelection(); 
            os.setVisible(true); 
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
             id1=checkMatch(jLabel47);
            System.out.println(id1);
            
            os = new OrderSelection(); 
            os.setVisible(true); 
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
             id1=checkMatch(jLabel48);
            System.out.println(id1);
            
            os = new OrderSelection(); 
            os.setVisible(true); 
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
             id1=checkMatch(jLabel62);
            System.out.println(id1);
            
            os = new OrderSelection(); 
            os.setVisible(true); 
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
             id1=checkMatch(jLabel63);
            System.out.println(id1);
            
            os = new OrderSelection(); 
            os.setVisible(true); 
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
             id1=checkMatch(jLabel64);
            System.out.println(id1);
            
            os = new OrderSelection(); 
            os.setVisible(true); 
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
             id1=checkMatch(jLabel65);
            System.out.println(id1);
            
            os = new OrderSelection(); 
            os.setVisible(true); 
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
             id1=checkMatch(jLabel66);
            System.out.println(id1);
            
            os = new OrderSelection(); 
            os.setVisible(true); 
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
             id1=checkMatch(jLabel67);
            System.out.println(id1);
            
            os = new OrderSelection(); 
            os.setVisible(true); 
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
             id1=checkMatch(jLabel68);
            System.out.println(id1);
            
            os = new OrderSelection(); 
            os.setVisible(true); 
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
             id1=checkMatch(jLabel69);
            System.out.println(id1);
            
            os = new OrderSelection(); 
            os.setVisible(true); 
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
             id1=checkMatch(jLabel70);
            System.out.println(id1);
            
            os = new OrderSelection(); 
            os.setVisible(true); 
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
         try {
             // TODO add your handling code here:
           //  image.getText(cl.rs.getByte(13));
             cl.stmt.executeUpdate("UPDATE `sign_up` SET `first_name`='"+jTextField1.getText()+"',`last_name`='"+jTextField2.getText()+"',`email`='"+jTextField3.getText()+"',`address`='"+jTextArea1.getText()+"',`city`='"+jTextField4.getText()+"',`postal_code`="+Integer.parseInt(jTextField5.getText())+",`phone_number`="+Long.parseLong(jTextField6.getText())+"WHERE customer_id="+customer);
         } catch (SQLException ex) {
             Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
        // TODO add your handling code here:
        if (jRadioButton2.isSelected()) {
            jRadioButton1.setSelected(false);
        } else {
            jRadioButton1.setSelected(true);
        }
    }//GEN-LAST:event_jRadioButton2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            id1=checkMatch(jLabel10);
            System.out.println(id1);

            os = new OrderSelection();
            os.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            id1=checkMatch(jLabel11);
            System.out.println(id1);

            os = new OrderSelection();
            os.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            id1=checkMatch(jLabel12);
            System.out.println(id1);

            os = new OrderSelection();
            os.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            id1=checkMatch(jLabel15);
            System.out.println(id1);

            os = new OrderSelection();
            os.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            id1=checkMatch(jLabel18);
            System.out.println(id1);

            os = new OrderSelection();
            os.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            id1=checkMatch(jLabel14);
            System.out.println(id1);

            os = new OrderSelection();
            os.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            id1=checkMatch(jLabel13);
            System.out.println(id1);

            os = new OrderSelection();
            os.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            id1=checkMatch(jLabel17);
            System.out.println(id1);

            os = new OrderSelection();
            os.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            id1=checkMatch(jLabel16);
            System.out.println(id1);

            os = new OrderSelection();
            os.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            id1=checkMatch(jLabel81);
            System.out.println(id1);

            os = new OrderSelection();
            os.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            id1=checkMatch(jLabel25);
            System.out.println(id1);

            os = new OrderSelection();
            os.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            id1=checkMatch(jLabel14);
            System.out.println(id1);

            os = new OrderSelection();
            os.setVisible(true);
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Throwable ex) {
            Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton34ActionPerformed

    /**
     * @param args the command line arguments
     */
    ArrayList<ImageIcon> imageCollection(String query) {
        ArrayList<ImageIcon> image = new ArrayList<ImageIcon>(9);
        try {
            cl.rs = cl.stmt.executeQuery(query);
            while (cl.rs.next()) {
                image.add(new ImageIcon(cl.rs.getBytes(12)));
            }
            for(JLabel j : label) {               
                if(cl.rs.next()) {
                    byte [] img = cl.rs.getBytes(12);
                    ImageIcon images = new ImageIcon(img);
                    Image imgs = images.getImage();
                    Image imgss = imgs.getScaledInstance(j.getWidth(), j.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon newimg = new ImageIcon(imgss);
                    j.setIcon(newimg);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return image;
    }

    ArrayList<String> nameCollection(String query) {
        ArrayList<String> name = new ArrayList<String>(9);
        try {
            cl.rs = cl.stmt.executeQuery(query);
            while (cl.rs.next()) {
                name.add(cl.rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return name;
    }
    
    ArrayList<Integer> priceCollection(String query) {
        ArrayList<Integer> price = new ArrayList<Integer>(9);
        try {
            cl.rs = cl.stmt.executeQuery(query);
            while (cl.rs.next()) {

                price.add(cl.rs.getInt(1));
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
        return price;

    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerShopScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerShopScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerShopScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerShopScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CustomerShopScreen().setVisible(true);
                } catch (Throwable ex) {
                    Logger.getLogger(CustomerShopScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton15;
    private javax.swing.JRadioButton jRadioButton16;
    private javax.swing.JRadioButton jRadioButton17;
    private javax.swing.JRadioButton jRadioButton18;
    private javax.swing.JRadioButton jRadioButton19;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton20;
    private javax.swing.JRadioButton jRadioButton21;
    private javax.swing.JRadioButton jRadioButton22;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel pic;
    private javax.swing.JLabel pic1;
    // End of variables declaration//GEN-END:variables

   //for womens wear 
    void temporaryConnection(int record, ArrayList<ImageIcon> image, ArrayList<String> name) {

        int i = 0;
        setIcon(jLabel1, jLabel10, jButton1, record, i, image, name);
        i++;
        setIcon(jLabel2, jLabel11, jButton2, record, i, image, name);
        i++;
        setIcon(jLabel3, jLabel12, jButton3, record, i, image, name);
        i++;
        setIcon(jLabel4, jLabel13, jButton4, record, i, image, name);
        i++;
        setIcon(jLabel5, jLabel14, jButton5, record, i, image, name);
        i++;
        setIcon(jLabel6, jLabel15, jButton34, record, i, image, name);
        i++;
        setIcon(jLabel24, jLabel25, jButton33, record, i, image, name);
        i++;
        setIcon(jLabel26, jLabel81, jButton32, record, i, image, name);
        i++;
      //  setIcon(jLabel9, jLabel18, jButton9, record, i, image, name);
      //  i++;
    }
    //for mens wear
    void temporaryConnection1(int record, ArrayList<ImageIcon> image, ArrayList<String> name) {

        int i = 0;
        setIcon(jLabel31, jLabel40, jButton11, record, i, image, name);
        i++;
        setIcon(jLabel32, jLabel41, jButton12, record, i, image, name);
        i++;
        setIcon(jLabel33, jLabel42, jButton13, record, i, image, name);
        i++;
        setIcon(jLabel34, jLabel43, jButton14, record, i, image, name);
        i++;
        setIcon(jLabel35, jLabel44, jButton15, record, i, image, name);
        i++;
        setIcon(jLabel36, jLabel45, jButton16, record, i, image, name);
        i++;
        setIcon(jLabel37, jLabel46, jButton17, record, i, image, name);
        i++;
        setIcon(jLabel38, jLabel47, jButton18, record, i, image, name);
        i++;
        //setIcon(jLabel39, jLabel48, jButton19, record, i, image, name);
        //i++;
    }
    //for kids wear
    void temporaryConnection2(int record, ArrayList<ImageIcon> image, ArrayList<String> name) {

        int i = 0;
        setIcon(jLabel53, jLabel62, jButton21, record, i, image, name);
        i++;
        setIcon(jLabel54, jLabel63, jButton22, record, i, image, name);
        i++;
        setIcon(jLabel55, jLabel64, jButton23, record, i, image, name);
        i++;
        setIcon(jLabel56, jLabel65, jButton24, record, i, image, name);
        i++;
        setIcon(jLabel57, jLabel66, jButton25, record, i, image, name);
        i++;
        setIcon(jLabel58, jLabel67, jButton26, record, i, image, name);
        i++;
        setIcon(jLabel59, jLabel68, jButton27, record, i, image, name);
        i++;
        setIcon(jLabel60, jLabel69, jButton28, record, i, image, name);
        i++;
     //   setIcon(jLabel61, jLabel70, jButton29, record, i, image, name);
     //   i++;
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         //for womens wear
        int record = 0;
        if (jRadioButton1.isSelected()) {

            ArrayList<ImageIcon> image = this.imageCollection("SELECT * FROM `cloth` WHERE `sub_type`='Traditional Wear'");
            ArrayList<String> name = this.nameCollection("SELECT * FROM `cloth` WHERE `sub_type`='Traditional Wear'");
           // ArrayList<Integer> price = this.priceCollection("SELECT price FROM `cloth` WHERE `sub_type`='Traditional Wear'");
            //In the case of Traditional and Price Range both selected
            if (jRadioButton3.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Traditional Wear'");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`<1000 AND `sub_type`='Traditional Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Traditional Wear'");
            }
            if (jRadioButton4.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Traditional Wear'");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`>=1000 AND `sub_type`='Traditional Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Traditional Wear'");
            }
            if (jRadioButton5.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE sub_type='Traditional Wear' ORDER BY rating");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE sub_type='Traditional Wear' ORDER BY rating");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE sub_type='Traditional Wear' ORDER BY rating");
            }

            record = image.size();
            temporaryConnection(record, image, name);
        }

        if (jRadioButton2.isSelected()) {
            ArrayList<ImageIcon> image = this.imageCollection("SELECT * FROM `cloth` WHERE `sub_type`='Western Wear'");
           // ArrayList<Integer> price = this.priceCollection("SELECT price FROM `cloth` WHERE `sub_type`='Western Wear'");
            ArrayList<String> name = this.nameCollection("SELECT * FROM `cloth` WHERE `sub_type`='Western Wear'");
            if (jRadioButton3.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Western Wear'");
           //     price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`<1000 AND `sub_type`='Western Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Western Wear'");
            }
            if (jRadioButton4.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Western Wear'");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`>=1000 AND `sub_type`='Western Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Western Wear'");
            }
            if (jRadioButton5.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE sub_type='Western Wear' ORDER BY rating");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE sub_type='Western Wear' ORDER BY rating");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE sub_type='Western Wear' ORDER BY rating");
            }

            record = image.size();
            temporaryConnection(record, image, name);
        }
        if (jRadioButton3.isSelected()) {

            ArrayList<ImageIcon> image = this.imageCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '60%' AND `price`<500");
         //   ArrayList<Integer> price = this.priceCollection("SELECT price FROM `cloth` WHERE `product_id` LIKE '60%' AND `price`<1000");
            ArrayList<String> name = this.nameCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '60%' AND `price`<500");
            if (jRadioButton1.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Traditional Wear'");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`<1000 AND `sub_type`='Traditional Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Traditional Wear'");
            }
            if (jRadioButton2.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Western Wear'");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`<1000 AND `sub_type`='Western Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Western Wear'");
            }

            record = image.size();
            temporaryConnection(record, image, name);

        }
        if (jRadioButton4.isSelected()) {

            ArrayList<ImageIcon> image = this.imageCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '60%' AND `price`>500");
          //  ArrayList<Integer> price = this.priceCollection("SELECT price FROM `cloth` WHERE `product_id` LIKE '60%' AND `price`>=1000");
            ArrayList<String> name = this.nameCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '60%' AND `price`>500");
            if (jRadioButton1.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Traditional Wear'");
           //     price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`>=1000 AND `sub_type`='Traditional Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Traditional Wear'");
            }
            if (jRadioButton2.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Western Wear'");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`>=1000 AND `sub_type`='Western Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Western Wear'");
            }
            record = image.size();
            temporaryConnection(record, image, name);
        }
        if (jRadioButton5.isSelected()) {
            group1.clearSelection();
            ArrayList<ImageIcon> image = this.imageCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '60%' ORDER BY `rating` DESC");
          //  ArrayList<Integer> price = this.priceCollection("SELECT price FROM `cloth` WHERE `product_id` LIKE '60%' ORDER BY `rating` DESC");
            ArrayList<String> name = this.nameCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '60%' ORDER BY `rating` DESC");
            if (jRadioButton1.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE sub_type='Traditional Wear' ORDER BY rating");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE sub_type='Traditional Wear' ORDER BY rating");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE sub_type='Traditional Wear' ORDER BY rating");
            }
            if (jRadioButton2.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE sub_type='Western Wear' ORDER BY rating");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE sub_type='Western Wear' ORDER BY rating");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE sub_type='Western Wear' ORDER BY rating");
            }
            record = image.size();
            temporaryConnection(record, image, name);
        }
        if (jRadioButton6.isSelected()) {
            group.clearSelection();
            group1.clearSelection();
            ArrayList<ImageIcon> image = this.imageCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '60%' ORDER BY `price` DESC");
        //    ArrayList<Integer> price = this.priceCollection("SELECT price FROM `cloth` WHERE `product_id` LIKE '60%' ORDER BY `price` DESC");
            ArrayList<String> name = this.nameCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '60%' ORDER BY `price` DESC");
            record = image.size();
            System.out.println(record);
            temporaryConnection(record, image, name);
        }
        if (jRadioButton7.isSelected()) {
            group.clearSelection();
            group1.clearSelection();
            ArrayList<ImageIcon> image = this.imageCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '60%' ORDER BY `price`");
        //    ArrayList<Integer> price = this.priceCollection("SELECT price FROM `cloth` WHERE `product_id` LIKE '60%' ORDER BY `price` ");
            ArrayList<String> name = this.nameCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '60%' ORDER BY `price`");
            record = image.size();
            temporaryConnection(record, image, name);
        }
        
        //for mens wear
        int record1 = 0;
        if (jRadioButton8.isSelected()) {

            ArrayList<ImageIcon> image = this.imageCollection("SELECT * FROM `cloth` WHERE `sub_type`='Formal Wear'");
            ArrayList<String> name = this.nameCollection("SELECT * FROM `cloth` WHERE `sub_type`='Formal Wear'");
           // ArrayList<Integer> price = this.priceCollection("SELECT price FROM `cloth` WHERE `sub_type`='Traditional Wear'");
            //In the case of Traditional and Price Range both selected
            if (jRadioButton11.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Formal Wear'");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`<1000 AND `sub_type`='Traditional Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Formal Wear'");
            }
            if (jRadioButton12.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Formal Wear'");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`>=1000 AND `sub_type`='Traditional Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Formal Wear'");
            }
            if (jRadioButton13.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE sub_type='Formal Wear' ORDER BY rating");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE sub_type='Traditional Wear' ORDER BY rating");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE sub_type='Formal Wear' ORDER BY rating");
            }

            record1 = image.size();
            temporaryConnection1(record1, image, name);
        }

        
        if (jRadioButton9.isSelected()) {
            ArrayList<ImageIcon> image = this.imageCollection("SELECT * FROM `cloth` WHERE `sub_type`='Casual Wear'");
           // ArrayList<Integer> price = this.priceCollection("SELECT price FROM `cloth` WHERE `sub_type`='Western Wear'");
            ArrayList<String> name = this.nameCollection("SELECT * FROM `cloth` WHERE `sub_type`='Casual Wear'");
            if (jRadioButton11.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Casual Wear'");
           //     price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`<1000 AND `sub_type`='Western Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Casual Wear'");
            }
            if (jRadioButton12.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Casual Wear'");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`>=1000 AND `sub_type`='Western Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Casual Wear'");
            }
            if (jRadioButton13.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE sub_type='Casual Wear' ORDER BY rating");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE sub_type='Western Wear' ORDER BY rating");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE sub_type='Casual Wear' ORDER BY rating");
            }

            record1 = image.size();
            temporaryConnection1(record1, image, name);
        }
        
        if (jRadioButton10.isSelected()) {
            ArrayList<ImageIcon> image = this.imageCollection("SELECT * FROM `cloth` WHERE `sub_type`='Festive Wear'");
           // ArrayList<Integer> price = this.priceCollection("SELECT price FROM `cloth` WHERE `sub_type`='Western Wear'");
            ArrayList<String> name = this.nameCollection("SELECT * FROM `cloth` WHERE `sub_type`='Festive Wear'");
            if (jRadioButton11.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Festive Wear'");
           //     price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`<1000 AND `sub_type`='Western Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Festive Wear'");
            }
            if (jRadioButton12.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Festive Wear'");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`>=1000 AND `sub_type`='Western Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Festive Wear'");
            }
            if (jRadioButton13.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE sub_type='Festive Wear' ORDER BY rating");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE sub_type='Western Wear' ORDER BY rating");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE sub_type='Festive Wear' ORDER BY rating");
            }

            record1 = image.size();
            temporaryConnection1(record1, image, name);
        }
        
        if (jRadioButton11.isSelected()) {

            ArrayList<ImageIcon> image = this.imageCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '50%' AND `price`<500");
         //   ArrayList<Integer> price = this.priceCollection("SELECT price FROM `cloth` WHERE `product_id` LIKE '60%' AND `price`<1000");
            ArrayList<String> name = this.nameCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '50%' AND `price`<500");
            if (jRadioButton8.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Formal Wear'");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`<1000 AND `sub_type`='Traditional Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Formal Wear'");
            }
            if (jRadioButton9.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Casual Wear'");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`<1000 AND `sub_type`='Western Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Casual Wear'");
            }
            if (jRadioButton10.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Festive Wear'");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`<1000 AND `sub_type`='Western Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Festive Wear'");
            }

            record1 = image.size();
            temporaryConnection1(record1, image, name);

        }
        if (jRadioButton12.isSelected()) {

            ArrayList<ImageIcon> image = this.imageCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '50%' AND `price`>500");
          //  ArrayList<Integer> price = this.priceCollection("SELECT price FROM `cloth` WHERE `product_id` LIKE '60%' AND `price`>=1000");
            ArrayList<String> name = this.nameCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '50%' AND `price`>500");
            if (jRadioButton8.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Formal Wear'");
           //     price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`>=1000 AND `sub_type`='Traditional Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Formal Wear'");
            }
            if (jRadioButton9.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Casual Wear'");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`>=1000 AND `sub_type`='Western Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Casual Wear'");
            }
             if (jRadioButton10.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Festive Wear'");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`>=1000 AND `sub_type`='Western Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Festive Wear'");
            }
            record1 = image.size();
            temporaryConnection1(record1, image, name);
        }
        if (jRadioButton13.isSelected()) {
            group1.clearSelection();
            ArrayList<ImageIcon> image = this.imageCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '50%' ORDER BY `rating` DESC");
          //  ArrayList<Integer> price = this.priceCollection("SELECT price FROM `cloth` WHERE `product_id` LIKE '60%' ORDER BY `rating` DESC");
            ArrayList<String> name = this.nameCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '50%' ORDER BY `rating` DESC");
            if (jRadioButton8.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE sub_type='Formal Wear' ORDER BY rating");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE sub_type='Traditional Wear' ORDER BY rating");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE sub_type='Formal Wear' ORDER BY rating");
            }
            if (jRadioButton9.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE sub_type='Casual Wear' ORDER BY rating");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE sub_type='Western Wear' ORDER BY rating");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE sub_type='Casual Wear' ORDER BY rating");
            }
            if (jRadioButton10.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE sub_type='Festive Wear' ORDER BY rating");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE sub_type='Western Wear' ORDER BY rating");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE sub_type='Festive Wear' ORDER BY rating");
            }
            record1 = image.size();
            temporaryConnection1(record1, image, name);
        }
        if (jRadioButton14.isSelected()) {
            group3.clearSelection();
            group4.clearSelection();
            
            ArrayList<ImageIcon> image = this.imageCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '50%' ORDER BY `price` DESC");
        //    ArrayList<Integer> price = this.priceCollection("SELECT price FROM `cloth` WHERE `product_id` LIKE '60%' ORDER BY `price` DESC");
            ArrayList<String> name = this.nameCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '50%' ORDER BY `price` DESC");
            record1 = image.size();
            System.out.println(record1);
            temporaryConnection(record1, image, name);
        }
        if (jRadioButton15.isSelected()) {
            group3.clearSelection();
            group4.clearSelection();
            
            ArrayList<ImageIcon> image = this.imageCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '50%' ORDER BY `price`");
        //    ArrayList<Integer> price = this.priceCollection("SELECT price FROM `cloth` WHERE `product_id` LIKE '60%' ORDER BY `price` ");
            ArrayList<String> name = this.nameCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '50%' ORDER BY `price`");
            record1 = image.size();
            temporaryConnection1(record1, image, name);
        }
        
        //for kids wear
        int record2 = 0;
        if (jRadioButton16.isSelected()) {

            ArrayList<ImageIcon> image = this.imageCollection("SELECT * FROM `cloth` WHERE `sub_type`='Boys Clothing'");
            ArrayList<String> name = this.nameCollection("SELECT * FROM `cloth` WHERE `sub_type`='Boys Clothing'");
           // ArrayList<Integer> price = this.priceCollection("SELECT price FROM `cloth` WHERE `sub_type`='Traditional Wear'");
            //In the case of Traditional and Price Range both selected
            if (jRadioButton18.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Boys Clothing'");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`<1000 AND `sub_type`='Traditional Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Boys Clothing'");
            }
            if (jRadioButton19.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Boys Clothing'");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`>=1000 AND `sub_type`='Traditional Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Boys Clothing'");
            }
            if (jRadioButton20.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE sub_type='Boys Clothing' ORDER BY rating");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE sub_type='Traditional Wear' ORDER BY rating");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE sub_type='Boys Clothing' ORDER BY rating");
            }

            record2 = image.size();
            temporaryConnection2(record2, image, name);
        }

        if (jRadioButton17.isSelected()) {
            ArrayList<ImageIcon> image = this.imageCollection("SELECT * FROM `cloth` WHERE `sub_type`='Girls Clothing'");
           // ArrayList<Integer> price = this.priceCollection("SELECT price FROM `cloth` WHERE `sub_type`='Western Wear'");
            ArrayList<String> name = this.nameCollection("SELECT * FROM `cloth` WHERE `sub_type`='Girls Clothing'");
            if (jRadioButton18.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Girls Clothing'");
           //     price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`<1000 AND `sub_type`='Western Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Girls Clothing'");
            }
            if (jRadioButton19.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Girls Clothing'");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`>=1000 AND `sub_type`='Western Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Girls Clothing'");
            }
            if (jRadioButton20.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE sub_type='Girls Clothing' ORDER BY rating");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE sub_type='Western Wear' ORDER BY rating");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE sub_type='Girls Clothing' ORDER BY rating");
            }

            record2 = image.size();
            temporaryConnection2(record2, image, name);
        }
        if (jRadioButton18.isSelected()) {

            ArrayList<ImageIcon> image = this.imageCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '70%' AND `price`<500");
         //   ArrayList<Integer> price = this.priceCollection("SELECT price FROM `cloth` WHERE `product_id` LIKE '60%' AND `price`<1000");
            ArrayList<String> name = this.nameCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '70%' AND `price`<500");
            if (jRadioButton16.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Boys Clothing'");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`<1000 AND `sub_type`='Traditional Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Boys Clothing'");
            }
            if (jRadioButton17.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Girls Clothing'");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`<1000 AND `sub_type`='Western Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`<500 AND `sub_type`='Girls Clothing'");
            }

            record2 = image.size();
            temporaryConnection2(record2, image, name);

        }
        if (jRadioButton19.isSelected()) {

            ArrayList<ImageIcon> image = this.imageCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '70%' AND `price`>500");
          //  ArrayList<Integer> price = this.priceCollection("SELECT price FROM `cloth` WHERE `product_id` LIKE '60%' AND `price`>=1000");
            ArrayList<String> name = this.nameCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '70%' AND `price`>500");
            if (jRadioButton16.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Boys Clothing'");
           //     price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`>=1000 AND `sub_type`='Traditional Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Boys Clothing'");
            }
            if (jRadioButton17.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Girls Clothing'");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE `price`>=1000 AND `sub_type`='Western Wear'");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE `price`>500 AND `sub_type`='Girls Clothing'");
            }
            record2 = image.size();
            temporaryConnection2(record2, image, name);
        }
        if (jRadioButton20.isSelected()) {
            group1.clearSelection();
            ArrayList<ImageIcon> image = this.imageCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '70%' ORDER BY `rating` DESC");
          //  ArrayList<Integer> price = this.priceCollection("SELECT price FROM `cloth` WHERE `product_id` LIKE '60%' ORDER BY `rating` DESC");
            ArrayList<String> name = this.nameCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '70%' ORDER BY `rating` DESC");
            if (jRadioButton16.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE sub_type='Boys Clothing' ORDER BY rating");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE sub_type='Traditional Wear' ORDER BY rating");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE sub_type='Boys Clothing' ORDER BY rating");
            }
            if (jRadioButton17.isSelected()) {
                image = this.imageCollection("SELECT * FROM `cloth` WHERE sub_type='Girls Clothing' ORDER BY rating");
            //    price = this.priceCollection("SELECT price FROM `cloth` WHERE sub_type='Western Wear' ORDER BY rating");
                name = this.nameCollection("SELECT * FROM `cloth` WHERE sub_type='Girls Clothing' ORDER BY rating");
            }
            record2 = image.size();
            temporaryConnection2(record2, image, name);
        }
        if (jRadioButton21.isSelected()) {
            group6.clearSelection();
            group7.clearSelection();
            ArrayList<ImageIcon> image = this.imageCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '70%' ORDER BY `price` DESC");
        //    ArrayList<Integer> price = this.priceCollection("SELECT price FROM `cloth` WHERE `product_id` LIKE '60%' ORDER BY `price` DESC");
            ArrayList<String> name = this.nameCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '70%' ORDER BY `price` DESC");
            record2 = image.size();
            System.out.println(record2);
            temporaryConnection2(record2, image, name);
        }
        if (jRadioButton22.isSelected()) {
            group6.clearSelection();
            group7.clearSelection();
            ArrayList<ImageIcon> image = this.imageCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '70%' ORDER BY `price`");
        //    ArrayList<Integer> price = this.priceCollection("SELECT price FROM `cloth` WHERE `product_id` LIKE '60%' ORDER BY `price` ");
            ArrayList<String> name = this.nameCollection("SELECT * FROM `cloth` WHERE `product_id` LIKE '70%' ORDER BY `price`");
            record2 = image.size();
            temporaryConnection2(record2, image, name);
        }
        
    }
    
     public void setIcon(JLabel label, JLabel textlabel, JButton button, int records, int i, ArrayList<ImageIcon> image, ArrayList<String> name) {
        ImageIcon common = new ImageIcon("C:\\Users\\DIPIKA PAWAR\\Pictures\\Saved Pictures\\commonPic.jpg");
        if (i < records) {
            button.setVisible(true);
            label.setVisible(true);
           // pricelabel.setVisible(true);
            textlabel.setVisible(true);
          //  pricelabel.setText(price.get(i) + "");
            label.setIcon(image.get(i));
            textlabel.setText(name.get(i));
        } else {
            button.setVisible(false);
            label.setVisible(false);
          //  pricelabel.setVisible(false);
            textlabel.setVisible(false);

        }

    }
}
