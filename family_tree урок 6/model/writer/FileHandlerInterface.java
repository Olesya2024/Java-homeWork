package family_tree.model.writer;


import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Human;

public interface FileHandlerInterface {

    public void write(FamilyTree<Human> obj, String fileName);

    public Object read(String fileName) throws ClassNotFoundException;

}