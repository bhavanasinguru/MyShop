package com.example.myshop.Seller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.myshop.R;

public class SelllerProductCategoryActivity extends AppCompatActivity {

    private ImageView tShirts, sportsTShirts, femaleDresses, sweaters;
    private ImageView glasses, hatsCaps, walletsBagsPurses, shoes;
    private ImageView headPhonesHandFree, Laptops, watches, mobilePhones;
    //private Button checkOrdersButton,logoutButton,maintainProductsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_add_category);
//        checkOrdersButton=(Button) findViewById(R.id.check_orders_button);
//        logoutButton=(Button) findViewById(R.id.admin_logout_button);
//        maintainProductsButton=(Button) findViewById(R.id.maintain_button);
//        maintainProductsButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SelllerProductCategoryActivity.this, HomeActivity.class);
//                intent.putExtra("Admin", "Admin");
//                startActivity(intent);
//            }
//        });
//        checkOrdersButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(SelllerProductCategoryActivity.this,AdminNewOrdersActivity.class);
//                startActivity(i);
//            }
//        });
//        logoutButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(SelllerProductCategoryActivity.this,MainActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(intent);
//                finish();
//            }
//        });
        tShirts=(ImageView)findViewById(R.id.tShirts);
        sportsTShirts=(ImageView) findViewById(R.id.sportsWear);
        femaleDresses=(ImageView)findViewById(R.id.femaleDresses);
        sweaters=(ImageView) findViewById(R.id.sweaters);
        glasses=(ImageView)findViewById(R.id.glasses);
        hatsCaps=(ImageView) findViewById(R.id.hats_caps);
        walletsBagsPurses=(ImageView)findViewById(R.id.purses_bags_wallets);
        shoes=(ImageView) findViewById(R.id.shoes);
        headPhonesHandFree=(ImageView)findViewById(R.id.headphones_handfree);
        Laptops=(ImageView) findViewById(R.id.laptop_pc);
        watches=(ImageView)findViewById(R.id.watches);
        mobilePhones=(ImageView) findViewById(R.id.mobilephones);

        tShirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SelllerProductCategoryActivity.this, SellerAddProductActivty.class);
                i.putExtra("category","T-Shirts");
                startActivity(i);
            }
        });
        sportsTShirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SelllerProductCategoryActivity.this, SellerAddProductActivty.class);
                i.putExtra("category","Sports T-Shirts");
                startActivity(i);
            }
        });
        femaleDresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SelllerProductCategoryActivity.this, SellerAddProductActivty.class);
                i.putExtra("category","Female-Dresses");
                startActivity(i);
            }
        });
        sweaters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SelllerProductCategoryActivity.this, SellerAddProductActivty.class);
                i.putExtra("category","Sweaters");
                startActivity(i);
            }
        });
        glasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SelllerProductCategoryActivity.this, SellerAddProductActivty.class);
                i.putExtra("category","Glasses");
                startActivity(i);
            }
        });
        hatsCaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SelllerProductCategoryActivity.this, SellerAddProductActivty.class);
                i.putExtra("category","Hats Caps");
                startActivity(i);
            }
        });
        walletsBagsPurses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SelllerProductCategoryActivity.this, SellerAddProductActivty.class);
                i.putExtra("category","Wallets Bags Purses");
                startActivity(i);
            }
        });
        shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SelllerProductCategoryActivity.this, SellerAddProductActivty.class);
                i.putExtra("category","Shoes");
                startActivity(i);
            }
        });
        headPhonesHandFree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SelllerProductCategoryActivity.this, SellerAddProductActivty.class);
                i.putExtra("category","HeadPhones");
                startActivity(i);
            }
        });
        Laptops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SelllerProductCategoryActivity.this, SellerAddProductActivty.class);
                i.putExtra("category","Laptops");
                startActivity(i);
            }
        });
        watches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SelllerProductCategoryActivity.this, SellerAddProductActivty.class);
                i.putExtra("category","Watches");
                startActivity(i);
            }
        });
        mobilePhones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SelllerProductCategoryActivity.this, SellerAddProductActivty.class);
                i.putExtra("category","Mobile Phones");
                startActivity(i);
            }
        });
    }
}
