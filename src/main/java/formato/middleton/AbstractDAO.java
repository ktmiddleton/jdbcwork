package formato.middleton;

import java.sql.*;
import java.util.List;

public abstract class AbstractDAO<E extends AbstractEntity> {
    protected String ConUrl = "jdbc:mysql://localhost";
    protected String Port = "3306";
    protected String Database = "project_db";
    protected String Username = "root";
    protected String Password = "pjhenrymabel403";

    public Connection getConnection() throws SQLException{
        String url = ConUrl+":"+Port+"/"+Database+"?user="+Username
                +"&password="+Password;
        Connection con = DriverManager.getConnection(url);
        return con;
    }

    public void setTestDatabase(){
        this.Database = "project_db_test";
    }

    public abstract void create(String eventName, String prizePool) throws SQLException;
    public abstract E read(String eventName) throws SQLException;
    public abstract void update(int id, String eventName, String prizePool) throws SQLException;
    public abstract void delete(int id) throws SQLException;
}
