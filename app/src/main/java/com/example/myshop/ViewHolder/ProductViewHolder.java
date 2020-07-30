package com.example.myshop.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myshop.Interface.ItemClickListener;
import com.example.myshop.R;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView productName,productDescription,productPrice;
    public ImageView productImage;
    public ItemClickListener listner;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        productImage=(ImageView) itemView.findViewById(R.id.product_image);
        productName=(TextView)itemView.findViewById(R.id.product_name);
        productDescription=(TextView) itemView.findViewById(R.id.product_description);
        productPrice=(TextView)itemView.findViewById(R.id.product_price);
    }
    public void setItemClickListener(ItemClickListener listner)
    {
        this.listner=listner;
    }

    @Override
    public void onClick(View v) {
        listner.onClick(v, getAdapterPosition(), false);

    }
}
