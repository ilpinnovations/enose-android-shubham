package com.tcs.enosenew;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tcs.enosenew.services.TimerTask;
import com.tcs.enosenew.utilities.ConnectionDetector;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadingsFragment extends Fragment {

    public static LinearLayout linearLayoutr;
    private static TextView sensor1,sensor2,sensor3,sensor4,temp,result;

    private static ProgressBar bar;
    public ReadingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_readings, container, false);


linearLayoutr = (LinearLayout) rootView.findViewById(R.id.linearLayoutreadings);
bar = (ProgressBar) rootView.findViewById(R.id.progressBar);
        // get_redings= (Button) rootView.findViewById(R.id.get_readings);
        sensor1 = (TextView)rootView.findViewById(R.id.sensor1);
        sensor2 = (TextView)rootView.findViewById(R.id.sensor2);
        sensor3 = (TextView)rootView.findViewById(R.id.sensor3);
        sensor4 = (TextView)rootView.findViewById(R.id.sensor4);
        temp = (TextView)rootView.findViewById(R.id.temp);
        //result = (TextView)rootView.findViewById(R.id.result);
        ConnectionDetector detector = new ConnectionDetector(getActivity());
        if( detector.isConnectingToInternet()) {
            bar.setVisibility(View.VISIBLE);
            TimerTask task = new TimerTask();
            String status = "get_readings";
            task.startTimer(status);

        }else {
            Snackbar.make(rootView, "Not Connected to Internet", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }


        return rootView;
    }
    public void setResultToScreen(String s1,String s2,String s3, String s4, Float tempe) {

        sensor1.setText("General Smell : " + s1);
        sensor2.setText("Solvent Vapour : " + s2);
        sensor3.setText("Hydrogen Compound : " + s3);
        sensor4.setText("Methane Compounds : " + s4);
        temp.setText("Temperature : " + tempe + "C");
        bar.setVisibility(View.GONE);
    }
    public void progress(){
        bar.setVisibility(View.VISIBLE);
    }
}
