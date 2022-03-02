package noor.serry.weather.InfoFromApi;

import noor.serry.weather.InfoFromApi.Main;

public class AllWeatherInfo {
    private Main main;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
