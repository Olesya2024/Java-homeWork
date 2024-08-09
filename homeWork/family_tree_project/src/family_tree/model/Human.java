package family_tree.model;

import family_tree.tree.TreeNode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human extends Person implements TreeNode<Human> {
    private List<Human> children;
    private Human father;
    private Human mother;

    public Human(String name, LocalDate birthDate, Gender gender) {
        super(name, birthDate, gender);
        this.children = new ArrayList<>();
    }

    @Override
    public List<Human> getChildren() {
        return new ArrayList<>(children);
    }

    public void addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            if (this.getGender() == Gender.MALE) {
                child.setFather(this);
            } else {
                child.setMother(this);
            }
        }
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
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