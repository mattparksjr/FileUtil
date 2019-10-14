package codes.matthewp.fileutil.command;

public interface ICommand {

	String getCommand();

	String getUsage();

	void processCommand(String[] args);
}
