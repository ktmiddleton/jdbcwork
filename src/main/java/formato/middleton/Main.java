package formato.middleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) 
    {
        String ConUrl = "jdbc:mysql://localhost";
        String Port = "3306";
        String Database = "project_db";
        String Username = "root";
        String Password = "pjhenrymabel403";

        try{
            String url = ConUrl+":"+Port+"/"+Database+"?user="+Username
                    +"&password="+Password;
            Connection con = DriverManager.getConnection(url);
            String sql = "INSERT INTO event(event_name,prize_pool) VALUES(?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,"Champions");
            pst.setInt(2,10000);
            int rows = pst.executeUpdate();

            con.close();
        } catch(Exception ex){
            System.out.println(ex);
        }
    }
}