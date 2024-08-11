package family_tree.service;

import family_tree.model.Gender;
import family_tree.model.Human;
import family_tree.model.Person;
import family_tree.tree.FamilyTree;
import family_tree.util.FileHandlerInterface;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class FamilyService {
    private FamilyTree<Human> familyTree;
    private final FileHandlerInterface fileHandler;

    public FamilyService(FamilyTree<Human> familyTree, FileHandlerInterface fileHandler) {
        this.familyTree = familyTree;
        this.fileHandler = fileHandler;
    }

    public void addHuman(String name, LocalDate birthDate, Gender gender) {
        Human human = new Human(name, birthDate, gender);
        familyTree.addMember(human);
    }

    public Set<Human> getAllHumans() {
        return new HashSet<>(familyTree.getMembers());
    }

    public Set<Human> sortByName() {
        return familyTree.getMembers().stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Set<Human> sortByBirthDate() {
        return familyTree.getMembers().stream()
                .sorted(Comparator.comparing(Person::getBirthDate))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public void saveToFile(String filename) {
        familyTree.saveToFile(filename, fileHandler);
    }

    public void loadFromFile(String filename) {
        try {
            FamilyTree<Human> loadedTree = FamilyTree.loadFromFile(filename, fileHandler);
            if (loadedTree != null) {
                this.familyTree = loadedTree;
            }
        } catch (Exception e) {
            System.err.println("Ошибка при загрузке из файла: " + e.getMessage());
        }
    }
}