package family_tree.view.commands.addDataMenuCommands;


import family_tree.view.ConsoleUI;
import family_tree.view.commands.Command;

public class SetDateOfDeath extends Command {
    public SetDateOfDeath(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить дату смерти";
    }

    @Override
    public void execute() {
        consoleUI.setDateOfDeath();
    }
}