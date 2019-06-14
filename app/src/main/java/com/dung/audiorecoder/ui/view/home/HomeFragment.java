package com.dung.audiorecoder.ui.view.home;

import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.dung.audiorecoder.R;
import com.dung.audiorecoder.data.AudioRecorderRepostitory;
import com.dung.audiorecoder.data.local.AudioRecorderData;
import com.dung.audiorecoder.data.local.AudioRecorederLocalDataSource;
import com.dung.audiorecoder.ui.contract.AudioRecorderInitContact;
import com.dung.audiorecoder.ui.presenter.AudioRecorderInitPresenter;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class HomeFragment extends Fragment implements View.OnClickListener, AudioRecorderInitContact.view {
    private openListAudioRecorderScreen mOpenRegisterFragmentCallback;
    private ImageButton mImageButtonListAudioRecorder;
    private ImageButton mBImageButtonPlay;
    private ImageButton mImageButtonSave;
    private TextView textTime;
    private MediaRecorder mMediaRecorder;
    private AudioRecorderInitPresenter mPresenter;
    private boolean checkPlay = true;
    private boolean checkPause = true;
    private boolean checkRemuse = false;
    private static String timeCount = "00:00:00";
    private static HomeFragment sInstance;

    public static synchronized HomeFragment getInstance() {
        if (sInstance == null) {
            sInstance = new HomeFragment();
        }
        return sInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        checkPesmission();
        setHasOptionsMenu(true);
        mPresenter = new AudioRecorderInitPresenter(this, AudioRecorderRepostitory.getInstance(new AudioRecorederLocalDataSource(new AudioRecorderData(mMediaRecorder))));
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView();
        initClickListeners();
    }

    private void initClickListeners() {
        mImageButtonListAudioRecorder.setOnClickListener(this);
        mBImageButtonPlay.setOnClickListener(this);
        mImageButtonSave.setOnClickListener(this);
    }

    private void initView() {
        textTime=getView().findViewById(R.id.text_time);
        mImageButtonListAudioRecorder = getView().findViewById(R.id.imagebutton_list_audio_recoder);
        mBImageButtonPlay = getView().findViewById(R.id.imagebutton_play);
        mImageButtonSave = getView().findViewById(R.id.imagebutton_save);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() instanceof openListAudioRecorderScreen) {
            mOpenRegisterFragmentCallback = (openListAudioRecorderScreen) getActivity();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imagebutton_list_audio_recoder:
                mOpenRegisterFragmentCallback.openListAudioRecorderScreen();
                saveRecorder();
                break;
            case R.id.imagebutton_play:
                checkPlay();
                break;
            case R.id.imagebutton_save:
                saveRecorder();
                break;
        }
    }

    private void checkPlay() {
        if (checkPlay) {
            playAudioRecorder();
            checkPlay = false;
        } else {
            if (checkPause == true && checkRemuse == false) {
                checkPause = false;
                checkRemuse = true;
                pauseRecorder();
                pauseAudioRecorder();
            } else {
                checkPause = true;
                checkRemuse = false;
                remuseRecorder();
                resummerAudioRecorer();
            }
        }
    }

    private Boolean playAudioRecorder() {
        mPresenter.initAudioRecorder(timeCount);
        return checkPlay;
    }

    private Boolean pauseRecorder() {
        mPresenter.pauseAudioRecorder(timeCount);
        return checkPause;
    }

    private Boolean remuseRecorder() {
        mPresenter.resummerAudioRecorer(timeCount);
        return checkRemuse;
    }

    public void saveRecorder() {
        mPresenter.saveAudioRecorder(timeCount);
    }

    @Override
    public void initAudioRecorder() {
        textTime.setText(timeCount);
        mBImageButtonPlay.setBackgroundResource(R.drawable.btn_pause);
        Toast.makeText(getActivity(), "start...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void saveAudioRecorder() {
        checkPlay = true;
        timeCount="00:00:00";
        textTime.setText("00:00:00");
        mBImageButtonPlay.setBackgroundResource(R.drawable.btn_play);
        Toast.makeText(getActivity(), "save...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void pauseAudioRecorder() {
        textTime.setText(timeCount);
        mBImageButtonPlay.setBackgroundResource(R.drawable.btn_play);
        Toast.makeText(getActivity(), "pauseRecorder", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void resummerAudioRecorer() {
        textTime.setText(timeCount);
        mBImageButtonPlay.setBackgroundResource(R.drawable.btn_pause);
        Toast.makeText(getActivity(), "remuse", Toast.LENGTH_SHORT).show();
    }

    private boolean checkPesmission() {
        int write_external_storage_result = ContextCompat.checkSelfPermission(getActivity(), WRITE_EXTERNAL_STORAGE);
        int recorver_audio_stoge = ContextCompat.checkSelfPermission(getActivity(), RECORD_AUDIO);
        return write_external_storage_result == PackageManager.PERMISSION_GRANTED && recorver_audio_stoge == PackageManager.PERMISSION_GRANTED;
    }

    public interface openListAudioRecorderScreen {
        void openListAudioRecorderScreen();
    }


}
