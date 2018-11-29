package steam.enums;

public enum Tabs {
    GENRE("genre"), FORYOU("foryou"), SOFTWARE("software"), HARDWARE("hardware"), VIDEOS("videos");

    private final String tab;

    Tabs(String tab) {
        this.tab = tab;
    }

    @Override
    public String toString() {
        return tab;
    }
}
