package codes.matthewp.fileutil.command;

import java.io.File;
import java.util.ArrayList;

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
				System.out.println("Error: " + args[0] + " does not exist");
				System.exit(0);
			}

			String realExt = "tmp";

			if (args[1].startsWith(".")) {
				realExt = args[1];
			} else {
				realExt = "." + args[1];
			}

			File[] files = f.listFiles();
			ArrayList<File> filesWithExt = new ArrayList<>();

			for (int i = 0; i < files.length; i++) {
				if (files[i].getName().endsWith(realExt)) {
					filesWithExt.add(files[i]);
				}
			}

			for (int j = 0; j < filesWithExt.size(); j++) {
				System.out.println(filesWithExt.get(j).getName());
			}
			System.exit(0);
		} else {
			System.out.println("Invalid usage. Please use: -listContentsByExtension [dictionary] [fileextension]");
			System.exit(0);
		}
	}

}
