package com.dung.audiorecoder.data;

import com.dung.audiorecoder.data.local.AudioRecorderDataSource;
import com.dung.audiorecoder.data.local.AudioRecorederLocalDataSource;

public class AudioRecorderRepostitory implements AudioRecorderDataSource {
    private AudioRecorderDataSource mAudioRecorderDataSource;
    private static AudioRecorderRepostitory sInstance;

    public static AudioRecorderRepostitory getInstance(AudioRecorderDataSource audioRecorderDataSource) {
        if (sInstance == null) {
            synchronized (AudioRecorderRepostitory.class) {
                if (sInstance == null) {
                    sInstance = new AudioRecorderRepostitory(audioRecorderDataSource);
                }
            }
        }
        return sInstance;
    }

    private AudioRecorderRepostitory(AudioRecorderDataSource mAudioRecorderDataSource) {
        this.mAudioRecorderDataSource = mAudioRecorderDataSource;
    }

    @Override
    public void initAudioRecorder(String timePlay) {
       mAudioRecorderDataSource.initAudioRecorder(timePlay);
    }

    @Override
    public void saveAudioRecorder(String timeSave) {
            mAudioRecorderDataSource.saveAudioRecorder(timeSave);
    }

    @Override
    public void pauseAudioRecorder(String timepause) {
        mAudioRecorderDataSource.pauseAudioRecorder(timepause);
    }

    @Override
    public void resummerAudioRecorer(String timeremuse) {
   mAudioRecorderDataSource.resummerAudioRecorer(timeremuse);
    }
}
