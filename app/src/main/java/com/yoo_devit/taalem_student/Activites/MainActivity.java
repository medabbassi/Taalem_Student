package com.yoo_devit.taalem_student.Activites;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.yoo_devit.taalem_student.R;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_explore:
                    Intent intent =new Intent(MainActivity.this,MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_search:
                    Intent intent1 =new Intent(MainActivity.this,SearchActivity.class);
                    startActivity(intent1);
                    return true;
                case R.id.navigation_library:
                    Intent intent2=new Intent(MainActivity.this,LibraryActivity.class);
                    startActivity(intent2);
                    return true;
                case  R.id.navigation_profile:
                       Intent intent3=new Intent(MainActivity.this,ProfileActivity.class);
                       startActivity(intent3);
                        return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        Menu menu =bottomNavigationView.getMenu();
        MenuItem menuItem =menu.getItem(0);
        menuItem.setChecked(true);
    }
}
