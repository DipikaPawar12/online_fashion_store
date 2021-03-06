/*
 * Admin can UPDATE or DELETE a product based on the product id.
 */
package projectshopping;

import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public final class UpdateStockPanel extends javax.swing.JPanel {

    /**
     * Creates new form UpdateStockPanel
     */
    String username = "root";
    String password = "";
    String driverName = "com.mysql.jdbc.Driver";
    String dbName = "fashion_store_db";
    String dbURL = "jdbc:mysql://localhost:3306/" + dbName;
    ResultSet rs;
    Connection conn;
    Statement stmt;
   // private Object jComboxBox1;
    public UpdateStockPanel() throws SQLException {
        
        initComponents();
        this.setSize(1920,1080);
        
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(dbURL, username, password);
            stmt = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Exception e = " + e);
        }
        ArrayList<Integer> productId =this.getAllProductIds();
        //add customerLogic ids in JComboBox
        for (int i :productId) {
           jComboBox1.addItem(String.valueOf(i));
            
        }
       
    }
    ArrayList<Integer> getAllProductIds() throws SQLException {
        ArrayList<Integer> productIds = new ArrayList<>();
       
        int i = 0;
        String selectQuery = "SELECT product_id from cloth";
        rs=stmt.executeQuery(selectQuery);
        try {
            
            while (rs.next()) {
                productIds.add(rs.getInt(1));
            }
           // System.out.println("No. of product Ids = " + customerIds.size());
        } catch (Exception e) {
            System.out.println("e = " + e);
            e.printStackTrace();
        }
         // TODO add your handling code here:
         
        return productIds;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Stencil Std", 1, 36)); // NOI18N
        jLabel1.setText("Product ID:");
        add(jLabel1);
        jLabel1.setBounds(40, 200, 249, 50);

        jLabel2.setFont(new java.awt.Font("Stencil Std", 1, 36)); // NOI18N
        jLabel2.setText("Product name:");
        add(jLabel2);
        jLabel2.setBounds(40, 290, 313, 50);

        jLabel3.setFont(new java.awt.Font("Stencil Std", 1, 36)); // NOI18N
        jLabel3.setText("Price:");
        add(jLabel3);
        jLabel3.setBounds(40, 380, 180, 50);

        jLabel4.setFont(new java.awt.Font("Stencil Std", 1, 36)); // NOI18N
        jLabel4.setText("Stock:");
        add(jLabel4);
        jLabel4.setBounds(40, 470, 140, 60);

        jLabel5.setFont(new java.awt.Font("Stencil Std", 1, 36)); // NOI18N
        jLabel5.setText("Colour:");
        add(jLabel5);
        jLabel5.setBounds(40, 550, 190, 60);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update button.jpg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(70, 660, 233, 110);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete button.jpg"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(390, 660, 233, 109);

        jComboBox1.setFont(new java.awt.Font("Stencil Std", 1, 36)); // NOI18N
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1);
        jComboBox1.setBounds(410, 210, 142, 50);

        jTextField1.setFont(new java.awt.Font("Stencil Std", 1, 36)); // NOI18N
        add(jTextField1);
        jTextField1.setBounds(410, 290, 272, 60);

        jTextField2.setFont(new java.awt.Font("Stencil Std", 1, 36)); // NOI18N
        add(jTextField2);
        jTextField2.setBounds(410, 380, 150, 60);

        jTextField3.setFont(new java.awt.Font("Stencil Std", 1, 36)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        add(jTextField3);
        jTextField3.setBounds(410, 470, 142, 60);

        jTextField4.setFont(new java.awt.Font("Stencil Std", 1, 36)); // NOI18N
        add(jTextField4);
        jTextField4.setBounds(410, 550, 199, 60);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete product panel.PNG"))); // NOI18N
        add(jLabel6);
        jLabel6.setBounds(30, 40, 1065, 80);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectshopping/cart.jpg"))); // NOI18N
        add(jLabel7);
        jLabel7.setBounds(0, 0, 1930, 950);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         try {
            int result=0;
            int id = Integer.parseInt((String) jComboBox1.getSelectedItem());
            
          
            String updateQuery ="DELETE FROM `cloth` WHERE `product_id`="+id;
           
           result= stmt.executeUpdate(updateQuery);
     
        
            if (result == 1) {
                //JOptionPane.showMessageDialog (null, "Message", "Title", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null, "Customer deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
              
               
            } else {
                JOptionPane.showMessageDialog(null, "Error occured in deleting Customer", "Failure", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException | SQLException | HeadlessException e1) {
            e1.printStackTrace();
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            int result=0;
            int id = Integer.parseInt((String) jComboBox1.getSelectedItem());
            String productName = jTextField1.getText();
            int price =Integer.parseInt(jTextField2.getText());
            int stock=Integer.parseInt(jTextField3.getText());
            String colour=jTextField4.getText();
          
            String updateQuery ="UPDATE `cloth` SET `product_name`='"+productName+"',`price`="+price+",`stock`="+stock+",`colour`='"+colour+"' WHERE product_id="+id;
           
           result= stmt.executeUpdate(updateQuery);
     
        
            if (result == 1) {
                //JOptionPane.showMessageDialog (null, "Message", "Title", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null, "Customer updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
              
                jTextField1.setText(productName);
                jTextField2.setText(price+"");
                jTextField3.setText(stock+"");
                jTextField4.setText(colour);

            } else {
                JOptionPane.showMessageDialog(null, "Error occured in updating Customer", "Failure", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException | SQLException | HeadlessException e1) {
            e1.printStackTrace();
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
         int id = Integer.parseInt((String)jComboBox1.getSelectedItem());
        try {
            // stmt.executeQuery("");
            rs= stmt.executeQuery("SELECT * FROM `cloth` WHERE 1");
        } catch (SQLException ex) {
            Logger.getLogger(UpdateStockPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()) {
                if(id==rs.getInt(1)){
                    
                    jTextField1.setText(rs.getString(2));
                    jTextField2.setText(rs.getString(3));
                    jTextField3.setText(rs.getString(4));
                    jTextField4.setText(rs.getString(8));
                }  
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateStockPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
