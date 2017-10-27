package code.matthew.fileutil.command;

import java.io.File;

import code.matthew.fileutil.ICommand;

public class GetFileSize implements ICommand {

	@Override
	public String getCommand() {
		return "-getFileSize";
	}

	@Override
	public void processComannd(String[] args) {
		if (args[0] != null) {

			File f = new File(args[0]);

			if (!f.exists()) {
				System.out.println("Error: That file does not exist");
				System.exit(0);
			}

			System.out.println("Showing sizes for: " + args[0]);
			
			double bytes = f.length();
			double kilobytes = (bytes / 1024);
			double megabytes = (kilobytes / 1024);
			double gigabytes = (megabytes / 1024);
			double terabytes = (gigabytes / 1024);
			double petabytes = (terabytes / 1024);
			
			System.out.println("    bytes: " + bytes);
			System.out.println("    kilobytes: " + kilobytes);
			System.out.println("    megabytes: " + megabytes);
			System.out.println("    gigabytes: " + gigabytes);
			System.out.println("    terabytes: " + terabytes);
			System.out.println("    petabytes: " + petabytes);
			System.exit(0);
		} else {
			System.out.println("Error: Invalid command usage. Please use: -getFileSize [file]");
			System.exit(0);
		}
	}


}
