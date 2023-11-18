package data.menu;

import lombok.Getter;

@Getter
public enum SubMenuCategory implements ISubMenu{

    TESTING("/categories/testing"),

    LESSON_CALENDAR("/events/near");
    private final String name;


    SubMenuCategory(String name) {
        this.name = name;
    }


}
