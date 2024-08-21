package family_tree.view.commands;
import family_tree.view.ConsoleUI;

public abstract class Command {
    protected String description;
    protected ConsoleUI consoleUI;

    public Command(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}