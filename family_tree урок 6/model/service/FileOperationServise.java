package family_tree.model.service;
import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Human;

import java.util.logging.FileHandler;


public class FileOperationServise {
    FileHandler fileHandler;

    public FileOperationServise() {
        fileHandler = new FileHandler();
    }

    public void saveFamilyTree(FamilyTree<Human> familyTree) {
        fileHandler.write(familyTree, "FamilyTree.bin");
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public FamilyTree<Human> loadFamilyTree() {
        try {
            return (FamilyTree) fileHandler.read("FamilyTree.bin");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}