package noor.serry.weather.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import noor.serry.weather.InfoFromApi.AllWeatherInfo;
import noor.serry.weather.R;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Holder> {
    ArrayList<AllWeatherInfo> arrayList;
    Context context;
    public CustomAdapter (ArrayList <AllWeatherInfo> arrayList, Context context){
        this.arrayList=arrayList;
        this.context=context;
    }
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           View view= LayoutInflater.from (context).inflate (R.layout.view_holde,parent,false);
        return new Holder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
         holder.city.setText ("City :"+arrayList.get (position).getName ());
         int min_temp=(int)(arrayList.get (position).getMain ().getTempMin ()-273.15);
         int max_temp=(int)(arrayList.get (position).getMain ().getTempMax ()-273.15);
         holder.minTemp.setText ("temp_min :"+min_temp);
         holder.maxTemp.setText ("temp_max :"+max_temp);

    }

    @Override
    public int getItemCount() {
        return arrayList.size ();
    }

    protected class Holder extends RecyclerView.ViewHolder{
TextView city,minTemp,maxTemp;
        public Holder(@NonNull View itemView) {
            super (itemView);
            this.city=itemView.findViewById (R.id.city);
            this.maxTemp=itemView.findViewById (R.id.temp_max);
            this.minTemp=itemView.findViewById (R.id.temp_min);
        }
    }
}
