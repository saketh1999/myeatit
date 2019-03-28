package com.example.eat2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {
    TextView textView1;
    private TextView nameView;
    private TextView passwordView;
    private TextView phoneView;
    private Button signUP;
    DatabaseReference databaseReference;
    public void signFunction(View view){
        EditText nameView=findViewById(R.id.nameView);
        EditText passwordView=findViewById(R.id.passwordView);
        EditText phoneView=findViewById(R.id.phoneView);
        Log.i("name",nameView.getText().toString());
        Log.i("name",passwordView.getText().toString());
        Log.i("name",phoneView.getText().toString());


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        databaseReference= FirebaseDatabase.getInstance().getReference("costumer");
        textView1=findViewById(R.id.txtView1);
        nameView=findViewById(R.id.nameView);
        passwordView=findViewById(R.id.passwordView);
        phoneView=findViewById(R.id.phoneView);
        textView1.animate().translationYBy(-700).setDuration(2000);
        nameView.animate().alpha(1).setDuration(4000);
        passwordView.animate().alpha(1).setDuration(4000);
        phoneView.animate().alpha(1).setDuration(4000);
        signUP=findViewById(R.id.signUp);
        signUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCostumer();
            }
        });




    }
    public  void addCostumer(){
        String costumerName=nameView.getText().toString();
        String password= passwordView.getText().toString();
        String phoneNumber=phoneView.getText().toString();
        if (!TextUtils.isEmpty(costumerName)&&!TextUtils.isEmpty(password)&&!TextUtils.isEmpty(phoneNumber)){
                String id=databaseReference.push().getKey();
                Names names=new Names( id, costumerName  ,  password, phoneNumber);
                    databaseReference.child(id).setValue(names);
                    nameView.setText("");
                    passwordView.setText("");
                    phoneView.setText("");
                     }

        else
            Toast.makeText(this, "ERROR:Fill in the Details", Toast.LENGTH_SHORT).show();
    }
}
