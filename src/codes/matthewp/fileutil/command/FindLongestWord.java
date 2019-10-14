package codes.matthewp.fileutil.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FindLongestWord implements ICommand {

    @Override
    public String getCommand() {
        return "-locateLongestWord";
    }

    @Override
    public String getUsage() {
        return "-locateLongestWord [file]";
    }

    @Override
    public void processCommand(String[] args) {
        if (args[0] != null) {
            File f = new File(args[0]);
            if (!f.exists()) {
                System.out.println("Error: file " + args[0] + " does not exist");
                System.exit(0);
            }

            String longest = "";

            try {
                BufferedReader br = new BufferedReader(new FileReader(f));

                String st;
                while ((st = br.readLine()) != null) {
                    if (st.length() > longest.length()) {
                        longest = st;
                    }
                }
            } catch (IOException ex) {
                System.out.println("Error reading file: ");
                ex.printStackTrace();
            }

            System.out.println("The longest word is: " + longest);
        } else {
            System.out.println("Error: Invalid command usage. Please use: " + getUsage());
            System.exit(0);
        }
    }
}
