package com.yoo_devit.taalem_student.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;



import com.yoo_devit.taalem_student.R;

public class LibraryActivity extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_explore:
                    Intent intent =new Intent(LibraryActivity.this,MainActivity.class);
                    startActivity(intent);
                case R.id.navigation_search:
                    Intent intent1 =new Intent(LibraryActivity.this,SearchActivity.class);
                    startActivity(intent1);


                case R.id.navigation_library:
                    Intent intent2=new Intent(LibraryActivity.this,LibraryActivity.class);
                    startActivity(intent2);
                case  R.id.navigation_profile:
                    Intent intent3=new Intent(LibraryActivity.this,ProfileActivity.class);
                    startActivity(intent3);
                case R.id.navigation_live:
                    Intent intent4=new Intent(LibraryActivity.this,LiveActivity.class);
                    startActivity(intent4);
            }
            return false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library2);


        BottomNavigationView navView = findViewById(R.id.nav_view);
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        Menu menu =bottomNavigationView.getMenu();
        MenuItem menuItem =menu.getItem(3);
        menuItem.setChecked(true);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);






    }

}
