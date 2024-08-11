package family_tree.util;

import java.io.*;

public class FileHandler implements FileHandlerInterface {
    @Override
    public void writeToFile(String filename, Serializable object) {
        File file = new File(filename);
        file.getParentFile().mkdirs(); 
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(object);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    @Override
    public Object readFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("Файл не найден. Будет создан новый файл при сохранении.");
            return null;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            return null;
        }
    }
}