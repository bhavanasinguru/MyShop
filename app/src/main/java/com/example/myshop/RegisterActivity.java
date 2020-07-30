package com.example.myshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private Button createAccountButton;
    private EditText inputName,inputPhoneNumber,inputPassword;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        createAccountButton=(Button)findViewById(R.id.ConfirmRegister);
        inputName=(EditText) findViewById(R.id.register_userName);
        inputPhoneNumber=(EditText) findViewById(R.id.register_phoneNumber);
        inputPassword=(EditText) findViewById(R.id.register_passWord);
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        });

    }

    private void createAccount() {
        String name=inputName.getText().toString();
        String  phone=inputPhoneNumber.getText().toString();
        String password=inputPassword.getText().toString();
        loadingBar=new ProgressDialog(this);
        if(TextUtils.isEmpty(name))
        {
            Toast.makeText(RegisterActivity.this,"Please enter name",Toast.LENGTH_SHORT).show();
        }
         else if(TextUtils.isEmpty(phone))
        {
            Toast.makeText(RegisterActivity.this,"Please enter phone number",Toast.LENGTH_SHORT).show();
        }
         else if(TextUtils.isEmpty(password))
        {
            Toast.makeText(RegisterActivity.this,"Please enter password",Toast.LENGTH_SHORT).show();
        }
         else
        {
            loadingBar.show();
            loadingBar.setMessage("Please wait..");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();
            validatePhone(name,phone,password);

        }
    }

    private void validatePhone(final String name, final String phone, final String password){
        final DatabaseReference rootRef= FirebaseDatabase.getInstance().getReference();
        rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!dataSnapshot.child("Users").child(phone).exists()){

                    HashMap<String,Object> userDataMap=new HashMap<>();
                    userDataMap.put("phone",phone);
                    userDataMap.put("name",name);
                    userDataMap.put("password",password);
                    rootRef.child("Users").child(phone).updateChildren(userDataMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful())
                                    {
                                        loadingBar.dismiss();
                                        Toast.makeText(RegisterActivity.this,"Successful",Toast.LENGTH_SHORT).show();
                                        Intent intent4=new Intent(RegisterActivity.this,LoginActivity.class);
                                        startActivity(intent4);
                                    }
                                    else {
                                        loadingBar.dismiss();
                                        Toast.makeText(RegisterActivity.this,"Network Error",Toast.LENGTH_SHORT).show();
                                        Intent intent5=new Intent(RegisterActivity.this,MainActivity.class);
                                        startActivity(intent5);

                                    }
                                }
                            });



                }
                else
                {
                    Toast.makeText(RegisterActivity.this,"Phone Number already exists..Please try again",Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                    Intent intent3=new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent3);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
