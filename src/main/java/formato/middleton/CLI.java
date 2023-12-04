package formato.middleton;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name= "CLI", subcommands = {create.class, read.class, update.class, delete.class})
public class CLI 
{}

@Command(name="create", description= "Create a record on the database")
class create implements Runnable 
{
    @Parameters(paramLabel = "<name>", 
               description = "The name of the event.")
    private String event_name;

    @Parameters(paramLabel = "<prize_pool_amount>", 
               description = "Amount of money in prize pool for the event")
    private String prize_pool;

    @Override
    public void run() 
    {
        ClientService client = new ClientService();
        try 
        {
            client.create(event_name, prize_pool);
        }catch(Exception e) {
            System.out.println(e);
        }
    }
}

@Command(name="read", description= "Read a record on the database")
class read implements Runnable 
{
    @Parameters(paramLabel = "<id number for record>", 
               description = "Used to differentiate records in the database.")
    private int id;

    @Override
    public void run() 
    {
        ClientService client = new ClientService();
        try 
        {
            client.read(id);
        }catch(Exception e) {
            System.out.println(e);
        }
    }
}

@Command(name="update", description= "Update a record on the database")
class update implements Runnable 
{
    @Parameters(paramLabel = "<name>", 
               description = "The name of the event.")
    private String event_name;

    @Parameters(paramLabel = "<prize_pool_amount>", 
               description = "Amount of money in prize pool for the event")
    private String prize_pool;

    @Parameters(paramLabel = "<id number for record>", 
               description = "Used to differentiate records in the database.")
    private int id;

    @Override
    public void run() 
    {
        ClientService client = new ClientService();
        try 
        {
            client.update(id, event_name, prize_pool);
        }catch(Exception e) {
            System.out.println(e);
        }
    }

}

@Command(name="delete", description= "Delete a record on the database")
class delete implements Runnable 
{
    @Parameters(paramLabel = "<id number for record>", 
               description = "Used to differentiate records in the database.")
    private int id;

    @Override
    public void run() 
    {
        ClientService client = new ClientService();
        try 
        {
            client.delete(id);
        }catch(Exception e) {
            System.out.println(e);
        }
    }

}

@Command(name = "CLI", mixinStandardHelpOptions = true) 
public class CLI implements Runnable
{
    @Option(names = {"-c", "--create"}, description = "Create a record")
    Boolean create;

    @Option(names = {"-r", "--read"}, description = "Read a record")
    Boolean read;

    @Option(names = {"-u", "--update"}, description = "Update a record")
    Boolean update;

    @Option(names = {"-d", "--delete"}, description = "Delete a record")
    Boolean delete;


    @Parameters(paramLabel = "<name>", 
               description = "The name of the event.")
    private String name;

    @Parameters(paramLabel = "<prize_pool_amount>", 
               description = "Amount of money in prize pool for the event")
    private String prize_pool;

    @Parameters(paramLabel = "<id number for record>", 
               description = "Used to differentiate records in the database.")
    private int id;

    @Override
    public void run()
    { 
        ClientService client = new ClientService();
        if (create == true)
        {
            try {
                client.create(name, prize_pool);
            }catch(Exception e) {
                System.out.println(e);
            }
        }
        else if (read == true)
        {
            try {
                client.read(id);
            }catch(Exception e) {
                System.out.println(e);
            }
        }
        else if (update == true)
        {
            try {
                client.update(id, name, prize_pool);
            }catch(Exception e) {
                System.out.println(e);
            }
        }
        else if (delete == true)
        {
            try {
                client.delete(id);
            }catch(Exception e) {
                System.out.println(e);
            }
        }
    }
}

// Create
// Read
// Update
// Delete