package com.yoo_devit.taalem_student.ConnectionBeans;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {

    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private static final String SHARED_PREF_NAME = "mysharedpref12";
   // private static final String KEY_USERNAME = "username";
    private static final String KEY_USER_EMAIL = "useremail";
    private static final String Key_USER_NAME="userfullname";
    //private static final  String KEY_USER_JOB="userjob";
    private static final String KEY_USER_ID = "userid";
    private static final  String KEY_USER_PASSWORD="userpassword";
    //private  static final String KEY_USER_PHONE="phone";
    private static final  String KEY_USER_COURSE="coursename";
    private static final  String KEY_USER_NBCHCOURSE="nbchpter";
    private static final  String KEY_USER_COURSEDESC="description";
    private static final  String KEY_USER_COURSEIMAGE="image";
    private static final  String KEY_USER_COURSEFILE="file";


    private SharedPrefManager(Context context) {
        mCtx = context;

    }



    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }



    public boolean userLogin(int id, String email,String fullname){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //editor.putInt(KEY_USER_ID, id);
        editor.putString(KEY_USER_EMAIL, email);
       // editor.putString(KEY_USERNAME, username);
        editor.putString(Key_USER_NAME,fullname);
        //editor.putString(KEY_USER_JOB,job);
        //editor.putString(KEY_USER_PHONE,phone);


        editor.apply();

        return true;
    }

            public boolean resetPassword(String password){

                SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.putString(KEY_USER_PASSWORD,password);
                        editor.apply();
                        return true;
            }
    public boolean courseSave(int id, String coursename,String coursenbchapter,String images,String file){
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        return true;
    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if(sharedPreferences.getString(KEY_USER_EMAIL, null) != null){
            return true;
        }
        return false;
    }

    public boolean logout(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }

    public String getUserId(){
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_ID,null);
    }

   /* public String getUsername(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME, null);
    }*/

    public String getUserEmail(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_EMAIL, null);
    }
    public String getFullName(){

        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return  sharedPreferences.getString(Key_USER_NAME,null);
    }
    /*public String getUserJob(){
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return  sharedPreferences.getString(KEY_USER_JOB,null);
    }*/
    /*public String getUserPhone(){
        SharedPreferences sharedPreferences=mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return  sharedPreferences.getString(KEY_USER_PHONE,null);
    }*/

}
