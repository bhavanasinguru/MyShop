package com.example.myshop.Seller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myshop.MainActivity;
import com.example.myshop.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SellerLoginActivity extends AppCompatActivity {

    private EditText userEmail,userPassword;
    private ProgressDialog loadingBar;
    private Button button;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadingBar=new ProgressDialog( this);
        mAuth=FirebaseAuth.getInstance();
        setContentView(R.layout.activity_seller_login);
        userEmail=(EditText) findViewById(R.id.seller_login_email);
        userPassword=(EditText) findViewById(R.id.seller_login_password);
        button=(Button) findViewById(R.id.regSeller_login_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginSeller();
            }
        });
    }

    private void loginSeller() {
        String  email=userEmail.getText().toString();
        String password=userPassword.getText().toString();
        if(!TextUtils.isEmpty(email) || !TextUtils.isEmpty(password))
        {
            loadingBar.setTitle("Logging into seller account");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.setMessage("Please wait");
            loadingBar.show();
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if(task.isSuccessful())
                    {
                        Intent i=new Intent(SellerLoginActivity.this,SellerHomeActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(i);
                        finish();
                    }
                }
            });

        }
        else
        {
            Toast.makeText(SellerLoginActivity.this,"Please enter both mail and password",Toast.LENGTH_SHORT).show();
        }
    }


}
