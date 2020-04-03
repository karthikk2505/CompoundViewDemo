package com.kb.compoundviewdemo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class FriendCountActivity extends AppCompatActivity {
    TextView mTextView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTextView = findViewById(R.id.friend_text);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            List<String> names = extras.getStringArrayList("names");
            setFriendText(names);}
    }
    private void setFriendText(List<String> names) {
        StringBuilder builder = new StringBuilder();
        builder.append(getString(R.string.you_have_friends));
        builder.append('\n');
        for (String name : names) {
            builder.append(name).append('\n');
        }
        mTextView.setText(builder.toString());
    }
}
