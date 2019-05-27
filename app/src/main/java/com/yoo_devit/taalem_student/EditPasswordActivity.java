package com.yoo_devit.taalem_student;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class EditPasswordActivity extends AppCompatActivity {
    private EditText EmailVerif;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_password);

        EmailVerif=findViewById(R.id.editText);





    }
}
