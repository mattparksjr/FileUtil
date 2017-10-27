package code.matthew.fileutil.command;

import java.io.File;

public class ReadDictonary implements ICommand {

	@Override
	public String getCommand() {
		return "-listDirContents";
	}

	@Override
	public void processComannd(String[] args) {
		if (args.length > 0 && args[0] != null) {
			File dictonary = new File(args[0]);

			if (!dictonary.exists()) {
				System.out.println("Error, the dictonary provided does not exist... Please enter a valid dictonary.");
				System.exit(0);
			}

			File[] files = dictonary.listFiles();

			if (files.length < 0) {
				System.out.println("Error: " + args[0] + "is empty");
				System.exit(0);
			}

			System.out.println("Listing files for: " + args[0]);
			
			for (int i = 0; i < files.length; i++) {
				System.out.println(files[i].getName());
			}
		} else {
			System.out.println("Invalid usage. Please use: -listDirContents [dictonary]");
			System.exit(0);
		}
	}

}
