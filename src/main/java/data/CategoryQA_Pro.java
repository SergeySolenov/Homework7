package data;

import lombok.Getter;

@Getter
public enum CategoryQA_Pro {
    JAVA_QA_PRO("java-qa-pro");

    private final String name;

    CategoryQA_Pro(String name) {
        this.name = name;
    }

}

