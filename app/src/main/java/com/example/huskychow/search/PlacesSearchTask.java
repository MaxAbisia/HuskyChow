package com.example.huskychow.search;

import android.os.AsyncTask;

import com.example.huskychow.CurrencyType;
import com.example.huskychow.Restaurant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A textsearch using the Places API
 */
public class PlacesSearchTask extends AsyncTask<Void, Void, ArrayList<Restaurant>> {

    private StringBuilder message;
    private String input;
    private String key;
    private ArrayList<Restaurant> foundRestaurants;

    public PlacesSearchTask(String textInput, String apiKey) {
        input = textInput;
        message = new StringBuilder();
        key = apiKey;
        foundRestaurants = new ArrayList<>();
    }

    protected ArrayList<Restaurant> doInBackground(Void... voids) {
        HttpURLConnection connection = null;

        try {
            Map<String, String> parameters = new HashMap<>();

            parameters.put("query", input);
            parameters.put("location", "42.3398,-71.0892");
            parameters.put("key", key);
            parameters.put("rankby", "distance");

            String targetURL = "https://maps.googleapis.com/maps/api/place/textsearch/xml?" + getParamsString(parameters);
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestProperty("Content-Type", "text/plain");
            connection.setRequestProperty("charset", "utf-8");
            connection.setRequestMethod("GET");

            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            InputStream response = connection.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(response));
            ParseResponse(reader);
            connection.disconnect();

        } catch (Exception e) {
            //message = getClass().getCanonicalName() + " outer catch";
        }

        // this is updated in ParseResponse!
        return foundRestaurants;
    }

    private void ParseResponse(BufferedReader reader) throws IOException {
        String line = "";

        while ((line = reader.readLine()) != null)
        {
            message.append(line);

            if (message.indexOf("<result>") == -1) {
                message.setLength(0);
            }

            else if (line.contains("</result>")) {
                foundRestaurants.add(ParseResultXML(message.toString()));
                message.setLength(0);
            }
        }
    }

    private Restaurant ParseResultXML(String result) {
        int nameIndex = result.indexOf("<name>") + "<name>".length();
        String name = result.substring(nameIndex, result.indexOf("</name>"));

        int addressIndex = result.indexOf("<formatted_address>") + "<formatted_address>".length();
        String address = result.substring(addressIndex, result.indexOf("</formatted_address"));
        return new Restaurant(name, address, CurrencyType.HUSKY_DOLLARS);
    }

    private String getParamsString(Map<String, String> parameters)
            throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            result.append("&");
        }

        String resultString = result.toString();
        return resultString.length() > 0
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;
    }

    @Override
    protected void onPostExecute(ArrayList<Restaurant> feed) {
        super.onPostExecute(feed);
    }
}
