package code.matthew.fileutil.command;

public interface ICommand {

	public String getCommand();

	public String getUsage();

	public void processCommand(String[] args);
}
