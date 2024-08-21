package family_tree.model.human.comparator;

import family_tree.model.family_tree.FamilyTreeItem;

import java.util.Comparator;

public class HumanComparatorByAge<E extends FamilyTreeItem> implements Comparator<E> {

    @Override
    public int compare(E h1, E h2) {
        return Integer.compare(h1.getAge(), h2.getAge());
    }

}