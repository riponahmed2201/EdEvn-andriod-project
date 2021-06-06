package com.entertech.edevn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class BookNowActivity extends AppCompatActivity {

    private ImageView bookNowCrossMenuIconId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_now);

        bookNowCrossMenuIconId = findViewById(R.id.book_now_cross_menu_icon_id);

        bookNowCrossMenuIconId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookNowActivity.this, FreeLiveClassActivity.class);
                startActivity(intent);
            }
        });
    }
}