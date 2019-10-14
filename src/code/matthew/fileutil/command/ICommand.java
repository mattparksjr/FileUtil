package code.matthew.fileutil.command;

public interface ICommand {

	String getCommand();

	String getUsage();

	void processCommand(String[] args);
}
