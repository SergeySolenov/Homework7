package data.menu;



public enum HeaderMenu {

    LEARN("Обучение");

    private final String name;

    HeaderMenu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
