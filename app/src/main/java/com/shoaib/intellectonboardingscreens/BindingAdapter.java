package com.shoaib.intellectonboardingscreens;

import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class BindingAdapter {

    @androidx.databinding.BindingAdapter("setImageURL")
    public static void setImageURL(ImageView imageView, int path){
        if (path != 0){
            imageView.setImageResource(path);
            Log.d("universal", "setImageURL: found");

        }else{
            imageView.setImageDrawable(null);
            Log.d("universal", "setImageURL: not found");
        }
    }
}
