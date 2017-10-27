package code.matthew.fileutil;

import java.util.HashMap;

import code.matthew.fileutil.command.GetFileSize;
import code.matthew.fileutil.command.ICommand;
import code.matthew.fileutil.command.IsValidDir;
import code.matthew.fileutil.command.ListContentsByExt;
import code.matthew.fileutil.command.ReadDictonary;

public class FileUtil {

	private static HashMap<String, ICommand> possibleCommands = new HashMap<String, ICommand>();
	
	public static ICommand readDir;
	public static ICommand listContentsBy;
	public static ICommand isValidDir;
	public static ICommand getFileSize;
	
	public static void main(String[] args) {

		// Set class references
		readDir = new ReadDictonary();
		listContentsBy = new ListContentsByExt();
		isValidDir = new IsValidDir();
		getFileSize = new GetFileSize();
		
		// Register commands
		possibleCommands.put(readDir.getCommand(), readDir);
		possibleCommands.put(listContentsBy.getCommand(), listContentsBy);
		// possibleCommands.add("-checkReadWrite");
		possibleCommands.put(isValidDir.getCommand(), isValidDir);
		// possibleCommands.add("-compareLex");
		// possibleCommands.add("-lastModificationTime");
		// possibleCommands.add("-listFileContents");
		possibleCommands.put(getFileSize.getCommand(), getFileSize);
		// possibleCommands.add("-contentsToByteArray");
		// possibleCommands.add("-locateLongestWord");
		// possibleCommands.add("-readLines");
		// possibleCommands.add("-append");
		// possibleCommands.add("-readStoreToArray");
		// possibleCommands.add("-readFile");

		// Begin processing
		if (args.length > 0) {
			if (args[0].startsWith("-")) {
				for (int i = 0; i < possibleCommands.size(); i++) {
					String[] strippedArgs = new String[args.length];
					for (int j = 0; j < args.length; j++) {
						if(j != 0) {
							strippedArgs[j - 1] = args[j];
						}
					}
					if (possibleCommands.get(args[0]) != null) {
						possibleCommands.get(args[0]).processComannd(strippedArgs);
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

	public static void printHelp() {
		System.out.println("FileUtil help ->");
		System.out.println(" ");
		System.out.println("FileUtil may be run with the following commands:");
		System.out.println(" ");
		System.out.println("    -listDirContents [dictonary]");
		System.out.println("    -listContentsByExtension [dictonary] [extension]");
		System.out.println("    -checkReadWrite [dictonatry/file] [dictonarypath/filepath]");
		System.out.println("    -isValidDictonary [dictonary]");
		System.out.println("    -compareLex [file] [file]");
		System.out.println("    -lastModificationTime [file]");
		System.out.println("    -listFileContents [dictonary]");
		System.out.println("    -getFileSize [file]");
		System.out.println("    -contentsToByteArray [file]");
		System.out.println("    -locateLongestWord [file]");
		System.out.println("    -readLines [file]");
		System.out.println("    -append [file] [textToBeAppended]");
		System.out.println("    -readStoreToArray [file] [echo?t/f]");
		System.out.println("    -readFile [file]");
		System.exit(0);

	}
}
