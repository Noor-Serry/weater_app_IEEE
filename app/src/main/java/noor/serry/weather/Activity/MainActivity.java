package noor.serry.weather.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.util.ArrayList;

import noor.serry.weather.Adapter.CustomAdapter;
import noor.serry.weather.R;
import noor.serry.weather.retrofit.Callloacl;
import noor.serry.weather.retrofit.InfoForOneCity;
import noor.serry.weather.InfoFromApi.AllWeatherInfo;

public class MainActivity extends AppCompatActivity {
      ArrayList<AllWeatherInfo> arrayList;
      RecyclerView recyclerView;
      CustomAdapter recyclerAdapter;
      Callloacl call;
      ArrayList <String>defultCity;
      AutoCompleteTextView autoComplete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        recyclerView = findViewById (R.id.RecyclerView);
        autoComplete = findViewById (R.id.AutoComplete);

        setLayoutManager ();
        setDefultCity ();
        setInfoInArray ();
        fillAutoCompleteView ();

    }
    public void setLayoutManager(){
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager (getBaseContext ());
        recyclerView.setLayoutManager (layoutManager);
    }

    public void setDefultCity(){
        defultCity=new ArrayList<> ();
        defultCity.add ("cairo");defultCity.add ("Marsá Maţrūḩ");
        defultCity.add ("Alexandra");defultCity.add ("Munūf");

    }
    public void setInfoInArray(){
        arrayList=new ArrayList<> ();
        call=new Callloacl ();
        for(int i=0;i<defultCity.size ();i++) {
            call.getAllWeatherInfo (defultCity.get (i), new InfoForOneCity ( ) {
                @Override
                public void getAllWeatherInfo(AllWeatherInfo allWeatherInfo) {
                    arrayList.add (allWeatherInfo);
                    recyclerAdapter = new CustomAdapter (arrayList, getBaseContext ( ));
                    recyclerView.setAdapter (recyclerAdapter);
                }
            });
        }
    }
public void onClick(View view){
        String city=autoComplete.getText ().toString ();
        call.getAllWeatherInfo (city, new InfoForOneCity ( ) {
            @Override
            public void getAllWeatherInfo(AllWeatherInfo allWeatherInfo) {
                if (allWeatherInfo != null) {
                    arrayList.add (0, allWeatherInfo);
                    recyclerAdapter = new CustomAdapter (arrayList, getBaseContext ( ));
                    recyclerView.setAdapter (recyclerAdapter);
                } else {
                    Toast.makeText (getBaseContext ( ), getString (R.string.Error), Toast.LENGTH_SHORT).show ( );
                }
            }});
}
public void fillAutoCompleteView(){
        String []array= getResources ( ).getStringArray (R.array.autuCompleteCity);
        ArrayAdapter<String> adapter;
        adapter=new ArrayAdapter<> (this, android.R.layout.simple_list_item_1,array);
    autoComplete.setAdapter (adapter);
}




}