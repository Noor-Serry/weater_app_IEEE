package noor.serry.weather.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofit {
    private static Retrofit instance;


    public static synchronized Retrofit getInstance(){
        if(instance==null){

            instance=new Retrofit.Builder ().baseUrl ("https://api.openweathermap.org/").addConverterFactory (GsonConverterFactory.create ())
                    .build ();
        }
        return instance;
    }


}
