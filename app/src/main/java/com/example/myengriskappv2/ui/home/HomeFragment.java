package com.example.myengriskappv2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.myengriskappv2.MainActivity;
import com.example.myengriskappv2.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

//    private static final String ARG_QUES = "ques";
//    private static final String ARG_ANS1 = "param1";
//    private static final String ARG_ANS2 = "param2";
//    private static final String ARG_ANS3 = "param3";
//    private static final String ARG_ANS4 = "param4";
//    private static final String ARG_SOL = "sol";
//
//    // TODO: Rename and change types of parameters
//    private String mQues;
//    private String mAns1;
//    private String mAns2;
//    private String mAns3;
//    private String mAns4;
//    private String mSol;
//
//    public HomeFragment() {}
//
//    public static HomeFragment newInstance(String ques, String param1, String param2, String param3, String param4, String sol) {
//        HomeFragment fragment = new HomeFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_QUES, ques);
//        args.putString(ARG_ANS1, param1);
//        args.putString(ARG_ANS2, param2);
//        args.putString(ARG_ANS3, param3);
//        args.putString(ARG_ANS4, param4);
//        args.putString(ARG_SOL, sol);
//        fragment.setArguments(args);
//        return fragment;
//    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Bundle bun = getArguments();
//        if (bun != null) {
//            mQues = bun.getString(ARG_QUES);
//            mAns1 = bun.getString(ARG_ANS1);
//            mAns2 = bun.getString(ARG_ANS2);
//            mAns3 = bun.getString(ARG_ANS3);
//            mAns4 = bun.getString(ARG_ANS4);
//            mSol = bun.getString(ARG_SOL);
//        }
//    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        TextView textView = view.findViewById(R.id.textQuestion);
//        textView.setText(mQues + " means: ");
//        Button button1 = view.findViewById(R.id.option1);
//        Button button2 = view.findViewById(R.id.option2);
//        Button button3 = view.findViewById(R.id.option3);
//        Button button4 = view.findViewById(R.id.option4);
//        button1.setText(mAns1);
//        button2.setText(mAns2);
//        button3.setText(mAns3);
//        button4.setText(mAns4);
//        button1.setOnClickListener(this);
//        button2.setOnClickListener(this);
//        button3.setOnClickListener(this);
//        button4.setOnClickListener(this);
//    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_game, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });
        return root;
    }

//    @Override
//    public void onClick(View v) {
//        if (((TextView)v).getText() == mSol)
//            Toast.makeText(getActivity(), "Correct", Toast.LENGTH_SHORT).show();
//        else
//            Toast.makeText(getActivity(), "Wrong", Toast.LENGTH_SHORT).show();
//        nextQuestion();
//
//    }
//
//    private void nextQuestion() {
//        ((MainActivity) getActivity()).replaceFragment();
//    }
}