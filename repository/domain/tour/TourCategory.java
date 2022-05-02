package razarm.tosan.repository.domain.tour;

public enum TourCategory {
    DESERT("desert"),
    CITY("city"),
    VILLAGE("village"),
    ECO("eco"),
    FOREIGN("foreign"),
    TOURIST("tourist");

    private final String name;

    TourCategory(String name) {
        this.name = name;
    }
}
