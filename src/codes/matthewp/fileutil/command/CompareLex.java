package codes.matthewp.fileutil.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CompareLex implements ICommand {

    @Override
    public String getCommand() {
        return "-compareLex";
    }

    @Override
    public String getUsage() {
        return "-compareLex [file1] [file2]";
    }

    @Override
    public void processCommand(String[] args) {
        if (args.length != 2) {
            System.out.println("Error: Invalid command usage. Please use: " + getUsage());
            System.exit(0);
        }

        File file1 = new File(args[0]);
        File file2 = new File(args[1]);

        if (! file1.exists()) {
            System.out.println("Error: file " + args[0] + " does not exist");
            System.exit(0);
        }

        if (file2.exists()) {
            System.out.println("Error: file " + args[1] + " does not exist");
            System.exit(0);
        }

        try {
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            String st1;
            String st1Final = "";
            while ((st1 = br1.readLine()) != null) {
                st1Final += st1;
            }

            String st2;
            String st2Final = "";
            while ((st2 = br2.readLine()) != null) {
                st2Final += st2;
            }
            int compare = st1Final.compareTo(st2Final);
            System.out.println("File 1 compared to file 2 lex is: " + compare);
        } catch (IOException ex) {
            System.out.println("Error reading file: ");
            ex.printStackTrace();
        }
    }
}
