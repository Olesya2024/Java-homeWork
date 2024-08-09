package family_tree.sort;

import family_tree.tree.Node;

import java.util.List;

public interface SortStrategy<T extends TreeNode<T>> {
    List<T> sort(List<T> nodes);
}