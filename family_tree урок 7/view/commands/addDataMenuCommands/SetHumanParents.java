package family_tree.view.commands.addDataMenuCommands;


import family_tree.view.ConsoleUI;
import family_tree.view.commands.Command;

public class SetHumanParents extends Command {

    public SetHumanParents(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Создание связи родители-ребенок";
    }

    @Override
    public void execute() {
        consoleUI.setHumanParents();
    }

}