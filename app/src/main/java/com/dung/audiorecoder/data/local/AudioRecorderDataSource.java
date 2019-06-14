package com.dung.audiorecoder.data.local;

public interface AudioRecorderDataSource {
   void initAudioRecorder(String timePlay);
   void saveAudioRecorder(String timeSave);
   void pauseAudioRecorder(String timepause);
   void resummerAudioRecorer(String timeremuse);
}
