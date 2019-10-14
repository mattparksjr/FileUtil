package codes.matthewp.fileutil.command;

import java.io.File;

public class ListContentsByExt implements ICommand {

	@Override
	public String getCommand() {
		return "-listContentsByExtension";
	}

	@Override
	public String getUsage() {
		return "-listContentsByExtension [dictionary] [extension]";
	}

	@Override
	public void processCommand(String[] args) {
		if (args.length > 0 && args[0] != null && args[1] != null) {
			File f = new File(args[0]);
			if (!f.exists()) {
				System.out.println("Error: file " + args[0] + " does not exist");
				System.exit(0);
			}

			String realExt = args[1];
			if (!realExt.startsWith(".")) {
				realExt = "." + realExt;
			}

			File[] files = f.listFiles();
			if (files == null) {
				System.out.println("Error: This dictionary is empty!");
				System.exit(0);
			}

			System.out.println("Listing files with extension " + realExt + " : ");
			for (File file : files) {
				if (file.getName().endsWith(realExt)) {
					System.out.println(file.getName());
				}
			}
			System.exit(0);
		} else {
			System.out.println("Invalid usage. Please use: -listContentsByExtension [dictionary] [fileextension]");
			System.exit(0);
		}
	}

}
