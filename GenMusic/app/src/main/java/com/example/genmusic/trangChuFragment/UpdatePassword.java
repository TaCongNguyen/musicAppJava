package com.example.genmusic.trangChuFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.genmusic.Model.User;
import com.example.genmusic.R;
import com.example.genmusic.UserSetting;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdatePassword extends AppCompatActivity {
    private EditText editTextOldPass, editTextNewPass, editTextCfNewPass;
    private Button btnUpdatePass;
    FirebaseAuth mAuth= FirebaseAuth.getInstance();
    private FirebaseUser user;
    private DatabaseReference mDBref;
    private String userID;
    private String oldpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);

        editTextOldPass = findViewById(R.id.oldPass);
        editTextNewPass = findViewById(R.id.newPass);
        editTextCfNewPass = findViewById(R.id.cfNewPass);
        btnUpdatePass = findViewById(R.id.btnUpdatePass);

        user = mAuth.getCurrentUser();
        mDBref = FirebaseDatabase.getInstance("https://gen-music-c99c9-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference();
        userID = user.getUid();
        mDBref.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);

                if(userProfile != null) {
                    oldpass = userProfile.password;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        btnUpdatePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangePass();
            }
        });



    }

    private void ChangePass() {
        String OldPass = editTextOldPass.getText().toString().trim();
        String NewPass = editTextNewPass.getText().toString().trim();
        String CfNewPass = editTextCfNewPass.getText().toString().trim();

        if(OldPass.isEmpty()) {
            editTextOldPass.setError("Email kh??ng ???????c ????? tr???ng");
            editTextOldPass.requestFocus();
            return;
        }

        if(!OldPass.equals(oldpass)) {
            editTextOldPass.setError("M???t kh???u kh??ng ????ng, vui l??ng th??? l???i!");
            editTextOldPass.requestFocus();
            return;
        }

        if(NewPass.isEmpty()) {
            editTextNewPass.setError("M???t kh???u kh??ng ???????c ????? tr???ng");
            editTextNewPass.requestFocus();
            return;
        }

        if(NewPass.length() < 6) {
            editTextNewPass.setError("M???t kh???u ph???i l???n h??n 6 k?? t???");
            editTextNewPass.requestFocus();
            return;
        }

        if(!CfNewPass.equals(NewPass)) {
            editTextCfNewPass.setError("M???t kh???u kh??ng tr??ng kh???p");
            editTextCfNewPass.requestFocus();
            return;
        }

        user.updatePassword(NewPass).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull  Task<Void> task) {
                if(task.isSuccessful()) {
                    mDBref.child(userID).child("password").setValue(NewPass);
                    Toast.makeText(UpdatePassword.this, "?????i m???t kh???u th??nh c??ng!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UpdatePassword.this, UserSetting.class));
                    finish();
                } else {
                    Toast.makeText(UpdatePassword.this, "?????i m???t kh???u kh??ng th??nh c??ng!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}