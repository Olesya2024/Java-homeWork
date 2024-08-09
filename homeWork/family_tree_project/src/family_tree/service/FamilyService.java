package family_tree.service;

import family_tree.model.Gender;
import family_tree.model.Human;
import family_tree.tree.FamilyTree;
import family_tree.util.FileHandlerInterface;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyService {
    private static FamilyTree<Human> familyTree;
    private FileHandlerInterface fileHandler;

    public FamilyService(FamilyTree<Human> familyTree, FileHandlerInterface fileHandler) {
        this.familyTree = familyTree;
        this.fileHandler = fileHandler;
    }

    public void addHuman(String name, LocalDate birthDate, Gender gender) {
        Human human = new Human(name, birthDate, gender);
        familyTree.addMember(human);
    }

    public List<Human> getAllHumans() {
        return familyTree.getMembers();
    }

    public List<Human> sortByName() {
        return familyTree.getMembers().stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Human> sortByBirthDate() {
        return familyTree.getMembers().stream()
                .sorted((h1, h2) -> h1.getBirthDate().compareTo(h2.getBirthDate()))
                .collect(Collectors.toList());
    }

    public void saveToFile(String filename) {
        familyTree.saveToFile(filename, fileHandler);
    }

    public void loadFromFile(String filename) {
        FamilyTree<Human> loadedTree = FamilyTree.loadFromFile(filename, fileHandler);
        if (loadedTree != null) {
            this.familyTree = loadedTree;
        }
    }
}
