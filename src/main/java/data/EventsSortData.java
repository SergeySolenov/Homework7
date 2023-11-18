package data;

import lombok.Getter;

@Getter
public enum EventsSortData {
    OPENWEB("Открытый вебинар", "Открытый вебинар");

    private final String nameFilter;
    private final String namePage;

    EventsSortData(String nameFilter, String namePage ) {
        this.nameFilter = nameFilter;
        this.namePage = namePage;
    }

}

