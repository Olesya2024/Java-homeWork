package family_tree.model;
import family_tree.tree.FamilyTree;
import java.time.LocalDate;

public class FamilyMembers {
        public static void addFamilyMembers(FamilyTree<Human> familyTree) {
            Human human1 = new Human("Олеся", LocalDate.of(1978, 4, 1), Gender.FEMALE);
            Human human2 = new Human("Тимофей", LocalDate.of(2012, 2, 4), Gender.MALE);
            Human human3 = new Human("Татьяна", LocalDate.of(1959, 8, 16), Gender.FEMALE);
            Human human4 = new Human("Валера", LocalDate.of(1958, 4, 20), Gender.MALE);
            Human human5 = new Human("Маргарита", LocalDate.of(1933, 5, 18), Gender.FEMALE);
            Human human6 = new Human("Владимир", LocalDate.of(1934, 3, 7), Gender.MALE);


            familyTree.addMember(human1);
            familyTree.addMember(human2);
            familyTree.addMember(human3);
            familyTree.addMember(human4);
            familyTree.addMember(human5);
            familyTree.addMember(human6);
        }
    }
