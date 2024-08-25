package family_tree.view.commands.addDataMenuCommands;


import family_tree.view.ConsoleUI;
import family_tree.view.commands.Command;

public class SetHumanSpouse extends Command {

    public SetHumanSpouse(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавление связи муж-жена";
    }

    @Override
    public void execute() {
        consoleUI.setHumanSpouse();
    }
}