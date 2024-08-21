package family_tree.view.commands;
import family_tree.view.ConsoleUI;

public class LoadFamilyTreeData extends Command {

    public LoadFamilyTreeData(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить из файла";
    }

    @Override
    public void execute() {
        try {
            consoleUI.loadFamilyTreeData();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}