package data;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Month {

    JANUARY("января", "01"),
    FEBRUARY("февраля", "02"),
    MARCH("марта", "03"),
    APRIL("апреля", "04"),
    MAY ("мая", "05"),
    JUNE ("июня", "06"),
    JULY ("июля", "07"),
    AUGUST ("августа", "08"),
    SEPTEMBER ("сентября", "09"),
    OCTOBER ("октября", "10"),
    NOVEMBER ("ноября", "11"),
    DECEMBER ("декабря", "12");

    private final String name;
    private final String id;

    Month(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public static Month getDateData(String name) {
        return Arrays.stream(Month.values())
                .filter((Month month) -> month.getName().equals(name))
                .findFirst().get();
    }
}
