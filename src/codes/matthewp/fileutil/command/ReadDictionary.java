package codes.matthewp.fileutil.command;

import java.io.File;

public class ReadDictionary implements ICommand {

	@Override
	public String getCommand() {
		return "-listDirContents";
	}

	@Override
	public String getUsage() {
		return "-listDirContents [dictionary]";
	}

	@Override
	public void processCommand(String[] args) {
		if (args.length > 0 && args[0] != null) {
			File dictionary = new File(args[0]);
			if (!dictionary.exists()) {
				System.out.println("Error, the dictionary provided does not exist... Please enter a valid dictionary.");
				System.exit(0);
			}

			File[] files = dictionary.listFiles();
			if (files == null) {
				System.out.println("Error: This dictionary is empty!");
				System.exit(0);
			}

			System.out.println("Listing files for: " + args[0]);
			for (File file : files) {
				System.out.println(file.getName());
			}
		} else {
			System.out.println("Invalid usage. Please use: -listDirContents [dictionary]");
			System.exit(0);
		}
	}
}
