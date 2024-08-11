package family_tree.model;
import family_tree.tree.TreeNode;
import java.time.LocalDate;
import java.util.*;

public class Human extends Person implements TreeNode<Human> {
    private static final long serialVersionUID = 1L;
    private Set<Human> children;
    private Map<Gender, Human> parents;

    public Human(String name, LocalDate birthDate, Gender gender) {
        super(name, birthDate, gender);
        this.children = new HashSet<>();
        this.parents = new HashMap<>();
    }

    @Override
    public Set<Human> getChildren() {
        return new HashSet<>(children);
    }

    public void addChild(Human child) {
        children.add(child);
        if (this.getGender() == Gender.MALE) {
            child.setFather(this);
        } else {
            child.setMother(this);
        }
    }

    @Override
    public Human getFather() {
        return parents.get(Gender.MALE);
    }
    public void setFather(Human father) {
        parents.put(Gender.MALE, father);
        }

    public Human getMother() {
        return parents.get(Gender.FEMALE);
    }

    public void setMother(Human mother) {
        parents.put(Gender.FEMALE, mother);
    }

    @Override
    public int compareTo(Human other) {
        return this.getName().compareTo(other.getName());
    }

    @Override
    public String toString() {
        return String.format("%s (Пол: %s, Дата рождения: %s)", 
                             getName(), getGender(), getBirthDate());
    }
}