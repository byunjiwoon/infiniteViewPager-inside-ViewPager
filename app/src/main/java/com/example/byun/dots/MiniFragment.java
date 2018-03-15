package com.example.byun.dots;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.byun.dots.databinding.MiniFragmentBinding;

/**
 * Created by byun on 2018-03-14.
 */

public class MiniFragment extends Fragment {

    MiniFragmentBinding miniFragmentBinding;


   public static MiniFragment newInstance(int img) {

        Bundle args = new Bundle();
        args.putInt("image", img);
        MiniFragment fragment = new MiniFragment();
        fragment.setArguments(args);
        return fragment;

    }




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        miniFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.mini_fragment, container, false);
        View view = miniFragmentBinding.getRoot();
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        miniFragmentBinding.tv.setImageResource(getArguments().getInt("image"));


    }
}


