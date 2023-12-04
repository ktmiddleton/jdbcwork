package formato.middleton;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

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