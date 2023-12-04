package formato.middleton;

import java.sql.*;
import java.util.List;

public abstract class AbstractDAO<E extends AbstractEntity> {
    protected String ConUrl = "jdbc:mysql://localhost";
    protected String Port = "3306";
    protected String Database = "project_db";
    protected String Username = "root";
    protected String Password = "mypassword";

    public Connection getConnection() throws SQLException{
        String url = ConUrl+":"+Port+"/"+Database+"?user="+Username
                +"&password="+Password;
        Connection con = DriverManager.getConnection(url);
        return con;
    }

    public void setTestDatabase(){
        this.Database = "project_db_test";
    }

    public abstract void create(E entity) throws SQLException;
    public abstract E read(String eventName) throws SQLException;
    public abstract void update(E entity) throws SQLException;
    public abstract void delete(E entity) throws SQLException;
}
