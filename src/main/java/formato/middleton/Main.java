package formato.middleton;
import cli.java;

public class Main {
    public static void main(String[] args) 
    {
        int exitCode = new CommandLine(new CLI()).execute(args); 
        System.exit(exitCode);
    }
}