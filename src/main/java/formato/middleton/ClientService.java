package main.java.formato.middleton;

import formato.middleton.Event;
import formato.middleton.EventDAO;

public class ClientService {
    public void create(String event_name, String prize_pool) throws Exception
    {
        Event e = new Event();
        e.setName(event_name);
        e.setPrizePool(prize_pool);

        EventDAO dao = new EventDAO();
        dao.create(e);
    }

    public Event read(int id) throws Exception
    {
        EventDAO dao = new EventDAO();
        return dao.read(id);
    }

    public void update(String event_name, String prize_pool, String id) throws Exception
    {
        EventDAO dao = new EventDAO();
        dao.update(event_name, prize_pool, id);
    }

    public void delete(String id) throws Exception
    {
        EventDAO dao = new EventDAO();
        dao.delete(id);
    }
}
