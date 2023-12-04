package formato.middleton;
import cli.java;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) 
    {
        int exitCode = new CommandLine(new CLI()).execute(args); 
        System.exit(exitCode);
    }
}