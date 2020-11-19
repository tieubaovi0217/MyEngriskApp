package com.example.myengriskappv2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.Button;

import com.example.myengriskappv2.ui.home.HomeFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    public QuestionFragment getQuestionFragment() {
        return questionFragment;
    }

    private QuestionFragment questionFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_game, R.id.nav_difficulty, R.id.nav_dictionary)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        if (savedInstanceState != null)
        {
            questionFragment = (QuestionFragment)getSupportFragmentManager().findFragmentById(R.id.frameQuestion);
        }
        else if (questionFragment == null)
        {
            questionFragment = QuestionFragment.newInstance("cookie", "cake", "candy", "snack", "biscuit", "biscuit");
        }
        if (!questionFragment.isInLayout()) {
            FragmentTransaction tf = getSupportFragmentManager().beginTransaction();
            tf.replace(R.id.frameQuestion, questionFragment);
            tf.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    public void pressed(View view) {
        Log.e("abc", "abc");

    }

    @Override
    protected void onPause() {
        Log.d("debug", "main activity pause");
        super.onPause();
    }

    public void replaceFragment()
    {
        FragmentTransaction tf = getSupportFragmentManager().beginTransaction();
        questionFragment = QuestionFragment.newInstance("ssosso", "lauren", "sohee", "sehee", "gabi", "sohee");
        tf.replace(R.id.frameQuestion, questionFragment);
        tf.commit();
    }
}