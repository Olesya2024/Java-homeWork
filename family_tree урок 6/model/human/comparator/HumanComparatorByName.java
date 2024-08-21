package family_tree.model.human.comparator;

import family_tree.model.family_tree.FamilyTreeItem;

import java.util.Comparator;


public class HumanComparatorByName<E extends FamilyTreeItem> implements Comparator<E> {

    @Override
    public int compare(E h1, E h2) {
        return h1.getName().compareTo(h2.getName());
    }

}