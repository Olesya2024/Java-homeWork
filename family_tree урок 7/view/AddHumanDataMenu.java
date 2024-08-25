package family_tree.view;
import family_tree.view.commands.Command;
import family_tree.view.commands.addDataMenuCommands.SetDateOfDeath;
import family_tree.view.commands.addDataMenuCommands.SetHumanParents;
import family_tree.view.commands.addDataMenuCommands.SetHumanSpouse;

import java.util.ArrayList;
import java.util.List;

public class AddHumanDataMenu {
    private List<Command> commands;

    public AddHumanDataMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new SetDateOfDeath(consoleUI));
        commands.add(new SetHumanParents(consoleUI));
        commands.add(new SetHumanSpouse(consoleUI));
    }

    public String menu() {
        StringBuilder menu = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            menu.append(i + 1);
            menu.append(".");
            menu.append(commands.get(i).getDescription());
            menu.append("\n");
        }
        return menu.toString();
    }

    public int getSize() {
        return commands.size();
    }

    public void execute(int choice) {
        Command command = commands.get(choice);
        command.execute();
    }
}