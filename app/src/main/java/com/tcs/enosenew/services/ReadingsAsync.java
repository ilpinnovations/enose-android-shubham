package com.tcs.enosenew.services;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.LinearLayout;

import com.tcs.enosenew.ReadingsFragment;
import com.tcs.enosenew.beans.ReadingsBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class ReadingsAsync extends AsyncTask<Void, Void, Void> {
    private static ReadingsFragment fragment = new ReadingsFragment();
    ReadingsBean readingdata = new ReadingsBean();
String sens1, sens2, sens3, sens4,results,temperature;
    Float temperature1;
    private static LinearLayout linearLayoutr;
    JSONObject jsonRootObject;
    @Override
    protected void onPreExecute() {
//fragment.progress();
    }

    @Override
    protected Void doInBackground(Void... args) {
        try {
            //publishProgress();

            URL obj = new URL(readingdata.getUrl());
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            System.out.println(response.toString());
            String json_string = response.toString();
            try {
                jsonRootObject = new JSONObject(json_string);
                JSONArray jsonArray = jsonRootObject.optJSONArray("data");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    readingdata.setSens1(jsonObject.getString("Sensor1"));
                    sens1 = readingdata.getSens1();
                    readingdata.setSens2(jsonObject.getString("Sensor2"));
                    sens2 = readingdata.getSens2();
                    readingdata.setSens3(jsonObject.getString("Sensor3"));
                    sens3 = readingdata.getSens3();
                    readingdata.setSens4(jsonObject.getString("Sensor4"));
                    sens4 = readingdata.getSens4();
                    readingdata.setTemperature(jsonObject.getString("Temperature"));
                    temperature = readingdata.getTemperature();
                    readingdata.setResults(jsonObject.getString("Result"));
                    results = readingdata.getResults();
                    temperature1 = round(Float.parseFloat(temperature), 2);


                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

            } catch (Exception ex) {
                Log.d("MyTag", "Exception2: " + ex);
            }
        }


        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
if(sens1!=null ){
    ReadingsFragment readingsFragment = new ReadingsFragment();
    readingsFragment.setResultToScreen(sens1, sens2, sens3, sens4, temperature1);
}
    }

    @Override
    protected void onProgressUpdate(Void... values) {

    }
    public static float round(float d, int decimalPlace) {
        return BigDecimal.valueOf(d).setScale(decimalPlace, BigDecimal.ROUND_HALF_UP).floatValue();
    }
}