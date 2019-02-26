package com.example.sampleapp;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sampleapp.databinding.FragmentSampleBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class SampleFragment extends Fragment {


    public SampleFragment() {
        // Required empty public constructor
    }

    FragmentSampleBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_sample,container,false);
        return binding.getRoot();
    }

}
