package firas.karbich.com.wakalni.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import firas.karbich.com.wakalni.Models.RestaurantModel;
import firas.karbich.com.wakalni.R;


public class RestaurantsRecyclerAdapter extends RecyclerView.Adapter<RestaurantsRecyclerAdapter.RestaurantViewHolder> {

    Context context;
    private ArrayList<RestaurantModel> restaurants = new ArrayList<RestaurantModel>();
    private OnRestaurantListener onRestaurantListener;

    public RestaurantsRecyclerAdapter(Context context, ArrayList<RestaurantModel> restaurants,OnRestaurantListener onRestaurantListener) {
        this.context = context;
        this.restaurants = restaurants;
        this.onRestaurantListener = onRestaurantListener;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.restaurant_item, parent, false);
        return new RestaurantViewHolder(view, onRestaurantListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        holder.name.setText(restaurants.get(position).getName());
        holder.location.setText(restaurants.get(position).getAdresse());

        // ImageView  using Glid Library
        Glide.with(holder.itemView.getContext())
                .load(restaurants.get(position))
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        if (restaurants != null){
            return restaurants.size();
        }
        return 0;
    }

    public void setRestaurants(ArrayList<RestaurantModel> restaurants) {
        this.restaurants = restaurants;
        notifyDataSetChanged();
    }

    public class RestaurantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name, location, services, seemore;
        ImageView image;
        OnRestaurantListener onRestaurantListener;

        public RestaurantViewHolder(@NonNull View itemView, OnRestaurantListener onRestaurantListener) {
            super(itemView);
            this.onRestaurantListener = onRestaurantListener;
            name =itemView.findViewById(R.id.restaurantName);
            location =itemView.findViewById(R.id.restaurantLocation);
            services =itemView.findViewById(R.id.restaurantServices);
            seemore =itemView.findViewById(R.id.restaurantSeemore);
            image =itemView.findViewById(R.id.restaurantImage);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onRestaurantListener.onRestaurantClick(getAdapterPosition());
        }
    }
}
