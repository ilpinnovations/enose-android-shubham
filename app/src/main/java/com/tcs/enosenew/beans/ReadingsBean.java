package com.tcs.enosenew.beans;

/**
 * Created by Omkar Tarale on 10/02/2016.
 */
public class ReadingsBean {
    private static String sens1 = "0";
    private static String sens2 = "0";
    private static String sens3 = "0";
    private static String sens4 = "0";

    public static String getDecay() {
        return decay;
    }

    public static void setDecay(String decay) {
        ReadingsBean.decay = decay;
    }

    private static String decay = "decay";

    private static String temperature = "Temperature";
    private static String results = "Result";
    private static String url = "http://theinspirer.in/Enose/enose.php";

    public static String getSens1() {
        return sens1;
    }

    public static void setSens1(String sens1) {
        ReadingsBean.sens1 = sens1;
    }

    public static String getSens2() {
        return sens2;
    }

    public static void setSens2(String sens2) {
        ReadingsBean.sens2 = sens2;
    }

    public static String getSens3() {
        return sens3;
    }

    public static void setSens3(String sens3) {
        ReadingsBean.sens3 = sens3;
    }

    public static String getSens4() {
        return sens4;
    }

    public static void setSens4(String sens4) {
        ReadingsBean.sens4 = sens4;
    }

    public static String getTemperature() {
        return temperature;
    }

    public static void setTemperature(String temperature) {
        ReadingsBean.temperature = temperature;
    }

    public static String getResults() {
        return results;
    }

    public static void setResults(String results) {
        ReadingsBean.results = results;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        ReadingsBean.url = url;
    }


}
