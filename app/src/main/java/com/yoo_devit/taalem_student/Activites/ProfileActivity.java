package com.yoo_devit.taalem_student.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yoo_devit.taalem_student.ConnectionBeans.SharedPrefManager;
import com.yoo_devit.taalem_student.EditPasswordActivity;
import com.yoo_devit.taalem_student.R;

import es.dmoral.toasty.Toasty;

public class ProfileActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_explore:
                    Intent intent =new Intent(ProfileActivity.this,MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_search:
                    Intent intent1 =new Intent(ProfileActivity.this,SearchActivity.class);
                    startActivity(intent1);
                    return true;
                case R.id.navigation_live:
                    Intent intent4=new Intent(ProfileActivity.this,LiveActivity.class);
                    startActivity(intent4);
                case R.id.navigation_library:
                    Intent intent2=new Intent(ProfileActivity.this,LibraryActivity.class);
                    startActivity(intent2);
                    return true;
                case  R.id.navigation_profile:
                    Intent intent3=new Intent(ProfileActivity.this,ProfileActivity.class);
                    startActivity(intent3);
                    return true;
            }
            return false;
        }
    };

    private TextView Name,Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        Menu menu =bottomNavigationView.getMenu();
        MenuItem menuItem =menu.getItem(4);
        menuItem.setChecked(true);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Name=findViewById(R.id.name);
        Email=findViewById(R.id.email);

            Toasty.success(ProfileActivity.this,"Welcome",Toasty.LENGTH_LONG,true).show();
        if(!SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            Toasty.error(ProfileActivity.this, "Error to connect.", Toast.LENGTH_SHORT, true).show();
            startActivity(new Intent(this, LoginActivity.class));
            return;

        }
        Email.setText(SharedPrefManager.getInstance(this).getUserEmail());
        Name.setText(SharedPrefManager.getInstance(this).getFullName());





    }

    public void Edit(View view) {
        Intent intent=new Intent(this, EditPasswordActivity.class);
        startActivity(intent);
    }


    public void Logout(View view) {
        SharedPrefManager.getInstance(this).logout();
        finish();
        startActivity(new Intent(this,LoginActivity.class));

    }
}
