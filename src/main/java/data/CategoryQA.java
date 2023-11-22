package data;

public enum CategoryQA {
    TESTING("Тестирование");

    private final String name;
    CategoryQA(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
