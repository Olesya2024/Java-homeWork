package family_tree.view.commands;
import family_tree.view.ConsoleUI;

public class SaveFamilyTreeData extends Command {

    public SaveFamilyTreeData(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить в файл";
    }

    @Override
    public void execute() {
        consoleUI.saveFamilyTreeData();
    }

}