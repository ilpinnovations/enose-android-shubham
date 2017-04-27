package com.tcs.enosenew;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tcs.enosenew.services.TimerTask;
import com.tcs.enosenew.utilities.ConnectionDetector;


public class MainFragment extends Fragment {

    private static ImageView imageView,line,markerVegNon;
    private static ProgressBar bar3;
    private static  TextView titles,something1,something2,something3,something4,something5,appname;
    public MainFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_main, container, false);

        imageView=(ImageView) rootView.findViewById(R.id.imageView2);
        line=(ImageView) rootView.findViewById(R.id.imageViewline);
        markerVegNon=(ImageView) rootView.findViewById(R.id.imageViewStdVegNon);
        titles = (TextView) rootView.findViewById(R.id.title);
        appname = (TextView) rootView.findViewById(R.id.appname);
        something1= (TextView) rootView.findViewById(R.id.something1);
        bar3 = (ProgressBar) rootView.findViewById(R.id.progressBar3);
        something2= (TextView) rootView.findViewById(R.id.something2);
        something3= (TextView) rootView.findViewById(R.id.something3);
        something4= (TextView) rootView.findViewById(R.id.something4);
        something5= (TextView) rootView.findViewById(R.id.something5);
        bar3.setVisibility(View.GONE);
        something1.setVisibility(View.GONE);
        something2.setVisibility(View.GONE);
        something3.setVisibility(View.GONE);
        something4.setVisibility(View.GONE);
        something5.setVisibility(View.GONE);
        markerVegNon.setVisibility(View.GONE);
        line.setVisibility(View.GONE);

        titles.setVisibility(View.GONE);
        ConnectionDetector detector = new ConnectionDetector(getActivity());
        if( detector.isConnectingToInternet()) {
            bar3.setVisibility(View.VISIBLE);
            TimerTask task = new TimerTask();
            String status = "get_image";
            task.startTimer(status);

        }else {
          /*  Snackbar.make(getView(), "Not Connected to Internet", Snackbar.LENGTH_LONG)
                  .setAction("Action", null).show();*/
        }

        return rootView;
    }



    public void setImage(String codes,String decay) {
        int code = Integer.parseInt(codes);
if(code==10)
{
    appname.setVisibility(View.GONE);
    something1.setVisibility(View.VISIBLE);
    something2.setVisibility(View.VISIBLE);
    titles.setVisibility(View.VISIBLE);
    something3.setVisibility(View.VISIBLE);
    something4.setVisibility(View.VISIBLE);
    something5.setVisibility(View.VISIBLE);
  //  titles.setText("Category : Non Veg");

    SpannableStringBuilder str = new SpannableStringBuilder("Category : Non Veg");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    titles.setText(str);
    markerVegNon.setImageResource(R.drawable.non);
    markerVegNon.setVisibility(View.VISIBLE);



    str = new SpannableStringBuilder();
    SpannableString str1= new SpannableString("Food Status : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    SpannableString str2= new SpannableString("Fresh");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#228B22")), 0, str2.length(), 0);
    str.append(str2);
    something1.setText(str);

    str = new SpannableStringBuilder("Decaying Index :"+ decay);
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something2.setText(str);

    str = new SpannableStringBuilder("Item Name : Chicken");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something3.setText(str);

    str = new SpannableStringBuilder("No. of Days old : 0");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something4.setText(str);

    str = new SpannableStringBuilder();
    str1= new SpannableString("Consumable : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    str2= new SpannableString("Yes");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#228B22")), 0, str2.length(), 0);
    str.append(str2);

    something5.setText(str);

    //  titles.setText("Category : Non Veg");
    /*something1.setText("Food Status : Fresh");
    something2.setText("Decaying Index :"+ decay);
    something3.setText("Item Name : Chicken");
    something4.setText("No. of Days old : 0");
    something5.setText("Consumable : Yes");*/
imageView.setImageResource(R.drawable.freshmeet);
}
        else if(code==11)
{
    appname.setVisibility(View.GONE);
    something1.setVisibility(View.VISIBLE);
    something2.setVisibility(View.VISIBLE);
    something3.setVisibility(View.VISIBLE);
    titles.setVisibility(View.VISIBLE);
    something4.setVisibility(View.VISIBLE);
    something5.setVisibility(View.VISIBLE);


    SpannableStringBuilder str = new SpannableStringBuilder("Category : Non Veg");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    titles.setText(str);
    markerVegNon.setImageResource(R.drawable.non);
    markerVegNon.setVisibility(View.VISIBLE);



    str = new SpannableStringBuilder();
    SpannableString str1= new SpannableString("Food Status : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    SpannableString str2= new SpannableString("Cook Well");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#1768ea")), 0, str2.length(), 0);
    str.append(str2);
    something1.setText(str);

    str = new SpannableStringBuilder("Decaying Index :"+ decay);
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something2.setText(str);

    str = new SpannableStringBuilder("Item Name : Chicken");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something3.setText(str);

    str = new SpannableStringBuilder("No. of Days old : 1");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something4.setText(str);

    str = new SpannableStringBuilder();
    str1= new SpannableString("Consumable : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    str2= new SpannableString("Yes");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#228B22")), 0, str2.length(), 0);
    str.append(str2);
    something5.setText(str);

    imageView.setImageResource(R.drawable.freshmeet);
}
else if(code==12)
{
    appname.setVisibility(View.GONE);
    something1.setVisibility(View.VISIBLE);
    something2.setVisibility(View.VISIBLE);
    titles.setVisibility(View.VISIBLE);
    something3.setVisibility(View.VISIBLE);
    something4.setVisibility(View.VISIBLE);
    something5.setVisibility(View.VISIBLE);


    SpannableStringBuilder str = new SpannableStringBuilder("Category : Non Veg");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    titles.setText(str);
    markerVegNon.setImageResource(R.drawable.non);
    markerVegNon.setVisibility(View.VISIBLE);



    str = new SpannableStringBuilder();
    SpannableString str1= new SpannableString("Food Status : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    SpannableString str2= new SpannableString("Spoiled");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#ed2217")), 0, str2.length(), 0);
    str.append(str2);
    something1.setText(str);

    str = new SpannableStringBuilder("Decaying Index :"+ decay);
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something2.setText(str);

    str = new SpannableStringBuilder("Item Name : Chicken");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something3.setText(str);

    str = new SpannableStringBuilder("No. of Days old : 2");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something4.setText(str);

    str = new SpannableStringBuilder();
    str1= new SpannableString("Consumable : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    str2= new SpannableString("No");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#ed2217")), 0, str2.length(), 0);
    str.append(str2);
    something5.setText(str);

    imageView.setImageResource(R.drawable.rottenmeet);
}
else if(code==13)
{
    appname.setVisibility(View.GONE);
    something1.setVisibility(View.VISIBLE);
    something2.setVisibility(View.VISIBLE);
    something3.setVisibility(View.VISIBLE);
    titles.setVisibility(View.VISIBLE);
    something4.setVisibility(View.VISIBLE);
    something5.setVisibility(View.VISIBLE);


    SpannableStringBuilder str = new SpannableStringBuilder("Category : Non Veg");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    titles.setText(str);
    markerVegNon.setImageResource(R.drawable.non);
    markerVegNon.setVisibility(View.VISIBLE);



    str = new SpannableStringBuilder();
    SpannableString str1= new SpannableString("Food Status : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    SpannableString str2= new SpannableString("Spoiled");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#ed2217")), 0, str2.length(), 0);
    str.append(str2);
    something1.setText(str);

    str = new SpannableStringBuilder("Decaying Index :"+ decay);
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something2.setText(str);

    str = new SpannableStringBuilder("Item Name : Chicken");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something3.setText(str);

    str = new SpannableStringBuilder("No. of Days old : 3");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something4.setText(str);

    str = new SpannableStringBuilder();
    str1= new SpannableString("Consumable : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    str2= new SpannableString("No");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#ed2217")), 0, str2.length(), 0);
    str.append(str2);
    something5.setText(str);


    imageView.setImageResource(R.drawable.rottenmeet);
}
else if(code==14)
{
    appname.setVisibility(View.GONE);
    something1.setVisibility(View.VISIBLE);
    something2.setVisibility(View.VISIBLE);
    something3.setVisibility(View.VISIBLE);
    titles.setVisibility(View.VISIBLE);
    something4.setVisibility(View.VISIBLE);
    something5.setVisibility(View.VISIBLE);
    SpannableStringBuilder str = new SpannableStringBuilder("Category : Non Veg");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    titles.setText(str);
    markerVegNon.setImageResource(R.drawable.non);
    markerVegNon.setVisibility(View.VISIBLE);



    str = new SpannableStringBuilder();
    SpannableString str1= new SpannableString("Food Status : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    SpannableString str2= new SpannableString("Spoiled");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#ed2217")), 0, str2.length(), 0);
    str.append(str2);
    something1.setText(str);

    str = new SpannableStringBuilder("Decaying Index :"+ decay);
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something2.setText(str);

    str = new SpannableStringBuilder("Item Name : Chicken");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something3.setText(str);

    str = new SpannableStringBuilder("No. of Days old : 4");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something4.setText(str);

    str = new SpannableStringBuilder();
    str1= new SpannableString("Consumable : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    str2= new SpannableString("No");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#ed2217")), 0, str2.length(), 0);
    str.append(str2);
    something5.setText(str);
    imageView.setImageResource(R.drawable.rottenmeet);
}
else if(code==15)
{
    appname.setVisibility(View.GONE);
    something1.setVisibility(View.VISIBLE);
    something2.setVisibility(View.VISIBLE);
    something3.setVisibility(View.VISIBLE);
    titles.setVisibility(View.VISIBLE);
    something4.setVisibility(View.VISIBLE);
    something5.setVisibility(View.VISIBLE);
    SpannableStringBuilder str = new SpannableStringBuilder("Category : Non Veg");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    titles.setText(str);
    markerVegNon.setImageResource(R.drawable.non);
    markerVegNon.setVisibility(View.VISIBLE);



    str = new SpannableStringBuilder();
    SpannableString str1= new SpannableString("Food Status : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    SpannableString str2= new SpannableString("Spoiled");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#ed2217")), 0, str2.length(), 0);
    str.append(str2);
    something1.setText(str);

    str = new SpannableStringBuilder("Decaying Index :"+ decay);
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something2.setText(str);

    str = new SpannableStringBuilder("Item Name : Chicken");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something3.setText(str);

    str = new SpannableStringBuilder("No. of Days old : 5");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something4.setText(str);

    str = new SpannableStringBuilder();
    str1= new SpannableString("Consumable : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    str2= new SpannableString("No");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#ed2217")), 0, str2.length(), 0);
    str.append(str2);
    something5.setText(str);
    imageView.setImageResource(R.drawable.rottenmeet);
}
else if(code==20)
{
    appname.setVisibility(View.GONE);
    titles.setVisibility(View.VISIBLE);
    something1.setVisibility(View.VISIBLE);
    //something2.setVisibility(View.VISIBLE);
    something3.setVisibility(View.VISIBLE);
    something4.setVisibility(View.VISIBLE);
    something5.setVisibility(View.VISIBLE);

    SpannableStringBuilder str = new SpannableStringBuilder("Category : Non Veg");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    titles.setText(str);
    markerVegNon.setImageResource(R.drawable.non);
    markerVegNon.setVisibility(View.VISIBLE);



    str = new SpannableStringBuilder();
    SpannableString str1= new SpannableString("Food Status : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    SpannableString str2= new SpannableString("Fresh");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#228B22")), 0, str2.length(), 0);
    str.append(str2);
    something1.setText(str);

    str = new SpannableStringBuilder("Decaying Index :"+ decay);
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something2.setText(str);

    str = new SpannableStringBuilder("Item Name : Egg");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something3.setText(str);

    str = new SpannableStringBuilder("No. of Days old : 0");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something4.setText(str);

    str = new SpannableStringBuilder();
    str1= new SpannableString("Consumable : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    str2= new SpannableString("Yes");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#228B22")), 0, str2.length(), 0);
    str.append(str2);
    something5.setText(str);

    imageView.setImageResource(R.drawable.fresheggs);
}
else if(code==21)
{
    appname.setVisibility(View.GONE);
    something1.setVisibility(View.VISIBLE);
    //something2.setVisibility(View.VISIBLE);
    something3.setVisibility(View.VISIBLE);
    titles.setVisibility(View.VISIBLE);
    something4.setVisibility(View.VISIBLE);
    something5.setVisibility(View.VISIBLE);

    SpannableStringBuilder str = new SpannableStringBuilder("Category : Non Veg");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    titles.setText(str);
    markerVegNon.setImageResource(R.drawable.non);
    markerVegNon.setVisibility(View.VISIBLE);



    str = new SpannableStringBuilder();
    SpannableString str1= new SpannableString("Food Status : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    SpannableString str2= new SpannableString("Spoiled");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#ed2217")), 0, str2.length(), 0);
    str.append(str2);
    something1.setText(str);

    str = new SpannableStringBuilder("Decaying Index :"+ decay);
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something2.setText(str);

    str = new SpannableStringBuilder("Item Name : Egg");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something3.setText(str);

    str = new SpannableStringBuilder("No. of Days old : 1");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something4.setText(str);

    str = new SpannableStringBuilder();
    str1= new SpannableString("Consumable : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    str2= new SpannableString("No");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#ed2217")), 0, str2.length(), 0);
    str.append(str2);
    something5.setText(str);
    imageView.setImageResource(R.drawable.rottenegg);
}
else if(code==22)
{
    appname.setVisibility(View.GONE);
    something1.setVisibility(View.VISIBLE);
    //something2.setVisibility(View.VISIBLE);
    something3.setVisibility(View.VISIBLE);
    something4.setVisibility(View.VISIBLE);
    titles.setVisibility(View.VISIBLE);
    something5.setVisibility(View.VISIBLE);

    SpannableStringBuilder str = new SpannableStringBuilder("Category : Non Veg");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    titles.setText(str);
    markerVegNon.setImageResource(R.drawable.non);
    markerVegNon.setVisibility(View.VISIBLE);



    str = new SpannableStringBuilder();
    SpannableString str1= new SpannableString("Food Status : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    SpannableString str2= new SpannableString("Spoiled");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#ed2217")), 0, str2.length(), 0);
    str.append(str2);
    something1.setText(str);

    str = new SpannableStringBuilder("Decaying Index :"+ decay);
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something2.setText(str);

    str = new SpannableStringBuilder("Item Name : Egg");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something3.setText(str);

    str = new SpannableStringBuilder("No. of Days old : 2");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something4.setText(str);

    str = new SpannableStringBuilder();
    str1= new SpannableString("Consumable : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    str2= new SpannableString("No");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#ed2217")), 0, str2.length(), 0);
    str.append(str2);
    something5.setText(str);
    imageView.setImageResource(R.drawable.rottenegg);
}
else if(code==30)
{
    appname.setVisibility(View.GONE);
    something1.setVisibility(View.VISIBLE);
    //something2.setVisibility(View.VISIBLE);
    something3.setVisibility(View.VISIBLE);
    titles.setVisibility(View.VISIBLE);
    something4.setVisibility(View.VISIBLE);
    something5.setVisibility(View.VISIBLE);

    SpannableStringBuilder str = new SpannableStringBuilder("Category : Non Veg");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    titles.setText(str);
    markerVegNon.setImageResource(R.drawable.non);
    markerVegNon.setVisibility(View.VISIBLE);

    str = new SpannableStringBuilder();
    SpannableString str1= new SpannableString("Food Status : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    SpannableString str2= new SpannableString("Fresh");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#228B22")), 0, str2.length(), 0);
    str.append(str2);
    something1.setText(str);

    str = new SpannableStringBuilder("Decaying Index :"+ decay);
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something2.setText(str);

    str = new SpannableStringBuilder("Item Name : Egg");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something3.setText(str);

    str = new SpannableStringBuilder("No. of Days old : 0");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something4.setText(str);

    str = new SpannableStringBuilder();
    str1= new SpannableString("Consumable : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    str2= new SpannableString("Yes");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#228B22")), 0, str2.length(), 0);
    str.append(str2);
    something5.setText(str);

    imageView.setImageResource(R.drawable.freshfish);
}
else if(code==31)
{
    appname.setVisibility(View.GONE);
    something1.setVisibility(View.VISIBLE);
    //something2.setVisibility(View.VISIBLE);
    something3.setVisibility(View.VISIBLE);
    something4.setVisibility(View.VISIBLE);
    titles.setVisibility(View.VISIBLE);
    something5.setVisibility(View.VISIBLE);

    SpannableStringBuilder str = new SpannableStringBuilder("Category : Non Veg");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    titles.setText(str);
    markerVegNon.setImageResource(R.drawable.non);
    markerVegNon.setVisibility(View.VISIBLE);



    str = new SpannableStringBuilder();
    SpannableString str1= new SpannableString("Food Status : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    SpannableString str2= new SpannableString("Spoiled");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#ed2217")), 0, str2.length(), 0);
    str.append(str2);
    something1.setText(str);

    str = new SpannableStringBuilder("Decaying Index :"+ decay);
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something2.setText(str);

    str = new SpannableStringBuilder("Item Name : Fish");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something3.setText(str);

    str = new SpannableStringBuilder("No. of Days old : 1");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something4.setText(str);

    str = new SpannableStringBuilder();
    str1= new SpannableString("Consumable : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    str2= new SpannableString("No");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#ed2217")), 0, str2.length(), 0);
    str.append(str2);
    something5.setText(str);
    imageView.setImageResource(R.drawable.rottenfish);
}
else if(code==40)
{
    appname.setVisibility(View.GONE);
    something1.setVisibility(View.VISIBLE);
    //something2.setVisibility(View.VISIBLE);
    titles.setVisibility(View.VISIBLE);
    something3.setVisibility(View.VISIBLE);
    something4.setVisibility(View.VISIBLE);
    something5.setVisibility(View.VISIBLE);

    SpannableStringBuilder str = new SpannableStringBuilder("Category : Veg");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    titles.setText(str);
    markerVegNon.setImageResource(R.drawable.veg);
    markerVegNon.setVisibility(View.VISIBLE);

    str = new SpannableStringBuilder();
    SpannableString str1= new SpannableString("Food Status : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    SpannableString str2= new SpannableString("Fresh");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#228B22")), 0, str2.length(), 0);
    str.append(str2);
    something1.setText(str);

    str = new SpannableStringBuilder("Decaying Index :"+ decay);
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something2.setText(str);

    str = new SpannableStringBuilder("Item Name : Pineapple");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something3.setText(str);

    str = new SpannableStringBuilder("No. of Days old : 0");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something4.setText(str);

    str = new SpannableStringBuilder();
    str1= new SpannableString("Consumable : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    str2= new SpannableString("Yes");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#228B22")), 0, str2.length(), 0);
    str.append(str2);
    something5.setText(str);
    imageView.setImageResource(R.drawable.pineapple);
}
else if(code==41)
{
    appname.setVisibility(View.GONE);
    something1.setVisibility(View.VISIBLE);
    //something2.setVisibility(View.VISIBLE);
    something3.setVisibility(View.VISIBLE);
    titles.setVisibility(View.VISIBLE);
    something4.setVisibility(View.VISIBLE);
    something5.setVisibility(View.VISIBLE);

    SpannableStringBuilder str = new SpannableStringBuilder("Category : Veg");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    titles.setText(str);
    markerVegNon.setImageResource(R.drawable.veg);
    markerVegNon.setVisibility(View.VISIBLE);

    str = new SpannableStringBuilder();
    SpannableString str1= new SpannableString("Food Status : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    SpannableString str2= new SpannableString("Spoiled");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#ed2217")), 0, str2.length(), 0);
    str.append(str2);
    something1.setText(str);

    str = new SpannableStringBuilder("Decaying Index :"+ decay);
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something2.setText(str);

    str = new SpannableStringBuilder("Item Name : Pineapple");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something3.setText(str);

    str = new SpannableStringBuilder("No. of Days old : 1");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something4.setText(str);

    str = new SpannableStringBuilder();
    str1= new SpannableString("Consumable : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    str2= new SpannableString("No");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#ed2217")), 0, str2.length(), 0);
    str.append(str2);
    something5.setText(str);
    imageView.setImageResource(R.drawable.rottenpineapple);
}
else if(code==42)
{
    appname.setVisibility(View.GONE);
    something1.setVisibility(View.VISIBLE);
    //something2.setVisibility(View.VISIBLE);
    titles.setVisibility(View.VISIBLE);
    something3.setVisibility(View.VISIBLE);
    something4.setVisibility(View.VISIBLE);
    something5.setVisibility(View.VISIBLE);
    SpannableStringBuilder str = new SpannableStringBuilder("Category : Veg");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    titles.setText(str);
    markerVegNon.setImageResource(R.drawable.veg);
    markerVegNon.setVisibility(View.VISIBLE);

    str = new SpannableStringBuilder();
    SpannableString str1= new SpannableString("Food Status : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    SpannableString str2= new SpannableString("Spoiled");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#ed2217")), 0, str2.length(), 0);
    str.append(str2);
    something1.setText(str);

    str = new SpannableStringBuilder("Decaying Index :"+ decay);
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something2.setText(str);

    str = new SpannableStringBuilder("Item Name : Pineapple");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something3.setText(str);

    str = new SpannableStringBuilder("No. of Days old : 2");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something4.setText(str);

    str = new SpannableStringBuilder();
    str1= new SpannableString("Consumable : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    str2= new SpannableString("No");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#ed2217")), 0, str2.length(), 0);
    str.append(str2);
    something5.setText(str);
    imageView.setImageResource(R.drawable.rottenpineapple);
}
else if(code==51)
{
    appname.setVisibility(View.GONE);
    something1.setVisibility(View.VISIBLE);
    //something2.setVisibility(View.VISIBLE);
    something3.setVisibility(View.VISIBLE);
    something4.setVisibility(View.VISIBLE);
    titles.setVisibility(View.VISIBLE);
    something5.setVisibility(View.VISIBLE);

    SpannableStringBuilder str = new SpannableStringBuilder("Category : Veg");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    titles.setText(str);
    markerVegNon.setImageResource(R.drawable.veg);
    markerVegNon.setVisibility(View.VISIBLE);

    str = new SpannableStringBuilder();
    SpannableString str1= new SpannableString("Food Status : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    SpannableString str2= new SpannableString("Fresh");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#228B22")), 0, str2.length(), 0);
    str.append(str2);
    something1.setText(str);


    str = new SpannableStringBuilder("Item Name : Orange");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something3.setText(str);

    str = new SpannableStringBuilder("No. of Days old : 0");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something4.setText(str);

    str = new SpannableStringBuilder();
    str1= new SpannableString("Consumable : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    str2= new SpannableString("Yes");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#228B22")), 0, str2.length(), 0);
    str.append(str2);
    something5.setText(str);

    imageView.setImageResource(R.drawable.freshorange);
}
else if(code==52)
{
    appname.setVisibility(View.GONE);
    something1.setVisibility(View.VISIBLE);
    //something2.setVisibility(View.VISIBLE);
    something3.setVisibility(View.VISIBLE);
    titles.setVisibility(View.VISIBLE);
    something4.setVisibility(View.VISIBLE);
    something5.setVisibility(View.VISIBLE);


    SpannableStringBuilder str = new SpannableStringBuilder("Category : Veg");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    titles.setText(str);
    markerVegNon.setImageResource(R.drawable.veg);
    markerVegNon.setVisibility(View.VISIBLE);

    str = new SpannableStringBuilder();
    SpannableString str1= new SpannableString("Food Status : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    SpannableString str2= new SpannableString("Spoiled");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#228B22")), 0, str2.length(), 0);
    str.append(str2);
    something1.setText(str);


    str = new SpannableStringBuilder("Item Name : Orange");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something3.setText(str);

    str = new SpannableStringBuilder("No. of Days old : 1");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something4.setText(str);

    str = new SpannableStringBuilder();
    str1= new SpannableString("Consumable : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    str2= new SpannableString("No");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#ed2217")), 0, str2.length(), 0);
    str.append(str2);
    something5.setText(str);


    imageView.setImageResource(R.drawable.orange);
}
else if(code==53)
{
    appname.setVisibility(View.GONE);
    something1.setVisibility(View.VISIBLE);
    //something2.setVisibility(View.VISIBLE);
    something3.setVisibility(View.VISIBLE);
    titles.setVisibility(View.VISIBLE);
    something4.setVisibility(View.VISIBLE);
    something5.setVisibility(View.VISIBLE);

    SpannableStringBuilder str = new SpannableStringBuilder("Category : Veg");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    titles.setText(str);
    markerVegNon.setImageResource(R.drawable.veg);
    markerVegNon.setVisibility(View.VISIBLE);

    str = new SpannableStringBuilder();
    SpannableString str1= new SpannableString("Food Status : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    SpannableString str2= new SpannableString("Spoiled");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#228B22")), 0, str2.length(), 0);
    str.append(str2);
    something1.setText(str);


    str = new SpannableStringBuilder("Item Name : Orange");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something3.setText(str);

    str = new SpannableStringBuilder("No. of Days old : 2");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something4.setText(str);

    str = new SpannableStringBuilder();
    str1= new SpannableString("Consumable : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    str2= new SpannableString("No");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#ed2217")), 0, str2.length(), 0);
    str.append(str2);
    something5.setText(str);

    imageView.setImageResource(R.drawable.orange);
}
else if(code==60)
{
    appname.setVisibility(View.GONE);
    something1.setVisibility(View.VISIBLE);
    //something2.setVisibility(View.VISIBLE);
    something3.setVisibility(View.VISIBLE);
    titles.setVisibility(View.VISIBLE);
    something4.setVisibility(View.VISIBLE);
    //something5.setVisibility(View.VISIBLE);

    SpannableStringBuilder str = new SpannableStringBuilder("Category : Veg");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    titles.setText(str);
    markerVegNon.setImageResource(R.drawable.veg);
    markerVegNon.setVisibility(View.VISIBLE);

    str = new SpannableStringBuilder();
    SpannableString str1= new SpannableString("Food Status : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    SpannableString str2= new SpannableString("Fresh");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#ed2217")), 0, str2.length(), 0);
    str.append(str2);
    something1.setText(str);


    str = new SpannableStringBuilder("Item Name : Orange Peel");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something3.setText(str);

    str = new SpannableStringBuilder("No. of Days old : 0");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something4.setText(str);


    imageView.setImageResource(R.drawable.peelorange);
}
else if(code==61)
{
    appname.setVisibility(View.GONE);
    something1.setVisibility(View.VISIBLE);
    //something2.setVisibility(View.VISIBLE);
    something3.setVisibility(View.VISIBLE);
    titles.setVisibility(View.VISIBLE);
    something4.setVisibility(View.VISIBLE);
    //something5.setVisibility(View.VISIBLE);

    SpannableStringBuilder str = new SpannableStringBuilder("Category : Veg");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    titles.setText(str);
    markerVegNon.setImageResource(R.drawable.veg);
    markerVegNon.setVisibility(View.VISIBLE);

    str = new SpannableStringBuilder();
    SpannableString str1= new SpannableString("Food Status : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    SpannableString str2= new SpannableString("Spoiled");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#ed2217")), 0, str2.length(), 0);
    str.append(str2);
    something1.setText(str);


    str = new SpannableStringBuilder("Item Name : Orange Peel");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something3.setText(str);

    str = new SpannableStringBuilder("No. of Days old : 1");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something4.setText(str);


    imageView.setImageResource(R.drawable.crushedpeel);
}

else if(code==70)
{
    appname.setVisibility(View.GONE);
    //something1.setVisibility(View.VISIBLE);
    //something2.setVisibility(View.VISIBLE);
    something3.setVisibility(View.VISIBLE);
    something4.setVisibility(View.VISIBLE);
    something5.setVisibility(View.VISIBLE);
    titles.setVisibility(View.VISIBLE);


    SpannableStringBuilder str = new SpannableStringBuilder("Category : Non Ogranic");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    titles.setText(str);

    markerVegNon.setVisibility(View.GONE);



    str = new SpannableStringBuilder("Item Name : Solder Flux");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something3.setText(str);

    str = new SpannableStringBuilder("No. of Days old : 0");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something4.setText(str);

    str = new SpannableStringBuilder();
    SpannableString str1= new SpannableString("Consumable : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    SpannableString str2= new SpannableString("No");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#ed2217")), 0, str2.length(), 0);
    str.append(str2);
    something5.setText(str);

    imageView.setImageResource(R.drawable.soldierflux);
}
else if(code==80)
{
    appname.setVisibility(View.GONE);
    //something1.setVisibility(View.VISIBLE);
    //something2.setVisibility(View.VISIBLE);
    something3.setVisibility(View.VISIBLE);
    something4.setVisibility(View.VISIBLE);
    titles.setVisibility(View.VISIBLE);
    something5.setVisibility(View.VISIBLE);


    SpannableStringBuilder str = new SpannableStringBuilder("Category : Non Ogranic");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    titles.setText(str);

    markerVegNon.setVisibility(View.GONE);



    str = new SpannableStringBuilder("Item Name : Coffee");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something3.setText(str);

    str = new SpannableStringBuilder("No. of Days old : 0");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something4.setText(str);

    str = new SpannableStringBuilder();
    SpannableString str1= new SpannableString("Consumable : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    SpannableString str2= new SpannableString("Yes");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#228B22")), 0, str2.length(), 0);
    str.append(str2);
    something5.setText(str);

    imageView.setImageResource(R.drawable.coffee);
}
else if(code==90)
{
    appname.setVisibility(View.GONE);
    something1.setVisibility(View.VISIBLE);
    //something2.setVisibility(View.VISIBLE);
    something3.setVisibility(View.VISIBLE);
    something4.setVisibility(View.VISIBLE);
    something5.setVisibility(View.VISIBLE);
    titles.setVisibility(View.VISIBLE);

    SpannableStringBuilder str = new SpannableStringBuilder("Category : Non Organic");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    titles.setText(str);
   /* markerVegNon.setImageResource(R.drawable.veg);
    markerVegNon.setVisibility(View.VISIBLE);*/

    str = new SpannableStringBuilder();
    SpannableString str1= new SpannableString("Food Status : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    SpannableString str2= new SpannableString("Fresh");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#228B22")), 0, str2.length(), 0);
    str.append(str2);
    something1.setText(str);


    str = new SpannableStringBuilder("Item Name : Bread");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something3.setText(str);

    str = new SpannableStringBuilder("No. of Days old : 0");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something4.setText(str);

    str = new SpannableStringBuilder();
    str1= new SpannableString("Consumable : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    str2= new SpannableString("Yes");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#228B22")), 0, str2.length(), 0);
    str.append(str2);
    something5.setText(str);
    imageView.setImageResource(R.drawable.bread);
}
else if(code==91)
{
    appname.setVisibility(View.GONE);
    something1.setVisibility(View.VISIBLE);
    //something2.setVisibility(View.VISIBLE);
    something3.setVisibility(View.VISIBLE);
    something4.setVisibility(View.VISIBLE);
    something5.setVisibility(View.VISIBLE);
    titles.setVisibility(View.VISIBLE);

    SpannableStringBuilder str = new SpannableStringBuilder("Category : Non Organic");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    titles.setText(str);
   /* markerVegNon.setImageResource(R.drawable.veg);
    markerVegNon.setVisibility(View.VISIBLE);*/

    str = new SpannableStringBuilder();
    SpannableString str1= new SpannableString("Food Status : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    SpannableString str2= new SpannableString("Burned");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#ed2217")), 0, str2.length(), 0);
    str.append(str2);
    something1.setText(str);

    str = new SpannableStringBuilder("Decaying Index :"+ decay);
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something2.setText(str);

    str = new SpannableStringBuilder("Item Name : Bread");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 9, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something3.setText(str);

    str = new SpannableStringBuilder("No. of Days old : 1");
    str.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    something4.setText(str);

    str = new SpannableStringBuilder();
    str1= new SpannableString("Consumable : ");
    str1.setSpan(new android.text.style.StyleSpan(android.graphics.Typeface.BOLD), 0, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    str.append(str1);
    str2= new SpannableString("No");
    str2.setSpan(new ForegroundColorSpan(Color.parseColor("#ed2217")), 0, str2.length(), 0);
    str.append(str2);
    something5.setText(str);
    imageView.setImageResource(R.drawable.burnedbread);
}
else
{
    appname.setVisibility(View.VISIBLE);
    appname.setText("No Item Found");
    something1.setVisibility(View.GONE);
    something2.setVisibility(View.GONE);
    something3.setVisibility(View.GONE);
    something4.setVisibility(View.GONE);
    something5.setVisibility(View.GONE);
    titles.setVisibility(View.GONE);
    markerVegNon.setVisibility(View.GONE);
    imageView.setImageResource(R.drawable.noitem);
}
        line.setVisibility(View.VISIBLE);
        bar3.setVisibility(View.GONE);

    }
    public void progress(){
        bar3.setVisibility(View.VISIBLE);
    }
}
