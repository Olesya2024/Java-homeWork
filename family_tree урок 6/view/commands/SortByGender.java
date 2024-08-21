package family_tree.view.commands;
import family_tree.view.ConsoleUI;

public class SortByGender extends Command {

    public SortByGender(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать по полу";
    }

    @Override
    public void execute() {
        consoleUI.sortByGender();
    }

}