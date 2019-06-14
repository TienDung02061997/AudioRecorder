package com.dung.audiorecoder.ui.presenter;

import com.dung.audiorecoder.data.AudioRecorderRepostitory;
import com.dung.audiorecoder.ui.contract.AudioRecorderInitContact;



public class AudioRecorderInitPresenter implements AudioRecorderInitContact.Presenter {
    private AudioRecorderInitContact.view mView;
    private AudioRecorderRepostitory mAudioRecorderRepostitory;

    public AudioRecorderInitPresenter(AudioRecorderInitContact.view mView, AudioRecorderRepostitory mAudioRecorderRepostitory) {
        this.mView = mView;
        this.mAudioRecorderRepostitory = mAudioRecorderRepostitory;
    }

    @Override
    public void initAudioRecorder(String init) {
        mAudioRecorderRepostitory.initAudioRecorder(init);
        mView.initAudioRecorder();
    }

    @Override
    public void saveAudioRecorder(String save) {
        mAudioRecorderRepostitory.saveAudioRecorder(save);
        mView.saveAudioRecorder();
    }

    @Override
    public void pauseAudioRecorder(String pause) {
        mAudioRecorderRepostitory.pauseAudioRecorder(pause);
        mView.pauseAudioRecorder();
    }

    @Override
    public void resummerAudioRecorer(String remuse) {
        mAudioRecorderRepostitory.resummerAudioRecorer(remuse);
        mView.resummerAudioRecorer();
    }
}
