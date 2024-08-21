package family_tree.view.commands;
import family_tree.view.ConsoleUI;

public class StartAddDataMenu extends Command {
    public StartAddDataMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Меню добавления данных";
    }

    @Override
    public void execute() {
        consoleUI.startAddDataMenu();
    }
}