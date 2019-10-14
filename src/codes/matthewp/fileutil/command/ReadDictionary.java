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
			if (files.length < 1) {
				System.out.println("Error: " + args[0] + "is empty");
				System.exit(0);
			}

			System.out.println("Listing files for: " + args[0]);
			
			for (int i = 0; i < files.length; i++) {
				System.out.println(files[i].getName());
			}
		} else {
			System.out.println("Invalid usage. Please use: -listDirContents [dictionary]");
			System.exit(0);
		}
	}

}
