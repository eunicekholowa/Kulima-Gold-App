package com.example.kulimagoldapplication.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kulimagoldapplication.Activities.ShowDetailsActivity;
import com.example.kulimagoldapplication.Domain.ProductDomain;
import com.example.kulimagoldapplication.R;

import java.util.ArrayList;


public class AvailableStockSAdapter extends RecyclerView.Adapter<AvailableStockSAdapter.ViewHolder> {

    ArrayList<ProductDomain> productDomains;

    public AvailableStockSAdapter(ArrayList<ProductDomain> productDomains){
        this.productDomains = productDomains;
    }


    @NonNull
    @Override
    public AvailableStockSAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_availablestock,parent,  false);

        return new AvailableStockSAdapter.ViewHolder(inflate);
    }




    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(productDomains.get(position).getTitle());
        holder.fee.setText(String.valueOf(productDomains.get(position).getFee()));
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(productDomains.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.picPic);
        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailsActivity.class);
                intent.putExtra( "object", productDomains.get(position ));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return productDomains.size();
    }
    public class ViewHolder  extends RecyclerView.ViewHolder{
        TextView title,fee;
        ImageView picPic;
        TextView addBtn;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.title);
            fee = itemView.findViewById(R.id.fee);
            picPic = itemView.findViewById(R.id.picPic);
            addBtn=itemView.findViewById(R.id.addBtn);
        }
    }
}