package family_tree.tree;

import family_tree.util.FileHandlerInterface;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class FamilyTree<T extends TreeNode<T>> implements Iterable<T>, Serializable {

    private final Set<T> members;

    public FamilyTree() {
        this.members = new HashSet<>();;
    }
    public void addMember(T member) {
            members.add(member);
    }
    public Set<T> getMembers() {
        return new HashSet<>(members);
    }
    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }
    public void saveToFile(String filename, FileHandlerInterface fileHandler) {
        fileHandler.writeToFile(filename, this);
    }
    public static <T extends TreeNode<T>> FamilyTree<T> loadFromFile(String filename, FileHandlerInterface fileHandler) {
        return (FamilyTree<T>) fileHandler.readFromFile(filename);
    }
}
