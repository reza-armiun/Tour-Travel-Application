package razarm.tosan.repository.domain.auth;

public enum PremiumType {
    NORMAL("NORMAL"),
    SILVER("SILVER"),
    GOLD("GOLD");

    private String name;
     PremiumType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
