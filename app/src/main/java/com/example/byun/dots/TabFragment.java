package com.example.byun.dots;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.byun.dots.databinding.MiniFragmentBinding;
import com.example.byun.dots.databinding.TabFragmentBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by byun on 2018-03-14.
 */

public class TabFragment extends android.support.v4.app.Fragment{

    LayoutInflater mLayoutInflater;
    ViewGroup mContainer;
    TabFragmentBinding tabFragmentBinding;

    private LinearLayout llPagerDots;
    private ImageView[] ivArrayDotsPager;

    private ViewPager vp;

    public static TabFragment newInstance(int position){

        TabFragment fragment = new TabFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("flag", position);
        fragment.setArguments(bundle);

        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        mLayoutInflater = inflater;
        mContainer = container;

        tabFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.tab_fragment,container,false);
        View view = tabFragmentBinding.getRoot();
        return view;
       // return super.onCreateView()
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tabFragmentBinding.tv.setTextSize(20);

        if(getArguments().getInt("flag")==0)
            tabFragmentBinding.tv.setText("봄 신상 추천합니다 추천추천");
        else if(getArguments().getInt("flag")==1)
            tabFragmentBinding.tv.setText("핫 인기 상품!!!!");
        else
            tabFragmentBinding.tv.setText("무엇을 선물할까?");


        pagerAdapter pA = new pagerAdapter(getChildFragmentManager());



        vp = (ViewPager) getView().findViewById(R.id.vp);
        vp.setAdapter(pA);
        vp.setCurrentItem(3000);
        llPagerDots = (LinearLayout)getView().findViewById(R.id.pager_dots);



        setupPagerIndidcatorDots();
        ivArrayDotsPager[0].setImageResource(R.drawable.selected);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < ivArrayDotsPager.length; i++) {
                    ivArrayDotsPager[i].setImageResource(R.drawable.unselected);
                }
                ivArrayDotsPager[position%3].setImageResource(R.drawable.selected);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setupPagerIndidcatorDots() {
        ivArrayDotsPager = new ImageView[3];
        for (int i = 0; i < ivArrayDotsPager.length; i++) {
            ivArrayDotsPager[i] = new ImageView(getActivity());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(5, 0, 5, 0);
            ivArrayDotsPager[i].setLayoutParams(params);
            ivArrayDotsPager[i].setImageResource(R.drawable.unselected);
            //ivArrayDotsPager[i].setAlpha(0.4f);
            ivArrayDotsPager[i].setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    view.setAlpha(1);
                }
            });
            llPagerDots.addView(ivArrayDotsPager[i]);
            llPagerDots.bringToFront();
        }
    }


    public class pagerAdapter extends FragmentStatePagerAdapter{


        public pagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {

            int resPos = position%3;

            if(resPos == 0)
                return MiniFragment.newInstance(R.drawable.pic1);
            else if(resPos == 1)
                return MiniFragment.newInstance(R.drawable.pic2);
            else if(resPos == 2)
                return MiniFragment.newInstance(R.drawable.pic3);
            else
                return null;
        }



        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

    }
}
