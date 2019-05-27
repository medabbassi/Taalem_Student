package com.yoo_devit.taalem_student.Activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.yoo_devit.taalem_student.R;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

public class SearchActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_explore:
                    Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                    startActivity(intent);
                case R.id.navigation_search:
                    Intent intent1 = new Intent(SearchActivity.this, SearchActivity.class);
                    startActivity(intent1);

                case R.id.navigation_library:
                    Intent intent2 = new Intent(SearchActivity.this, LibraryActivity.class);
                    startActivity(intent2);

                case R.id.navigation_profile:
                    Intent intent3 = new Intent(SearchActivity.this, ProfileActivity.class);
                    startActivity(intent3);
                case R.id.navigation_live:
                    Intent intent4=new Intent(SearchActivity.this,LiveActivity.class);
                    startActivity(intent4);

            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Toasty.success(SearchActivity.this,"Start search",Toasty.LENGTH_LONG,true).show();

    }
}
