package com.example.quiz1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.quiz1.data.UserData;
import com.example.quiz1.fragment.FragmentAdapter;
import com.example.quiz1.fragment.LoginFragment;
import com.example.quiz1.models.User;

import java.util.Vector;

public class ProfileActivity extends AppCompatActivity {

    EditText edtNewUsername;
    TextView tvUsernameProfile, tvEmailProfile, tvPhoneProfile;
    Button btnEdit, btnDelete, btnLogout;
    UserData userData;
    Vector<User> vectUser = UserData.getVectUser();
    FragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("Hi " + userData.getLoggedIn().getUsername() + "!");

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String email = intent.getStringExtra("email");
        String phone = intent.getStringExtra("phone");


        tvUsernameProfile = findViewById(R.id.tvUsernameProfile);
        tvUsernameProfile.setText(username);
        tvEmailProfile = findViewById(R.id.tvEmailProfile);
        tvEmailProfile.setText(email);
        tvPhoneProfile = findViewById(R.id.tvPhoneProfile);
        tvPhoneProfile.setText(phone);
        edtNewUsername= findViewById(R.id.Profile);
        btnEdit = findViewById(R.id.btnEditProfile);
        btnDelete = findViewById(R.id.btnDeleteProfile);
        btnLogout = findViewById(R.id.btnLogoutProfile);

        btnLogout.setOnClickListener( v -> {
            Log.wtf("before logout", UserData.getLoggedIn().getUsername());
            UserData.setLoggedIn(null);
            Log.wtf("logout", UserData.getLoggedIn().getUsername());
//            Intent intent1 = new Intent(this, LoginFragment.class);
//            fragmentAdapter.createFragment(0);
            //cara pindah ke fragment gimana weii
        });

        btnDelete.setOnClickListener( v -> {
            for (User allUser: vectUser) {
                if (allUser.getUsername().equals(UserData.getLoggedIn().getUsername())) {
                    Log.wtf("before delete", UserData.getLoggedIn().getUsername());
                    Log.wtf("before delete", allUser.getUsername());
                    UserData.setLoggedIn(null);
                    vectUser.remove(allUser.getId());
                    Log.wtf("after delete", allUser.getUsername());
                    Log.wtf("after delete", UserData.getLoggedIn().getUsername());
//                    Intent intent1 = new Intent(this, LoginFragment.class);
//                    startActivity(intent1);
                    break;
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home :
                startActivity(new Intent(ProfileActivity.this, HomeActivity.class));
                Log.wtf("test", "Masuk Home");
                break;
            case R.id.profile :
                Log.wtf("test", "Masuk Profile");
                break;
            case R.id.history :
                Intent intent2 = new Intent(this, HistoryActivity.class);
                int userId = userData.getLoggedIn().getId();
                intent2.putExtra("userId", userData.getLoggedIn().getId());
                userId = intent2.getIntExtra("userId", 0);
                startActivity(intent2);
                startActivity(new Intent(ProfileActivity.this, HistoryActivity.class));
                Log.wtf("test", "Masuk History");
                break;
        }

        return super.onOptionsItemSelected(item);
    }



    private Object getActivity() {
        return 3;
    }
}