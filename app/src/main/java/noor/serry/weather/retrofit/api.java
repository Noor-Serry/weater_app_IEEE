package noor.serry.weather.retrofit;

import noor.serry.weather.InfoFromApi.AllWeatherInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface api {

    @GET("data/2.5/weather?&appid=b22afff598351b47f70a22f49feb55cd")
    Call<AllWeatherInfo> getWeatherInfo(@Query("q") String city);
}
