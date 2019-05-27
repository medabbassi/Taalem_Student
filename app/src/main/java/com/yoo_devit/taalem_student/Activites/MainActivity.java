package com.yoo_devit.taalem_student.Activites;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.yoo_devit.taalem_student.Beans.Course;
import com.yoo_devit.taalem_student.ConnectionBeans.Constants;
import com.yoo_devit.taalem_student.Activites.Adapters.CourseAdapter;
import com.yoo_devit.taalem_student.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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
                case R.id.navigation_live:
                    Intent intent4=new Intent(MainActivity.this,LiveActivity.class);
                    startActivity(intent4);
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

    List<Course> courseList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //init  course list
        courseList =new ArrayList<>();

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        Menu menu =bottomNavigationView.getMenu();
        MenuItem menuItem =menu.getItem(0);
        menuItem.setChecked(true);
        loadCourse();
    }



    private void loadCourse(){
        StringRequest stringRequest= new StringRequest(Request.Method.GET,
                Constants.URL_COURSE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject course = array.getJSONObject(i);

                        courseList.add(new Course(
                                course.getInt("id"),
                                course.getString("cname"),
                                course.getString("cchapter"),
                                course.getString("csshortdesc"),
                                course.getString("Cfee")
                                /*course.getString("cimage")*/));
                    }
                    CourseAdapter adapter = new CourseAdapter(MainActivity.this, courseList);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        Volley.newRequestQueue(this).add(stringRequest);
    }
}
