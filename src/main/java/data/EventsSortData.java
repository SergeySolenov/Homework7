package data;


public enum EventsSortData {
    OPENWEB("Открытый вебинар", "Открытый вебинар");

    private final String nameFilter;
    private final String namePage;

    EventsSortData(String nameFilter, String namePage ) {
        this.nameFilter = nameFilter;
        this.namePage = namePage;
    }

    public String getNamePage() {
        return namePage;
    }

    public String getNameFilter() {
        return nameFilter;
    }
}

