package family_tree.model.human;

import family_tree.model.family_tree.FamilyTree;

public class Person {
        public static void addFamilyMembers(FamilyTree<Human> familyTree) {
            Human human1 = new Human("Олеся", Gender.FEMALE, 1978, 4, 1);
            Human human2 = new Human("Тимофей", Gender.MALE, 2012, 2, 4);
            Human human3 = new Human("Татьяна", Gender.FEMALE,1959, 8, 16);
            Human human4 = new Human("Валера", Gender.MALE,1958, 4, 20);
            Human human5 = new Human("Маргарита", Gender.FEMALE, 1933, 5, 18);
            Human human6 = new Human("Владимир", Gender.MALE, 1934, 3, 7);


            familyTree.addHuman(human1);
            familyTree.addHuman(human2);
            familyTree.addHuman(human3);
            familyTree.addHuman(human4);
            familyTree.addHuman(human5);
            familyTree.addHuman(human6);
        }
    }
