package codes.matthewp.fileutil.command;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ModifTime implements ICommand {

    @Override
    public String getCommand() {
        return "-lastModificationTime";
    }

    @Override
    public String getUsage() {
        return "-lastModificationTime [file]";
    }

    @Override
    public void processCommand(String[] args) {
        if (args[0] != null) {
            File f = new File(args[0]);

            if (f.exists()) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
                Date date = new Date(f.lastModified());
                System.out.println(args[0] + " was last modified at: " + format.format(date));
            } else {
                System.out.println("Error: file" + args[0] + " does not exist.");
                System.exit(0);
            }
        } else {
            System.out.println("Invalid usage. Please use: " + getUsage());
            System.exit(0);
        }
    }
}
