package family_tree.model.family_tree;
import family_tree.model.human.Gender;

public interface FamilyTreeItem {
    int getId();

    int getAge();

    String getName();

    Gender getGender();
}