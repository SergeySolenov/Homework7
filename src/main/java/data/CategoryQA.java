package data;

import lombok.Getter;

@Getter
public enum CategoryQA {
    TESTING("Тестирование");
    private final String name;
    CategoryQA(String name) {
        this.name = name;
    }

}
