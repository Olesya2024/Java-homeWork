package family_tree.model.service;


import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.model.human.HumanBuilder;

public class Service {
    private FamilyTree<Human> familyTree;

    public Service() {
        this.familyTree = new FamilyTree<>();
    }

    private Human createHuman(String name, Gender gender, int year, int month, int day) {
        HumanBuilder humanBuilder = new HumanBuilder();
        return humanBuilder.setName(name).setGender(gender).setDateOfBirth(year, month, day).build();
    }

    public void addHuman(String name, Gender gender, int year, int month, int day) {
        this.familyTree.addHuman(createHuman(name, gender, year, month, day));
    }

    public void setHumanDateOfDeath(int id, int year, int month, int day) {
        Human human = getHumanById(id);
        human.setDateOfDeath(year, month, day);
    }

    public void setHumanParents(int humanId, int fatherId, int motherId) {
        Human human = getHumanById(humanId);
        Human father = getHumanById(fatherId);
        Human mother = getHumanById(motherId);
        human.setParents(father, mother);
    }

    public void setHumanSpouse(int humanId, int spouseId) {
        Human human = getHumanById(humanId);
        Human spouse = getHumanById(spouseId);
        human.setSpouse(spouse);
    }

    public Human getHumanById(int id) {
        return this.familyTree.getHumanById(id);
    }

    public boolean isInFamilyTree(int id) {
        return this.familyTree.isInFamilyTree(id);
    }

    public void sortByName() {
        this.familyTree.sortByName();
    }

    public void sortByAge() {
        this.familyTree.sortByAge();
    }

    public void sortByGender() {
        this.familyTree.sortByGender();
    }

    public String getFamilyTreeInfo() {
        return this.familyTree.toString();
    }

    public void saveFamilyTree() {
        FileOperationServise saveFamilyTree = new FileOperationServise();
        saveFamilyTree.saveFamilyTree(this.familyTree);
    }

    public void loadFamilyTree() throws ClassNotFoundException {
        FileOperationServise loadFamilyTree = new FileOperationServise();
        this.familyTree = loadFamilyTree.loadFamilyTree();
    }
}