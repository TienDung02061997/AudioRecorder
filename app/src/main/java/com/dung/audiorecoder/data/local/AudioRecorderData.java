package com.dung.audiorecoder.data.local;

import android.media.MediaRecorder;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AudioRecorderData {
    private MediaRecorder mMediaRecorder;
    private static String pathSave = "";
    private static String titletimeToday = "";
    private static int second = 0;
    private static int minute = 0;
    private static int hours = 0;
    public static boolean timerun = true;
    public static String timeCount = "";

    public AudioRecorderData(MediaRecorder mMediaRecorder) {
        this.mMediaRecorder = mMediaRecorder;
    }

    public void initAudioRecorder(String timeplay) {
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        dateFormatter.setLenient(false);
        Date timeDate = new Date();
        titletimeToday = dateFormatter.format(timeDate) + ".3gp";
        pathSave = Environment.getExternalStorageDirectory().getAbsolutePath() + "/ "
                + titletimeToday;
        timeplay= timeCount;
        mMediaRecorder = new MediaRecorder();
        mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mMediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mMediaRecorder.setOutputFile(pathSave);

        try {
            mMediaRecorder.prepare();
            mMediaRecorder.start();
            Log.d("title", pathSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveAudioRecorder(String timeSave) {
        mMediaRecorder.stop();
        timeSave=timeCount;
    }

    public void pausesdk24(String timepause) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mMediaRecorder.pause();
            timerun=false;
            timepause=timeCount;
        }
    }

    public void remusesdk24(String timeremuse) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mMediaRecorder.resume();
            timerun=true;
            timeremuse=timeCount;
        }
    }

    public static void TimeCount() {
        while (timerun) {
            second++;
            if (second == 60) {
                second = 0;
                minute++;
            }
            if (minute == 60) {
                minute = 0;
                hours++;
            }
            if (hours == 99 && minute == 60 && second == 60) {
                hours = 99;
                minute = 60;
                second = 60;
            }

        }
        timeCount=String.valueOf(hours)+":"+String.valueOf(minute)+":"+second;
    }
}
