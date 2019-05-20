package com.yoo_devit.taalem_student.Activites;

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


import com.yoo_devit.taalem_student.Activites.Adapters.PageAdapter;
import com.yoo_devit.taalem_student.R;

public class LibraryActivity extends AppCompatActivity {

        private TabLayout tabLayout;
        private  TabItem mycourse,myfiles;
        private ViewPager viewPager;


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
        TabLayout tabLayout = findViewById(R.id.tablayout);
        TabItem tabCourse=findViewById(R.id.course);
        TabItem tabfile=findViewById(R.id.files);
        ViewPager viewPager = findViewById(R.id.viewpager);

        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        BottomNavigationView navView = findViewById(R.id.nav_view);
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        Menu menu =bottomNavigationView.getMenu();
        MenuItem menuItem =menu.getItem(2);
        menuItem.setChecked(true);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

}
