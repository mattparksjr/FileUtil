package codes.matthewp.fileutil.command;

import java.io.File;

public class CheckReadWrite implements ICommand {

	@Override
	public String getCommand() {
		return "-checkReadWrite";
	}

	@Override
	public String getUsage() {
		return "-checkReadWrite [dictionary/file]";
	}

	@Override
	public void processCommand(String[] args) {
		if(args[0] != null) {
			
			File f = new File(args[0]);
			
			if(!f.exists()) {
                System.out.println("Error: the provided dictionary/file does not exist..");
				System.exit(0);
			}
			
			System.out.println("Checking read/write for: " + args[0]);
			System.out.println("Write: " + f.canWrite());
			System.out.println("Read: " + f.canRead());
			System.exit(0);
		} else {
            System.out.println("Error: Invalid command usage. Please use: -checkReadWrite [dictionary/file]");
			System.exit(0);
		}
	}

	
}
