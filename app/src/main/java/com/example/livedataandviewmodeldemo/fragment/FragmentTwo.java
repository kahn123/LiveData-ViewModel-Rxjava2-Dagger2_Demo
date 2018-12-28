package com.example.livedataandviewmodeldemo.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.livedataandviewmodeldemo.R;
import com.example.livedataandviewmodeldemo.base.BaseFragment;
import com.example.livedataandviewmodeldemo.viewmodel.StudentViewModel;

public class FragmentTwo extends BaseFragment<StudentViewModel> {
    StudentViewModel studentViewModel;
    TextView tv2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fm2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv2 = view.findViewById(R.id.tv2);
//        studentViewModel = ViewModelProviders.of(getActivity()).get(StudentViewModel.class);
//        viewModel.gettMutableLiveData().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                tv2.setText(String.valueOf(System.currentTimeMillis())+s);
//            }
//        });

    }
}
