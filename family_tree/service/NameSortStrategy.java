package family_tree.service;

import family_tree.tree.TreeNode;
import java.util.Comparator;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class NameSortStrategy<T extends TreeNode<T>> implements SortStrategy<T> {

    public Set<T> sort(Set<T> nodes) {
        return nodes.stream()
                .sorted(Comparator.comparing(TreeNode::getName))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}