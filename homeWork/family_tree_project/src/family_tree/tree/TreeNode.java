package family_tree.tree;

import java.time.LocalDate;
import java.util.List;

public interface TreeNode<T extends TreeNode<T>> extends Comparable<T> {
    String getName();
    LocalDate getBirthDate();
    List<? extends T> getChildren();
}