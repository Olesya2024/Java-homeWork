package family_tree.model.human;

import family_tree.model.family_tree.FamilyTreeItem;
import family_tree.model.human.Person;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Human implements Serializable, Comparable<Human>, FamilyTreeItem {
    static int count;

    private int id;
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth, dateOfDeath;
    private Human spouse;
    private List<Human> parents;
    private List<Human> children;

    public Human(String name, Gender gender, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
        this.id = count;
        count++;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
    }

    public Human() {
        this.id = count;
        count++;
    }
    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

public void setGender(Gender gender) {
    this.gender = gender;
}
    public Gender getGender() {
        return this.gender;
    }

    public int getAge() {
        int age;

        if (this.dateOfDeath == null) {
            LocalDate now = LocalDate.now();
            Period diff = Period.between(dateOfBirth, now);
            age = diff.getYears();
        } else {
            Period diff = Period.between(dateOfBirth, dateOfDeath);
            age = diff.getYears();
        }

        return age;
    }
    public void setDateOfBirth(int year, int month, int day) {
        this.dateOfBirth = LocalDate.of(year, month, day);
    }

    public void setDateOfDeath(int year, int month, int day) {
        this.dateOfDeath = LocalDate.of(year, month, day);
    }

    public String getSpouseName() {
        if (this.spouse != null) {
            return this.spouse.getName();
        } else {
            return "не в браке";
        }
    }
    public Human getSpouse() {
        return this.spouse;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
        if (spouse.getSpouse() != null) {
            return;
        }
        spouse.setSpouse(this);
    }

public String getParentsNames() {
    if (this.parents != null) {
        return String.join(" ", parents.get(0).getName(), parents.get(1).getName());
    } else {
        return "нет данных";
    }
}

    public List<Human> getParents() {
        return this.parents;
    }

public void setParents(Human father, Human mother) {
    this.parents = List.of(father, mother);
    father.setChild(this);
    mother.setChild(this);
}

    public String getChildrenNames() {
        if (this.children != null) {
            return children.stream().map(Human::getName).collect(Collectors.joining(" "));
        } else {
            return "детей нет";
        }
    }

    public List<Human> getChildren() {
        return this.children;
    }
    private void setChild(Human child) {
        if (this.children == null) {
            this.children = new ArrayList<>();
        }
        this.children.add(child);
    }
    @Override
    public String toString() {
        String result = "";

        result += String.format("id: %d", this.id);
        result += String.format(", name: %s", getName());

        if (gender == Gender.MALE) {
            result += ", gender: муж";
        } else {
            result += ", gender: жен";
        }
        result += String.format(", age: %d", getAge());
        result += String.format(", spouse: %s", getSpouseName());
        result += String.format(", parents: %s", getParentsNames());
        result += String.format(", children: %s", getChildrenNames());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        var e = (Human) obj;
        return this.id == e.id;
    }
    @Override
    public int hashCode() {
        return this.id;
    }
    @Override
    public int compareTo(Human o) {
        return this.getName().compareTo(o.getName());
    }
}