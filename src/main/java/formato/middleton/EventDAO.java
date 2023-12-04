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
        pst.setInt(2, entity.getPrizePool());
        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if(rs.next()){
            entity.setId(rs.getInt(1));
        }
        con.close();
    }

    public Event read(int id) throws SQLException {
        String sql = "SELECT * FROM client WHERE event_id = ?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,id);
        ResultSet rs = pst.executeQuery();
        Event c = null;
        if(rs.next()){
            c = new Event();
            c.setId( rs.getInt("event_id") );
            c.setName( rs.getString("event_name") );
            c.setPrizePool(rs.getInt("prize_pool"));
        }
        con.close();
        return c;
    }

    public void update(Event entity) throws SQLException {
        String sql = "UPDATE event SET event_name = ?, prize_pool = ? WHERE event_id = ?";
        Connection con  = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, entity.getName());
        pst.setInt(2, entity.getPrizePool());
        pst.executeUpdate();
        con.close();
    }

    public void delete(Event entity) throws SQLException {
        String sql = "DELETE FROM event WHERE event_id = ?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, entity.getId());
        pst.executeUpdate();
        con.close();
    }

    public List<Event> list() throws SQLException {
        ArrayList<Event> lstEvent = new ArrayList<>();
        Connection con = getConnection();
        String sql = "SELECT * FROM event ORDER BY event_name";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Event c = new Event();
            c.setId( rs.getInt("event_id") );
            c.setName( rs.getString("event_name"));
            lstEvent.add(c);
        }
        con.close();
        return lstEvent;
    }
}