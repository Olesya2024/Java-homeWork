package family_tree.model.service;
import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Human;
import java.io.IOException;
import family_tree.model.writer.FileHandler;

public class FileOperationServise {
    private FileHandler fileHandler;

    public FileOperationServise() throws IOException {
        fileHandler = new FileHandler();
    }

    public void saveFamilyTree(FamilyTree<Human> familyTree) {
        fileHandler.write(familyTree, "FamilyTree.txt");
    }

    public FamilyTree<Human> loadFamilyTree() {
        try {
            return (FamilyTree<Human>) fileHandler.read("FamilyTree.txt");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

