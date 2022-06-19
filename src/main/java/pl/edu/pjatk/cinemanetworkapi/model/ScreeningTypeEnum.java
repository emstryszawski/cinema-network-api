package pl.edu.pjatk.cinemanetworkapi.model;

public enum ScreeningTypeEnum {
    II_D("2D"),
    III_D("3D");

    private final String screeningType;

    ScreeningTypeEnum(String screeningType) {
        this.screeningType = screeningType;
    }

    public String getScreeningType() {
        return screeningType;
    }
}
