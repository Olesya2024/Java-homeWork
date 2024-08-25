package family_tree.presenter;

import family_tree.model.human.Gender;
import family_tree.model.service.FileOperationServise;
import family_tree.model.service.Service;
import family_tree.view.View;

public class Presenter {
    private final View view;
    private final Service service;

    public Presenter(View view,
    FileOperationServise fileOperationServise) {
            this.view = view;
            service = new Service(fileOperationServise);
        }

    //        this.view = view;
//        service = new Service();
//    }
public void addHuman(String name, Gender gender, int year, int month, int day) {
    service.addHuman(name, gender, year, month, day);
    getFamilyTreeInfo();
}


    public void setDateOfDeath(int id, int year, int month, int day) {
        service.setHumanDateOfDeath(id, year, month, day);
        getFamilyTreeInfo();
    }

    public void setHumanParents(int humanId, int fatherId, int motherId) {
        service.setHumanParents(humanId, fatherId, motherId);
        getFamilyTreeInfo();
    }

    public void setHumanSpouse(int humanId, int spouseId) {
        service.setHumanSpouse(humanId, spouseId);
        getFamilyTreeInfo();
    }

    public void sortByName() {
        service.sortByName();
        getFamilyTreeInfo();
    }

    public void sortByGender() {
        service.sortByGender();
        getFamilyTreeInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getFamilyTreeInfo();
    }

    public void saveFamilyTree() {
        service.saveFamilyTree();
        String info = "Данные сохранены";
        view.printAnswer(info);
    }

    public void loadFamilyTree() throws ClassNotFoundException {
        service.loadFamilyTree();
        String info = "Данные загружены";
        view.printAnswer(info);
    }

    public void getFamilyTreeInfo() {
        String info = service.getFamilyTreeInfo();
        view.printAnswer(info);
    }

}