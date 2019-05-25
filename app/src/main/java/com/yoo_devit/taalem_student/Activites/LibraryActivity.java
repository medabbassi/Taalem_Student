package com.yoo_devit.taalem_student.Activites;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.Toast;


import com.yoo_devit.taalem_student.Activites.Adapters.PageAdapter;
import com.yoo_devit.taalem_student.R;

public class LibraryActivity extends  TabActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_explore:
                    Intent intent =new Intent(LibraryActivity.this,MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_search:
                    Intent intent1 =new Intent(LibraryActivity.this,SearchActivity.class);
                    startActivity(intent1);
                    return true;
                case R.id.navigation_library:
                    Intent intent2=new Intent(LibraryActivity.this,LibraryActivity.class);
                    startActivity(intent2);
                    return true;
                case  R.id.navigation_profile:
                    Intent intent3=new Intent(LibraryActivity.this,ProfileActivity.class);
                    startActivity(intent3);
                    return true;
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
        MenuItem menuItem =menu.getItem(2);
        menuItem.setChecked(true);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost); // initiate TabHost
        TabHost.TabSpec spec; // Reusable TabSpec for each tab
        Intent intent; // Reusable Intent for each tab

        spec = tabHost.newTabSpec("My Courses"); // Create a new TabSpec using tab host
        spec.setIndicator("My Courses"); // set the “HOME” as an indicator
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent(this, coursesActivity.class);
        spec.setContent(intent);
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("My Files"); // Create a new TabSpec using tab host
        spec.setIndicator("My Files"); // set the “CONTACT” as an indicator
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent(this, FilesActivity.class);
        spec.setContent(intent);
        tabHost.addTab(spec);

        tabHost.setCurrentTab(1);
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                // display the name of the tab whenever a tab is changed
                Toast.makeText(getApplicationContext(), tabId, Toast.LENGTH_SHORT).show();
            }
        });




    }

}
