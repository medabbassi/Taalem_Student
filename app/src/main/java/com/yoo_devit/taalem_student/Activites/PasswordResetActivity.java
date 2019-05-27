package com.yoo_devit.taalem_student.Activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import com.yoo_devit.taalem_student.R;

public class PasswordResetActivity extends AppCompatActivity {

    private EditText Password,Conpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset);
        Password=findViewById(R.id.password);
        Conpassword=findViewById(R.id.conpassword);


    }




    public void Reset(View view) {



    }
    public boolean VerifyInsert(){
        Boolean match=true;
        String password=Password.getText().toString();
        String conpassowrd=Conpassword.getText().toString();



        return match;

    }
}
