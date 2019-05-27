package com.yoo_devit.taalem_student;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.yoo_devit.taalem_student.Activites.PasswordResetActivity;
import com.yoo_devit.taalem_student.ConnectionBeans.SharedPrefManager;

public class EditPasswordActivity extends AppCompatActivity {
    private EditText EmailVerif;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_password);

        EmailVerif=findViewById(R.id.editText);




    }

    public boolean EmailVerify(){
        Boolean valid=true;
        if(EmailVerif.equals(SharedPrefManager.getInstance(this).getUserEmail())){
            Intent intent=new Intent(this, PasswordResetActivity.class);
            startActivity(intent);
        }
        else {
            valid=false;
        }
        return valid;


    }

    public void Verify(View view) {
        EmailVerify();

    }
}
