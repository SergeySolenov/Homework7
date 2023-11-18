package data.courses;

public enum CoursesDuration {
    JAVA_QA_PRO("//p[contains(text(),'4 месяца')]");

    private String name;

    CoursesDuration(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
