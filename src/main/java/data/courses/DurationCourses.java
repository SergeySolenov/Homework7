package data.courses;

import data.menu.IMenu;

public enum DurationCourses implements IMenu {
    DURATION_JAVA_QA_PRO("4 месяца");
    private final String name;
    DurationCourses(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
