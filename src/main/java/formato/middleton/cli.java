import picocli.CommandLine;
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
    private String[] name;

    @Parameters(paramLabel = "<prize_pool_amount>", 
               description = "Amount of money in prize pool for the event")
    private String[] prize_pool;

    @Override
    public void run() { 
        // The business logic of the command goes here...
        // In this case, code for generation of ASCII art graphics
        // (omitted for the sake of brevity).
    }
}

// Create
// Read
// Update
// Delete