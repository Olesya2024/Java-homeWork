package family_tree.model;

public enum Gender {
    MALE("Мужской"),
    FEMALE("Женский");

    private final String russianName;

    Gender(String russianName) {
        this.russianName = russianName;
    }

    public String getRussianName() {
        return russianName;
    }

    @Override
    public String toString() {
        return russianName;
    }
}