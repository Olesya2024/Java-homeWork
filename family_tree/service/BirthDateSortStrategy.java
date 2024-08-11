package family_tree.service;
import family_tree.tree.TreeNode;
import java.util.Comparator;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BirthDateSortStrategy<T extends TreeNode<T>> implements SortStrategy<T> {

    public Set<T> sort(Set<T> nodes) {
        return nodes.stream()
                .sorted(Comparator.comparing(TreeNode::getBirthDate))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}