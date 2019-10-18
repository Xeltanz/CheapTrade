package hu.elte.alkfejl.cheaptrade.domain.item;

/*
 * divat, műszaki cikk, sport, autó, otthon, kert, mobiltelefon, szórakozás, ingatlan
 *
 * */

public enum Category {
    ANTIQUES("antik, régiség"),
    ART("művészetek"),
    ELECTRONICS("elektronika"),
    BOOKS("könyvek"),
    CAMERAS("kamera, fényképezőgép"),
    CARS("autó, motor"),
    FASHION("divat, ruházat"),
    JEWELLERY("ékszerek"),
    MUSIC("zene, film"),
    SPORTS("sport, szabadidő"),
    TOYS("játékok"),
    OTHER("egyéb");

    private String categoryName;

    Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return categoryName;
    }
}

