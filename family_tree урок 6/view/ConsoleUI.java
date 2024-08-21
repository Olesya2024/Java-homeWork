package family_tree.view;

import family_tree.model.human.Gender;
import family_tree.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;
    private AddHumanDataMenu addDataMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        menu = new MainMenu(this);
        addDataMenu = new AddHumanDataMenu(this);
        work = true;
    }

    @Override
    public void printAnswer(String answer) {
        System.err.println(answer);
    }


    public void start() {
        Menu();
        while (work) {
            printMenu();
            execute();
        }
    }

    public void finish() {
        goodbye();
        work = false;
    }

    private void execute() {
          String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            numCommand--;
            if (checkCommand(numCommand)) {
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkCommand(int numCommand) {
        if (numCommand <= menu.getSize()) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkTextForInt(String line) {
        if (line.matches("[0-8]+")) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    public void startAddDataMenu() {
        helloAddDataMenu();
        printAddDataMenu();
        executeAddDataMenu();
    }

    private void executeAddDataMenu() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            numCommand--;
            if (checkCommandAddDataMenu(numCommand)) {
                addDataMenu.execute(numCommand);
            }
        }
    }

    private boolean checkCommandAddDataMenu(int numCommand) {
        if (numCommand <= addDataMenu.getSize()) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    public void addHuman() {
        String name = nameRequest();
        String gender = String.valueOf(genderChoice());
        int year = yearRequest();
        int month = monthRequest();
        int day = dayRequest();
        presenter.addHuman(name, Gender.valueOf(gender), year, month, day);
    }

    private int dayRequest() {
        int day = 1;
        boolean flag = true;
        while (flag) {
            System.out.println("Введите день: ");
            int answer = scanner.nextInt();
            if (answer > 0 && answer < 32) {
                day = answer;
                flag = false;
            } else {
                inputError();
            }
        }
        return day;
    }

    private int monthRequest() {
        int month = 1;
        boolean flag = true;
        while (flag) {
            System.out.println("Введите месяц: ");
            int answer = scanner.nextInt();
            if (answer > 0 && answer < 13) {
                month = answer;
                flag = false;
            } else {
                inputError();
            }
        }
        return month;
    }

    private int yearRequest() {
        System.out.println("Введите год рождения: ");
        int year = scanner.nextInt();
        return year;
    }

    private String nameRequest() {
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        return name;
    }

    private int genderChoice() {
        boolean flag = true;
        int gender = 1;
        while (flag) {
            System.out.println("Введите пол: 1 - мужской, 2 - женский");
            int answer = scanner.nextInt();
            if (answer == 1 || answer == 2) {
                gender = answer;
                flag = false;
            } else {
                inputError();
            }
        }
        return gender;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByGender() {
        presenter.sortByGender();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void saveFamilyTreeData() {
        presenter.saveFamilyTree();
    }

    public void loadFamilyTreeData() throws ClassNotFoundException {
        presenter.loadFamilyTree();
    }

    public void getFamilyTreeInfo() {
        presenter.getFamilyTreeInfo();
    }

    private void inputError() {
        System.out.println("Введены неверные данные\n");
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    private void printAddDataMenu() {
        System.out.println(addDataMenu.menu());
    }

    private void Menu() {
        System.out.println("Меню Семейного Дерева");
    }

    private void helloAddDataMenu() {
        System.out.println("Меню добавления данных");
    }

    private void goodbye() {
        System.out.println("Выход");
    }

    public void setDateOfDeath() {

    }

    public void setHumanParents() {
    }

    public void setHumanSpouse() {

    }
}

