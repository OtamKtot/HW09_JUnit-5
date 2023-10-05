package guru.qa;

public enum Locale {
    DK ("da-dk"),
    ES ("es-es"),
    FR ("fr-fr");

    public final String localeString;

    private Locale(String localeString) {
        this.localeString = localeString;
    }
    @Override
    public String toString() {
        return localeString;
    }
}
