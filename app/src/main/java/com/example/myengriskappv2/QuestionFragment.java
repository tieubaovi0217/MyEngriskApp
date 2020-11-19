package com.example.myengriskappv2;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_QUES = "ques";
    private static final String ARG_ANS1 = "param1";
    private static final String ARG_ANS2 = "param2";
    private static final String ARG_ANS3 = "param3";
    private static final String ARG_ANS4 = "param4";
    private static final String ARG_SOL = "sol";

    // TODO: Rename and change types of parameters
    private String mQues;
    private String mAns1;
    private String mAns2;
    private String mAns3;
    private String mAns4;
    private String mSol;

    public QuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuestionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuestionFragment newInstance(String ques, String param1, String param2, String param3, String param4, String sol) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_QUES, ques);
        args.putString(ARG_ANS1, param1);
        args.putString(ARG_ANS2, param2);
        args.putString(ARG_ANS3, param3);
        args.putString(ARG_ANS4, param4);
        args.putString(ARG_SOL, sol);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bun = getArguments();
        if (bun != null) {
            mQues = bun.getString(ARG_QUES);
            mAns1 = bun.getString(ARG_ANS1);
            mAns2 = bun.getString(ARG_ANS2);
            mAns3 = bun.getString(ARG_ANS3);
            mAns4 = bun.getString(ARG_ANS4);
            mSol = bun.getString(ARG_SOL);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = view.findViewById(R.id.textQuestion);
        textView.setText(mQues + " means: ");
        Button button1 = view.findViewById(R.id.option1);
        Button button2 = view.findViewById(R.id.option2);
        Button button3 = view.findViewById(R.id.option3);
        Button button4 = view.findViewById(R.id.option4);
        button1.setText(mAns1);
        button2.setText(mAns2);
        button3.setText(mAns3);
        button4.setText(mAns4);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question, container, false);
        if (savedInstanceState != null)
        {
            mQues = savedInstanceState.getString(ARG_QUES);
            mAns1 = savedInstanceState.getString(ARG_ANS1);
            mAns2 = savedInstanceState.getString(ARG_ANS2);
            mAns3 = savedInstanceState.getString(ARG_ANS3);
            mAns4 = savedInstanceState.getString(ARG_ANS4);
            mSol = savedInstanceState.getString(ARG_SOL);
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        if (((TextView)v).getText() == mSol)
            Toast.makeText(getActivity(), "Correct", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getActivity(), "Wrong", Toast.LENGTH_SHORT).show();
        nextQuestion();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(ARG_ANS1, mAns1);
        outState.putString(ARG_ANS2, mAns2);
        outState.putString(ARG_ANS3, mAns3);
        outState.putString(ARG_ANS4, mAns4);
        outState.putString(ARG_QUES, mQues);
        outState.putString(ARG_SOL, mSol);
        super.onSaveInstanceState(outState);
    }

    private void nextQuestion() {
        ((MainActivity) getActivity()).replaceFragment();
    }
}