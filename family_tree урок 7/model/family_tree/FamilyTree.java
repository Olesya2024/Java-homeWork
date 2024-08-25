package family_tree.model.family_tree;
import family_tree.model.human.comparator.HumanComparatorByAge;
import family_tree.model.human.comparator.HumanComparatorByGender;
import family_tree.model.human.comparator.HumanComparatorByName;
import family_tree.model.human.Person;

import java.io.Serializable;
import java.util.*;


public class FamilyTree<E extends FamilyTreeItem> implements Serializable, Iterable<E> {
    private List<E> familyTree;
    private Set<E> members;
    public FamilyTree() {

        familyTree = new ArrayList<>();
        members = new HashSet<>();
    }


    public void addHuman(E human) {
        this.familyTree.add(human);
        members = new HashSet<>();
    }

public String findHuman(String name) {
    for (E human : members) {
        if (human.getName().equals(name)) {
            return human.toString();
        }
    }
    return String.format("Человек с именем %s не найден!", name);
}

    public void sortByName() {
        familyTree.sort(new HumanComparatorByName<>());
    }

    public void sortByAge() {
        familyTree.sort(new HumanComparatorByAge<>());
    }

    public void sortByGender() {
        familyTree.sort(new HumanComparatorByGender<>());
    }

    public boolean isInFamilyTree(int id) {
        for (E human : this.familyTree) {
            if (human.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public E getHumanById(int id) {
        for (E human : this.familyTree) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (E human : familyTree) {
            result.append(human.toString());
            result.append("\n");
        }        return result.toString();
    }
    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(familyTree);
    }
}


