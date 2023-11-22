package data.courses;

import data.menu.IMenu;

public enum FormatCourses implements IMenu {
    FORMAT_JAVA_QA_PRO("Онлайн");
    private final String name;
    FormatCourses(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
