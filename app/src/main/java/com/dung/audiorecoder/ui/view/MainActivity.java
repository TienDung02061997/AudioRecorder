package com.dung.audiorecoder.ui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dung.audiorecoder.R;
import com.dung.audiorecoder.ui.view.ListAudioRecorder.ListAudioRecorderFragment;
import com.dung.audiorecoder.ui.view.home.HomeFragment;

public class MainActivity extends AppCompatActivity implements  HomeFragment.openListAudioRecorderScreen{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openHomeScreen() {
        HomeFragment homeFragment = new HomeFragment();
        int fragmentManager = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_mainActitity, homeFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void openListAudioRecorderScreen() {
        ListAudioRecorderFragment listAudioRecorderFragment = new ListAudioRecorderFragment();
        int fragmentManager = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_mainActitity, listAudioRecorderFragment)
                .addToBackStack(null)
                .commit();
    }
}
