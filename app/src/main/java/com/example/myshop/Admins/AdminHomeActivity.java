package com.example.myshop.Admins;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myshop.HomeActivity;
import com.example.myshop.MainActivity;
import com.example.myshop.R;

public class AdminHomeActivity extends AppCompatActivity {
    private Button maintainOrders,checkNewOrders,logoutButton,approveProductsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        maintainOrders=(Button) findViewById(R.id.maintain_button);
        checkNewOrders=(Button) findViewById(R.id.check_orders_button);
        logoutButton=(Button) findViewById(R.id.admin_logout_button);
        approveProductsButton=(Button) findViewById(R.id.check_approve_products);
        maintainOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHomeActivity.this, HomeActivity.class);
                intent.putExtra("Admin", "Admin");
                startActivity(intent);
            }
        });
        checkNewOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AdminHomeActivity.this,AdminNewOrdersActivity.class);
                startActivity(i);
            }
        });
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminHomeActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });
        approveProductsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AdminHomeActivity.this,AdminCheckNewProductsActivity.class);
                startActivity(i);
            }
        });


    }
}
