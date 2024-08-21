package family_tree.view;

import family_tree.view.commands.*;
import java.util.HashMap;
import java.util.Map;


public class MainMenu {
    private Map<Integer, Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new HashMap<>();
        commands.put(1, new AddHuman(consoleUI));
        commands.put(2, new StartAddDataMenu(consoleUI));
        commands.put(3, new SortByAge(consoleUI));
        commands.put(4, new SortByName(consoleUI));
        commands.put(5, new GetFamilyTreeInfo(consoleUI));
        commands.put(6, new LoadFamilyTreeData(consoleUI));
        commands.put(7, new SaveFamilyTreeData(consoleUI));
        commands.put(8, new Finish(consoleUI));
    }

public String menu() {
    StringBuilder menu = new StringBuilder();
    for (Map.Entry<Integer, Command> entry : commands.entrySet()) {
        menu.append(entry.getKey()).append(". ").append(entry.getValue().getDescription()).append("\n");
    }
    return menu.toString();
}
        public int getSize() {
        return commands.size();
    }

    public void execute(int choice) {
        Command command = commands.get(choice);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Неверно введены данные");
        }
    }
}