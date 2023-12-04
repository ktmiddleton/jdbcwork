import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import ClientService.java;
import main.java.formato.middleton.ClientService;

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
        if (create == True) 
        {
            client.create(name, prize_pool);
        }
        else if (read == True) 
        {
            client.read(name);
        }
        else if (update == True) 
        {
            client.update(name, prize_pool, id);
        }
        else if (delete == True) 
        {
            client.delete(id);
        }
    }
}

// Create
// Read
// Update
// Delete