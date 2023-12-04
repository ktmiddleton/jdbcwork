package formato.middleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDAO extends AbstractDAO<Event> {
    @Override
    public void create(Event entity) throws SQLException {
        String sql="INSERT INTO event(event_name,prize_pool) VALUES(?,?)";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setString(1, entity.getName());
        pst.setString(2, entity.getPrizePool());
        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if(rs.next()){
            entity.setId(rs.getInt(1));
        }
        con.close();
    }

    @Override
    public Event read(String eventName) throws SQLException {
        String sql = "SELECT * FROM client WHERE event_name = ?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, eventName);
        ResultSet rs = pst.executeQuery();
        Event c = null;
        if(rs.next()){
            c = new Event();
            c.setId( rs.getInt("event_id") );
            c.setName( rs.getString("event_name") );
            c.setPrizePool(rs.getString("prize_pool"));
        }
        con.close();
        return c;
    }

    @Override
    public void update(int id, String eventName, String prizePool) throws SQLException {
        String sql = "UPDATE event SET event_name = ?, prize_pool = ? WHERE event_id = ?";
        Connection con  = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, eventName);
        pst.setString(2, prizePool);
        pst.setInt(3, id);
        pst.executeUpdate();
        con.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM event WHERE event_id = ?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        pst.executeUpdate();
        con.close();
    }
}
