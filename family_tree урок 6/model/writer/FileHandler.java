package family_tree.model.writer;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Human;
import family_tree.model.writer.FileHandlerInterface;

import java.io.*;

public class FileHandler implements FileHandlerInterface {

    public void write(FamilyTree<Human> obj, String fileName) {
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fileName, false));
            oos.writeObject(obj);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

 
    public FamilyTree read(String fileName) throws ClassNotFoundException {
        ObjectInputStream ois;
        FamilyTree obj = null;
        ;
        try {
            ois = new ObjectInputStream(new FileInputStream(fileName));
            obj = (FamilyTree) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return obj;
    }
}