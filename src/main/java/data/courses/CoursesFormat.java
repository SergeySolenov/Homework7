package data.courses;

import lombok.Getter;

@Getter
public enum CoursesFormat {
    JAVA_QA_PRO("//p[contains(text(),'Онлайн')]");

    private final String name;

    CoursesFormat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
