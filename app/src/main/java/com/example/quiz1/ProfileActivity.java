package com.example.quiz1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz1.data.UserData;
import com.example.quiz1.fragment.FragmentAdapter;
import com.example.quiz1.fragment.LoginFragment;
import com.example.quiz1.models.User;

import java.util.Vector;

public class ProfileActivity extends AppCompatActivity {

    EditText edtNewUsername;
    TextView tvUsernameProfile, tvEmailProfile, tvPhoneProfile;
    Button btnEdit, btnDelete, btnLogout, btnSave;
    UserData userData;
    Vector<User> vectUser = UserData.getVectUser();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("Hi " + userData.getLoggedIn().getUsername() + "!");

        intent = getIntent();
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");

        edtNewUsername = findViewById(R.id.edtUsername);
        tvUsernameProfile = findViewById(R.id.txtContentUsername);
        tvEmailProfile = findViewById(R.id.txtContentEmail);
        tvPhoneProfile = findViewById(R.id.txtContentPhone);

        tvUsernameProfile.setText(username);
        tvEmailProfile.setText(email);
        tvPhoneProfile.setText(phone);

        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);
        btnLogout = findViewById(R.id.btnLogOut);
        btnSave = findViewById(R.id.btnSave);

        btnEdit.setOnClickListener(v -> {
            btnEdit.setVisibility(View.GONE);
            btnSave.setVisibility(View.VISIBLE);

            edtNewUsername.setVisibility(View.VISIBLE);
            edtNewUsername.setText(username);
            tvUsernameProfile.setVisibility(View.GONE);
        });

        btnSave.setOnClickListener(v -> {
//            btnEdit.setVisibility(View.VISIBLE);
//            btnSave.setVisibility(View.GONE);

//            edtNewUsername.setVisibility(View.GONE);

            String newUsername = edtNewUsername.getText().toString();

            if (newUsername.length() < 3 || newUsername.length() > 20) {
                Toast.makeText(this, "Min 3 characters", Toast.LENGTH_LONG).show();
            } else if(newUsername.length() > 20) {
                Toast.makeText(this, "Max 20 characters", Toast.LENGTH_LONG).show();
            } else {
                btnEdit.setVisibility(View.VISIBLE);
                btnSave.setVisibility(View.GONE);
                edtNewUsername.setVisibility(View.GONE);
                tvUsernameProfile.setText(newUsername);

                userData.getLoggedIn().setUsername(newUsername);
                tvUsernameProfile.setVisibility(View.VISIBLE);
                tvUsernameProfile.setText(newUsername);

                Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();

                // Code dibawah akan digunakan untuk menginput data hasil edit profile ke database
                // =============================================================================

//                userData.changeUsername(this, newUsername); //masih error -> dia lgsung nutup

                // ==============================================================================
            }

//            tvUsernameProfile.setVisibility(View.VISIBLE);
        });


        btnDelete.setOnClickListener(v -> {
            for (User allUser: vectUser) {
                if (allUser.getUsername().equals(UserData.getLoggedIn().getUsername())) {
                    Toast.makeText(getApplicationContext(), "User " + UserData.getLoggedIn().getUsername() + " is Deleted!", Toast.LENGTH_LONG).show();
                    UserData.setLoggedIn(null);
                    vectUser.remove(allUser.getId() - 1);
                    Intent intent1 = new Intent(this, MainActivity.class);
                    startActivity(intent1);
                    break;
                }
            }
        });

        btnLogout.setOnClickListener(v -> {
            Log.wtf("before logout", UserData.getLoggedIn().getUsername());
            Toast.makeText(getApplicationContext(), "Logout From " + UserData.getLoggedIn().getUsername() + " is Successful!", Toast.LENGTH_LONG).show();
            UserData.setLoggedIn(null);
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });


        //Codingan di bawah ini adalah arsip lama dari project individu tanpa database dan dengan ui yg berbeda
        // ==================================================================================================
//        tvUsernameProfile = findViewById(R.id.tvUsernameProfile);
//        tvUsernameProfile.setText(username);
//        tvEmailProfile = findViewById(R.id.tvEmailProfile);
//        tvEmailProfile.setText(email);
//        tvPhoneProfile = findViewById(R.id.tvPhoneProfile);
//        tvPhoneProfile.setText(phone);
//        edtNewUsername= findViewById(R.id.Profile);
//        btnEdit = findViewById(R.id.btnEditProfile);
//        btnDelete = findViewById(R.id.btnDeleteProfile);
//        btnLogout = findViewById(R.id.btnLogoutProfile);
//
//        btnEdit.setOnClickListener( v -> {
//            for (User updateUser: vectUser) {
//                if (updateUser.getUsername().equals(edtNewUsername.getText().toString())) {
//                    Toast.makeText(getApplicationContext(), "Username " + edtNewUsername.getText().toString() + " Already Exist!", Toast.LENGTH_LONG).show();
//                    break;
//                } else if(updateUser.getUsername().equals(UserData.getLoggedIn().getUsername())) {
//                    updateUser.setUsername(edtNewUsername.getText().toString());
//                    UserData.setLoggedIn(vectUser.get(updateUser.getId() - 1));
//                    break;
//                }
//            }
//            Intent intent1 = new Intent(this, ProfileActivity.class);
//            intent1.putExtra("username", userData.getLoggedIn().getUsername());
//            intent1.putExtra("email", userData.getLoggedIn().getEmailAddress());
//            intent1.putExtra("phone", userData.getLoggedIn().getPhoneNum());
//            Toast.makeText(getApplicationContext(), "Username Has Been Updated!", Toast.LENGTH_LONG).show();
//            startActivity(intent1);
//        });
//
//        btnLogout.setOnClickListener( v -> {
//            Log.wtf("before logout", UserData.getLoggedIn().getUsername());
//            Toast.makeText(getApplicationContext(), "Logout From " + UserData.getLoggedIn().getUsername() + " is Successful!", Toast.LENGTH_LONG).show();
//            UserData.setLoggedIn(null);
//            Intent intent1 = new Intent(this, MainActivity.class);
//            startActivity(intent1);
//        });
//
//        btnDelete.setOnClickListener( v -> {
//            for (User allUser: vectUser) {
//                if (allUser.getUsername().equals(UserData.getLoggedIn().getUsername())) {
//                    Toast.makeText(getApplicationContext(), "User " + UserData.getLoggedIn().getUsername() + " is Deleted!", Toast.LENGTH_LONG).show();
//                    UserData.setLoggedIn(null);
//                    vectUser.remove(allUser.getId() - 1);
//                    Intent intent1 = new Intent(this, MainActivity.class);
//                    startActivity(intent1);
//                    break;
//                }
//            }
//        });
        // ==================================================================================================

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.home :
//                startActivity(new Intent(ProfileActivity.this, HomeActivity.class));
//                Log.wtf("test", "Masuk Home");
//                break;
//            case R.id.profile :
//                Log.wtf("test", "Masuk Profile");
//                break;
//            case R.id.history :
//                intent = new Intent(this, HistoryActivity.class);
//                int userId = userData.getLoggedIn().getId();
//                intent.putExtra("userId", userData.getLoggedIn().getId());
//                userId = intent.getIntExtra("userId", 0);
//                startActivity(intent);
//                Log.wtf("test", "Masuk History");
//                break;
//            case R.id.about :
//                intent = new Intent(this, AboutActivity.class);
//                startActivity(intent);
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//
//
//    private Object getActivity() {
//        return 3;
//    }
}