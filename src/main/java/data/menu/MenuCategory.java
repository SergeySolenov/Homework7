package data.menu;

import lombok.Getter;

@Getter
public enum MenuCategory implements ISubMenu{
    TEST("Тестирование"),
    EVENTS_CALENDAR("Календарь мероприятий");
    private final String name;

    MenuCategory(String name) {
        this.name = name;
    }

}
