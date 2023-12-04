package formato.middleton;

import formato.middleton.Event;
import formato.middleton.EventDAO;

public class ClientService {
    public void create(String event_name, String prize_pool) throws Exception
    {

        EventDAO dao = new EventDAO();
        dao.create(event_name, prize_pool);
    }

    public Event read(int id) throws Exception
    {
        EventDAO dao = new EventDAO();
        return dao.read(id);
    }

    public void update(int id, String event_name, String prize_pool) throws Exception
    {
        EventDAO dao = new EventDAO();
        dao.update(id, event_name, prize_pool);
    }

    public void delete(int id) throws Exception
    {
        EventDAO dao = new EventDAO();
        dao.delete(id);
    }
}
