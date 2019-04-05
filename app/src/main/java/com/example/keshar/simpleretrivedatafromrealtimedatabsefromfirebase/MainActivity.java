package com.example.keshar.simpleretrivedatafromrealtimedatabsefromfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private TextView retriveData;
    private Firebase firebaseUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        retriveData=findViewById(R.id.retrive_data);
        firebaseUrl=new Firebase("https://applicationdemo-eff34.firebaseio.com/Name/Keshar/");

        firebaseUrl.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                retriveData.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
