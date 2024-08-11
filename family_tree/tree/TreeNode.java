package family_tree.tree;

import family_tree.model.Human;

import java.time.LocalDate;
import java.util.Set;

public interface TreeNode<T extends TreeNode<T>> extends Comparable<T> {
    String getName();
    LocalDate getBirthDate();
    Set<T> getChildren();
    T getFather();
    T getMother();
}

