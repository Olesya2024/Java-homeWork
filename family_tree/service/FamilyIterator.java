package family_tree.service;

import family_tree.tree.TreeNode;

import java.util.Iterator;
import java.util.List;

public class FamilyIterator<T extends TreeNode<T>> implements Iterator<T> {
    private List<T> list;
    private int index;

    public FamilyIterator(List<T> list) {
        this.list = list;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

        @Override
        public T next() {
            return list.get(index++);
        }
    }

