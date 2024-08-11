package family_tree.service;
import family_tree.tree.TreeNode;

import java.util.List;


public interface SortStrategy<T extends TreeNode<T>> {
    default List<T> sort(List<T> nodes) {
        return null;
    }
}