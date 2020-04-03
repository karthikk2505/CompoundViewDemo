package com.kb.compoundviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    NumberPicker mFriendCountPicker;
    FriendNameView mFriendNameView;
    Button mCountFriendsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFriendCountPicker = findViewById(R.id.friend_count);
        mFriendNameView = findViewById(R.id.friend_names);
        mCountFriendsButton = findViewById(R.id.count_friends_button);
        mFriendCountPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                mFriendNameView.setFriendCount(newVal);
            }
        });
        mCountFriendsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> names = mFriendNameView.getFriendNames();
                Intent i = new Intent(MainActivity.this,
                        FriendCountActivity.class);
                i.putStringArrayListExtra("names", new ArrayList<String>(names));
                startActivity(i);
            }
        });
    }
}
