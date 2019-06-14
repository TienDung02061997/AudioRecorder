package com.dung.audiorecoder.data.local;

public class AudioRecorederLocalDataSource implements AudioRecorderDataSource {
    private AudioRecorderData mAudioRecorderData;

    public AudioRecorederLocalDataSource(AudioRecorderData mAudioRecorderData) {
        this.mAudioRecorderData = mAudioRecorderData;
    }

    @Override
    public void initAudioRecorder(String timePlay) {
        mAudioRecorderData.initAudioRecorder(timePlay);
    }

    @Override
    public void saveAudioRecorder(String timeSave) {
         mAudioRecorderData.saveAudioRecorder(timeSave);
    }

    @Override
    public void pauseAudioRecorder(String timepause) {
        mAudioRecorderData.pausesdk24(timepause);
    }

    @Override
    public void resummerAudioRecorer(String timeremuse) {
        mAudioRecorderData.remusesdk24(timeremuse);
    }
}
