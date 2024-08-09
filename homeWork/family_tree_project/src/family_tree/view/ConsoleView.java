package family_tree.view;

import family_tree.model.Gender;
import family_tree.model.Human;
import family_tree.service.FamilyService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleView {
    private FamilyService service;
    private Scanner scanner;

    public ConsoleView(FamilyService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addHuman();
                    break;
                case 2:
                    displayAllHumans();
                    break;
                case 3:
                    displaySortedByName();
                    break;
                case 4:
                    displaySortedByBirthDate();
                    break;
                case 5:
                    saveToFile();
                    break;
                case 6:
                    loadFromFile();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n--- Меню Семейного Дерева ---");
        System.out.println("1. Добавить нового человека");
        System.out.println("2. Показать всех людей");
        System.out.println("3. Показать отсортированных по имени");
        System.out.println("4. Показать отсортированных по дате рождения");
        System.out.println("5. Сохранить в файл");
        System.out.println("6. Загрузить из файла");
        System.out.println("0. Выход");
        System.out.print("Введите ваш выбор: ");
    }

    private void addHuman() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите дату рождения (гггг-мм-дд): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.print("Введите пол (МУЖСКОЙ/ЖЕНСКИЙ): ");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase().equals("МУЖСКОЙ") ? "MALE" : "FEMALE");

        service.addHuman(name, birthDate, gender);
        System.out.println("Человек успешно добавлен.");
    }

    private void displayAllHumans() {
        System.out.println("\n--- Все люди ---");
        for (Human human : service.getAllHumans()) {
            System.out.println(human);
        }
    }

    private void displaySortedByName() {
        System.out.println("\n--- Люди, отсортированные по имени ---");
        for (Human human : service.sortByName()) {
            System.out.println(human);
        }
    }

    private void displaySortedByBirthDate() {
        System.out.println("\n--- Люди, отсортированные по дате рождения ---");
        for (Human human : service.sortByBirthDate()) {
            System.out.println(human);
        }
    }

    private void saveToFile() {
        service.saveToFile("data/familyTree.ser");
        System.out.println("Семейное дерево сохранено в файл.");
    }

    private void loadFromFile() {
        service.loadFromFile("data/familyTree.ser");
        System.out.println("Семейное дерево загружено из файла.");
    }
}