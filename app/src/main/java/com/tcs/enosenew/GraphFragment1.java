package com.tcs.enosenew;


import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/**
 * Created by jonas on 28.11.14.
 */
public class GraphFragment1 extends Fragment {

    private static GraphView graph2;
    Button get_graph;
    private LineGraphSeries<DataPoint> mSeries1;
    private static LineGraphSeries<DataPoint> mSeries2;
    GraphFragmentListener1 activityCommander2;
private static LinearLayout linearLayoutg1;
    public GraphFragment1() {
        // Required empty public constructor
    }
    public interface GraphFragmentListener1{

        public void createGraph();
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            activityCommander2=(GraphFragmentListener1) activity;
        }
        catch(ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_graph_fragment1, container, false);
        get_graph = (Button)rootView.findViewById(R.id.graphbtn);
linearLayoutg1 = (LinearLayout) rootView.findViewById(R.id.linearLayoutgraph1);

        get_graph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getGraphData(v);
            }
        });
        graph2 = (GraphView) rootView.findViewById(R.id.graph);


        graph2.getViewport().setXAxisBoundsManual(true);
        graph2.getViewport().setMinX(0);
        graph2.getViewport().setMaxX(40);

        return rootView;
    }



    public void getGraphData(View view){
        activityCommander2.createGraph();
    }

    public void getGraph(Double s1,Double s2,Double s3, Double s4) {
        double s11 = s1;
        double s22 = s2;
        double s33 = s3;
        double s44 = s4;
        mSeries2 = new LineGraphSeries<DataPoint>();
        mSeries2.appendData(new DataPoint(s11, s1), true, 40);
        graph2.addSeries(mSeries2);
    }
    public void progress(){
        Snackbar.make(linearLayoutg1, "Getting Data...", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}