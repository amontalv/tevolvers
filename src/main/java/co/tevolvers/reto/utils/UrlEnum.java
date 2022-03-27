package co.tevolvers.reto.utils;

public enum UrlEnum {

    URI_CREATE_BOOKING("/booking"),
    URI_GET_BOOKING("/booking/"),
    URI_CREATE_TOKEN("/auth"),
    URI_UPDATE_BOOKING("/booking/");

    private String value;

    UrlEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
