package firas.karbich.com.wakalni.Asapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import firas.karbich.com.wakalni.Models.ProductModel;
import firas.karbich.com.wakalni.R;


public class ProductsRecyclerAdapter extends RecyclerView.Adapter<ProductsRecyclerAdapter.ProductViewHolder> {

    Context context;
    ArrayList<ProductModel> products = new ArrayList<ProductModel>();
    private OnProductListener onProductListener;

    public ProductsRecyclerAdapter(Context context, ArrayList<ProductModel> products, OnProductListener onProductListener) {
        this.context = context;
        this.products = products;
        this.onProductListener = onProductListener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.product_item, parent, false);
        return new ProductViewHolder(view, onProductListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.name.setText(products.get(position).getFoodWithExtras().getFood().getLibelle());
        holder.foodPrix.setText(String.valueOf(products.get(position).getFoodWithExtras().getFood().getPrix()));

        // ImageView  using Glid Library
        Glide.with(holder.itemView.getContext())
                .load(products.get(position))
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        if (products != null){
            return products.size();
        }
        return 0;
    }

    public void setProducts(ArrayList<ProductModel> products) {
        this.products = products;
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name, foodPrix;
        Button addToCart;
        ImageView image;
        OnProductListener onProductListener;

        public ProductViewHolder(@NonNull View itemView, OnProductListener onProductListener) {
            super(itemView);
            this.onProductListener = onProductListener;
            name = itemView.findViewById(R.id.foodName);
            foodPrix = itemView.findViewById(R.id.foodPrix);
            addToCart = itemView.findViewById(R.id.addToCartbtn);
            image =itemView.findViewById(R.id.foodImage);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onProductListener.onProductClick(getAdapterPosition());
        }
    }
}
