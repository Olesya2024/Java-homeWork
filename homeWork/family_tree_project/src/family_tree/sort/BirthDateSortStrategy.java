package family_tree.sort;

//import family_tree.tree.Node;
import family_tree.tree.TreeNode;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BirthDateSortStrategy<T extends TreeNode<T>> implements SortStrategy<T> {
    @Override
    public List<T> sort(List<T> nodes) {
        return nodes.stream()
                .sorted(Comparator.comparing(TreeNode::getBirthDate))
                .collect(Collectors.toList());
    }
}