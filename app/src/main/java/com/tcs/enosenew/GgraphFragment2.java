package com.tcs.enosenew;


import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.tcs.enosenew.beans.ReadingsBean;
import com.tcs.enosenew.services.TimerTask;
import com.tcs.enosenew.utilities.ConnectionDetector;

import java.util.Random;

/**
 * Created by jonas on 28.11.14.
 */
public class GgraphFragment2 extends Fragment {
    private final Handler mHandler = new Handler();
    private Runnable mTimer1;
    private Runnable mTimer2;
    private Runnable mTimer3;
    private Runnable mTimer4;
    ReadingsBean readings = new ReadingsBean();
    private static ProgressBar bar2;
    private double x;
    private static LineGraphSeries<DataPoint> mSeries1;
    private static LineGraphSeries<DataPoint> mSeries2;
    private static LineGraphSeries<DataPoint> mSeries3;
    private static LineGraphSeries<DataPoint> mSeries4;
    private double graph2LastXValue = 0d;
    private double graph2LastXValue1 = 0d;
    private double graph2LastXValue2 = 0d;
    private double graph2LastXValue3 = 0d;
    public GgraphFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ggraph_fragment2, container, false);
        bar2 = (ProgressBar) rootView.findViewById(R.id.progressBar2);
        GraphView graph = (GraphView) rootView.findViewById(R.id.graph);
        ConnectionDetector detector = new ConnectionDetector(getContext());
        if( detector.isConnectingToInternet()) {
            bar2.setVisibility(View.VISIBLE);
            TimerTask task = new TimerTask();
            String status = "get_graph";
            task.startTimer(status);
        }else {
            Snackbar.make(rootView, "Not Connected to Internet", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
        mSeries1 = new LineGraphSeries<DataPoint>();
        graph.addSeries(mSeries1);

        mSeries2 = new LineGraphSeries<DataPoint>();
        graph.addSeries(mSeries2);

        mSeries3 = new LineGraphSeries<DataPoint>();
        graph.addSeries(mSeries3);

        mSeries4 = new LineGraphSeries<DataPoint>();
        graph.addSeries(mSeries4);

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(40);

        return rootView;
    }


    @Override
    public void onResume() {
        super.onResume();
        mTimer1 = new Runnable() {
            @Override
            public void run() {
                graph2LastXValue += Double.parseDouble(readings.getSens1());
               mSeries1.appendData(new DataPoint(graph2LastXValue, getGraph1()), true, 40);
                mHandler.postDelayed(this, 200);
            }
        };
        mHandler.postDelayed(mTimer1, 1000);

        mTimer2 = new Runnable() {
            @Override
            public void run() {
                graph2LastXValue1 += Double.parseDouble(readings.getSens2());
                mSeries2.appendData(new DataPoint(graph2LastXValue1, getGraph2()), true, 40);
                mHandler.postDelayed(this, 200);
        }
        };
        mHandler.postDelayed(mTimer2, 1000);

        mTimer3 = new Runnable() {
            @Override
            public void run() {
                graph2LastXValue2 += Double.parseDouble(readings.getSens3());
                mSeries3.appendData(new DataPoint(graph2LastXValue2, getGraph3()), true, 40);
                mHandler.postDelayed(this, 200);
            }
        };
        mHandler.postDelayed(mTimer3, 1000);

        mTimer4 = new Runnable() {
            @Override
            public void run() {
                graph2LastXValue3 += Double.parseDouble(readings.getSens4());
                mSeries4.appendData(new DataPoint(graph2LastXValue3, getGraph4()), true, 40);
                mHandler.postDelayed(this, 200);
            }
        };
        mHandler.postDelayed(mTimer4, 1000);
    }

    @Override
    public void onPause() {
        mHandler.removeCallbacks(mTimer1);
        mHandler.removeCallbacks(mTimer2);
        mHandler.removeCallbacks(mTimer3);
        mHandler.removeCallbacks(mTimer4);

        super.onPause();
    }

    public double getGraph1() {
       // int count = 20;
       // for (int i=0; i<count; i++) {
             x = Double.parseDouble(readings.getSens1());

           // values[i] = v;
       // }
        return x;
    }
    public double getGraph2() {
       // int count = 20;

        //for (int i=0; i<count; i++) {
            double x = Double.parseDouble(readings.getSens2());



       // }
        return x;
    }
    public double getGraph3() {
        //int count = 20;

        //for (int i=0; i<count; i++) {
            double x = Double.parseDouble(readings.getSens3());


       // }
        return x;
    }
    public double getGraph4() {
        //int count = 20;

        //for (int i=0; i<count; i++) {
            double x =Double.parseDouble(readings.getSens4());

       // }
        return x;
    }
    public void progress(){
        bar2.setVisibility(View.GONE);
    }

    double mLastRandom = 2;
    Random mRand = new Random();
    private double getRandom() {
        return mLastRandom += mRand.nextDouble()*0.5 - 0.25;
    }
}
