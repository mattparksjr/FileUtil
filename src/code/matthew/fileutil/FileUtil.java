package code.matthew.fileutil;

import java.util.HashMap;
import java.util.Scanner;

import code.matthew.fileutil.command.CheckReadWrite;
import code.matthew.fileutil.command.GetFileSize;
import code.matthew.fileutil.command.ICommand;
import code.matthew.fileutil.command.IsValidDir;
import code.matthew.fileutil.command.ListContentsByExt;
import code.matthew.fileutil.command.ReadDictonary;

public class FileUtil {

    private static HashMap<String, ICommand> possibleCommands = new HashMap<String, ICommand>();

    public static void main(String[] args) {
        // Register commands
        possibleCommands.put(new ReadDictonary().getCommand(), new ReadDictonary());
        possibleCommands.put(new ListContentsByExt().getCommand(), new ListContentsByExt());
        possibleCommands.put(new CheckReadWrite().getCommand(), new CheckReadWrite());
        possibleCommands.put(new IsValidDir().getCommand(), new IsValidDir());
        // possibleCommands.add("-compareLex");
        // possibleCommands.add("-lastModificationTime");
        // possibleCommands.add("-listFileContents");
        possibleCommands.put(new GetFileSize().getCommand(), new GetFileSize());
        // possibleCommands.add("-contentsToByteArray");
        // possibleCommands.add("-locateLongestWord");
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
        for(String s : possibleCommands.keySet()) {
			System.out.println("    " + possibleCommands.get(s).getUsage());
		}
//        System.out.println("    -compareLex [file] [file]");
//        System.out.println("    -lastModificationTime [file]");
//        System.out.println("    -listFileContents [dictonary]");
//        System.out.println("    -contentsToByteArray [file]");
//        System.out.println("    -locateLongestWord [file]");
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
}
