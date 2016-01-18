package com.tatbigy.a.data.adapter;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.graphics.Palette;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

@SuppressWarnings("unused")
public class BindingAdapters {


    private static final String TAG = "BindingAdapters";
    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String imageUrl) {
        Picasso.with(imageView.getContext()).load(imageUrl).into(imageView);
    }

    @BindingAdapter({"imageUrl", "placeholder"})
    public static void loadImage(ImageView imageView, String imageUrl, Drawable drawable) {
        Picasso.with(imageView.getContext()).load(imageUrl).placeholder(drawable).into(imageView);
    }

    @BindingAdapter("image")
    public static void setBackground(final TextView text, String image){
        Picasso.with(text.getContext()).load(image).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                    public void onGenerated(Palette p) {
                        // Use generated instance
                        Palette.Swatch Vibrant = p.getVibrantSwatch();
                        if (Vibrant != null) {
                            text.setTextColor(Vibrant.getTitleTextColor());
                            text.setBackgroundColor(Vibrant.getRgb());
                        }
                    }
                });
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
                Log.d(TAG, "onBitmapFailed: ");
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });

    }

    @BindingAdapter("color")
    public static void setScrim(final CollapsingToolbarLayout text, String image){
        Picasso.with(text.getContext()).load(image).into(new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                    public void onGenerated(Palette p) {
                        // Use generated instance
                        Palette.Swatch Vibrant = p.getVibrantSwatch();
                        if (Vibrant != null) {
                            text.setContentScrimColor(Vibrant.getRgb());
                            text.setStatusBarScrimColor(Vibrant.getRgb());
                        }
                    }
                });
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        });

    }
}
