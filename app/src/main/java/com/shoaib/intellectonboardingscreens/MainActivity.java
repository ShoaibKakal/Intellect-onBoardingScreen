package com.shoaib.intellectonboardingscreens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager2.widget.ViewPager2;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.shoaib.intellectonboardingscreens.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        List<ModelClass> modelClassList = new ArrayList<>();
        modelClassList.add(new ModelClass(R.drawable.ic_undraw_a_whole_year_vnfm, "Welcome\nto Intellect", "This is a journey to begin\nworking on who you are."));
        modelClassList.add(new ModelClass(R.drawable.ic_undraw_book_reading_kx9s, "Build\nThrough Science", "Engineered by our team of\nworld-leading psychologists."));
        modelClassList.add(new ModelClass(R.drawable.ic_undraw_heartbroken_cble, "Overcome\nthough times", "Get through stress, overwhelm,\n& tough times."));
        modelClassList.add(new ModelClass(R.drawable.ic_undraw_instruction_manual_cyae, "Create\nnew behaviors", "Eliminate unhelpful habits and\nform new ones."));
        activityMainBinding.viewPager.setOffscreenPageLimit(1);
        activityMainBinding.viewPager.setAdapter(new ModelClassAdapter(modelClassList));


        setupIndicators(modelClassList.size());


        activityMainBinding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentIndicator(position);
                count = position;
            }
        });

        activityMainBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // todo: active this button.

            }
        });
    }

    private void setupIndicators(int count) {
        ImageView[] indicators = new ImageView[count];

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(15, 0, 15, 0);
        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageResource(R.drawable.background_slider_indicator_inactive);
            indicators[i].setLayoutParams(layoutParams);
            activityMainBinding.layoutIndicators.addView(indicators[i]);
        }
        setCurrentIndicator(0);
    }

    private void setCurrentIndicator(int position) {

        int childCount = activityMainBinding.layoutIndicators.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) activityMainBinding.layoutIndicators.getChildAt(i);
            if (i == position){
                imageView.setImageResource(R.drawable.background_slider_indicator_active);
            }else{
                imageView.setImageResource(R.drawable.background_slider_indicator_inactive);
            }
        }
    }
}