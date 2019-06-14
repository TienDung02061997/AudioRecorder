package com.dung.audiorecoder.ui.view.ListAudioRecorder;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dung.audiorecoder.R;


public class ListAudioRecorderFragment extends Fragment {


    public ListAudioRecorderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_audio_recorder, container, false);
    }

}
