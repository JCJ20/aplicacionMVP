package com.example.seqrity.OnboardingApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.seqrity.R;
import com.example.seqrity.View.LoginActivity;

public class Onboarding extends AppCompatActivity implements View.OnClickListener {
    private ViewPager mSlideViewPager;
    private LinearLayout mDotsLayout;
    private SlideAdapter sliderAdapter;
    private TextView[] mDots;
    private Button btn_back;
    private Button btn_next;

    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding);

        mSlideViewPager = findViewById(R.id.slideViewPager);
        mDotsLayout = findViewById(R.id.dotsLayout);
        btn_back = findViewById(R.id.button_prev);
        btn_next = findViewById(R.id.button_next);

        btn_next.setOnClickListener(this);
        btn_back.setOnClickListener(this);

        sliderAdapter = new SlideAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);


    }

    public void addDotsIndicator(int position){
        mDots = new TextView[3];
        mDotsLayout.removeAllViews();
        for(int i = 0 ;  i < mDots.length ; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mDotsLayout.addView(mDots[i]);
        }
        if(mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            mCurrentPage = i;

            if(i==0){
                btn_next.setEnabled(true);
                btn_next.setId(R.id.button_next);
                btn_back.setEnabled(false);
                btn_back.setVisibility(View.INVISIBLE);

            }
            if(i == 1){

                btn_next.setEnabled(true);
                btn_back.setEnabled(true);
                btn_back.setVisibility(View.VISIBLE);

                btn_next.setText("NEXT");
                btn_next.setId(R.id.button_next);
                btn_back.setText("BACK");


            }
            if(i == 2){
                btn_next.setEnabled(true);
                btn_back.setEnabled(true);
                btn_back.setVisibility(View.VISIBLE);

                btn_next.setText("CONTINUAR");
                btn_next.setId(R.id.btn_continuar);

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_next:
                mSlideViewPager.setCurrentItem(mCurrentPage + 1);
                break;

            case R.id.button_prev:
                mSlideViewPager.setCurrentItem(mCurrentPage - 1);
                break;

            case R.id.btn_continuar:
                startActivity(new Intent(this,LoginActivity.class));
                break;

        }

    }
}



