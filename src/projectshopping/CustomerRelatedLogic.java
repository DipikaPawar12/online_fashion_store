/*
 * This is a common file for making connection to the database MySQL
 */
package projectshopping;

import java.sql.*;

public class CustomerRelatedLogic {
     String username = "root";
    String password = "";
    String driverName = "com.mysql.jdbc.Driver";
    String dbName = "fashion_store_db";
    String dbURL = "jdbc:mysql://localhost:3306/" + dbName;
    ResultSet rs;
    Connection conn;
    Statement stmt;
        
    public CustomerRelatedLogic() throws Throwable{
         try {
            Class.forName(driverName);
            //OBTAIN DATABASE CONNECTION
            conn = DriverManager.getConnection(dbURL, username, password);
            stmt = conn.createStatement();
        } catch (Exception e) {
            System.out.println("Exception e = " + e);
        }
     
    
    }
     protected void finalize() {
        try {
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("Exception e = " + e);
        } 
    }
    public boolean updateProfile(int id,String first_name,String last_name,String password,String email,String address,String city,int postal_code,long phone_number,byte[] photo) throws SQLException{
        boolean flag=false;
        try{
        rs=stmt.executeQuery("SELECT `customer_id` FROM `sign_up` WHERE 1");
        while(rs.next()){
            if(id==rs.getInt(1)){
                stmt.executeUpdate("UPDATE `sign_up` SET `first_name`='"+first_name+"',`last_name`='"+last_name+"',`password`='"+password+"',`email`='"+email+"',`address`='"+address+"',`city`='"+city+"',`postal_code`="+postal_code+",`phone_number`="+phone_number+",`profile_photo`="+photo+" WHERE 1");
                flag=true;
            }
        }
        }catch(Exception e){
            
        }
        return flag;
    }
    
    
}
