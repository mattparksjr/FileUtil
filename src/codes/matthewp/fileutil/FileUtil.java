package codes.matthewp.fileutil;

import codes.matthewp.fileutil.command.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileUtil {

    private static Map<String, ICommand> possibleCommands = new HashMap<>();

    public static void main(String[] args) {
        // Register commands
        registerCommands(new ReadDictionary(), new ListContentsByExt(), new CheckReadWrite(), new IsValidDir(), new GetFileSize(), new FindLongestWord());
        // possibleCommands.add("-compareLex");
        // possibleCommands.add("-lastModificationTime");
        // possibleCommands.add("-listFileContents");
        // possibleCommands.add("-contentsToByteArray");
        // possibleCommands.add("-readLines");
        // possibleCommands.add("-append");
        // possibleCommands.add("-readStoreToArray");
        // possibleCommands.add("-readFile");
        doArgProcess(args);
    }

    private static void doArgProcess(String[] args) {
        if (args.length > 0) {
            if (args[0].startsWith("-")) {
                for (int i = 0; i < possibleCommands.size(); i++) {
                    String[] strippedArgs = new String[args.length];
                    for (int j = 0; j < args.length; j++) {
                        if (j != 0) {
                            strippedArgs[j - 1] = args[j];
                        }
                    }
                    if (possibleCommands.get(args[0]) != null) {
                        possibleCommands.get(args[0]).processCommand(strippedArgs);
                    } else {
                        printHelp();
                    }
                }
            } else {
                printHelp();
            }
        } else {
            printHelp();
        }
    }

    private static void printHelp() {
        System.out.println("FileUtil help ->");
        System.out.println("FileUtil may be run with the following commands:");
        for (String s : possibleCommands.keySet()) {
            System.out.println("    " + possibleCommands.get(s).getUsage());
        }
//        System.out.println("    -compareLex [file] [file]");
//        System.out.println("    -lastModificationTime [file]");
//        System.out.println("    -listFileContents [dictionary]");
//        System.out.println("    -contentsToByteArray [file]");
//        System.out.println("    -readLines [file]");
//        System.out.println("    -append [file] [textToBeAppended]");
//        System.out.println("    -readStoreToArray [file] [echo?t/f]");
//        System.out.println("    -readFile [file]");
        Scanner userInput = new Scanner(System.in);
        while (true) {
            String input = userInput.nextLine();
            if (!input.isEmpty()) {
                String[] args = input.split(" ");
                doArgProcess(args);
            }
        }
    }

    private static void registerCommands(ICommand... commands) {
        for (ICommand command : commands) {
            registerCommand(command);
        }
    }

    private static void registerCommand(ICommand command) {
        possibleCommands.put(command.getCommand(), command);
    }
}
