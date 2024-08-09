package family_tree;

import family_tree.model.Human;
import family_tree.service.FamilyService;
import family_tree.tree.FamilyTree;
import family_tree.util.FileHandler;
import family_tree.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        FamilyTree<Human> familyTree = FamilyTree.loadFromFile("data/familyTree.ser", fileHandler);
        if (familyTree == null) {
            familyTree = new FamilyTree<>();
        }
        FamilyService service = new FamilyService(familyTree, fileHandler);
        ConsoleView view = new ConsoleView(service);
        view.run();
    }
}