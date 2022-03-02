package noor.serry.weather.retrofit;


import noor.serry.weather.InfoFromApi.AllWeatherInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Callloacl {
    api Api;

    public Callloacl(){
            Api = retrofit.getInstance ( ).create (api.class);
    }

    public void getAllWeatherInfo(String cityName,InfoForOneCity infoForOneCity){
        Call<AllWeatherInfo> call= Api.getWeatherInfo (cityName);
    call.enqueue (new Callback<AllWeatherInfo> ( ) {
        @Override
        public void onResponse(Call<AllWeatherInfo> call, Response<AllWeatherInfo> response) {
              infoForOneCity.getAllWeatherInfo (response.body ());
        }

        @Override
        public void onFailure(Call<AllWeatherInfo> call, Throwable t) {

        }
    });


    }


}
