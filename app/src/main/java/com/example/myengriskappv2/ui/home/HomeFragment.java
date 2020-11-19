package com.example.myengriskappv2.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myengriskappv2.MainActivity;
import com.example.myengriskappv2.QuestionFragment;
import com.example.myengriskappv2.R;

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_game, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        QuestionFragment questionFragment;
        questionFragment = ((MainActivity) getActivity()).getQuestionFragment();
        if (questionFragment != null) {
            if (!questionFragment.isInLayout()) {
                Log.d("my debug", "check check check");
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction tf = fm.beginTransaction();
                tf.replace(R.id.frameQuestion, questionFragment);
                tf.commit();
            }
        }
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onPause() {
        Log.d("my debug", "destroy");
        QuestionFragment questionFragment;
        questionFragment = ((MainActivity) getActivity()).getQuestionFragment();
        if (questionFragment != null) {
            if (questionFragment.isAdded()) {
                Log.d("my debug", "check2");
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction tf = fm.beginTransaction();
                tf.remove(questionFragment);
                tf.commit();
            }
        }
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}