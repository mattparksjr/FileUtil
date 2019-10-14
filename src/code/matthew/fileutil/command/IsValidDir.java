package code.matthew.fileutil.command;

import java.io.File;

public class IsValidDir implements ICommand {

	@Override
	public String getCommand() {
		return "-isValidDictionary";
	}

	@Override
	public String getUsage() {
		return "-isValidDictionary [dictionary]";
	}

	@Override
	public void processCommand(String[] args) {
		if(args[0] != null)  {
			File f = new File(args[0]);
			if(f.exists()) {
				System.out.println(args[0] + " is a valid dictionary!");
				System.exit(0);
			} else {
				System.out.println(args[0] + " is not a valid dictionary!");
				System.exit(0);
			}
		} else {
			System.out.println("Error: Invalid usage. Please use -isValidDictionary [dictionary]");
			System.exit(0);
		}
	}

}
