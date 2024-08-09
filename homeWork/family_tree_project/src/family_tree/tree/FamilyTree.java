package family_tree.tree;

import family_tree.util.FileHandlerInterface;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends TreeNode<T>> implements Iterable<T>, Serializable {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T member) {
        if (!members.contains(member)) {
            members.add(member);
        }
    }

    public List<T> getMembers() {
        return new ArrayList<>(members);
    }

    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }

    public void saveToFile(String filename, FileHandlerInterface fileHandler) {
        fileHandler.writeToFile(filename, this);
    }

    @SuppressWarnings("unchecked")
    public static <T extends TreeNode<T>> FamilyTree<T> loadFromFile(String filename, FileHandlerInterface fileHandler) {
        return (FamilyTree<T>) fileHandler.readFromFile(filename);
    }
}