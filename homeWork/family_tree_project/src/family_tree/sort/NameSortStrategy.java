package family_tree.sort;

import family_tree.tree.Node;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NameSortStrategy<T extends TreeNode<T>> implements SortStrategy<T> {
    @Override
    public List<T> sort(List<T> nodes) {
        return nodes.stream()
                .sorted(Comparator.comparing(TreeNode::getName))
                .collect(Collectors.toList());
    }
}