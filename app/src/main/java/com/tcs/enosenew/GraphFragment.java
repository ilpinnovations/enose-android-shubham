package com.tcs.enosenew;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.tcs.enosenew.services.TimerTask;
import com.tcs.enosenew.utilities.ConnectionDetector;


/**
 * A simple {@link Fragment} subclass.
 */
public class GraphFragment extends Fragment {
    private static GraphView graph;

    private static ProgressBar bar1;
    public static LinearLayout linearLayoutg;

    public GraphFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_graph, container, false);
        graph= ((GraphView) rootView.findViewById(R.id.graph));
        bar1 = (ProgressBar) rootView.findViewById(R.id.progressBar1);
linearLayoutg = (LinearLayout) rootView.findViewById(R.id.linearLayoutgraph);

        ConnectionDetector detector = new ConnectionDetector(getContext());
        if( detector.isConnectingToInternet()) {
            bar1.setVisibility(View.VISIBLE);
            TimerTask task = new TimerTask();
            String status = "get_graph";
            task.startTimer(status);
        }else {
            Snackbar.make(rootView, "Not Connected to Internet", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }

        return rootView;
    }


    public void getGraph(String s1,String s2,String s3, String s4) {

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, Float.parseFloat(s1)),
                new DataPoint(1,  Float.parseFloat(s1)),
                new DataPoint(2,  Float.parseFloat(s1)),
                new DataPoint(3,  Float.parseFloat(s1))

        });
        graph.addSeries(series);
        LineGraphSeries<DataPoint> series1 = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, Float.parseFloat(s2)),
                new DataPoint(1,  Float.parseFloat(s2)),
                new DataPoint(2,  Float.parseFloat(s2)),
                new DataPoint(3,  Float.parseFloat(s2))

        });
        graph.addSeries(series1);
        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, Float.parseFloat(s3)),
                new DataPoint(1,  Float.parseFloat(s3)),
                new DataPoint(2,  Float.parseFloat(s3)),
                new DataPoint(3,  Float.parseFloat(s3))

        });
        graph.addSeries(series2);
        LineGraphSeries<DataPoint> series3 = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, Float.parseFloat(s4)),
                new DataPoint(1,  Float.parseFloat(s4)),
                new DataPoint(2,  Float.parseFloat(s4)),
                new DataPoint(3,  Float.parseFloat(s4))

        });
        graph.addSeries(series3);

        series.setTitle("sensor1");
        series1.setTitle("sensor2");
        series2.setTitle("sensor3");
        series3.setTitle("sensor4");

        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.BOTTOM);


    }
    public void progress(){
        bar1.setVisibility(View.VISIBLE);
    }
}
