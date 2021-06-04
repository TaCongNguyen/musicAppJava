package com.example.genmusic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import org.w3c.dom.Text;

public class UserSetting extends AppCompatActivity {
    private ImageButton btnUserBack;
    TextView Name, Email;
    ImageView Image, Logout;
    GoogleSignInClient mGoogleSignInClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setting);

        btnUserBack = findViewById(R.id.btnUserBack);
        Name = findViewById(R.id.userName);
        Email = findViewById(R.id.userEmail);
        Image = (ImageView) findViewById(R.id.imgUser);
        Logout = findViewById(R.id.imgLogout);

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    // ...
                    case R.id.imgLogout:
                        signOut();
                        break;
                    // ...
                }
            }
        });

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);


        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();

            String personEmail = acct.getEmail();

            Uri personPhoto = acct.getPhotoUrl();

            Name.setText(personName);
            Email.setText(personEmail);
            //Glide.with(this).load(String.valueOf(personPhoto)).into(Image);


        }
        //Quay về Main Activity
        backToMainActivity();

    }



    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(UserSetting.this, "Logout Success!", Toast.LENGTH_LONG).show();
                        Intent intent= new Intent(UserSetting.this, LoginActivity.class);
                        startActivity(intent);
                    }
                });
    }

    private void backToMainActivity() {
        btnUserBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainIntent = getIntent();
                int index = MainIntent.getIntExtra("current_fragment",0);
                Intent intent = new Intent(UserSetting.this, MainActivity.class);
                intent.putExtra("current_fragment",index);
                startActivity(intent);
                finish();
            }
        });
    }
}