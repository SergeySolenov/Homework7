package data.menu;


public enum MenuCategory implements IMenu {
    TEST("Тестирование"),
    EVENTS_CALENDAR("Календарь мероприятий");
    private final String name;

    MenuCategory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
