package data.menu;

import lombok.Getter;

@Getter
public enum HeaderMenu {

    LEARN("Обучение");

    private final String name;

    HeaderMenu(String name) {
        this.name = name;
    }

}
