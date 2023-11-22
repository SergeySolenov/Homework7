package data.courses;

import data.menu.IMenu;

public enum TitleCourses implements IMenu {
    TITLE_JAVA_QA_PRO("Java QA Engineer. Professional");
    private final String name;
    TitleCourses(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
