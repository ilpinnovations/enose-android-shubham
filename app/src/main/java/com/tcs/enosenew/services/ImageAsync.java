package com.tcs.enosenew.services;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;

import com.tcs.enosenew.MainFragment;
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

public class ImageAsync extends AsyncTask<Void, Void, Void> {
private static MainFragment fragment = new MainFragment();
    ReadingsBean readingdata = new ReadingsBean();
    String sens1, sens2, sens3, sens4,results,temperature,decay;
int code=10;
    Float temperature1;
    JSONObject jsonRootObject;
    @Override
    protected void onPreExecute() {


        fragment.progress();

    }

    @SuppressLint("LongLogTag")
    @Override
    protected Void doInBackground(Void... args) {
        try {
            publishProgress();

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
                    readingdata.setDecay(jsonObject.getString("decay"));
                    decay = readingdata.getDecay();
                    temperature1 = round(Float.parseFloat(temperature), 2);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            Log.d("Do in Background Exception1 :", String.valueOf(e));
            e.printStackTrace();
        } catch (ProtocolException e) {
            Log.d("Do in Background Exception2 :", String.valueOf(e));
            e.printStackTrace();
        } catch (IOException e) {
            Log.d("Do in Background Exception3 :", String.valueOf(e));
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

        if(sens1!=null ) {

            fragment.setImage(results,decay);
        }


    }

    @Override
    protected void onProgressUpdate(Void... values) {
        //super.onProgressUpdate(values);
    }
    public static float round(float d, int decimalPlace) {
        return BigDecimal.valueOf(d).setScale(decimalPlace, BigDecimal.ROUND_HALF_UP).floatValue();
    }
}