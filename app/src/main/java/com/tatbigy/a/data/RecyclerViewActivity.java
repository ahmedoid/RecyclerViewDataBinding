package com.tatbigy.a.data;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.tatbigy.a.data.DetailsActivity;
import com.tatbigy.a.data.R;
import com.tatbigy.a.data.adapter.BindingAdapter;
import com.tatbigy.a.data.model.FlickrResults;
import com.tatbigy.a.data.model.RecyclerItemClickListener;


public class RecyclerViewActivity extends AppCompatActivity {
    BindingAdapter adapter;
    FlickrResults items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        final RecyclerView recycler = (RecyclerView) findViewById(R.id.recyclerview);

        Ion.with(this)
                .load("http://www.flickr.com/services/feeds/photos_public.gne?tags=sky&format=json&jsoncallback=?")
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                        // do stuff with the result or error
                        Log.d("RecyclerViewActivity", result.substring(1, result.length() - 1));
                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        items = gson.fromJson(result.substring(1, result.length() - 1), FlickrResults.class);
                        adapter = new BindingAdapter(items);
                        adapter.notifyDataSetChanged();
                        recycler.setLayoutManager(new LinearLayoutManager(RecyclerViewActivity.this, LinearLayoutManager.VERTICAL, true));
                        recycler.setAdapter(adapter);
                    }
                });



        recycler.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position, float x, float y) {
                Bundle photo = new Bundle();
                photo.putParcelable("photo",items.items.get(position));
                Intent intent = new Intent(RecyclerViewActivity.this, DetailsActivity.class);
                intent.putExtras(photo);
                startActivity(intent);
            }
        }));
    }
}
