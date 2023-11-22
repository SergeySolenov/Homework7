package data.courses;

import data.menu.IMenu;

public enum SubTitleCourses implements IMenu {

    SUBTITLE_JAVA_QA_PRO( "Прокачайте свои навыки автоматизации тестирования на Java" );
    private final String name;
    SubTitleCourses(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
}
