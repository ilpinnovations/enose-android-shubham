package com.tcs.enosenew.services;

import android.os.Handler;
import android.util.Log;

import java.util.Timer;

public class TimerTask {
    Timer timer;
    final Handler handler = new Handler();
    java.util.TimerTask timerTask;
    public void startTimer(String s) {
if(s.equalsIgnoreCase("get_readings")) {
    timer = new Timer();
    initializeReadingTask();
    timer.schedule(timerTask, 5000, 2000);
}else if(s.equalsIgnoreCase("get_graph"))
{
    timer = new Timer();
    initializeGraphTask();
    timer.schedule(timerTask, 5000, 2000);
}
else if(s.equalsIgnoreCase("get_image"))
{
    timer = new Timer();
    initializeImageTask();
    timer.schedule(timerTask, 5000, 2000);
}

    }
    public void stoptimertask() {
        if (timer != null) {
            Log.d("MyTag", "Timer Stopped");
            timer.cancel();
            timer = null;
        }
    }

    public void initializeReadingTask() {
        timerTask = new java.util.TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                       ReadingsAsync readingsAsync = new ReadingsAsync();
                        readingsAsync.execute();

                    }

                });

            }

        };

    }

    public void initializeGraphTask() {
        timerTask = new java.util.TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        GraphAsync graphAsync = new GraphAsync();
                        graphAsync.execute();
                    }

                });

            }

        };
    }
    public void initializeImageTask() {
        timerTask = new java.util.TimerTask() {
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        ImageAsync imageAsync = new ImageAsync();
                        imageAsync.execute();
                    }

                });

            }

        };
    }

}
