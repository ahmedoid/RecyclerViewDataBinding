package com.tatbigy.a.data;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tatbigy.a.data.databinding.ActivityDetailsBinding;
import com.tatbigy.a.data.model.ItemsEntity;

public class DetailsActivity extends AppCompatActivity {
    ItemsEntity photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailsBinding details = DataBindingUtil.setContentView(this, R.layout.activity_details);
        photo = getIntent().getExtras().getParcelable("photo");
        details.setFliker(photo);
    }

    public void openUrl(View v) {
        String url = photo.getLink();
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
