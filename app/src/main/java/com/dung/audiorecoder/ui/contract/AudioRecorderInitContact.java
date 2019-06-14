package com.dung.audiorecoder.ui.contract;

public interface AudioRecorderInitContact {
    interface  view{
        void  initAudioRecorder();
        void saveAudioRecorder();
        void pauseAudioRecorder();
        void resummerAudioRecorer();
    }
    interface Presenter{
        void  initAudioRecorder(String init);
        void saveAudioRecorder(String save);
        void pauseAudioRecorder(String pause);
        void resummerAudioRecorer(String remuse);
    }
}
