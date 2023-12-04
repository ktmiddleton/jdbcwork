package formato.middleton;

public class Event extends AbstractEntity {
    private int id;
    private String name;
    private String prizePool;

    public Event() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrizePool() {
        return prizePool;
    }

    public void setPrizePool(String prizePool) {
        this.prizePool = prizePool;
    }

    @Override
    public String toString() {
        return Integer.toString(id) + " | " + name + ": " + prizePool;
    }
}

