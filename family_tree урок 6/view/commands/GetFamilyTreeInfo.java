package family_tree.view.commands;
import family_tree.view.ConsoleUI;

public class GetFamilyTreeInfo extends Command {

    public GetFamilyTreeInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести данные";
    }

    @Override
    public void execute() {
        consoleUI.getFamilyTreeInfo();
    }

}