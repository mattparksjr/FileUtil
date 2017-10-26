package code.matthew.fileutil.command;

import java.io.File;
import java.util.ArrayList;

import code.matthew.fileutil.ICommand;

public class ListContentsByExt implements ICommand {

	@Override
	public String getCommand() {
		return "-listContentsByExtension";
	}

	@Override
	public void processComannd(String[] args) {
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

			/*
			 * A note to any one reading this... These random comments are me attepmting to
			 * debug it.. I felt cringy for having to do this so I left it as a memory! Good
			 * days!
			 */

			File[] files = f.listFiles();

			// 0 me.exe
			// 1 something.bmp
			// 2 lol.png
			// 3 lawl.png

			ArrayList<File> filesWithExt = new ArrayList<>();

			for (int i = 0; i < files.length; i++) {
				if (files[i].getName().endsWith(realExt)) {
					filesWithExt.add(files[i]);
				}
			}

			// 0 = null
			// 1 = file
			// 2 = null
			for (int j = 0; j < filesWithExt.size(); j++) {
				System.out.println(filesWithExt.get(j).getName());
			}
			System.exit(0);
		} else {
			System.out.println("Invalid usage. Please use: -listContentsByExtension [dictonary] [fileextension]");
			System.exit(0);
		}
	}

}
